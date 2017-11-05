package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;
public class Camera {
	//Device md=new UiDevice();
	@FindBy (id="com.android.packageinstaller:id/permission_allow_button")
	WebElement allow;
	//permission allow button
	@FindBy(id="com.android.camera:id/v6_shutter_button_audio_sound")
	WebElement capture;
	//for clicking photo
	@FindBy (id="com.android.camera:id/v6_camera_picker")
	WebElement camerapicker;
	//for choosing front and rear camera
	
	@FindBy(id="com.android.camera:id/mode_button")
	WebElement mode;
    // for choosing Modes
	@FindBy(id="com.android.camera:id/v6_module_picker")
	WebElement video;
	// for Choosing video
	@FindBy(id="com.android.camera:id/v6_thumbnail_image_cover")
    WebElement galleryshrtcut;
	// for choosing Gallery from Camera
	@FindBy(id="com.android.camera:id/v6_shutter_button_internal")
	WebElement shooting;
	//for start/stop shooting
	@FindBy(xpath="//*[@text='OK']")
	WebElement OK;
//	Rememberphoto location pop up
	@FindBy(xpath="//*[contains(@content-desc,'Tilt-shift')] ")
    WebElement tilt;
	//FOr Selecting tilt mode
	@FindBy(xpath="//*[@text ='Parallel']")
	WebElement parallel;
	@FindBy(xpath="//*[contains(@content-desc,'Straighten')]")
	WebElement straighten;
	@FindBy(xpath="//*[contains(@content-desc,'Square')]")
	WebElement square;
	@FindBy(xpath="//*[contains(@content-desc,'GroupShot')]")
	WebElement groupshot;
	@FindBy(xpath="//*[contains(@content-desc,'Manual')]")
	WebElement manual;
	private static Logger Log = Logger.getLogger(Camera.class.getName());
	public Camera(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickPic() throws IOException, InterruptedException{
		int initial=CountImages();
		capture.click();
		int finalCount=CountImages();
	  //  md.getCurrentPackageName();
	   // System.out.println("Camera app opened");
		//assertTrue(finalCount-);()
		
		Log.info("Camera Shutter pressed");
		}
	public void launchVideo() throws InterruptedException
	{
		video.click();
	    shooting.click();
		Thread.sleep(10000);
		shooting.click();
		Thread.sleep(3000);
	    video.click();
	    Log.info("Reccording Video");
	}
	public void popup() throws InterruptedException
	{
		  
//		  if(allow.isDisplayed()) {
//			  allow.click(); }
//		  else{
//			  System.out.println("No pop up");}
//		  Thread.sleep(3000);
		  if(OK.isDisplayed())
		  {
			  OK.click();
		  }
		  else{
			  System.out.println("No pop up");
		  }
	}
	  public void verifyLaunch()
	  { 
		  Assert.assertTrue(capture.isDisplayed());
		 System.out.println("Launch successfull");
		 }
	  public void selfieTest() throws InterruptedException
	  {
		 
		  camerapicker.click();
	      capture.click();
		  video.click(); //switch to video
		  Log.info("Switched to Video");
		  Thread.sleep(2000); shooting.click();
		  Thread.sleep(10000);
		  shooting.click();	
		  Log.info("Selfie Clicked");
		  Thread.sleep(2000);
		  video.click();
		  camerapicker.click();
		  Thread.sleep(3000);
	  }
	  public void modeTest() throws InterruptedException, IOException
	  {
		
		  mode.click();
		  Log.info("Camera Modes selected");
		  Thread.sleep(3000);
		  if(tilt.isDisplayed()){
			  tilt.click(); Thread.sleep(2000);
			  Log.info("Camera Mode :Tilt selected");
			  //capture.click();
			  imageNumberChange();
			  Thread.sleep(4000); 
			  }
		  
		  if(parallel.isDisplayed()){
			  parallel.click();
			  Log.info("Camera Mode :Parallel selected");
			  imageNumberChange();
			//  capture.click(); //select another mode.
			  Thread.sleep(5000);  
			  }
		  mode.click();
		  Thread.sleep(2000);
		  if(straighten.isDisplayed()){
		  straighten.click();
		  Thread.sleep(5000);
		  Log.info("Camera Mode :Straighten selected");
		 // capture.click(); 
		  imageNumberChange();
		  Thread.sleep(2000);
		  }
		  mode.click(); 
		  Thread.sleep(4000);
		  if(square.isDisplayed()){
		  square.click();
		  Log.info("Camera Mode :Square selected");
		 // capture.click();
		  imageNumberChange();
		  Thread.sleep(5000);
		  }
		  mode.click(); 
		  Thread.sleep(4000);
		  if(manual.isDisplayed()){
		  manual.click(); 
		  Thread.sleep(4000);
		  Log.info("Camera Mode :Group selected");
		//  capture.click();
		  imageNumberChange();
		  }
		  else{
			  Log.info("Modes not present");
		  } 
	  }

public int CountImages() throws IOException, InterruptedException{
	  ArrayList<String> al=new ArrayList<String>();
	  final Process exec = Runtime.getRuntime().exec("adb shell ls /sdcard/DCIM/Camera");
      
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    String s;
   // int initialCount=0;
    int finalCount=0;
    while((s = bufferedReader.readLine()) != null) {
    //    System.out.println(s);
        al.add(s);
       // System.out.println("SIZE OF COMPONENTS---DEB"+al.size());
        
        
        }
   // Log.info("DEB"+al.size());
    finalCount=al.size();
    
 Thread.sleep(3000);
return finalCount;
}
public void imageNumberChange() throws IOException, InterruptedException{
	  int initialCount=CountImages();
	 capture.click();
	 Thread.sleep(3000);
	  int finalCount=CountImages();
	  
	  if(finalCount-initialCount>1){
		  Assert.assertTrue(true,"Capture Successful");
		  Log.info("Image Captured Sussefssfully");
	  }
	  else{
		  Log.info("Capture Unsuccessful");
	  }
}}