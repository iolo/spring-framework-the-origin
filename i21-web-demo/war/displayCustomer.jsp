
<%--
	Could display more elegantly with JSTL.
--%>

<jsp:useBean id="user"
	 type="com.wrox.expertj2ee.ticket.customer.RegisteredUser"
	 scope="request"
/>

<h2>Valid information supplied</h2>

Birth year: <%=user.getBirthYear()%><br>
Postcode: <%=user.getBillingAddress().getPostcode()%><br>
Email: <%=user.getEmail()%><br>
