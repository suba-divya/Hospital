import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class New extends HttpServlet {  
	private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String i=request.getParameter("userId");         
String n=request.getParameter("userName");  
String a=request.getParameter("userAge");
String s=request.getParameter("userSex");
String d=request.getParameter("userDob");

String e=request.getParameter("userEmail");  
String c=request.getParameter("userCountry"); 
String p=request.getParameter("userPatient"); 
int id= Integer.parseInt(i);
int age1 =Integer.parseInt(a);  
int dob1= Integer.parseInt(d);
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","suba123");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into RegisterK values(?,?,?,?,?,?,?,?)");  
ps.setInt(1,id);  
ps.setString(2,n);  
ps.setInt(3,age1);
ps.setString(4,s);  
ps.setInt(5,dob1);
ps.setString(6,e);
ps.setString(7,c);
ps.setString(8,p);

          
int k=ps.executeUpdate();  
if(k>0)  
out.print("A new patient Record has been created.");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  