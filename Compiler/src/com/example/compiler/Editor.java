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

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Editor extends Fragment {
	SharedPreferences shared;
	Spinner extension;
	 String fileName,username;
	CharSequence x="sdsdsds",g;
	String sessionfile,sessiontext;
	 public String fileextension;
	String k;
	 Session ss;
	Button saves,cancel;
	InputStream is=null;
   Context ctxt;
  EditText editorText;
  EditText filename;
	String [] extensions;
          public View onCreateView(LayoutInflater infalte,ViewGroup view,Bundle sd)
          {
        	 
        	  View rootview=infalte.inflate(R.layout.editor, view,false);
        	  saves=(Button)rootview.findViewById(R.id.btnSave);
        	  ctxt=rootview.getContext().getApplicationContext();
        	  ss=new Session(ctxt);
        	  editorText=(EditText)rootview.findViewById(R.id.editorText);
        	  filename=(EditText)rootview.findViewById(R.id.filename);
        	  sessiontext=ss.getEditText();
        	  sessionfile=ss.getFilename();
        	  if(sessiontext!=null && sessionfile!=null)
        	  {
        	  editorText.setText(sessiontext);
        	  filename.setText(sessionfile);
        	  }
        	  username=ss.getusename();
        	  System.out.println(username);
        	 // cancel=(Button)rootview.findViewById(R.id.btnCancel);
        	   
              x=filename.getText();
              g=editorText.getText();
              extension=(Spinner)rootview.findViewById(R.id.fileExtension);
        	  extensions=getResources().getStringArray(R.array.extensions);
        	  ArrayAdapter<String> arr=new ArrayAdapter<String>(rootview.getContext(),android.R.layout.simple_expandable_list_item_1, extensions);
        	  extension.setAdapter(arr);     
        	 shared=PreferenceManager.getDefaultSharedPreferences(ctxt);
        	 
        	  saves.setOnClickListener(new OnClickListener(){
        		 
        		  public void onClick(View v) {
      				try
      				{
      					 fileName=x.toString();
      	      			  
      			   // Toast.makeText(getActivity(), x, Toast.LENGTH_SHORT).show();    
      			    Toast.makeText(getActivity(), g, Toast.LENGTH_SHORT).show();    
      			    // File sdcard=Environment.getExternalStorageDirectory();
      			     //File path=new File(sdcard.getAbsolutePath(),"/Myfiles");
      			     //path.mkdir();
      			     //File file=new File(path,"f.java");
      			  
      			   // File file=new File("f.txt");
      			    //file.setWritable(true);
      				  //FileOutputStream fout=new FileOutputStream(file);
      			    if(fileName.compareTo("")==0)
      			    {
      			    	Toast.makeText(getActivity(),x, Toast.LENGTH_SHORT).show();    
      			    }
      			    else
      			    {
      			  fileName+="."+fileextension;
      			  ss.setFilenamee(fileName);
      				new result().execute();
      				 
      			    }
      				}
      			 
      				
      				catch(Exception e)
      				{
      					editorText.setText(x);
      					Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_SHORT).show();    
      					e.printStackTrace();
      				}
      				}
      			
        	  });
        	 
        	 extension.setOnItemSelectedListener(new OnItemSelectedListener(){
             
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					     fileextension=extensions[position];
					     Toast.makeText(getActivity(), fileextension, Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					
					
				}
        		  
        	  });
        	 
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
 					 HttpPost post=new HttpPost(Config.url+"/androideditor.jsp");
 					 List<NameValuePair> arr=new ArrayList<NameValuePair>(2);
 					arr.add(new BasicNameValuePair("name",username));
 					 arr.add(new BasicNameValuePair("Code",g.toString().trim()));
 					 arr.add(new BasicNameValuePair("filename",fileName));
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
 				    	
 	 				     jsonstring=res.getString("status");
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
          		Toast.makeText(getActivity(), res, 1).show();
          		//Toast.makeText(getBaseContext(), res, Toast.LENGTH_LONG).show();
          	}
          }
		public void display()
    	  {
    		   
    	  }
}
