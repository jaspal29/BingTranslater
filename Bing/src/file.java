import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Assert;


public class file {	
	
	public static  Data[] extractinfo(String [] array) {
		Data [] data=new Data[array.length];
		int i=0;
		while(i<array.length)
		{
		  
		  String[] dataarray=array[i].split(",",3);
		  
		 data[i]=new Data(dataarray[0],dataarray[1],dataarray[2]);
		  


		i++;



		}
			
			
			
			
			return data;
		}
	
	
	
	public static  String[] dataString(String str) throws IOException
	{
		FileInputStream fileInputStream=new FileInputStream(str);
		int j=0;
		StringBuilder  d=new StringBuilder();;
		for(;( j=fileInputStream.read())!=-1;)
		{    

		   d.append((char)j);
		


		}
		System.out.print(d);
		fileInputStream.close();
		String string=new String(d);
		String [] dataArray=string.split("\\n");
		return dataArray;	


	}
	
	
	public static void write(StringBuilder str2,String str) throws IOException
	{
		FileOutputStream fileOutputStream=new FileOutputStream(str);
		String string=new String(str2);
		byte[] b=string.getBytes();
		fileOutputStream.write(b);	
		fileOutputStream.flush();
		fileOutputStream.close();

		
		
		
		
	}
	
	public static boolean compare() throws IOException
	{
		 FileInputStream f1=new FileInputStream("/home/jaspalchandramola/Desktop/file4");
		  FileInputStream f2=new FileInputStream("/home/jaspalchandramola/Desktop/file1");
		  
		  
		  while((f1.read()!=-1)&&(f2.read()!=-1))
		  {
			if(f1.read()!=f2.read())
			{
				
				return false;
			}
			  
			  
		  }
		  
		  f1.close();
		  f2.close();
		
		  return true;
		
		
	}
	
	
}
