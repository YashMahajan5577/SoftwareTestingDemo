package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayingVedioPage {
	private WebDriver driver;

	@FindBy (xpath = "//div[text()='Skip Ads']")
	private WebElement skip;
	
	@FindBy (xpath = "//video[@class='video-stream html5-main-video']")
	private WebElement stream;
	
	@FindBy (xpath = "//button[@class='ytp-fullscreen-button ytp-button']")
	private WebElement fullSize;
	
	public PlayingVedioPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    this.driver=driver;
	}
	
	public void skipAd()
	{
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wt.until(ExpectedConditions.visibilityOf(skip));
		skip.click();
	}
	
	public void fullSizeVedio()
	{
		stream.click();
		fullSize.click();
		stream.click();
	}
}
