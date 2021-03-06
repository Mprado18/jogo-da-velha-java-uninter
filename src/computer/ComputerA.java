package computer;

import java.util.Random;

import board.Board;
import player.PlayerOne;

public class ComputerA extends PlayerOne {
	
	//gera n?mero aleat?rio para jogada do computador
	Random generateRandomNumber = new Random();
    
    public ComputerA(int player) {
        super(player);
        this.player = player;
    }
    
    //realiza tentativa de jogada e seta posi??o da mesma no tabuleiro
    @Override
    public void play(Board board) {
    	attempt(board);
        board.setPosition(attempt, player);
    }
    
    //realiza tentativa de jogada aleat?ria considerando linha 1 a 3 e colunas 1 a 3
    @Override
    public void attempt(Board board) {
    	do {
            do {
                attempt[0] = generateRandomNumber.nextInt(4);                
            } while( attempt[0] > 3 ||attempt[0] < 1);
            
            do {
                attempt[1] = generateRandomNumber.nextInt(4);
            } while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;

        } while(!checkAttempt(attempt, board));
    }

}
