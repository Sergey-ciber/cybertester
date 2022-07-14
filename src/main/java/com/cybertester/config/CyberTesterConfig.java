package com.cybertester.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;

//@Transactional
@EnableJpaRepositories(
        entityManagerFactoryRef = CyberTesterConfig.ENTITY_MANAGER_FACTORY,
        // Аннотация @EnableJpaRepositories активирует Spring Data JPA.
        // Spring Data JPA будет создавать конкретную реализацию для PersonRepository и настраивать на взаимодействие с БД в памяти, используя JPA.
        transactionManagerRef = CyberTesterConfig.TEST_TRANSACTION_MANAGER,
        basePackages = CyberTesterConfig.JPA_REPOSITORY_PACKAGE
)
@Configuration
public class CyberTesterConfig {

    public static final String PROPERTY_PREFIX = "app.db-pg-test.datasource";
    public static final String JPA_REPOSITORY_PACKAGE = "com.cybertester.repository.testCalc";
    public static final String ENTITY_PACKAGE = "com.cybertester.entity.testcalc";
    public static final String ENTITY_MANAGER_FACTORY = "testEntityManagerFactory";
    public static final String TEST_DATA_SOURCE = "testDataSource";
    public static final String DATABASE_PROPERTY = "testDatabaseProperty";
    public static final String TEST_TRANSACTION_MANAGER = "testTransactionManager";

    // отвечает за передачу данных из файла application.property для подключения к бд: пароль, логин, url и драйвер.
    @Bean(DATABASE_PROPERTY)
    @ConfigurationProperties(prefix = PROPERTY_PREFIX)
    public DatabaseProperty appDatabaseProperty() {
        return new DatabaseProperty();
    }

    //инициализация источника данных
    @Bean(TEST_DATA_SOURCE)
    public DataSource appDataSource(
            @Qualifier(DATABASE_PROPERTY)
            DatabaseProperty databaseProperty
    ) {
        return DataSourceBuilder
                .create()
                .username(databaseProperty.getUsername())
                .password(databaseProperty.getPassword())
                .url(databaseProperty.getUrl())
                .driverClassName(databaseProperty.getClassDriver())
                .build();
    }


    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean appEntityManager(
            @Qualifier(TEST_DATA_SOURCE) DataSource dataSource
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
        em.setPackagesToScan(ENTITY_PACKAGE);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.validation.mode", "none");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaPropertyMap(properties);
        return em;
    }
//    @Primary
    @Bean(TEST_TRANSACTION_MANAGER)
    public PlatformTransactionManager sqlSessionTemplate(
            @Qualifier(ENTITY_MANAGER_FACTORY) LocalContainerEntityManagerFactoryBean entityManager,
            @Qualifier(TEST_DATA_SOURCE) DataSource dataSource
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}