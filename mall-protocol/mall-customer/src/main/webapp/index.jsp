<%@page import="com.ydual.mall.customer.Customer" %>
<html>
<body>
<h2>Hello World! customer web</h2>
<% 
out.print("now in customer c1.jsp");
out.print(new Customer().c1());
%>
</body>
</html>
