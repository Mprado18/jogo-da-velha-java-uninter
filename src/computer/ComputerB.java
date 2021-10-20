package computer;

import java.util.Random;

import board.Board;
import player.PlayerOne;

public class ComputerB extends PlayerOne {
	
	//gera número aleatório para jogada do computador
	Random generateRandomNumber = new Random();
    
    public ComputerB(int player) {
        super(player);
        this.player = player;
    }
    
    //realiza tentativa de jogada e seta posição da mesma no tabuleiro
    @Override
    public void play(Board board) {
    	attempt(board);
        board.setPosition(attempt, player);
    }
    
    //realiza tentativa de jogada aleatória considerando linha 1 a 2 e colunas 1 a 2 para mudar dificuldade
    @Override
    public void attempt(Board board) {
    	do {
            do {
                attempt[0] = generateRandomNumber.nextInt(3);                
            } while( attempt[0] > 3 ||attempt[0] < 1);
            
            do {
                attempt[1] = generateRandomNumber.nextInt(3);
            } while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;

        } while(!checkAttempt(attempt, board));
    }

}
