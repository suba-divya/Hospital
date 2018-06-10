import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Exist extends HttpServlet {  
	private static final long serialVersionUID = 1L;
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String i = request.getParameter("id"); 
int id= Integer.parseInt(i);

 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","suba123");  
              
PreparedStatement ps=con.prepareStatement("select * from RegisterK  where id=?");  
ps.setInt(1,id);  
              
out.print("<table width=50% border=1>");  
out.print("<caption>Result:</caption>");  
  
ResultSet rs=ps.executeQuery();  
              
/* Printing column names */  
ResultSetMetaData rsmd=rs.getMetaData();  
int total=rsmd.getColumnCount();  
out.print("<tr>");  
for(int j=1;j<=total;j++)  
{  
out.print("<th>"+rsmd.getColumnName(j)+"</th>");  
}  
  
out.print("</tr>");  
              
/* Printing result */  
  
while(rs.next())  
{  
out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+
		"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");  
                  
}  
  
out.print("</table>");  
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  
  
}  
}  