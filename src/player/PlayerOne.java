package player;

import board.Board;

public abstract class PlayerOne {
    
    protected int[] attempt = new int[2];
    protected int player;

    
    public PlayerOne(int player) {
        this.player = player;
    }
    
    //m�todo de jogar para sobrescrita de quem extender a classe
    public abstract void play(Board board);
    
    //m�todo de tentativa para sobrescrita de quem extender a classe
    public abstract void attempt(Board board);
    
    //m�todo que valida se a posi��o j� est� preenchida ou n�o
    public boolean checkAttempt(int[] attempt, Board board) {
        if(board.getPosition(attempt) == 0)
            return true;
        else
            return false;       
    } 
}
