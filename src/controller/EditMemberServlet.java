package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;
import model.BandMember;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/EditMemberServlet")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BandMemberHelper dao = new BandMemberHelper();
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String instrument = request.getParameter("instrument");
		String band = request.getParameter("bandName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BandMember memberToUpdate = dao.searchForMemberById(tempId);
		memberToUpdate.setFirstName(first);
		memberToUpdate.setLastName(last);
		memberToUpdate.setInstrument(instrument);
		memberToUpdate.setBandName(band);
		dao.updateMember(memberToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllMusiciansServlet").forward(request, response);
	}

}
