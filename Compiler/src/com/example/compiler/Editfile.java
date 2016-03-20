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
import org.json.JSONException;
import org.json.JSONObject;

import android.app.FragmentManager;
import android.content.Context;
import android.os.AsyncTask;

public class Editfile extends AsyncTask<String,String,String>{
	Session ss;
	HttpClient client;
	HttpPost post;
	HttpEntity entity;
	HttpResponse response;
	Context ctxt;
	String file,name;
	String result="",edit="",filename="";
	static String output="fhfh";
	ArrayList<String> ls;
	
	public Editfile(String name,String file,Context ctxt)
	{
		this.file=file;
		this.name=name;
		this.ctxt=ctxt;
		ss=new Session(ctxt);
	}
	@Override
	protected String doInBackground(String... params) {
		try {
		client=new DefaultHttpClient();
		post=new HttpPost(Config.url+"/androideditfile.jsp");
		List<NameValuePair> list=new ArrayList<NameValuePair>(2);
		list.add(new BasicNameValuePair("name",name));
		list.add(new BasicNameValuePair("filename",file));
	    
			post.setEntity(new UrlEncodedFormEntity(list));
			response=client.execute(post);
			entity=response.getEntity();
			result=EntityUtils.toString(entity);
			
		    output=result.substring(result.indexOf("{"),result.lastIndexOf("}")+1).toString();
			JSONObject obj=new JSONObject(output);
			edit=obj.getString("res");
			filename=obj.getString("file");
			filename=filename.substring(0,filename.indexOf("."));
			ss.setFilenamee(filename.trim());
			ss.setEditText(edit.trim());
			//System.out.println(ls);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return output;
	}
	public void onPostExecute(String res)
	{
	System.out.println(edit+filename);
	}

}
