import java.io.*;
public class FrequencyChar
{
	public static void main (String[] args) {
         String ch="";
         char i,j='A';
         try{
         	BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
         	ch=buff.readLine();
         }
         catch(Exception e)
         {
         	e.printStackTrace();
         }
         for(i='a';i<='z';i++)
         {
         	int count=0,countC=0;
         	
         	for(int k=0;k<ch.length();k++)
         	{
         		char check=ch.charAt(k);
         		if(check==i)
         		{
         			count++;
         		}
         		else if(check==j)
         		{
         			countC++;	
         		}
         	}
         	
         	if(count!=0)
         	System.out.println("character of "+i+"="+count);
         	else if(countC!=0)
             System.out.println("character of "+j+"="+countC);
             j++;
         }
}
}