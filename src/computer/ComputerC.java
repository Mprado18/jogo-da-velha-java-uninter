package computer;

import java.util.Random;

import board.Board;
import player.PlayerOne;

public class ComputerC extends PlayerOne {
	
	//gera número aleatório para jogada do computador
	Random generateRandomNumber = new Random();
    
    public ComputerC(int player) {
        super(player);
        this.player = player;
    }
    
    //realiza tentativa de jogada e seta posição da mesma no tabuleiro
    @Override
    public void play(Board baord) {
    	attempt(baord);
        baord.setPosition(attempt, player);
    }
    
    //realiza tentativa de jogada aleatória considerando linha 1 a 3 e colunas 1 a 2 para mudar dificuldade
    @Override
    public void attempt(Board board) {
    	do {
            do {
                attempt[0] = generateRandomNumber.nextInt(4);                
            } while( attempt[0] > 3 ||attempt[0] < 1);
            
            do {
                attempt[1] = generateRandomNumber.nextInt(3);
            } while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;

        } while(!checkAttempt(attempt, board));
    }

}
