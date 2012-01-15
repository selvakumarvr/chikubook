<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>ChikkuBukku -  An Online Community For Book Lovers</title>
<script type="text/javascript" src="/jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
			
			tinyMCE.init({
		mode : "textareas",
		theme : "simple"
	});
		
		
		</script>
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>


</head>
<body>
<div id="maincontainer">

<div id="header">
<h1>ChikuBooku..</h1>
<span>An Online Community For Book Lovers</span>
</div>

<div id="contentwrapper">
<div id="contentcolumn">

<h2>What's up?</h2>

<p>
<form action="/gb/new" method="post" accept-charset="utf-8">
	<table>
		
		<tr>
			
		
			<td>
			
		
			<textarea width="320" height="240" id="textarea3"  rows="5" cols="60" name="postDesc"></textarea>
			</td>
		</tr>
	
	<tr>
			<td colspan="2" align="right"><input type="submit" value="Post.."/></td>
		</tr>
	</table>
</form>

    <c:if test="${rowCount > 0 }">
   

<ul id="pagination-flickr">
<c:set var="totalCount" scope="session" value="${rowCount}"/>
    <c:set var="perPage" scope="session" value="10"/>
    <c:set var="totalPages" scope="session" value="${totalCount/perPage}"/>
    <c:set var="pageIndex" scope="session" value="${start/perPage+1}"/>

<li class="previous-off">
   <c:if test="${!empty start && start >(perPage-1) && start !=0 }">
          <a href="/gb/list/<c:out value="${start - perPage}"/>">«Prev </a>
    </c:if>
</li>
   <c:forEach
        var="boundaryStart"
        varStatus="status"
        begin="0"
        end="${totalCount - 1}"
        step="${perPage}">
        <c:choose>
        
            <c:when test="${status.count>0 && status.count != pageIndex}">
            <li>
                             <a href="/gb/list/<c:out value='${boundaryStart}'/>">
                                <c:out value="${status.count}"/> 
                            </a>
             </li>
            </c:when>
        <c:otherwise>
        	
        	<li class="active">
                <c:out value="${status.count}"/> 
            </li>
        </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${empty start || start<(totalCount-perPage)}">
    <li class="next">
          <a href="/gb/list/<c:out value="${start + perPage}"/>">Next » </a>
     </li>
    </c:if>

</ul>
    </c:if>


</p>

 



<ul>
<c:forEach var="post" items="${posts}">
<li>
<div class="comments">
  <c:choose>
    <c:when test="${!empty post.author}">
      <p><b>${post.author.nickname}</b> wrote:
    </c:when>
   </c:choose>
  ${post.commentText}
  <span class="datedisplay">about ${post.entryDate}</span>
 </div>
</li>
</c:forEach>

</ul>






</div>
</div>

<div id="leftcolumn">
<h4>Menu</h4>

<ul id="navlist">

<li><a href="/" class="seagreen">Home</a></li>
<li><a class="rawsienna" href="#sitename">Book Forums</a></li>
<li><a class="lightblue" href="#sitename">Book Reviews</a></li>
<li><a class="beet" href="#sitename">Members</a></li>
<li><a class="steelblue" href="#sitename">Tell a Friend</a></li>
<li>
<c:choose>
  <c:when test="${!empty user}">
    <a class="steelblue"  href="${logoutHref}">sign
    out</a>
  </c:when>
  <c:otherwise>
    <p><a class="steelblue" href="${loginHref}">Sign in</a></p>
  </c:otherwise>
</c:choose>
</li>
</ul>

<div class="greybox">

</div>

</div>

<div id="push"></div>

</div>

<div id="footer">
</div>

</body>
</html>
