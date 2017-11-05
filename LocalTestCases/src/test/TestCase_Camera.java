package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;
import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Camera;
import org.apache.log4j.Logger;
public class TestCase_Camera {
	static tools.Camera camera;
  @SuppressWarnings("rawtypes")
@Test(priority =0)
  public void LaunchCamera() throws InterruptedException, IOException 
  {
	  Logger Log = Logger.getLogger(Camera.class.getName());
	  Log.info("************CAMERA TEST CASES *************");
	  AndroidDriver dr1= StartApplication.preconditions(Utils.AppIdentifiers.CameraPackage,Utils.AppIdentifiers.CameraActivity);
	  camera =new tools.Camera(dr1); 
	  }
	  @Test(priority=1)
	  public static void popMain() throws InterruptedException
	  {
	  Thread.sleep(4000);
	  camera.popup();
	  }
	  @Test(priority=2)
	  public static void click() throws InterruptedException, IOException
	  {
	  camera.clickPic();
	  
	   Thread.sleep(10000);
	   final Process exec = Runtime.getRuntime().exec("adb shell ls /sdcard/DCIM/Camera");
        
	      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
	      String s;
	      while((s = bufferedReader.readLine()) != null) {
	          System.out.println(s);}
	   Thread.sleep(3000);
	   }
	  @Test (priority=3)
	  public void verify() throws IOException, InterruptedException
	  {
		  
	   camera.verifyLaunch();
	  // StartApplication.log.debug("Launching");
	   
	   camera.clickPic();
	  }
	  @Test (priority =4)
	  public void video() throws InterruptedException
	  {
	   Thread.sleep(4000);
	   camera.launchVideo();
	   Thread.sleep(1000);
	  }
	  @Test (priority =5)
	  public void selfie() throws InterruptedException
	  {
	   camera.selfieTest();
	   Thread.sleep(4000);
	  }
	  @Test(priority = 6)
	  public void mode() throws InterruptedException, IOException
	  {
	   camera.modeTest();
	  
	  }
  }
