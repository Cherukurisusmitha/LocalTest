package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

public class TestCase_Call {
  @Test(priority=0)
  public void startcode() throws IOException 
  {
	 final Process exec = Runtime.getRuntime().exec("adb shell am start -a android.intent.action.CALL -d tel:9498007353");
     final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
     String s;
     while((s = bufferedReader.readLine()) != null) 
     {
         System.out.println(s);}
     }
  }

