package player;

import board.Board;

public abstract class PlayerOne {
    
    protected int[] attempt = new int[2];
    protected int player;

    
    public PlayerOne(int player) {
        this.player = player;
    }
    
    //método de jogar para sobrescrita de quem extender a classe
    public abstract void play(Board board);
    
    //método de tentativa para sobrescrita de quem extender a classe
    public abstract void attempt(Board board);
    
    //método que valida se a posição já está preenchida ou não
    public boolean checkAttempt(int[] attempt, Board board) {
        if(board.getPosition(attempt) == 0)
            return true;
        else
            return false;       
    } 
}
