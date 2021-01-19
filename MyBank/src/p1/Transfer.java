package p1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transfer {
protected void service(HttpServletRequest request, HttpServletResponse response) {
	try {
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		String taccno=request.getParameter("taccno");
		String tamnt=request.getParameter("tamnt");
		Model m=new Model();
		m.setTamt(tamnt);
		m.setAccno(accno);
		m.setTaccno(taccno);
		boolean status =m.transfer();
		if(status==true)
		{
			response.sendRedirect("/Mybank/transfersucess.jsp");
			
		}
		else {
			response.sendRedirect("/Mybank/transferfail.jsp");
			
		}
	}
		catch(Exception e)
		{
			
		}
	}
}
	
	
	
	
	
	
	
	
	

