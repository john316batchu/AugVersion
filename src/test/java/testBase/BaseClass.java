package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@Parameters({"browser","os"})
	@BeforeClass(groups={"sanity","regression","master"})
	public void setUp(String br,String os) throws InterruptedException, IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		prop= new Properties();
		prop.load(fis);
		logger=LogManager.getLogger(getClass());
		switch(br) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge"  :driver = new EdgeDriver();break;
		case "firefox":driver= new FirefoxDriver();break;
		default: logger.info("Invalid browser name"); return;
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {

		driver.quit();

	}
	
	public String generateString() {		
	 	return RandomStringUtils.randomAlphabetic(5);
		
	}
	public String generateNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	public String generateNumber(int num) {
		return RandomStringUtils.randomNumeric(num);
	}
	public String generateAlphaNumeric() {
		return generateString()+"@"+generateNumber(3);
	}
	
	public String captureScreen(String name) throws IOException {
		try {
			SimpleDateFormat sdt=new SimpleDateFormat("ddmmyyyyhhmmss");
			String timestamp=sdt.format(new Date());
			
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String des_path= System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timestamp+".png";
		FileUtils.copyFile(src, new File(des_path));		
		return des_path ;
		}catch(Exception e) {
			return " ";
		}
	}

}
