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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String previous = request.getParameter("previous");
		String next = request.getParameter("next");
		String submit = request.getParameter("submit");
		String filterParty = request.getParameter("filterParty");
		List <String> filterList = dao.getFilterList();
		List<President> pres = dao.getAllPresidents();
		List<President> presFilteredList = dao.getPresFilteredList();
		
		int filterIndex =1;
		int lengthOfFilter=50;
		

		int termNumber = 0;
		
		President president = null;
		System.out.println("filter party: " + (filterParty != null));

		if (filterParty != null && ((next == null) && (previous == null))
				&& request.getParameter("termNumber") == null) {
			president = dao.filterPartyPresident(filterParty);
			presFilteredList = dao.getPresFilteredList();
			lengthOfFilter = (presFilteredList.size()-1);
			System.out.println("initialize filter");
			filterIndex =0 ;
		} else if (filterParty != null && request.getParameter("termNumber") == null) {
			if ((!(filterParty.equals("NoFilter"))) && next != null) {
				System.out.println("Next president");
				president = dao.filterPartyNextPresident();
				lengthOfFilter = (presFilteredList.size()-1);
				filterIndex = presFilteredList.indexOf(president);
			} else if ((!(filterParty.equals("NoFilter"))) && previous != null) {
				president = dao.filterPartyPreviousPresident();
				filterIndex = presFilteredList.indexOf(president);
				lengthOfFilter = (presFilteredList.size()-1);
				System.out.println("Previous president");
			}
		} else if (request.getParameter("termNumber") != null) {
			termNumber = Integer.parseInt(request.getParameter("termNumber"));
			president = dao.getPresident(termNumber);
		} else if (request.getParameter("next") != null || request.getParameter("previous") != null) {
			if (next != null && next.equals("Next President")) {
				int term = Integer.parseInt(request.getParameter("term"));
				president = dao.getNextPres(term);
			} else if (previous != null && previous.equals("Previous President")) {
				int term = Integer.parseInt(request.getParameter("term"));
				president = dao.getPreviousPres(term);
			} else {
				president = dao.getPresident(termNumber);
			}

		}
		// if they clicked next, next will have a value

		
		System.out.println(filterIndex);
		System.out.println(lengthOfFilter);
		request.setAttribute("president", president);
		request.setAttribute("filterIndex", filterIndex);
		request.setAttribute("filterListSize", lengthOfFilter);
		request.setAttribute("filterParty", filterParty);
		request.setAttribute("filterList", filterList);
		request.getRequestDispatcher("president.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		dao = new PresidentDaoListImpl(this.getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}