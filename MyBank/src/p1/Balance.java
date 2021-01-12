package p1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Balance extends HttpServlet {
	private String balance;
	protected void Service(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			HttpSession session =request.getSession();
			String accno=(String) session.getAttribute("accno");
			Model m =new Model();
			boolean status =m.checkBalance();
			if(status==true)
			{
				balance = m.getBalance();
				session.setAttribute("balance", balance);
				response.sendRedirect("/Mybank/balance.jsp");
			}
			else {
				response.sendRedirect("/Mybank/balance.jsp");
			}
		}
		
			
		catch(Exception e){
			e.printStackTrace();
			
			
		}
	}
	

}
