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
	int termNumber = Integer.parseInt(request.getParameter("termNumber"));
	//if they clicked next, next will have a value
	List <President> pres = dao.getAllPresidents();
	President president =null;
	if(submit != null && termNumber !=0){
		president = dao.getPresident(termNumber);
	}
	else if(next != null ){
		president = dao.getNextPres(termNumber);
	}
	else if(previous != null ){
		president = dao.getPreviousPres(termNumber);
	}
	
	
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
