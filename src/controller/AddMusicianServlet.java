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
 * Servlet implementation class AddMusicianServlet
 */
@WebServlet("/AddMusicianServlet")
public class AddMusicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMusicianServlet() {
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
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String instrument = request.getParameter("instrument");
		String band = request.getParameter("bandName");
		BandMember b = new BandMember(first, last, instrument, band);
		BandMemberHelper dao = new BandMemberHelper();
		dao.insertMember(b);
		getServletContext().getRequestDispatcher("/ViewAllMusiciansServlet").forward(request, response);
	}

}
