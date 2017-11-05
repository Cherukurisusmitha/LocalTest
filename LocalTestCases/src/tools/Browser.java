
package tools;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Helper;
import Utils.Log;
import android.view.KeyEvent;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Browser {
// WebDriver driver;
  @FindBy(id="com.android.packageinstaller:id/permission_allow_button")
 WebElement permissions;
 @FindBy(id="android:id/button1")
 WebElement terms;
 @FindBy(id="com.android.browser:id/search_hint")
 //@FindBy(xpath="(//*[@text='Enter a URL or search the web'])")
 WebElement browse;
 @FindBy(id="com.android.browser:id/rightBtn")
 WebElement go;
 @FindBy(id="com.android.browser:id/action_more")
 WebElement menu;
 @FindBy(id="com.android.browser:id/action_menu_bookmark")
 WebElement addBookmark;
 @FindBy(id="com.android.browser:id/action_menu_useful_page")
 WebElement addShortcut;
 @FindBy(id="com.android.browser:id/sendstartpage")
 WebElement startpage;
 @FindBy(id="com.android.browser:id/senddesktop")
 WebElement hs;//shortcut to homescreen
 @FindBy(id="android:id/button1")
 WebElement ok;
 @FindBy(id="com.android.browser:id/action_menu_history")
 WebElement bookmarks;
 //@FindBy(id="com.android.browser:id/label")
 @FindBy(id="com.android.browser:id/url")
 WebElement bmList;
 @FindBy(id="com.android.browser:id/action_tabs")
 WebElement add;//pages count to add new tab
 @FindBy(id="com.android.browser:id/nav_action_new_tab")
 WebElement newTab;
 @FindBy(id="com.android.browser:id/action_menu_toolbox")
 WebElement tools;
 @FindBy(id="com.android.browser:id/action_menu_snapshot")
 WebElement savePage;
 @FindBy(xpath="(//*[@resource-id='com.android.browser:id/title'])")
 WebElement asScreenshot;
 @FindBy(xpath="(//*[@text='Save as HTML file'])")
 WebElement asHtmlPage;
 @FindBy(id="android:id/button1")
 WebElement save;
 @FindBy(id="com.android.browser:id/action_home")
 WebElement homePage;
 @FindBy(xpath="(//*[@class='android.widget.LinearLayout'])[1]")
 WebElement history;
 @FindBy(id="com.android.browser:id/clear_history_menu_id")
 WebElement clearHistory;
 @FindAll({@FindBy(xpath="(//*[@class='android.widget.TextView'])")})
 public List<WebElement> defShortcuts;
@FindBy(xpath="(//*[@resource-id='com.android.browser:id/url'])")
WebElement Url;
@FindBy(xpath="(//*[@resource-id='com.android.vending:id/title_creator'])") 
WebElement appCreator;
@FindBy(id="com.android.vending:id/title_title")
WebElement appTitle;
 //////////////////////////////////
//private static Logger Log = Logger.getLogger(Camera.class.getName());
String appName;	
String urlText;
String shortcutName;
String appdetails;

 public Browser(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
 
 
  public void agreeTerms() throws InterruptedException {
	  if(terms.isDisplayed()){
		  Thread.sleep(3000);
		  terms.click();
	  }
	  else{
		  Thread.sleep(3000);
	  }
  }
  public void browse(String url) throws InterruptedException{
//	  System.out.println(browse.isDisplayed());
	  homePage.click();
	  Thread.sleep(4000);
//	  browse.click();
	  browse.sendKeys(url+"\n");
//	  go.click();
	  Thread.sleep(5000);
	  
  }
  public void addBookmark() throws InterruptedException
  {
	  browse("www.python.org");
	  menu.click();
	  if(addBookmark.isEnabled())
		  {
		  addBookmark.click();
		  }
	  else{
		  Helper.back();
		  browse("www.python.org");
		  Thread.sleep(5000);
		  menu.click();
		  addBookmark.click();
	  }
  }
  public void addShortcutToStartPage() throws InterruptedException{
	  menu.click();
	  if(addShortcut.isEnabled()){
		  addShortcut.click();
  	  }
	  else{
		  Helper.back();
		  browse("www.python.org");
		  Thread.sleep(3000);
		  menu.click();
		  addShortcut.click();
	  }
	  startpage.click();
	  ok.click();
  }
  public void addShortcutToHomeScreen() throws InterruptedException{
	  menu.click();
	  if(addShortcut.isEnabled()){
		  addShortcut.click();
  	  }
	  else{
		  Helper.back();
		  browse("www.python.org");
		  Thread.sleep(5000);
		  menu.click();
		  addShortcut.click();
	  
	  }
	  hs.click();
	  ok.click();
	  
  }
  public void verifyBookmark(String expurl) throws InterruptedException{
	  menu.click();
	  bookmarks.click();
	  Thread.sleep(3000);
	  if(bmList.isDisplayed()){
		  String acturl= bmList.getText();
			 System.out.println(acturl);
			 Assert.assertEquals(acturl, expurl,"Pass");
	  }
	 
  }
  public void addNewTab(){
	  add.click();
	  newTab.click();
	  
  }
  public void savePageAsHTML() throws InterruptedException{
	  menu.click();
	  tools.click();
	  if(savePage.isEnabled())
	  {
		  savePage.click();
		  Thread.sleep(1500);
		  asHtmlPage.click();
		  Thread.sleep(1500);
		  save.click();
	  }
	  else{
		  Helper.back();
		  browse("www.mi.com");
		  Thread.sleep(3000);
		  menu.click();
		  tools.click();
		  savePage.click();
		  Thread.sleep(3000);
		  asHtmlPage.click();
		  save.click();
	  }

  }
  public void savePageAsScreenshot() throws InterruptedException{
	  menu.click();
	  tools.click();
	  if(savePage.isEnabled())
	  {
		  savePage.click();
		  asScreenshot.click();
	  }
	  else{
		  Helper.back();
		  browse("www.mi.com");
		  Thread.sleep(3000);
		  menu.click();
		  tools.click();
		  savePage.click();
		  Thread.sleep(4000);
		  asScreenshot.click();
	  }
  }
  public void homePage() throws InterruptedException{
	  if(homePage.isDisplayed()){
		  homePage.click();
	  }
	  else{
		  Helper.back();
		  Thread.sleep(4000);
		  homePage.click();
	  }
  }
  public void viewHistory() throws InterruptedException{
	
		menu.click();
		bookmarks.click();
		Thread.sleep(3000);
	//	history.click();
		Helper.swipeRtoL();
		Thread.sleep(2000);
		
	}
  public void clearHistory() throws InterruptedException{
	  viewHistory();
	  if(clearHistory.isDisplayed()){
	  clearHistory.click();
	  ok.click();
	  System.out.println("History is cleared successfully");
	  
	  }
	  else{
		  System.out.println("History is Empty");
	  }
  }
  public void defaultShortcuts(WebDriver driver) throws InterruptedException{
	  Log.info("get name of defaults browser shortcuts");
	  int shortcutCount = defShortcuts.size();
		 System.out.println("Total shortcuts present are .."+(shortcutCount));

		 for(int i=3;i<shortcutCount;i++){

			 	WebElement wb = defShortcuts.get(i);
			 	 shortcutName = wb.getText();

			 	System.out.println("\nName + Number===>"+shortcutName+"  and shortcut position is "+i);
/*		 	if(!(wb.isDisplayed()))
			 	{
// 		    		System.out.println("Name + Number****===>"+wb.getText());
			 		System.out.println("###########Scroll###############");
			 		Helper.scroll();
			 	}
			 	else{
			 		
			 	}*/
			 	if((shortcutName.equals("Top Sites"))||(shortcutName.equals("App Store"))||(shortcutName.equals("Add"))||(shortcutName.equals("Top Apps"))){
			 		System.out.println("Skipped.."+shortcutName+" Shortcut");
			 	}
			 	else{
			 		wb.click();
			 	
			 	Thread.sleep(12000);
			 	try{
			 		 appName = appCreator.getText();
			 		 appdetails=appTitle.getText();
			 		 appName=appName.toLowerCase();
					 shortcutName = shortcutName.toLowerCase();
			 		 appdetails=appdetails.toLowerCase();
	 				System.out.println("Shortcut is of APP  "+appName);
	 				Thread.sleep(3000);
	 				Helper.back();	
	 				homePage.click();
	 				Thread.sleep(7000);
	 				if(appName.contains(shortcutName)){
	 					System.out.println(shortcutName+" is Pass....");
	 				}
	 				else if(appdetails.contains(shortcutName)){
	 					System.out.println(shortcutName+" is Pass....");
	 				}
	 				else{
	 					System.out.println(shortcutName+" is Fail.. given link is of.."+appName);
	 				}
			 	}catch(Exception e)
			 	{
			 		System.out.println("Shortcut is of browser link");
		 			Thread.sleep(3000);
//		 			driver.getTitle();
		 			 urlText = Url.getText();
					shortcutName = shortcutName.toLowerCase();
		 			System.out.println("url link.... "+urlText);
		 			Helper.back();
		 			homePage.click();
		 			
		 			if(urlText.contains(shortcutName)){
	 					System.out.println(shortcutName+" is Pass....");
	 				}
	 				else{
	 					System.out.println(shortcutName+" is Fail.. given link is of..");
	 				}
			 		
			 	}
			 	}
			 			
		 	}
		
		}
	  
  }

  

  

  

