package com.cybertester.seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@Component
public class RecalcDocs {

    String url;
    String login;
    String password;


    public void recalcDocs() throws IOException {

        Properties properties = new Properties();

        FileInputStream seleniumProperties = new FileInputStream("src/main/resources/selenium.properties");
        properties.load(seleniumProperties);

        String dateBegin = "20.12.2021 00:00:00";
        String dateEnd = "31.12.2022 00:00:00";


        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");

//       ** Режим без интерфейса **
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(600));
        Actions actions = new Actions(driver);

        driver.get(properties.getProperty("url"));

        WebElement inputLogin = driver.findElement(By.name("j_username"));
        WebElement inputPassword = driver.findElement(By.name("j_password"));


        inputLogin.sendKeys(properties.getProperty("login"));
        inputPassword.sendKeys(properties.getProperty("password"), Keys.ENTER);

        WebElement armFilial = driver.findElement(By.xpath("//*[@id='x-widget-5']/div[2]/table/tbody/tr/td/div[@class='GHGOUU-BCP GHGOUU-BHK GHGOUU-BGGC']"));
        armFilial.click();

        WebElement documents = driver.findElement(By.xpath("//*[@id='x-widget-7_f-695656']/div/img[2]"));
        documents.click();

        WebElement oneTimeDocuments = driver.findElement(By.xpath("//div[@id='x-widget-7_f-695681']/div[@class='GHGOUU-BLTC']/img[@src='http://10.225.16.26:8080/wozm/wozmgwt/clear.cache.gif']"));
        oneTimeDocuments.click();

        WebElement calculations = driver.findElement(By.xpath("//div[@id='x-widget-7_f-695694']/div[@class='GHGOUU-BLTC']/img[@src='http://10.225.16.26:8080/wozm/wozmgwt/clear.cache.gif']"));
        calculations.click();

        WebElement calculations2 = driver.findElement(By.xpath("//div[@id='x-widget-7_m-695695']/div/img[@src='http://10.225.16.26:8080/wozm/wozmgwt/clear.cache.gif']"));
        calculations2.click();

        WebElement filter = driver.findElement(By.xpath("(//div[@class='GHGOUU-BFK GHGOUU-BPJ GHGOUU-BMK GHGOUU-BJK'])[5]/div[@class='GHGOUU-BGMC GHGOUU-BCNC']/table/tbody/tr/td/div/div/table/tbody/tr/td/img"));
        filter.click();

        WebElement filterDateBegin = driver.findElement(By.id("x-widget-9-input"));
        filterDateBegin.click();
        filterDateBegin.sendKeys(dateBegin);

        WebElement filterDateEnd = driver.findElement(By.id("x-widget-10-input"));
        filterDateEnd.click();
        filterDateEnd.sendKeys(dateEnd);

        WebElement submitFilter = driver.findElement(By.xpath("(//div[@class='GHGOUU-BGDC']//div[@class='GHGOUU-BMP']//div[@class='GHGOUU-BFK GHGOUU-BPJ GHGOUU-BMK GHGOUU-BJK']//img[@src='http://10.225.16.26:8080/wozm/wozmgwt/clear.cache.gif'])[2]"));
        submitFilter.click();

        WebElement collectionOfDocuments = driver.findElement(By.xpath("//div[@class='GHGOUU-BJK GHGOUU-BKSB']"));
        actions.contextClick(collectionOfDocuments).perform();

        WebElement noticeDocuments = driver.findElement(By.xpath("//div[@id='x-menu-el-']/div[@class='GHGOUU-BNQC']/a[contains( text(),'Инвертировать отметки')]"));
        noticeDocuments.click();

        actions.contextClick(collectionOfDocuments).perform();

        WebElement calculationsDocuments = driver.findElement(By.xpath("//div[@id='x-menu-el-']/div[@class='GHGOUU-BNQC']/a[contains( text(),'Расчет пособий')]"));
        calculationsDocuments.click();

        WebElement startCalculations = driver.findElement(By.xpath("((//div[@class='GHGOUU-BMP'])[8]//img[@src='http://10.225.16.26:8080/wozm/wozmgwt/clear.cache.gif'])[2]"));
        startCalculations.click();

        WebElement calculationResult = driver.findElement(By.xpath("//div[contains( text(),'RegistrProcessingStarter')]"));
        calculationResult.click();

        WebElement resultText = driver.findElement(By.xpath("//textarea[@class='GHGOUU-BMW GHGOUU-BOW']"));

        driver.close();
    }
}

