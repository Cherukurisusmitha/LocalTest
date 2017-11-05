package tools;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messaging {
	@FindBy(id="com.android.mms:id/fab")
	WebElement wb;
    @FindBy (id="com.android.mms:id/recipients_editor")
	WebElement editor;
    @FindBy(id="com.android.mms:id/recipients_editor")
    WebElement to;
    @FindBy(id="com.android.mms:id/embedded_text_editor")
    WebElement message;
    @FindBy(id="com.android.mms:id/send_button")
    WebElement send;
    @FindBy(id="com.android.mms:id/switch_btn")
    WebElement mms;
    @FindBy(xpath="//*[@text ='Take photo']")
    WebElement takephoto;
    @FindBy(id="com.android.camera:id/v6_shutter_button_internal")
    WebElement click;
    @FindBy(id ="com.android.camera:id/v6_btn_done")
    WebElement select;
    @FindBy(id="com.android.mms:id/attachment_panel")
    WebElement attachment;
    private static Logger Log = Logger.getLogger(Camera.class.getName());
    public Messaging(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void launchMMS(){
		wb.click();
		editor.click();
		Log.info("Message Launch Passed");
}
	public void compose() throws InterruptedException{
		to.sendKeys("9498007353");
		message.sendKeys("asdfghjklmnbvcxzqwertyuiop"); send.click();
		Thread.sleep(5000);
		Log.info("Message Send Passed");
		
	}
	public void mms() throws InterruptedException{
		wb.click();
		to.sendKeys("9498007353"); mms.click(); Thread.sleep(6000);
		//attachment.click();Thread.sleep(4000);
	    takephoto.click(); Thread.sleep(5000);click.click(); Thread.sleep(4000);
		select.click(); send.click();
		Log.info("MMS Sending Passed");
	}
		
	}
	
