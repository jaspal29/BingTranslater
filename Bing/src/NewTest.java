

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class NewTest {
  @SuppressWarnings("deprecation")
@Test
  public void f() throws IOException {
	 Assert.assertEquals(true, file.compare());
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	BIngAPi  a=new BIngAPi();
	a.apibing();
	Bing b=new Bing();
	b.uibing();
	  
  }

}
