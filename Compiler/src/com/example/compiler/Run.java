package com.example.compiler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Run extends Fragment {
	TextView output;
	 Session ss;
	 String fileName,username;
	   Context ctxt;
	 public View onCreateView(LayoutInflater infalte,ViewGroup view,Bundle sd)
     {
   	  View rootview=infalte.inflate(R.layout.run, view,false);
   	  output=(TextView)rootview.findViewById(R.id.runText);
   	  
   	ctxt=rootview.getContext().getApplicationContext();
   	  ss=new Session(ctxt);
   	  fileName=ss.getFilename();
   	  username=ss.getusename();
   	  new result().execute();
   	  return rootview;
     }
	 class result extends AsyncTask<String,String,String>
     {

 		@Override
 		protected String doInBackground(String ... params) {
 			String result="",jsonstring="";
 		
 			try
			 {
 				
 				HttpClient client=new DefaultHttpClient();
				 HttpPost post=new HttpPost(Config.url+"/androidrun.jsp");
				 List<NameValuePair> arr=new ArrayList<NameValuePair>(2);
				arr.add(new BasicNameValuePair("name",username));
				 arr.add(new BasicNameValuePair("filename",fileName));
				 post.setEntity(new UrlEncodedFormEntity(arr));
				 System.out.println(arr);
				 HttpResponse response=client.execute(post);
		         HttpEntity entity=response.getEntity();		 
			     result=EntityUtils.toString(entity);
			   
			     JSONObject res=new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}")+1));
			    	
 				     jsonstring=res.getString("run");
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
     		output.setText(res);
     		output.setMovementMethod(ScrollingMovementMethod.getInstance());
     		//Toast.makeText(getActivity(), res, Toast.LENGTH_LONG).show();
     	}
     }
}

	