import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		
//		Set Capabilities 
		ChromeOptions options = new ChromeOptions();
		
//		Old School Methods :)
/*		c.setCapaSbility(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/
		
		options.setAcceptInsecureCerts(true);
		
//		How to Set Proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:8080");
		options.setCapability("proxy", proxy);
		
//		to block pop-ups
		options.setExperimentalOption("excludeSwitches",
				Arrays.asList("disable-popup-blocking"));
		
//		Initializing webdriver 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//		Launching the URL
		driver.get("https://expired.badssl.com/");
		System.out.println("The page title is : " +driver.getTitle());
//		driver.close();
	}
}