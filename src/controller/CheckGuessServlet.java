package controller;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;
import model.Game.GamePegs;

/**
 * Servlet implementation class CheckGuessServlet
 */
@WebServlet("/checkGuess")
public class CheckGuessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGuessServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Game game = (Game) request.getSession().getAttribute("game");
		var guess = getGuess(request);
		game.makeGuess(guess);

		log("Game Code: " + Arrays.deepToString(game.getGameCode()));

		request.getRequestDispatcher("/game.jsp").forward(request, response);		
	}
	
	private GamePegs[] getGuess(HttpServletRequest request) {
		GamePegs[] guess = new GamePegs[4];

		guess[0] = GamePegs.valueOf(request.getParameter("color1"));
		guess[1] = GamePegs.valueOf(request.getParameter("color2"));
		guess[2] = GamePegs.valueOf(request.getParameter("color3"));
		guess[3] = GamePegs.valueOf(request.getParameter("color4"));
				
		return (guess);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
