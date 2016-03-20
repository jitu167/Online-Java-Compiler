

 <%@page import="java.io.*"%>
  <%@page import="java.sql.*"%>
<%@page import="org.json.JSONObject"%>

    <%!
    int success=0;
        %>
		<%
         String temp_name=request.getParameter("name");       
           String path="";
           String st2="";
           String st1="";
           String code="",fileName="";
           int y=0;
           File f;
    %>
<% 
        	y=1;
            String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
                if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+temp_name+"/";
              st1=request.getParameter("filename");
              int dot=st1.indexOf(".");
             String classFile='"'+uploadPath+'"';
             classFile=classFile.trim();
            try
            {
            Process pro1=Runtime.getRuntime().exec("java -cp "+classFile+" "+st1.substring(0, dot));
         //out.println(f.getAbsolutePath());
         InputStreamReader isr2=new InputStreamReader(pro1.getErrorStream());
         char [] x2=new char[50];
         while(isr2.read(x2)>0)
         {
             st2 +=String.copyValueOf(x2,0,50);
             x2=new char[50];
         }
         isr2.close();
         InputStreamReader isr3=new InputStreamReader(pro1.getInputStream());
         char [] x3=new char[50];
         while(isr3.read(x3)>0)
         {
             st2 +=String.copyValueOf(x3,0,50);
             x3=new char[50];
         }
           isr3.close();
         out.println(classFile);
        // out.println(st2);
        JSONObject obj=new JSONObject();
        obj.put("run", st2);
        out.println(obj);
       
                 }
           catch(Exception e)
           {
             out.println(e.getMessage());
           } 
            
   %>