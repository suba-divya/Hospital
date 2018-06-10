import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class PatientRecord extends HttpServlet {  
	private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String id=request.getParameter("userId"); 
String i=request.getParameter("userIndoor");         
String p=request.getParameter("userPatient");  
String w=request.getParameter("userWard");
String b=request.getParameter("userBedno");
String d=request.getParameter("userDeposit");

String inc=request.getParameter("userIncharge");  

String a=request.getParameter("userAdmitdate"); 
int idd= Integer.parseInt(id);
int in= Integer.parseInt(i);
int pat =Integer.parseInt(p);  
int war= Integer.parseInt(w);
int bed= Integer.parseInt(b);
int dep= Integer.parseInt(d);
int dat = Integer.parseInt(a);
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","suba123");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into healthR values(?,?,?,?,?,?,?,?)");  
ps.setInt(1,idd); 
ps.setInt(2,in);  
ps.setInt(3,pat);  
ps.setInt(4,war);
ps.setInt(5,bed);  
ps.setInt(6,dep);
ps.setString(7,inc);
ps.setInt(8,dat);


          
int k=ps.executeUpdate();  
if(k>0)  
out.print("A new patient Record has been created.");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  