
package SignUp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class SignUp {

    public static void main(String[] args) throws InterruptedException, ParserConfigurationException, SAXException, IOException {

	WebDriver driver ;
        System.setProperty("webdriver.gecko.driver", "C:\\workspace\\automationTesting\\geckodriver.exe");
        driver = new FirefoxDriver();

		
	driver.get("https://www.expedia.com");
        driver.findElement(By.id("header-account-menu")).click();
        driver.findElement(By.id("account-register")).click();
        
        /*Get Data from XML*/
        File file = new File("data.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        String firstname = document.getElementsByTagName("firstname").item(0).getTextContent();
        String  lastname = document.getElementsByTagName("user_name").item(0).getTextContent();
        String  emailId = document.getElementsByTagName("emailId").item(0).getTextContent();
        String password = document.getElementsByTagName("password").item(0).getTextContent();
				
        
	driver.findElement(By.id("create-account-firstname")).sendKeys(firstname);
	driver.findElement(By.id("create-account-lastname")).sendKeys(lastname);
        driver.findElement(By.id("create-account-emailId")).sendKeys(emailId);
        driver.findElement(By.id("create-account-password")).sendKeys(password);
        driver.findElement(By.id("create-account-confirm-password")).sendKeys(password);
        driver.findElement(By.id("create-account-expedia-policy")).click();
        
        


    }
    
}
