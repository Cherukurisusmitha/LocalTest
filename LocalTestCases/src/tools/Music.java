package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Utils.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utils.Helper;

public class Music {
	@FindBy (id="com.miui.player:id/setting")
	WebElement setting;
	@FindBy(xpath="//*[@text='Advanced settings']") 
	WebElement next;
	@FindBy(xpath="//*[@text='By size']")
	WebElement uncheck;
//	@FindBy(xpath="//*[@id='com.miui.player:id/play_control']/[0]")  
//	WebElement play;
	@FindBy(xpath="//*[contains(@content-desc,'Play / Pause')] ")
    WebElement play;
	private static Logger Log = Logger.getLogger(Camera.class.getName());
	public Music(WebDriver driver){
	PageFactory.initElements(driver, this);
}
	public void push() throws IOException{
	final Process exec = Runtime.getRuntime().exec("adb push C:\\Users\\Admin\\Downloads\\Libraries\\Mp3 /storage/emulated/0/");
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    String s1;
    while((s1 = bufferedReader.readLine()) != null) {
    System.out.println(s1);
    Log.info("Music File Pushed");
   }}

	public  void setup() throws InterruptedException
	{
	setting.click();Thread.sleep(3000);next.click();Thread.sleep(4000);uncheck.click();Thread.sleep(3000);
	Helper.back(); Helper.back();
	Log.info("Home Page of Music");
	}
	public void play() throws InterruptedException
	{
		Thread.sleep(4000);
		play.click();
		Log.info("Music Plays");
	   
	}
}
