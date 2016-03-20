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
        String name="",error="";;
     
         String finalname="";
           String st="";
           String st2="";
           String st1="";
           String code="";
            
        
    %>
    
        <%
        JSONObject obj = new JSONObject(); 
         code=request.getParameter("Code");
         File f;
         int y=0;
         File fin;
         String file=request.getParameter("filename");
         String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
         if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+temp_name;
         out.print(uploadPath);
         st2=uploadPath;
           try
           {
           f=new File(uploadPath);
           if(!(f.exists()))
           f.mkdir();
           File fi=new File(f,file);
           OutputStream fos=new FileOutputStream(fi);
           OutputStreamWriter osw=new OutputStreamWriter(fos);
           osw.write(code);
           osw.close();
            
           }catch(Exception e)
           {
              st +=e.getMessage();
           }
           
           if(uploadPath!=null)
        {
          String s="";
        try
        {
        
       DateFormat form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date dat=new Date();
       s=form.format(dat);
        statement=con.createStatement();
       statement.executeUpdate("insert into compiledfiles values('"+file+"','"+temp_name+"',"+y+",'"+s+"')")  ;
                     // request.getRequestDispatcher("edit_file.jsp").forward(request, response);
                      success=1;
                       statement.close();
           con.close();

        }catch(Exception e)
        {
            st +=e.getMessage();
        }
        if(success==1)
        {
            obj.put("status", "File Saved");
        }
        else
            obj.put("status", "Failed");
        }
           out.println(obj);
//fileName%>