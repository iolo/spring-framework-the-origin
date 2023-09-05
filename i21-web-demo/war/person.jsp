<jsp:useBean id="person" type="command.Person" scope="request" />



Your name is <%=person.getName()%>.

<br>
You are <%=person.getAge()%> years old.


<br>
<i>Edit the GET parameters in the address and resubmit.
If you omit a value, the bean default is used.
If you specify a non-numeric age, the implementation
of command.SimpleCommandController currently displays
the debug page, on which you can see the binding errors.

</i>

<br>
<br>
Simple command-based binding can be useful when
errors are unlikely (for example, the user should have
selected from dropdowns) or errors can be treated as fatal.
