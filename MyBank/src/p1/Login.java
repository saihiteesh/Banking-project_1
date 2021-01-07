package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	private String accno;
	protected void Service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String custid=request.getParameter("custid");
			String pwd=request.getParameter("pwd");
			Model m=new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean status=m.Login();
			HttpSession session=request.getSession(true);
			if(status==true)
			{
				accno=m.getAccno();
				session.setAttribute("accno",accno);
				response.sendRedirect("/MyBank/home.jsp");
			}
			else
			{
				response.sendRedirect("/MyBank/loginfail.jsp");	
			}
		}
		catch(Exception e)
		{
			System.out.println("problem");
		}
	}
	

}
