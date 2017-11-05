package tools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ChromeBrowser {
  WebDriver driver;
  @FindBy(xpath="(//*[@text='ACCEPT & CONTINUE'])")
  WebElement accept;
  @FindBy(xpath="(//*[@text='NO THANKS'])")
  WebElement noThanks;
  @FindBy(xpath="(//*[@text='Search or type URL'])")
  WebElement searchUrl;
  @FindBy(xpath="(//*[@text='NEXT'])")
  WebElement next;
  @FindBy(id="com.android.chrome:id/tab_switcher_button")
  WebElement switcher;
  @FindBy(id="com.android.chrome:id/new_tab_button")
  WebElement newTab;
  @FindBy(xpath="(//*[@text='Close all tabs'])")
  WebElement closeAllTabs;
  @FindBy(id="com.android.chrome:id/menu_button")
  WebElement menu;
  @FindBy(xpath="(//*[@content-desc='398x230_bt_speaker'])")
  WebElement bt;
  public ChromeBrowser(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
  public void Browserinit() throws InterruptedException{
	  accept.click();
	  Thread.sleep(7000);
	  if(next.isDisplayed()){
		  System.out.println("***********************SSSSSSSSSS*****************************");
		  System.out.println(next.isDisplayed());
		  next.click();
  	  }
	  else{
		  
	  }
	  Thread.sleep(6000);
	  noThanks.click();
  }
  public void browsepage(String url){
	  searchUrl.sendKeys(url+"\n");
//	  searchUrl.sendKeys(Keys.ENTER);
  }
  public void newTab(){
	  switcher.click();
	  newTab.click();
  }
  public void closeTabs() throws InterruptedException{
	  switcher.click();
	  menu.click();
	  Thread.sleep(1500);
	  closeAllTabs.click();
  }
}
