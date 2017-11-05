package tools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utils.Helper;
import io.appium.java_client.android.AndroidDriver;

public class Gallery {
//	WebDriver driver;
//	AndroidDriver driver;
	int imgCount;
//	AndroidDriver driver;
//	@FindBy(xpath="(//*[@text='Take a photo'])")
	@FindBy(id="com.miui.gallery:id/action_button")
	WebElement takePhoto;
	@FindBy(xpath="(//*[@text='Empty'])")
	WebElement empty;
	@FindBy(id="com.android.camera:id/v6_shutter_button_internal")
	WebElement shutter;
	@FindBy(xpath="(//*[@text='Delete'])")
	WebElement delete;
	@FindBy(id="android:id/button1")
	WebElement ok;
	@FindBy(xpath="(//*[@text='Albums'])")
	WebElement  albums;
	@FindBy(id="com.miui.gallery:id/create_album")
	WebElement createAlbum;
	@FindBy(xpath="(//*[@text='Album name'])")
	WebElement albumName;
	@FindBy(xpath="(//*[@text='Photos'])")
	WebElement photos;
	@FindBy(xpath="(//*[@text='More'])")
	WebElement more;
	@FindBy(xpath="(//*[@text='Add to album'])")
	WebElement addtoalbum;
	@FindBy(xpath="(//*[@text='Testimg'])")
	WebElement createdFolder;
	@FindBy(xpath="(//*[@text='Select all'])")
	WebElement selctAll;
	@FindBy(xpath="(//*[@text='Set as wallpaper'])")
	WebElement setasWallpaper;
	@FindBy(xpath="(//*[@text='Apply'])")
	WebElement apply;
	@FindBy(xpath="(//*[@resource-id='android:id/text1'])[0]")
	WebElement setasLockscreen;
	@FindBy(xpath="(//*[@resource-id='android:id/text1'])[1]")
	WebElement setashomescreen;
	@FindBy(xpath="(//*[@resource-id='android:id/text1'])[2]")
	WebElement setboth;
	
	@FindAll({@FindBy(xpath="(//*[@resource-id='com.miui.gallery:id/micro_thumb'])")})
	public List<WebElement> allImages;
	
	 public Gallery(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
	 
	 public void imagecount(AndroidDriver driver){
//		 List<WebElement> galleryImages = driver.findElements(By.xpath("(//*[@resource-id='com.miui.gallery:id/pick_num_indicator'])"));
	
		  imgCount = allImages.size();
		 System.out.println("Total images present are .."+imgCount);
	 }
	 public void captureFromGallery() throws InterruptedException{
		 Thread.sleep(5000);
		 try{
			 if(takePhoto.isDisplayed()){
				 System.out.println("Take a photo is present...");
				 takePhoto.click();
				 shutter.click();
				 Helper.back();
			 }
			 else if(empty.isDisplayed()){
				 empty.click();
				 shutter.click();
				 Helper.back();
			 }
			
		 }catch(Exception e){
			 System.out.println("Images are already present in Gallery..");
		 }

	 }
	 
	 public void openImg() throws InterruptedException{
		 List<WebElement> images=allImages;
		 System.out.println(images.size());
		 images.get(0).click();
		 Thread.sleep(3000);
	 }
	 public void deleteImg() throws InterruptedException{
		 openImg();
		 delete.click();
//		 Thread.sleep(7000);
		 ok.click();
		 Helper.back();		 
	 }
	 
	 public void createAlbum() throws InterruptedException{
		 albums.click();
		 createAlbum.click();
		 albumName.sendKeys("Testimg");
		 ok.click();
		 Thread.sleep(3000);
		 ok.click();
		 photos.click();
	 }
	 public void addImgtoAlbum() throws InterruptedException{
		 openImg();
		 more.click();
		 addtoalbum.click();
		 Thread.sleep(4000);
		 createAlbum.click();
	 }
	 public void delMultiplle(AndroidDriver driver) throws InterruptedException{
		 List<WebElement> images=allImages;
		 Helper.longpress(driver, images.get(0));
		 Thread.sleep(3000);
		 selctAll.click();
		 delete.click();
		 delete.click();
	 }
	 public void delAlbums(AndroidDriver driver){
		 albums.click();
		 Helper.longpress(driver, createdFolder);
		 delete.click();
		 ok.click();
	 }
	 public void setasWallpaper() throws InterruptedException{
		 openImg();
		 more.click();
		 Thread.sleep(3000);
		 setasWallpaper.click();
		 Thread.sleep(2000);
		 apply.click();
//		 Thread.sleep(7000);
		 setboth.click();
		 Thread.sleep(3000);
		 Helper.back();
	 }
}
