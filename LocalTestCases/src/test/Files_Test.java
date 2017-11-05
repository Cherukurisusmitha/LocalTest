package test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Files;

public class Files_Test {
	public static AndroidDriver driver;
	public static Files files;
	@Test
  public void launchFiles() throws MalformedURLException, InterruptedException {
		driver=StartApplication.preconditions(AppIdentifiers.FilesPackage, AppIdentifiers.FilesActivity);
		files=new Files(driver);
		files.agreeTerms();
		Thread.sleep(3000);
  }
	@Test
	public void showRecents() throws InterruptedException{
		files.createFolder();
	}

		
	}
	


