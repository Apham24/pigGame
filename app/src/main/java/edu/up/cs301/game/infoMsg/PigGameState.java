package edu.up.cs301.game.infoMsg;

public class PigGameState extends GameState{
    private int currTurn;
    private int score0;
    private int score1;
    private int runningTotal;
    private int currValue;
    private String message;

    public PigGameState(){
        this.currTurn = 0;
        this.score0 = 0;
        this.score1 = 0;
        this.runningTotal = 0;
        this.currValue = 0;
        this.message = "";
    }
    public PigGameState(PigGameState orig){
        this.currTurn = orig.currTurn;
        this.score0 = orig.score0;
        this.score1 = orig.score1;
        this.runningTotal = orig.runningTotal;
        this.currValue = orig.currValue;
        this.message = orig.message;
    }
    public int getCurrTurn(){
        return currTurn;
    }
    public int getScore0(){
        return score0;
    }
    public int getScore1(){
        return score1;
    }
    public int getRunningTotal(){
        return runningTotal;
    }
    public int getCurrValue(){
        return currValue;
    }
    public String getMessage(){return message;}
    public void setCurrTurn(int val){
        this.currTurn = val;
    }
    public void setScore0(int val){
        this.score0 = val;
    }
    public void setScore1(int val){
        this.score1 = val;
    }
    public void setRunningTotal(int val){
        this.runningTotal = val;
    }
    public void setCurrValue(int val){
        this.currValue = val;
    }
    public void setMessage(String val){this.message = val;}
}
