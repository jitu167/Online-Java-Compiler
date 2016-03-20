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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SavedFiles extends ListFragment {
	Context ctxt;
	Session ss;
	String username;
	JSONArray array;
	//ListView list;
	String filename="";
	ArrayList<String> arr1;
	List<String> lst;
	 String []x={"df","ew","cv","ss","qwq"};
	 public View onCreateView(LayoutInflater infalte,ViewGroup view,Bundle sd)
     {
		
   	  View rootview=infalte.inflate(R.layout.saved, view,false);
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
				 HttpPost post=new HttpPost(Config.url+"/androidsavefiles.jsp");
				 List<NameValuePair> arr=new ArrayList<NameValuePair>(1);
				arr.add(new BasicNameValuePair("name",username));
				 post.setEntity(new UrlEncodedFormEntity(arr));
				 System.out.println(arr);
				 HttpResponse response=client.execute(post);
		         HttpEntity entity=response.getEntity();		 
			     result=EntityUtils.toString(entity);
			     JSONObject res=new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}")+1));
			     JSONObject obj;	
			     array=res.getJSONArray("files");
			     lst=new ArrayList<String>();
			    	for(int i=0;i<=array.length();i++)
			    	{
			    		obj=array.getJSONObject(i);
			    		String file=obj.getString("name");
			    		lst.add(file);
			    	}
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
     		String c="";
     		for(int i=0;i<lst.size();i++)
    		{
    			//x[i]=(String)lst.get(i);
    			c +="\n"+(String)lst.get(i);
    			System.out.println(c);
    		}
     	
     		ArrayAdapter<String> arr=new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, lst); 
     	   setListAdapter(arr);
     	   
    		//Toast.makeText(getActivity(), c, 1).show();
     	}
     	
     }
	 public void onListItemClick(ListView ls,View v,int pos,long id)
  	{
  		
  	    filename=(String)lst.get(pos);
  		System.out.println(filename);
  		Toast.makeText(getActivity(), filename, 1).show();
  		AlertDialog builder=new AlertDialog.Builder(getActivity()).create();
  		 builder.setTitle("Alert");
  		 builder.setMessage("Do you want"+filename+"to");
  		 builder.setButton(DialogInterface.BUTTON_POSITIVE,"EDIT",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Editfile e=new Editfile(username,filename,ctxt);
					
					arr1=new ArrayList<String>();
					e.execute();

					 FragmentManager fragmentManager = getFragmentManager();
				       	fragmentManager.beginTransaction()
				           .replace(R.id.container,new Editor() )
				           .commit();
					System.out.println("jitendrakumar");
				}
			});
  		 builder.setButton(DialogInterface.BUTTON_NEGATIVE,"DELETE",new DialogInterface.OnClickListener() {
				
  		 public void onClick(DialogInterface dialog, int which) {
  			DeleteFile de=new DeleteFile(username,filename,ctxt);
			
			arr1=new ArrayList<String>();
			de.execute();

			 FragmentManager fragmentManager = getFragmentManager();
		       	fragmentManager.beginTransaction()
		           .replace(R.id.container,new SavedFiles() )
		           .commit();
			System.out.println("jitendrakumar");
				}
			});
  		 builder.show();
  	}
}
