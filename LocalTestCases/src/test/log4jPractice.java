package test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.testng.annotations.Test;

	public class log4jPractice 
	{
	   final Logger LOGGER = Logger.getLogger(log4jPractice.class);

	   @Before
	   public void init() throws Exception
	   {
	       BasicConfigurator.configure();
	   }

	   @Test
	    public void testOne() throws Exception {
	       LOGGER.info("INFO TEST");
	       LOGGER.debug("DEBUG TEST");
	       LOGGER.error("ERROR TEST");

	       assertTrue(true);
	    }

	   @Test
	   public void testTwo(){
	       LOGGER.info("INFO TEST");
	       LOGGER.debug("DEBUG TEST");
	       LOGGER.error("ERROR TEST");
 
	       assertTrue(true);
	   }
	}

