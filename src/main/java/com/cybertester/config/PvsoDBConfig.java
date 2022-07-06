package com.cybertester.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

// Аннотация @EnableJpaRepositories активирует Spring Data JPA.
@EnableJpaRepositories(
        entityManagerFactoryRef = PvsoDBConfig.ENTITY_MANAGER_FACTORY,

        // Spring Data JPA будет создавать конкретную реализацию для PersonRepository и настраивать на взаимодействие с БД в памяти, используя JPA.
        transactionManagerRef = PvsoDBConfig.TRANSACTION_MANAGER,
        basePackages = PvsoDBConfig.JPA_REPOSITORY_PACKAGE
)
@Configuration
public class PvsoDBConfig {

    public static final String PROPERTY_PREFIX = "app.db-oracle-pvso.datasource";
    public static final String JPA_REPOSITORY_PACKAGE = "com.cybertester.repository.standardCalc";
    public static final String ENTITY_PACKAGE = "com.cybertester.entity.standardCalc";
    public static final String ENTITY_MANAGER_FACTORY = "pvsoEntityManagerFactory";
    public static final String DATA_SOURCE = "oneDataSource";
    public static final String DATABASE_PROPERTY = "pvsoDatabaseProperty";
    public static final String TRANSACTION_MANAGER = "oneTransactionManager";

    // отвечает за передачу данных из файла application.property для подключения к бд: пароль, логин, url и драйвер.
    @Bean(DATABASE_PROPERTY)
    @ConfigurationProperties(prefix = PROPERTY_PREFIX)
    public DatabaseProperty appDatabaseProperty() {
        return new DatabaseProperty();
    }

    //инициализация источника данных
    @Bean(DATA_SOURCE)
    public DataSource appDataSource(
            @Qualifier(DATABASE_PROPERTY) DatabaseProperty databaseProperty
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
            @Qualifier(DATA_SOURCE) DataSource dataSource
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
        em.setPackagesToScan(ENTITY_PACKAGE);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.validation.mode", "none");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager sqlSessionTemplate(
            @Qualifier(ENTITY_MANAGER_FACTORY) LocalContainerEntityManagerFactoryBean entityManager,
            @Qualifier(DATA_SOURCE) DataSource dataSource
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}

