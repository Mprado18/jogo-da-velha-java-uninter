package playerHuman;

import java.util.Scanner;

import board.Board;
import player.PlayerOne;

public class Player extends PlayerOne {
    public Scanner inputValue = new Scanner(System.in);
    
    public Player(int player ) {
        super(player);
        this.player = player;
    }
    
    //realiza tentativa de jogada e seta posição da mesma no tabuleiro
    @Override
    public void play(Board board) {
        attempt(board);
        board.setPosition(attempt, player);
    }
    
    //para cada vez do player humano podemos escolher uma posição na linha e coluna a ser jogada
    @Override
    public void attempt(Board board ) {
        do {
            do {
                System.out.print("\nLinha: ");
                attempt[0] = inputValue.nextInt();
                
                if(attempt[0] > 3 ||attempt[0] < 1)
                    System.out.println("\nLinha inválida. É 1, 2 ou 3");
                
            } while(attempt[0] > 3 ||attempt[0] < 1);
            
            do {
                System.out.print("Coluna: ");
                attempt[1] = inputValue.nextInt();
                
                if(attempt[1] > 3 ||attempt[1] < 1)
                    System.out.println("\nColuna inválida. É 1, 2 ou 3");
                
            } while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;
            
            if(!checkAttempt(attempt, board))
                System.out.println("\nEsse local já foi marcado. Tente outro.");
        } while(!checkAttempt(attempt, board));
    }
}
