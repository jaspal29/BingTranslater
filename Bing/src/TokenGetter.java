
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.google.gson.JsonObject;

public class TokenGetter {

public String getToekn() throws Exception {

	  
	String  cd=URLEncoder.encode("jas123_pal","UTF-8");
	String cv=URLEncoder.encode("reJ8FmwnMnVKBBeSJDcaSCYRuzzjEnZE3bUuu4DbAb0=","UTF-8");
	
	URL url = new URL("https://datamarket.accesscontrol.windows.net/v2/OAuth2-13");
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    
    
    conn.setRequestMethod("POST");
    conn.setDoOutput(true);
    conn.setRequestProperty("Accept-Language","en-US,en;q=0.5");
   
  
	DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
	
    writer.writeBytes("grant_type=client_credentials&client_id="+cd+"&client_secret="+cv+"&scope=http://api.microsofttranslator.com");
   
    writer.flush();
    writer.close();
  
 
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
   	String inputLine;
	StringBuffer Token = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		Token.append(inputLine);
	}
	in.close();
	System.out.println(Token.toString());
	String str=new String(Token); 
JSONObject js=new JSONObject(str);
	String token1=(String)js.get("access_token");
return token1;
    

  }
}




