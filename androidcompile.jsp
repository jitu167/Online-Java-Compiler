<%@page import="org.json.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@ include file="common/connection.jsp" %>

   
    
    <%!
    Statement statement;
  
    int success=0;
        %>
		 <%
        String temp_name=request.getParameter("name");
        String name="",error="";
    %>
		
        <%
        JSONObject obj = new JSONObject(); 
        int index=0;
         index=name.indexOf(" ");
         String finalname="";
           String st="";
           String st2="";
           String st1="";
           String code="";
            
        
         
         int y=1;
         
         String file=request.getParameter("filename");
       
         String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
         if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+temp_name+"/"+file;
         out.print(temp_name);
           try
           {
          String filename1='"'+uploadPath+'"';
         Process pro=Runtime.getRuntime().exec("javac "+filename1);
         //out.println(f.getAbsolutePath());
         InputStreamReader isr=new InputStreamReader(pro.getErrorStream());
         char [] x=new char[100];
         while(isr.read(x)>=0)
         {
             isr.read(x);
             st +="\n"+String.copyValueOf(x,0,100)+"\n";
             x=new char[100];
         }
         isr.close();
           }catch(Exception e)
           {
              st +=e.getMessage();
           }if(st.compareTo("")==0)
                 obj.put("output", "success");
                    else
           {  
           obj.put("output", st);
           }
           if(uploadPath!=null)
        {
          String s="";
        try
        {
        
       DateFormat form=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
       Date dat=new Date();
       s=form.format(dat);
        statement=con.createStatement();
		y=1;
       statement.executeUpdate("update compiledfiles set satus='1' where file_name='"+file+"' ");
                      success=1;
              statement.close();
           con.close();

        }catch(Exception e)
        {
            st +=e.getMessage();
        }
        }
        
           out.println(obj+st);
//fileName%>