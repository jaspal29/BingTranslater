import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import bsh.Token;


public class BIngAPi {
static TokenGetter token;
public  void apibing() throws Exception
{  
	String finalstring = null;
	StringBuilder str2=new StringBuilder();
	String [] data=file.dataString("/home/jaspalchandramola/Desktop/file");
	Data [] datafile =file.extractinfo(data);
	File file_code = new File("/home/jaspalchandramola/Desktop/code.csv");
	Map map=new HashMap();   
	
	@SuppressWarnings("resource")
	BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file_code)));
    String line_code = null;
    while( (line_code = br1.readLine())!= null )
      {
      String[] language = line_code.split(",");
      map.put(language[0],language[1]);
      }
	
    
 
    
	for(int i=0;i<datafile.length;i++){	
	String text = datafile[i].getdata();
	String from = (String) map.get(datafile[i].getfrom());
	String to = (String) map.get(datafile[i].getto());	
token=new TokenGetter();


String uri = "http://api.microsofttranslator.com/v2/Http.svc/Translate?text=" + URLEncoder.encode(text) + "&from=" + from + "&to=" + to;


String Token = "Bearer" + " " +token.getToekn();
URL url=new URL(uri);
HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
httpURLConnection.setRequestMethod("GET");
httpURLConnection.setRequestProperty("Authorization",Token);





BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
String inputLine;
StringBuffer answer = new StringBuffer();
while ((inputLine = br.readLine()) != null) {
	answer.append(inputLine);
}
br.close();
System.out.println(answer.toString());
 finalstring=answer.toString();
 finalstring = finalstring.substring(finalstring.indexOf(">") + 1);
 try{
 finalstring = finalstring.substring(0, finalstring.indexOf("<"));		
 }
 catch(Exception e){}
 System.out.println(finalstring);

str2.append(" "+finalstring);

	}
	
	
	file.write(str2,"/home/jaspalchandramola/Desktop/file4");
	



}
}
