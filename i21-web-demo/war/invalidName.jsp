

<jsp:useBean id="name"
	type="java.lang.String"
	 scope="request"
/>

Sorry, this name is invalid. Please try again.

<form>

	<input type="text"
		name="name"
		value="<%=name%>" />

</form>