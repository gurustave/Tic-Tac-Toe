/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import tictactoe.board.Board;
import tictactoe.board.Space;
import tictactoe.player.AI;
import tictactoe.player.Human;
import tictactoe.player.Player;
import tictactoe.render.CLI;
import tictactoe.render.Renderer;

/**
 *
 * @author Gustave Michel
 */
public class TicTacToe {
    public static int[][] win = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {1,4,7},
        {2,5,8},
        {3,6,9},
        {1,5,9},
        {3,5,7}
    };
    
    private static Player player1;
    private static Player player2;
    public static Board board = new Board();
    public static Renderer renderer = new CLI();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        player1 = new Human(Space.State.X);
        player2 = new AI(Space.State.O);
        
        board.setSpace(player1.prompt(), player1.getState());
        board.setSpace(player2.prompt(), player2.getState());
        renderer.renderBoard();
        board.setSpace(player1.prompt(), player1.getState());
        board.setSpace(player2.prompt(), player2.getState());
        renderer.renderBoard();
        board.setSpace(player1.prompt(), player1.getState());
        board.setSpace(player2.prompt(), player2.getState());
        renderer.renderBoard();
        board.setSpace(player1.prompt(), player1.getState());
        board.setSpace(player2.prompt(), player2.getState());
        renderer.renderBoard();
        board.setSpace(player1.prompt(), player1.getState());
        board.setSpace(player2.prompt(), player2.getState());
        renderer.renderBoard();
    }
    
    public void winDetect() {
        
    }
}