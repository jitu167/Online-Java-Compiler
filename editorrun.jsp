

 <%@page import="java.io.*"%>
 <html>
     <body>
<%
        session=request.getSession(false);
         String name=(String)session.getAttribute("userid");
           String path="";
           String st2="";
           String st1="";
           String code="",fileName="";
           int y=0;
           File f;
     
        if(session==null)
    {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
    %>
<% 
        	y=1;
                //request.setAttribute("action", "run");
            String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
                if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+name+"/";
             
              st1=request.getParameter("filename");
              int dot=st1.indexOf(".");
           String classfile='"'+uploadPath+'"';
            try
            {
            Process pro1=Runtime.getRuntime().exec("java -cp "+classfile+" "+st1.substring(0, dot));
         //out.println(f.getAbsolutePath());
         InputStreamReader isr2=new InputStreamReader(pro1.getErrorStream());
         char [] x2=new char[50];
         while(isr2.read(x2)>-1)
         {
             st2 +="\n"+String.copyValueOf(x2,0,50);
             x2=new char[50];
         }
         isr2.close();
         InputStreamReader isr3=new InputStreamReader(pro1.getInputStream());
         char [] x3=new char[50];
         while(isr3.read(x3)>-1)
         {
             st2 +="\n"+String.copyValueOf(x3,0,50);
             x3=new char[50];
         }
         isr3.close();
         out.println(classfile);
         out.println(st2);

         request.setAttribute("runfile", st2);
         request.getRequestDispatcher("Editor.jsp").forward(request, response);
        }
           catch(Exception e)
           {
             out.println(e.getMessage());
           } 
            

   %>     
     </body>
 </html>