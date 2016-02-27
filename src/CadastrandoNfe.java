

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fachada.Fachada;

/**
 * Servlet implementation class CadastrandoNfe
 */
@WebServlet("/CadastrandoNfe")
public class CadastrandoNfe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrandoNfe() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int numeroNfe= Integer.parseInt(request.getParameter("numero"));
		
		try {
			Fachada.getInstance().cadastrarNfe(numeroNfe);
			Fachada.getInstance().cadastrarNfeQuantidade(id, numeroNfe, quantidade);
			Fachada.getInstance().atualizar(quantidade, id);			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
