package com.rostifar.servlets;

import com.rostifar.gamecontrol.ScrabbleGameManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Git:Lazy (Dad) on 3/21/2016.
 * Servlet called by from end to process a player playing a word using back end.
 */
public class PlayWordServlet extends ScrabbleServletHelper {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //  String playerName  = request.getParameter("PlayerName");
        String scrabbleWordInput = request.getParameter("wordToPlay");
        int wordRow = Integer.valueOf(request.getParameter("wordRow"));
        int wordCol = Integer.valueOf(request.getParameter("wordCol"));
        String orientation  = request.getParameter("orientation");
        System.out.println(this.getClass().getName() + " - Play word: " + "scrabbleWordInput");

      /*if (scrabbleWordInput == null || scrabbleWordInput.isEmpty()) {
          throw new ScrabbleGameInvalidWordException("Word is blank");
      }*/

        ScrabbleGameManager gameManager = ScrabbleServletHelper.getGameManagerFromSession(request);
        gameManager.playWord(scrabbleWordInput, wordCol, wordRow, orientation);
        String json = ScrabbleServletHelper.getJSONforGameManager(gameManager);
        ScrabbleServletHelper.storeGameManagerOnSession(request, gameManager);
        System.out.println(this.getClass().getName() + "Returning JSON\n" + json);
        response.getWriter().write(json);
    }
}
