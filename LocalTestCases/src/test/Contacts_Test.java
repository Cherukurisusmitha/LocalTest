package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.AllPermission;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.AllPermissions;
import tools.Contacts;
import Utils.Helper;
@Listeners(Utils.Listener.class)

public class Contacts_Test {

	public static AndroidDriver driver=StartApplication.driver;
	public static Contacts contacts;
@BeforeClass
    public static void launchContacts() throws IOException, InterruptedException, MalformedURLException {

		driver = StartApplication.preconditions(AppIdentifiers.ContactsPackage, AppIdentifiers.ContactsActivity);
		contacts = new Contacts(driver);  

  }
	@Test//(priority=1)
    public void createContact() throws InterruptedException{
	  Thread.sleep(1000);
  	  contacts.createNewConatct("Tester1","9965784567","tester@gmail.com");
  	  Thread.sleep(3000);
  	  Helper.back();
  	  contacts.verifyContacts(driver,"Tester1");
   }
  @Test//(priority=6,dependsOnMethods={"createContact"})
   public void deleteContact() throws InterruptedException{
	   Thread.sleep(1000);
   contacts.delContact(driver, "Tester1");
   
   }

   @Test//(priority=4)
   public void importContacts() throws InterruptedException{
	   contacts.impToStorage();
	   Thread.sleep(3000);
	   Helper.back();

   }

   @Test//(priority=5)
   public void exportContacts() throws InterruptedException{
	   contacts.exportToStorage();
	   Thread.sleep(3000);
	   Helper.back();
   }
 //  @Test//(priority=2)
   public void deletebatch() throws InterruptedException{
	   contacts.delBatch(); 
	   Thread.sleep(4000);
	   Helper.back();
   }
 
/*    @Test
    public void createSimcontact() throws InterruptedException{
    	Thread.sleep(2000);
    	contacts.createSimContact("Tester3","123455667","test1@gmail.com");
    	
    }
*/

/*@AfterMethod
public void launch() throws InterruptedException, MalformedURLException{
	contacts.contactsCount();

}*/
}