

<%@ page session="false" %>

<%-- 
	IMPORTANT: SET THIS VARIABLE TO TRUE IN PRODUCTION,
	UNLESS YOU WANT STACK TRACES TO BE SHOWN
--%>
<%! static final boolean PRODUCTION = false; %>

<% try { %>


<HTML>
<HEAD>
<TITLE>i21 Web Demo | Internal Error</TITLE>
</HEAD>

<BODY>

<% if (!PRODUCTION) { %>
	<%@ include file="/jsp/debug/errorTrace.jspf" %>
<% } %>

	<h2>Internal error</h2>
	Sorry: we've encountered an internal error.
	


	
</BODY></HTML>

<% } catch (Exception ex) { 
	
	ex.printStackTrace(new java.io.PrintWriter(out));

} %>

