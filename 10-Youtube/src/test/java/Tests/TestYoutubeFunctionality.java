package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PlayingVedioPage;
import Pages.YoutubeHomePage;



public class TestYoutubeFunctionality {

	
private WebDriver driver;
	
	@BeforeClass
	public void launchTheBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	      options.addArguments("--no-sandbox");
	      options.addArguments("--disable-dev-shm-usage");
		System.setProperty("webdriver.chrome.driver", "E:\\\\Velocity\\\\Selenium Tools\\\\New folder\\\\chromedriver-win32\\\\chromedriver.exe");
		
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void launchTheApplication()
	{
		driver.get("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@Test (priority = 1)
	public void playVedio() throws InterruptedException
	{
		YoutubeHomePage homePage = new  YoutubeHomePage(driver);
		homePage.searchSong();
		homePage.clickOnSearchTab();
		homePage.chooseSong();
		Thread.sleep(20000);
		
		PlayingVedioPage playingVedioPage = new PlayingVedioPage(driver);
		playingVedioPage.skipAd();
		playingVedioPage.fullSizeVedio();
		
		Thread.sleep(30000);
		
	
	}
	@AfterMethod
	public void end()
	{
		System.out.println("logout");
	}
	
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
	}
}
