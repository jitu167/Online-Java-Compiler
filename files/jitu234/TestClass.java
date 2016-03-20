/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/
        int count=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line2=br.readLine();
        int A=Integer.parseInt(line2);
        System.out.print("Enter no.");
        ArrayList lst=new ArrayList();
        String line = br.readLine();
        int N = Integer.parseInt(line);
         System.out.print("Enter no.");
        int space=0;
        String line3=br.readLine();
       int ii=0;
        	String line4="";
             int space1=line3.indexOf(" ");
             line3=line3.replaceAll("\\s","");
             System.out.println(line3);
             for(char c: line3.toCharArray())
        {    
             lst.add(line3.charAt(ii));
             System.out.println("Enter no."+line3.charAt(ii));
             ii++;
        }
        for(int i=0;i<lst.size();i++)
        {
        	String sd=(String)lst.get(i).toString();
        	int d=Integer.parseInt(sd);
        	int greater=0,checkno1=0,checkno2=0;
    	if(A>d)
    	{
    		greater=A;
    	}
    	else 
    	greater=d;
    	for(int j=2;j<greater;i++)
    	{
    	    checkno1=A%j;
    	    checkno2=d%j;
    	    if(checkno1==0 && checkno2==0)
    	    {
    	    	count++;
    	    }
    	}
        }

        System.out.println(count);
    }
   
}