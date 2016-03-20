
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>

<html>
    
    <%
        String action = (String)request.getAttribute("action");
        session=request.getSession(false);
         String name=(String)session.getAttribute("userid");
           String st="";
           String st2="";
           String st1="",st3="";
         
        if(session==null)
    {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
    %>
     <% st2= (String)request.getAttribute("compile");
              st3=(String)request.getAttribute("runfile");  
            %>
    <%!
        String filename="";
        
        %>
        
          <%
          filename=request.getParameter("filename");
           

        String code=request.getParameter("Code");
        
        if(code==null && action!=null)
        {
            String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
                if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+name+"/";
              String filePath=uploadPath+filename;
              try
              {
                  File f = new File(filePath);
                  System.out.println(f.exists());
                BufferedReader input = new BufferedReader(new FileReader(filePath));
                String line = "";
                while ((line = input.readLine()) != null)
                {
                    code+="\n"+line;
                }
                input.close();
              }
              catch(Exception e)                  
              {
                  e.printStackTrace();
              }
        }
        
        
        
        %>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
</head>
<body>
    <form action="editorsavefile.jsp" method="post">

	
	
	
	<div id="background">
		<div id="page">
			<div id="header">
				<ul id="navigation">
					<li class="selected">
						<a href="Home.jsp">Home</a>
					</li>
					<li>
						<a href="Editor.jsp">Editor</a>
					</li>
					<li>
						<a href="Files.jsp">Files</a>
					</li>
					<li>
						<a href="Logout.jsp">LogOut</a>
					</li>
					<li>
						<a href="Download.html">App Download</a>
					</li>
				</ul>
				
			</div>
                </div>
            
			<div id="contents">
			
				<div id="sidebar">
					<h2>Output</h2>
					<div>
						<div class="section">
							<div class="body">
								
								<p>
                                                                <pre>  
                                                                          <% 
if(st2!=null)
                                                                   out.println(st2); 
             
if(st3!=null)                                                   
                                                                    out.println(st3); 
else
{
}%>
                                                                </pre>
                                                                </p>
								<span></span> <span class="author">    </span>
							</div>
						
				</div>
                                        </div>
                                </div>
				<div id="featured">
					<h2>Java </h2>
					<p>
  <p>
    <label for="Code"></label>
    <textarea name="Code" id="Code" cols="100" rows="20" ><%=code %></textarea>
  </p>
  <p>
    <label for="filename"></label>
    <input type="text" name="filename" id="filename" value="<%=filename %>" size="20"/>
                                       
                                
                                <p>
       <input type="hidden" name="filename"  value="1" />
      
      <input type="submit" name="submit" id="save" value="Save" /></form>&nbsp;</form>&nbsp;

<form action="editorcompile.jsp" method="post">
            <input type="hidden" name="filename"  value="<%=filename %>" />
            
            <input type="submit" name="compile" id="save" value="Compile" />
           
      </form>
  <form action="editorrun.jsp" method="post">
            <input type="hidden" name="filename"  value="<%=filename %>" />
            <input type="submit" name="save" id="save" value="Run" />
      </form>									
					<ul>
						<li>
							
						&nbsp;</li>
						<li>
							
							<span><a href="" class="more">All Programs</a></span>
						</li>
					</ul>
				</div>
                            
			</div>
            </div>
			<div id="footer">
				<div>
					<ul>
						
						<li>
							<h4>Links</h4>
							<ul class="navigation">
								<li>
									<a href="Home.jsp">Home</a>
								</li>
								<li>
									<a href="Editor.jsp">Editor</a>
								</li>
								<li>
									<a href="Files.jsp">Files</a>
                                                                </li>
								<li>
						<a href="Download.html">App Download</a>
					</li>
							</ul>
						</li>
						
					</ul>
					<p id="footnote">
						© Copyright Jitendra Kumar. All rights reserved.
					</p>
				</div>
			</div>
		</div>
	</div>
        
</body>
</html>