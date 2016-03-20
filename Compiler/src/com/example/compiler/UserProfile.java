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
import org.json.*;
import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class UserProfile  extends Fragment {
	Context ctxt;
	Session ss;
	String username;
	JSONArray array;
	//ListView list;
	String filename="";
	String name,email,phone,userid,gender;
	TextView txtname,txtphone,txtsex,txtemail,txtuserid;
	List<String> lst;
	 public View onCreateView(LayoutInflater infalte,ViewGroup view,Bundle sd)
     {
		
   	  View rootview=infalte.inflate(R.layout.profile, view,false);
   	  txtname=(TextView)rootview.findViewById(R.id.name);
   	  txtphone=(TextView)rootview.findViewById(R.id.phone);
   	  txtemail=(TextView)rootview.findViewById(R.id.email);
   	  txtsex=(TextView)rootview.findViewById(R.id.sex);
   	  txtuserid=(TextView)rootview.findViewById(R.id.userid);
  	ctxt=rootview.getContext().getApplicationContext();
 	  ss=new Session(ctxt);
 	  username=ss.getusename();
 		//list=(ListView)rootview.findViewById(R.id.list);
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
				 HttpPost post=new HttpPost(Config.url+"/androidhome.jsp");
				 List<NameValuePair> arr=new ArrayList<NameValuePair>(1);
				arr.add(new BasicNameValuePair("name",username));
				 post.setEntity(new UrlEncodedFormEntity(arr));
				 System.out.println(arr);
				 HttpResponse response=client.execute(post);
		         HttpEntity entity=response.getEntity();		 
			     result=EntityUtils.toString(entity);
			     JSONObject res=new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}")+1));
			   
			    gender=res.getString("gender");
			    if(gender.compareTo("0")==0)
			    {
			    	gender="Male";
			    }
			    else
			    	gender="Female";
			    phone=res.getString("phone");
			    name=res.getString("name");
			    userid=res.getString("userid");
			    email=res.getString("email");
			    
			   
 				    // jsonstring=result.substring(result.indexOf("{"), result.indexOf("}"));
 				return jsonstring;
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
     		 txtname.setText("Name      :"+name);
			    txtphone.setText("Phone     :"+phone);
			    txtemail.setText("Email Id  :"+email);
			    txtsex.setText("You are   :"+gender);
			    txtuserid.setText("User Id    :"+userid);
     	}
}
}
