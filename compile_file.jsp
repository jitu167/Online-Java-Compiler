<%@page import="java.io.InputStreamReader"%>
<%@page import="java.sql.*"%>
<%@ include file="common/connection.jsp" %>

<html>
    <body>
<%
    session=request.getSession(false);
         String name=(String)session.getAttribute("userid");
         String finalname="",filename1;
   
    String fileName=request.getParameter("filename");
    
    String st=" ";
    char quotes='"';
    String qotes=String.valueOf(quotes);
 try
               {
         String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
                if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+name+"/";
              String filePath=uploadPath+fileName;
        filename1=qotes+filePath+qotes;
         Process pro=Runtime.getRuntime().exec("javac "+filename1);
         //out.println(f.getAbsolutePath());
         InputStreamReader isr=new InputStreamReader(pro.getErrorStream());
         char [] x=new char[100];
         while(isr.read(x)>=0)
         {
             st +="\n"+String.copyValueOf(x,0,100)+"\n";
             x=new char[100];
         }
         request.setAttribute("compile",st);
         //out.println(filename1+fileName);
         if(st.compareTo(" ")==0)
         {
         
         Statement stmt=con.createStatement();
         stmt.executeUpdate("update compiledfiles set satus='1' where file_name='"+fileName+"'");
         stmt.close();
         }
       request.getRequestDispatcher("edit_file.jsp").forward(request, response);
       // out.print(st);
       }catch(Exception e)
           {
              out.println(e.getMessage());
           }
%>
    </body>
</html>