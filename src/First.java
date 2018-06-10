import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class First extends HttpServlet {  
	private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    String p=request.getParameter("userPass");  
          
    if(n.equals("admin")&&p.equals("admin")){  
        RequestDispatcher rd=request.getRequestDispatcher("/welcome.html");  
        rd.forward(request, response);  
    }  
    else{  
        out.print("Sorry UserName or Password Error!");  
        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);  
                      
        }  
    }  
  
}  