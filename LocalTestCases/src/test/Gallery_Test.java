package test;

import java.net.MalformedURLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Gallery;
@Listeners(Utils.Listener.class)
public class Gallery_Test {
	public static AndroidDriver driver;
	public static Gallery gallery;
  @Test
  public void captureFromGallery() throws MalformedURLException, InterruptedException {
	  
	  driver = StartApplication.preconditions(AppIdentifiers.GalleryPackage, AppIdentifiers.GalleryActivity);
	  gallery = new Gallery(driver);
	  Thread.sleep(10000);
//	  gallery.captureFromGallery();
	
  }
  @Test
  public void imgCount(){
	  gallery.imagecount(driver);
	 
  }
  @Test
  public void delImg() throws InterruptedException{
	  gallery.deleteImg();
  }
  @Test(dependsOnMethods={"createalbum"})
  public void deleteAlbum(){
	  gallery.delAlbums(driver);
  }
 // @Test
  public void delAllImages() throws InterruptedException{
	  gallery.delMultiplle(driver);
  }
  @Test
  public void setAsWallpaer() throws InterruptedException{
	  gallery.setasWallpaper();
	  
  }
  @Test
  public void createalbum() throws InterruptedException{
	  gallery.createAlbum();
  }
  @Test
  public void addImgtoAlbum() throws InterruptedException{
	  Thread.sleep(4000);
	  gallery.addImgtoAlbum();
  }
}
