package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utils.Helper;

public class Files {
  
	@FindBy(id="android:id/button1")
	WebElement ok;
	@FindBy(xpath="(//*[@text='Categories'])")
	WebElement categories;
	@FindBy(xpath="(//*[@class='android.widget.LinearLayout'])[2]")
	WebElement storage;
	@FindBy(xpath="(//*[@text='Recent'])")
	WebElement recents;
//	@FindBy(id="com.android.fileexplorer:id/more")
	@FindBy(xpath="(//*[@resource-id='com.android.fileexplorer:id/more'])[0]")
	WebElement menu;
	@FindBy(xpath="(//*[@text='Create new folder'])")
	WebElement newFolder;
	@FindBy(xpath="(//*[@text='Videos'])")
	WebElement videos;
	@FindBy(xpath="(//*[@text='Docs'])")
	WebElement docs;
	@FindBy(xpath="(//*[@text='Images'])")
	WebElement images;
	@FindBy(xpath="(//*[@text='Music'])")
	WebElement music;
	@FindBy(id="com.android.fileexplorer:id/text")
	WebElement foldername;
	@FindBy(xpath="(//*[@text='More'])")
	WebElement more;
	@FindBy(xpath="(//*[@text-'Delete'])")
	WebElement delete;
	@FindBy(id="com.android.fileexplorer:id/search")
	WebElement search;
  public Files(WebDriver driver){
	  PageFactory.initElements(driver, this);
  }
  public void agreeTerms(){
	  if(ok.isDisplayed()){
		  ok.click();
	  }
  }
  public void recents(){
	if(images.isDisplayed()){
		images.click();
	}
  }
  public void storage(){
	  Helper.swipeRtoL();
  }
  public void createFolder() throws InterruptedException{
//	  storage();
	  images.click();
	  if(storage.isEnabled()){
		  System.out.println("Storage is present....");
		  storage.click();
	  }
	  Thread.sleep(7000);
	  menu.click();
	  newFolder.click();
	  foldername.sendKeys("TestFolder");
  }
}
