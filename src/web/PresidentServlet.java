package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.President;
import data.PresidentDaoListImpl;
/**
 * Servlet implementation class PresidentServlet
 */
@WebServlet("/PresidentServlet")
public class PresidentServlet extends HttpServlet {
	private PresidentDaoListImpl dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String previous = request.getParameter("previous");
	String next = request.getParameter("next");
	String submit = request.getParameter("submit");
<<<<<<< HEAD
	System.out.println(next);
	System.out.println(submit);
	System.out.println(previous);
	int termNumber = Integer.parseInt(request.getParameter("termNumber"));
	//if they clicked next, next will have a value
	List <President> pres = dao.getAllPresidents();
=======
	int termNumber = 0;
	System.out.println(request.getParameter("term"));
>>>>>>> 81fc58107b75f5c26e1a5cb7089f8cfac4bb56e8
	President president =null;
	if(request.getParameter("termNumber")!=null){
		termNumber = Integer.parseInt(request.getParameter("termNumber"));
		president = dao.getPresident(termNumber);
	}
	else if(request.getParameter("next")!=null || request.getParameter("previous")!=null){
		if(next != null && next.equals("Next President")){
			int term = Integer.parseInt(request.getParameter("term"));
			president = dao.getNextPres(term);
		}
		else if(previous != null && previous.equals("Previous President")){
			int term = Integer.parseInt(request.getParameter("term"));
			president = dao.getPreviousPres(term);
		}
		else{
			president = dao.getPresident(termNumber);
		}
		
	}
	//if they clicked next, next will have a value
	List <President> pres = dao.getAllPresidents();
		System.out.println("next " + next);
		System.out.println("previous " + previous);
		System.out.println("termNumber " + termNumber);
	
	
		System.out.println(president.getFirstName());
		request.setAttribute("president", president);
		request.getRequestDispatcher("president.jsp").forward(request, response);
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
		dao = new PresidentDaoListImpl(this.getServletContext());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
