
import Excel.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class loginTest {
    
    public loginTest() {
    }
    WebDriver driver ;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        
        System.setProperty("webdriver.gecko.driver", "C:\\workspace\\automationTesting\\geckodriver.exe");
        driver = new FirefoxDriver();	
	driver.get("https://www.expedia.com");
        driver.findElement(By.id("header-account-menu")).click();
        driver.findElement(By.id("account-signin")).click();
    }

    @Test(dataProvider="Authentication")
 
    public void Registration_data(String sUserName,String sPassword)throws  Exception{
 
        driver.findElement(By.id("signin-loginid")).sendKeys(sUserName);
 
        driver.findElement(By.id("signin-password")).sendKeys(sPassword);
 
        driver.findElement(By.id("submitButton")).click();
 
		}
     @DataProvider
 
    public Object[][] Authentication() throws Exception{
 
         String[][] testObjArray = Excel.getData();
 
         return (testObjArray);
 
		}
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
