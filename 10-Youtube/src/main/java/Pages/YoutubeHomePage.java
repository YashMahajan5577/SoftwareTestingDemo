package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YoutubeHomePage {

	private WebDriver driver;
	private JavascriptExecutor js;
	
	@FindBy (xpath = "//input[@id='search']")
	private WebElement search;
	
	@FindBy (xpath = "//button[@id='search-icon-legacy']")
	private WebElement searchTab;
	
	@FindBy (xpath = "(//a[@href='/watch?v=yCLGGTTzH6o&pp=ygULWWFkYXYgQnJhbmQ%3D'])[1]")
	private WebElement song;
	
	
	
//	@FindBy (xpath = "")
//	private WebElement ;
	
	public YoutubeHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		js = (JavascriptExecutor)driver;
	}
	
	public void searchSong()
	{
		search.sendKeys("Yadav Brand");
	}
	
	public void clickOnSearchTab()
	{
		searchTab.click();
	}
	
	public void chooseSong() throws InterruptedException
	{
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true)", song);
		song.click();
	}
}
