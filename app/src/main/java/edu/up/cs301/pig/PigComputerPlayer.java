package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.PigHoldAction;
import edu.up.cs301.game.actionMsg.PigRollAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.PigGameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState state = new PigGameState((PigGameState) info);
        if(state.getCurrTurn() != this.playerNum){
            return;
        }else{
            if(Math.random() * 2 > 1){
                PigHoldAction action  = new PigHoldAction(this);
                this.sleep(2000);
                this.game.sendAction(action);
            }else {
                PigRollAction action = new PigRollAction(this);
                this.sleep(2000);
                this.game.sendAction(action);

            }
        }
        // TODO  You will implement this method
    }//receiveInfo

}
