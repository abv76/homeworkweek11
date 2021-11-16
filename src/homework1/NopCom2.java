/**
 *Homework – 2
 * Navigate to website "https://demo.nopcommerce.com/"
 * Click on register link.
 * Fill the all fields.
 * Click on register button.
 * Verify that the user register successfully.
 */

package homework1;

import homework1.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;




public class NopCom2 extends BaseClass {
    @Before
    public void openWeb(){
        String baseUrl = "https://demo.nopcommerce.com/";
        openBrowser(baseUrl);

    }
    @Test
    public void one(){
        LocalDateTime now = LocalDateTime.now();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();   ////input[@id='gender-male']
        driver.findElement(By.id("FirstName")).sendKeys("Ajay");
        driver.findElement(By.id("LastName")).sendKeys("Vyas");
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay"))); ////select[@name='DateOfBirthDay']
        day.selectByVisibleText("11");
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("January");
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText("1977");
        driver.findElement(By.id("Email")).sendKeys("ajay"+now.getSecond()+"@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Ajay Inc.");
        WebElement chkBox = driver.findElement(By.id("Newsletter"));
        chkBox.click();
        driver.findElement(By.id("Password")).sendKeys("aj12345&&");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("aj12345&&");
        driver.findElement(By.id("register-button")).click();
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        Assert.assertEquals("You are not registered",expectedResult,actualResult);
    }

}