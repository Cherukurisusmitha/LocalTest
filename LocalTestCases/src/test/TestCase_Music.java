package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Music;

public class TestCase_Music {
	static tools.Music music;
     @Test(priority=0)
     public void LaunchMusic() throws InterruptedException, IOException  {
      Logger Log = Logger.getLogger(tools.Music.class.getName());
   	  Log.info("************MUSIC TEST CASES *************");
	  AndroidDriver dr1= StartApplication.preconditions(Utils.AppIdentifiers.MusicPackage,Utils.AppIdentifiers.MusicActivity);
	  music =new tools.Music(dr1);
     }
     @Test(priority =1)
	  public void pushFile() throws InterruptedException, IOException
	  {
	  music.push(); Thread.sleep(5000);
	  }
     @Test(priority =2)
     public void setupInitial() throws InterruptedException
     {
	  music.setup();Thread.sleep(4000);
     }
     @Test(priority =3)
     public void start() throws InterruptedException
     {
    	 music.play(); Thread.sleep(10000);
     }
  }

