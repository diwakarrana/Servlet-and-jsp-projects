
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	// read form data
	String iname = request.getParameter("iname");
	float iprice = Float.parseFloat(request.getParameter("iprice")) ;
	float iqty = Float.parseFloat(request.getParameter("iqty"));
	//calculate bill amount.....
	float billAmt = iprice*iqty;
	
	//forwarding request to Discount.jsp if billAmt > 50000;
	
	if(billAmt > 50000)
	{ %>
		<jsp:forward page= "discount.jsp">
			<jsp:param name = "billamt" value="<%=billAmt %>" />
		</jsp:forward>		
	<%}
	else{
		%>
		Iteam Name : <%= iname %><br>
		Iteam AMT  : <%= billAmt %><br>
	<%}
          %>

</body>
</html>