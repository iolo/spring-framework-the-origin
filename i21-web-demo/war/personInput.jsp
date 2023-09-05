
<%@ taglib uri="/i21" prefix="i21" %>

<%@ taglib uri="/c" prefix="c" %>


<html>

<head>

<!--
	Assumes a POST request is a form submission
	by default. Can also use a more sophisticated approach
-->
<form action="form.html" method="POST">

<i21:hasBindErrors>
	There were <%=count%> errors
	<p>
</i21:hasBindErrors>


		

Postal code:
<br>
<i21:bind value="person.name">


		<c:if test="${bind.error}">
			<font color="red"><b>
				<c:out value="${bind.errorMessage}"/>
			</b></font>
			<br>
		</c:if>

<input type="text" length="16" name="name"
		value="<c:out value="${bind.value}" />"
		
		
</i21:bind>		
			
<p>		
			
Email:	
<br>
<i21:bind value="person.age">

	<c:choose>
	<c:when test="${bind.fromBean}">
		<c:out value="${bind.value}" />
	</c:when>
	<c:when test="${bind.fromError}">
		<font color="red"><b><c:out value="${bind.errorMessage}"/></b></font>
		<br>
		<center>
		<input type="text" length="2" size="30" name="age" value="<c:out value="${bind.value}" />"  />
		</center>
	</c:when>
	
	<c:otherwise>
		<input type="text" length="2" size="30" name="age" value="<c:out value="${bind.value}" />"  />
	</c:otherwise>
	</c:choose>

</i21:bind>


<p/>

<input type = "submit" value="Submit"  />




</form>

</body>

</html>
