package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllServlet
 */
@WebServlet("/ViewAllServlet")
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BandHelper bhlp = new BandHelper();
		request.setAttribute("allBands", bhlp.showAllBands());
		
		if(bhlp.showAllBands().isEmpty()){
		request.setAttribute("allBands", " ");		
		}
		
		BandMemberHelper dao = new BandMemberHelper();
		request.setAttribute("allMembers", dao.showAllMembers());
		
		if(dao.showAllMembers().isEmpty()){
		request.setAttribute("allMembers", " ");		
		}
		
		getServletContext().getRequestDispatcher("/EntireList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
