<%@page import="org.json.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>

<%
    String st="";
String temp_name=request.getParameter("name");
String filename=request.getParameter("filename");
        String fileName="";
        int success=0;
        try
        {String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
         if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+temp_name+"/"+filename;
          BufferedReader input = new BufferedReader(new FileReader
(uploadPath));
String line = "";
while ((line = input.readLine()) != null)
{
st+="\n"+line;
}
input.close();
        }
     catch(Exception e)
     {
        e.printStackTrace();
     }
        JSONObject obj=new JSONObject();
       JSONArray arr=new JSONArray();
        obj.put("res",st);
            obj.put("file",filename);
        out.println(obj);
%>