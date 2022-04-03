import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {
    public static String baseUrl="https://www.placelab.com";
    public WebDriver driver;
    public String browser;

    public Homepage (){
    }

    @BeforeTest
    public void openBrowser() {
        this.browser="Chrome";
        if (this.browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver=new ChromeDriver();
        }
        else if (this.browser.contains("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver=new FirefoxDriver();
        }
        else if (this.browser.contains("Edge")){
            WebDriverManager.edgedriver().setup();
            this.driver=new EdgeDriver();
            
        }
        this.driver.get(baseUrl);
    }
    @Test
    public void verifyHomepageTitle(){
        String expectedText="GIVE YOUR DATA A BOOST";
        
      //  String expectedText="GIVE YOUR DATA A BOOSTtr";
        String actualText=driver.findElement(By.xpath("//div[@class='text-container']/h1")).getText();
        Assert.assertEquals(actualText,expectedText);
    }

    @AfterTest
    public void closeBrowser(){
        this.driver.quit();
    }
}
