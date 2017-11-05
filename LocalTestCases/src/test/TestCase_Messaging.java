package test;

import org.testng.annotations.Test;
import java.io.IOException;
import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import Utils.Helper;
import test.StartApplication;
import tools.Messaging;
import org.apache.log4j.Logger;

	public class TestCase_Messaging{
	static tools.Messaging message;

  @Test(priority=0)
  public static void LaunchMessage() throws InterruptedException, IOException{
	  @SuppressWarnings("rawtypes")
	  Logger Log = Logger.getLogger(tools.Messaging.class.getName());
	  Log.info("************MESSAGE TEST CASES *************");
	  AndroidDriver dr= StartApplication.preconditions(Utils.AppIdentifiers.MessagePackage,Utils.AppIdentifiers.MessageActivity);
	  message=new tools.Messaging(dr);
  }
  @Test(priority=1)
  public void startapp()
  {
	  message.launchMMS();
  }
  @Test(priority=2)
  public void send() throws InterruptedException
  {
	  message.compose();
	  Utils.Helper.back(); 
	  Utils.Helper.back();
	  Thread.sleep(5000);
  }
	  //AndroidDriver dt=StartApplication.back();
  
	@Test (priority =3)
	public void mmsTest() throws InterruptedException
	{
	     message.mms();
	}
	  
  

	}

	

