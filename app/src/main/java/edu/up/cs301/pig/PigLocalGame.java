package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.infoMsg.PigGameState;

import junit.framework.Assert;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        this.state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {

        //TODO  You will implement this method
        return playerIdx == state.getCurrTurn();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
           if(state.getCurrTurn() == 0){
               state.setScore0( state.getScore0() + state.getRunningTotal());
               state.setRunningTotal(0);
               if(this.players.length > 1)
               state.setCurrTurn(1);
               return true;
           }
           else if(state.getCurrTurn() == 1){
               state.setScore1(state.getScore1() + state.getRunningTotal());
               state.setRunningTotal(0);
               state.setCurrTurn(0);
               return true;
            }
        }else if(action instanceof PigRollAction){
            state.setCurrValue((int) ((Math.random() * 6) + 1));
            if(state.getCurrValue() != 1){
                state.setRunningTotal(state.getRunningTotal() + state.getCurrValue());
            }else {
                state.setRunningTotal(0);

            if(this.players.length > 1){
                if(state.getCurrTurn() == 0) {
                    state.setCurrTurn(1);
                } else {
                    state.setCurrTurn(0);
                }
            }
            }
            return true;
        }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState newState = new PigGameState(state);
        p.sendInfo(newState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(state.getScore0() >= 50){
            return "Congrats " + this.playerNames[0] + " has won the game!";
        }
        else if(state.getScore1() >= 50){
            return "Congrats " + this.playerNames[1] + " has won the game!";
        }
        return null;
    }

}// class PigLocalGame
