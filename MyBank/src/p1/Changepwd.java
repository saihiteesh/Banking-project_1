package p1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Changepwd {
	protected void Service(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			String npwd=request.getParameter("npwd");
			
			HttpSession session =request.getSession();
			String accno=(String)session.getAttribute("Accno");
			Model m=new Model();
			m.setAccno(accno);
			m.setPwd(npwd);
			boolean status =m.ChangePwd();
			if(status==true)
			{
				response.sendRedirect("/Mybank/changesucess.jsp");
			}
			else {
				response.sendRedirect("/Mybank/changefail.jsp");
				
			}

}
		catch(Exception e) {
			
		}
	}
}
