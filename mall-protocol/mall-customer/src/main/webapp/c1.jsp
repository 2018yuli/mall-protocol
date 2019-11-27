<%@page import="com.ydual.mall.customer.Customer" %>
<html>
<body>
<h2>Hello World!</h2>
<%
out.print("now in customer c1.jsp");
out.print(new Customer().c1());
%>
</body>
</html>
