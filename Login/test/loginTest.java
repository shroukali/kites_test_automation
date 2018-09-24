
import Excel.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class loginTest {
    
    WebDriver driver ;

    @BeforeTest 
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

    
    @AfterTest
    public void tearDownMethod() throws Exception {
        driver.close();
    }
}
