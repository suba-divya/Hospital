<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient details</title>
</head>
<body style="background-color:#E8E2E1;">
<h1>PATIENT'S HOSPITAL DETAILS</h1>
<%
String i = request.getParameter("id"); 
int id= Integer.parseInt(i);

 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","suba123");  
PreparedStatement ps=con.prepareStatement("select * from healthR  where id=?");  
ps.setInt(1,id);
ResultSet rs=ps.executeQuery(); 
while(rs.next()) 
{
%>
<p> ID:<%=	rs.getInt("id") %><br></p>
<p> Indoor No:<%=rs.getInt("indoorNo") %></p><br>
<p>	Patient No:	<%=	rs.getInt("patientNo")	%></p><br>
<p>	Ward No:<%=	rs.getInt("ward")	%></p><br>
<p>	Bed No:<%=rs.getInt("bedNo")	%></p><br>
<p>	Deposit:<%=rs.getInt("deposit")	%></p><br>
<p>	Incharge Doctor:<%=rs.getString("inchargeDr") %></p><br>
<p>	Admit Date:<%=rs.getInt("admitdate") %></p><br>
<% 
}
}catch (Exception e2) 
 {
	e2.printStackTrace();}  
          
%>

<button>Billing</button>
<br>
<form action ="labrecords.jsp" method ="post">
<button>Lab Records</button>
</form><br>

<button>Avail services</button>

</body>
</html>
