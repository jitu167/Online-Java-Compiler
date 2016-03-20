
<!DOCTYPE html>
<%
        session=request.getSession(false);
         String name=(String)session.getAttribute("user");
        if(session==null)
    {
        request.getRequestDispatcher("index.jsp").include(request, response);
        return;
    }
    %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Online Compiler</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
        
               
<script src="jsFileUpload/jquery-1.7.1.min.js"></script>
<script src="jsFileUpload/vendor/jquery.ui.widget.js"></script>
<script src="jsFileUpload/jquery.iframe-transport.js"></script>
<script src="jsFileUpload/jquery.fileupload.js"></script>
<script>
 function showUpload()
 {
     $("#image-div").show(500);
 }
$(function () {
    
    $('#fileupload').fileupload({
        dataType: 'json',
        url: 'servlet/ImageUploadServlet',
        done: function (e, data) {
            $.each(data.result, function (index, file) {
                if(index=="name")
                 {   
                     $("#image").val(file)
                     $("#imageL").html("<img src='photo/"+file+"' width='100' height='100' />");
                     
                 }   
            });
        }
    });
});
</script>
</head>
<body>
    
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
			<div id="contents">
				<div id="sidebar">
                                    <h2></h2>
                                      <h2></h2>
					<h2>Personal Details</h2>
					<div>
						<div class="section">
							<div class="body">
								
								<p>
                                                                 <ul>
                                                           
                                                             <li><p><h3>User Id</h3><% out.println(session.getAttribute("userid"));
                                                             
                                                %></p></li>
                                                <li><p><h3>Phone</h3><% out.println(session.getAttribute("phone"));
                                                %></p></li>
                                                <li><p><h3>E-mail</h3><% out.println(session.getAttribute("email"));
                                                %></p></li>
                                                <li><p><h3>Gender</h3><% 
                                                String sex="";
                                                if(session.getAttribute("sex")!=null)
                                                {
                                                    if(session.getAttribute("sex").toString().compareTo("0")==0)
                                                    sex="Male";
                                                    else
                                                        sex="Female";
                                                }
                                                
                                                out.println(sex);
                                                %></p></li>
                                                        </ul> 
                                                                </p>
								<span></span> <span class="author">    </span>
							</div>
						
				</div>
                                        </div>
                                </div>
				<div class="header">
					
					<p>
						Welcome To Online Compiler				</p>
				</div>
				<div id="featured">
					<h2>Your Profile</h2>
					<p>
											</p>
					<ul>
						<li>
                                                <%
                                                String photo = (String)session.getAttribute("photo");
                                                if(photo==null)
                                                    photo="noimage.jpg";
                                                %>
							<img src="photo/<%=photo %>" alt="Img" height="167" width="280">
							
                             <span>
                                 <a href="javascript:void(0)" onclick="showUpload()"><h3>Update Profile Pic</h3></a>
                                 <div id="image-div" style="display: none">
                                     <form action="update_profilepic.jsp">
                                          <input type="hidden" name="image" id="image" />		
                                            <input id="fileupload" type="file" name="files[]" />
                                            <label id="imageL"></label>
                                            <input type="submit" name="submit" id="submitimg" value="Update" />		
                                     </form>
                                    
                                     
                                 </div>
                                    
                             </span>
                                                        <span><a href="" class="more"><%out.print(name);%></a></span>
                                                </li>
                                        </ul>
                                                            
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
						© Copyright Jitendra Kumar & Sashank Rawal. All rights reserved.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>