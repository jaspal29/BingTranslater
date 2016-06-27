
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Bing {
	
public  void uibing() throws IOException, InterruptedException
{  
	FileOutputStream fileOutputStream;
	StringBuilder str2=new StringBuilder();
	//file data 
	String [] data=file.dataString("/home/jaspalchandramola/Desktop/file");
	//opening firefox
	WebDriver webDriver=new FirefoxDriver();
	webDriver.get("https://www.bing.com/translator/");
	webDriver.manage().window().maximize();
	
	//elements
	WebElement sourcetext=webDriver.findElement(By.id("srcText"));
	WebElement destination=webDriver.findElement(By.id("destText"));
	//WebElement destination1=destination1.findElement(By.id(""));
	
	
	List<WebElement> button=webDriver.findElements(By.className("LS_Header"));
	
	List<WebElement> language=webDriver.findElements(By.className("LanguageList"));
	List<WebElement> selectsource=language.get(0).findElements(By.className("LS_Item"));
	List<WebElement> selectdestination=language.get(1).findElements(By.className("LS_Item"));
	
	//information about language
	
	
	Data [] datafile =file.extractinfo(data);
	
	
	for(int k=0;k<datafile.length;k++){
		
	button.get(0).click();
	for(int i=0;i<54;i++){
	String str=selectsource.get(i).getText();
	if(str.equals(datafile[k].getfrom()))
	{
		//System.out.println("matched");
		
		selectsource.get(i).click();
		break;
	}
	}
	
	
	button.get(1).click();
	for(int i=0;i<53;i++){
		String str1=selectdestination.get(i).getText();
		if(str1.equals(datafile[k].getto()))
		{
			//System.out.println("matched");
			
			selectdestination.get(i).click();
			break;
		}
	}
	
	
	sourcetext.sendKeys(datafile[k].getdata());	
	webDriver.findElement(By.id("TranslateButton")).click();
	Thread.sleep(3000);
	String str23=destination.getText();
	str2.append(" "+str23);
   
    if(k!=datafile.length){
    Thread.sleep(3000);
    sourcetext.clear();
	}
    
	}
	webDriver.close();
	
	file.write(str2,"/home/jaspalchandramola/Desktop/file1");
	

}


}
