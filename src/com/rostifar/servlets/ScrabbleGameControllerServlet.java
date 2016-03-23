package com.rostifar.servlets;

import com.rostifar.gamecontrol.GameManager;
import com.rostifar.gamecontrol.ScrabbleGameException;
import com.rostifar.gamecontrol.ScrabbleGameManager;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 *  This Servlet can be used to "talk" to the ScrabbleGame Java based domain model from a UI.
 *  Created by GitLazy (Dad) on 3/4/2016.
 */
public class ScrabbleGameControllerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println(this.getClass().getName() + "DO GET Called!");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println(this.getClass().getName() + "Starting Scrabble Game Engine on Backend...");
        try {
            GameManager gameManager = new ScrabbleGameManager();
            gameManager.runGame();
        } catch (ScrabbleGameException gameExp) {
            throw new ServletException(gameExp);
        }
    }


}
