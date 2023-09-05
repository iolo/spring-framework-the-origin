
<%@ taglib uri="/i21" prefix="i21" %>

<%@ taglib uri="/c" prefix="c" %>


<html>

<head>
<title>Customer details</title>
</head>


<!-- No action: handled by same URL -->
<form method="POST">

<i21:hasBindErrors>
	There were <%=count%> errors
	<p>
</i21:hasBindErrors>


Postal code:
<br>
<i21:bind value="user.billingAddress.postcode">

		<c:if test="${bind.error}">
			<font color="red"><b>
				<c:out value="${bind.errorMessage}"/>
				(hint, it's hardcoded to expect SE10)
			</b></font>
			<br>
		</c:if>

<input type="text" length="16" name="billingAddress.postcode"
		value="<c:out value="${bind.value}" />">
		
</i21:bind>		

<p>
Birth year:
<br>
<i21:bind value="user.birthYear">
	<c:if test="${bind.error}">
			<font color="red"><b>
				Birth year is required
			</b></font>
			<br>
		</c:if>

	<select size="1" name="birthYear">
		<option value=""/>Please select</option>
		<c:forEach var="birthYear" items="${BIRTHYEARS}">
			<option value="<c:out value="${birthYear}"/>"
			 <c:if test="${bind.value == birthYear}">SELECTED</c:if>
				> <c:out value="${birthYear}"/>
			</option>
		</c:forEach>
	</select>	
</i21:bind>		
	
<p>		
			
Email:	
<br>
<i21:bind value="user.email">
	<c:if test="${bind.error}">
			<font color="red"><b>
				<c:out value="${bind.errorMessage}"/>
			</b></font>
			<br>
		</c:if>

	<input type="text" length="2" size="30" name="email" value="<c:out value="${bind.value}" />"  />
</i21:bind>

<p/>

<input type = "submit" value="Submit"  />

</form>
</body>
</html>


<%--
	<c:choose>
	<c:when test="${bind.fromBean}">
		<c:out value="${bind.value}" />
	</c:when>
	<c:when test="${bind.fromError}">
		<font color="red"><b><c:out value="${bind.errorMessage}"/></b></font>
		<br>
		<center>
		<input type="text" length="2" size="30" name="email" value="<c:out value="${bind.value}" />"  />
		</center>
	</c:when>
	
	<c:otherwise>
		<input type="text" length="2" size="30" name="email" value="<c:out value="${bind.value}" />"  />
	</c:otherwise>
	</c:choose>
	
	--%>
