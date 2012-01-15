<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
	<head>
		<title>ChikkuBukku...</title>
		<script type="text/javascript" src="../jscripts/tiny_mce/tiny_mce.js"></script>
		
		<link rel="stylesheet" type="text/css" href="/css/main.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
	</head>	
	<body>



	<div style="width: 100%;">
		<div class="line"></div>
		<div class="topLine">
		
			<div style="float: left;" class="headline">Chikku booku...</div>
			<div style="float: right;">
			<c:choose>
  <c:when test="${!empty user}">
    <p>Hello, ${user.nickname}! (You can <a href="${logoutHref}">sign
    out</a>.)</p>
  </c:when>
  <c:otherwise>
    <p>Hello! <a href="${loginHref}">Sign in</a> to include your
    name with greetings you post.</p>
  </c:otherwise>
</c:choose>

<c:if test="${empty posts}">
  <p> No messages.</p>
</c:if>

			
			</div>
		</div>
	</div>

<div style="clear: both;"/>	



<hr />

<div class="main">




<div class="headline">How’s going? </div> 
<script type="text/javascript">
			
			tinyMCE.init({
		mode : "textareas",
		theme : "simple"
	});
		
		
		</script>
		


<form action="/gb/new" method="post" accept-charset="utf-8">
	<table>
		
		<tr>
			
		
			<td>
			
		
			<textarea width="450" id="textarea3"  rows="5" cols="60" name="postDesc"></textarea>
			</td>
		</tr>
	
	<tr>
			<td colspan="2" align="right"><input type="submit" value="Post.."/></td>
		</tr>
	</table>
</form>

<table>
  <tr>
      <th hight="2" width="500"> Posts </th>
     
      
    </tr>

<c:forEach var="post" items="${posts}">
<tr> 
<td  hight="2" width="500">
  <c:choose>
    <c:when test="${!empty post.author}">
      <p><b>${post.author.nickname}</b> wrote:
    </c:when>
   </c:choose>

  <blockquote>${post.postDesc}</blockquote>
</td>

</c:forEach>

</tr> 
</div>


<ul id="pagination-flickr">
<li class="previous-off">«Previous</li>
<li><a href="/gb/list/1">1</a></li>
<li><a href="/gb/list/2">2</a></li>
<li><a href="/gb/list/3">3</a></li>
<li><a href="/gb/list/4">4</a></li>

<li class="next"><a href="?page=2">Next »</a></li>
</ul><br>
</body>
</html>
