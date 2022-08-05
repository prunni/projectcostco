/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.test.itexps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author rajes
 */
public class CostcoTest {
    
    private WebDriver driver;
   private String baseUrl;
   private static Login login;
   WebDriverWait wait;
    
    public CostcoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        login = FileUtil.getLoginData();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");     
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test//success search 
    public void testCostco() {
    driver.get("https://www.costco.com/");
    driver.close();
    
    }
    @Test
    public void testCostcoLogin() throws Exception {
       
    //driver.get("https://www.costco.com");
  //driver.findElement(By.id("header_sign_in")).click();
    driver.get("https://www.costco.com/LogonForm");
    driver.findElement(By.id("signInName")).clear();
    driver.findElement(By.id("signInName")).sendKeys(login.getUsername());
    Thread.sleep(2000);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(login.getPassword());
    Thread.sleep(2000);
    driver.findElement(By.id("rememberMe")).click();
    driver.findElement(By.id("next")).click();
    driver.close();
    
   //driver.get("https://signin.costco.com");
   //driver.get("https://www.costco.com/LinkYourMembershipInterruptView");
   
   
    }
    
     @Test//success search
  public void testSearch() throws Exception {
   
    driver.get("https://www.costco.com/");
     wait=new WebDriverWait(driver,Duration.ofSeconds(20));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
    driver.findElement(By.id("search-field")).click();
    driver.findElement(By.id("search-field")).clear();
    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
    driver.findElement(By.id("search-field")).sendKeys("Laptop");
    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formcatsearch")));
    driver.findElement(By.id("formcatsearch")).submit();
    //driver.findElement(By.xpath("//div[@id='search-results']/div[4]/div/div[2]/div[2]/div[2]/div[2]")).click();
    driver.close();
    
    
    }
//  @Test
//  
//  public void testOpticalTab() throws Exception{
//      
//    driver.get("https://www.costco.com/");
//    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Home_Ancillary_4")));
//    driver.findElement(By.id("Home_Ancillary_4")).click();
//    driver.get("https://www.costco.com/optical.html");
//    driver.close();
////    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
////    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results")));
////    driver.findElement(By.id("search-results")).click();
////    //Thread.sleep(2000);
//    
//    
//  }
}
