package tools;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Themes {

	@FindBy(xpath="//*[@text='Themes']")
    WebElement themes;
	@FindBys(@FindBy(xpath="//android.widget.FrameLayout[@resource-id='com.android.thememanager:id/root_flag']"))
    List<WebElement> selects;
	@FindBy(id="com.android.thememanager:id/applyBtn")
	WebElement apply;
	private static Logger Log = Logger.getLogger(Camera.class.getName());
	public Themes(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void launchThemes()
	{
		themes.click();
		Log.info("themes launched");
	}
	public void selectThemes1() throws InterruptedException
	{
		  for(int j=0;j<=selects.size();j++)
		  { Thread.sleep(3000);}
		  Log.info("themes iteration");
		  ((WebElement) selects.get(1)).click();
		  Log.info("themes 1 selected");
	}
	
	public void applyThemes()
	{
		apply.click();
		Log.info("themes applied");
	}
}
