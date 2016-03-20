package com.example.compiler;
import java.io.*;

import java.io.FileOutputStream;

import java.io.OutputStream;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	
	Context ctxt;
	 String fileName;
	 SharedPreferences.Editor editor;
	String user,password;
	 public String fileextension;
	String k;
	Button login;
	InputStream is=null;
  EditText username,passw;
	String [] extensions;
	SharedPreferences share;
          public void onCreate(Bundle sd)
          {
        	  super.onCreate(sd);
        	  setContentView(R.layout.login);
        	  ctxt=this.getApplicationContext();
        	  login=(Button)findViewById(R.id.login);
        	 // cancel=(Button)rootview.findViewById(R.id.btnCancel);
        	  username=(EditText)findViewById(R.id.uname);
        	   passw=(EditText)findViewById(R.id.pass);
        	   Session sess=new Session(ctxt);
        	   Toast.makeText(getBaseContext(), "Designed and developed by JITENDRA KUMAR", 1).show();
  		        	if (sess.getusename().compareTo("")!=0)
  		          {
  		        		
  		        		 Intent i=new Intent("com.example.compiler.MainActivity");
	      				 startActivity(i);
                          finish();
  		          }
  		        	else
  		        	{
        	  login.setOnClickListener(new OnClickListener(){
        		 
        		  public void onClick(View v) {
      				try
      				{
      					
      					 user=username.getText().toString();
      		              password=passw.getText().toString(); 
      				new result().execute();
      				 
      			    }
      				catch(Exception e)
      				{
      					CharSequence ce=e.getMessage();
      					Toast.makeText(getBaseContext(),e.getMessage(), Toast.LENGTH_SHORT).show();    
      					e.printStackTrace();
      				}
      				}
        	  }
        	  );}
        	 
          }
          class result extends AsyncTask<String,String,String>
          {

      		@Override
      		protected String doInBackground(String ... params) {
      			String result="",jsonstring="";
      		
      			try
 				 {
 					 HttpClient client=new DefaultHttpClient();
 					 HttpPost post=new HttpPost(Config.url+"/androidlogin.jsp");
 					 List<NameValuePair> arr=new ArrayList<NameValuePair>(2);
 					 arr.add(new BasicNameValuePair("uname",user));
 					 arr.add(new BasicNameValuePair("pass",password));
 					 post.setEntity(new UrlEncodedFormEntity(arr));
 					 System.out.println(arr);
 					 HttpResponse response=client.execute(post);
 			         HttpEntity entity=response.getEntity();		 
 				     result=EntityUtils.toString(entity);
 				    /*
 				     InputStreamReader isr=new InputStreamReader(is);
 				     char []ch=new char[100];
 				     
 				     while(isr.read()>-1){
 				    	 isr.read(ch);
 				    	 result +=String.copyValueOf(ch, 0,100);
 				    	 ch=new char[100];
 				     }
 				     	*/
 				    	JSONObject res=new JSONObject(result.substring(result.indexOf("{"), result.indexOf("}")+1));
 				    	
 	 				     jsonstring=res.getString("name");
 	 				 //  Toast.makeText(getBaseContext(), jsonstring, 1).show();
 	 				     if(jsonstring.compareToIgnoreCase("failed")!=0)
 	 				     {
 	 				    	 /*editor=share.edit();
 	 				    	 editor.putString("name",user);
 	 				    	Bundle b=new Bundle();
 	  		        		b.putString("name",share.getString("name",""));*/
 	 				    	 Session sess=new Session(ctxt);
 	 				    	 sess.setusename(user);
 	  		        		 Intent i=new Intent("com.example.compiler.MainActivity");
 		      				 startActivity(i);
 		      			  finish();
 	 				     }
 	 				     else
 	 				     {
 	 				    	System.out.print("error");
 	 				     }
 	 				    // jsonstring=result.substring(result.indexOf("{"), result.indexOf("}"));
 	 				    		 
 				     
 				 }
 				catch (UnsupportedEncodingException e) {
 					// TODO Auto-generated catch block
 					jsonstring+=e.getMessage();
 				} catch (ClientProtocolException e) {
 					// TODO Auto-generated catch block
 					jsonstring+=e.getMessage();
 				} catch (IOException e) {
 					// TODO Auto-generated catch block
 					jsonstring+=e.getMessage();
 				} 
 				catch(Exception e)
 				{
 					jsonstring+=e.getMessage();
 				}
      			return jsonstring;
      		}
          	public void onPostExecute(String res)
          	{
          		
          		//Toast.makeText(getActivity(), res, Toast.LENGTH_LONG).show();
          		
          		Toast.makeText(getBaseContext(), res, Toast.LENGTH_LONG).show();
          	}
          }
		public void display()
    	  {
    		   
    	  }

 

}
