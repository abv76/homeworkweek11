/*     Homework – 2
        **Navigate to website"https://demo.nopcommerce.com/"
        **Click on register link.
        **Fill the all fields.
        **Click on register button.
        **Verify that the user register successfully.
        **/

package homework1;

import homework1.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AutomationPractice extends BaseClass {
    @Before
    public void page() {
        openBrowser("http://automationpractice.com/index.php");

    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email")).sendKeys("ajavabac123@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("GA__1234");
        driver.findElement(By.id("SubmitLogin")).click();
        String expectedResult = "There is 1 error";
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'There is 1 error')]")).getText();
        Assert.assertEquals("You are on login page", expectedResult, actualResult);

    }

    @After
    public void close(){
        //closeBrowser();   --> having this we are not able to see error and browser closed
    }
}