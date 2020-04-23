<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%//read the data from req params
  
  float billamt = Float.parseFloat(request.getParameter("billamt"));
  //calculate discount
  float disCount = billamt*0.3f;
  //get final amount
  float finalAMT = billamt - disCount;
  //Display the details............
  %>
  
  Iteam Name: <%=request.getParameter("iname") %><br>
  Bill AMT:   <%=billamt %>
  Discount:		<%=disCount %>
  Final AMT:	<%= finalAMT%>
  

</body>
</html>