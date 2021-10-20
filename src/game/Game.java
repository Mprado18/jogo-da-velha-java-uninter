package game;

import java.util.Scanner;

import board.Board;
import computer.ComputerA;
import computer.ComputerB;
import computer.ComputerC;
import player.PlayerOne;
import playerHuman.Player;

public class Game {
    private Board board;
    private int round=1;
    private int turn=1;
    private PlayerOne playerOne;
    private PlayerOne playerTwo;
    public Scanner inputValue = new Scanner(System.in);

   //inicia game, jogadores e repete game até finalização
    public Game() {
        board = new Board();
        startPlayers();
        
        while(play());
    }
    
    //cria jogadores e define dificuldade do computador
    public void startPlayers() {
        System.out.println("\nJogador 1");
        this.playerOne = new Player(1);
        
        System.out.println("\nJogador 2 - Computador");
        System.out.println("\nEscolha o nível de dificuldade do Computador");
        
        chooseDifficulty();
                
    }
    
    //cria método para escolher dificuldade do computador
    public int chooseDifficulty() {
        int option=0;
        
        do {
            System.out.println("1 - Computador nível 1");
            System.out.println("2 - Computador nível 2");
            System.out.println("3 - Computador nível 3");
            System.out.print("\nOpção: ");
            option = inputValue.nextInt();
            
            if(option == 1) {
            	System.out.println("\nJogador 2 - Computador Nível 1");
            	this.playerTwo = new ComputerA(2);
            } else if(option == 2) {
            	System.out.println("\nJogador 2 - Computador Nível 2");
            	this.playerTwo = new ComputerB(2);
            } else if(option == 3) {
            	System.out.println("\nJogador 2 - Computador Nível 3");
            	this.playerTwo = new ComputerC(2);
            }
            
            if(option == 0 || option > 3)
                System.out.println("\nOpção inválida! Tente novamente");
        } while(option == 0 || option > 3);
        
        return option;
    }
    
    //cria método de jogar validando turno de cada jogador, se for computador joga direto
    public boolean play() {
        if(won() == 0 ){
            System.out.println("\n===========================");
            System.out.println("\nRodada "+round);
            System.out.println("É a vez do jogador " + turn());
            
            if(turn() == 1)
                playerOne.play(board);
            else
                playerTwo.play(board);
            
            
            if(board.boardCompleted()) {
                System.out.println("Deu velha!!!! Jogo empatado!");
                return false;
            }
            turn++;
            round++;

            return true;
        } else {
            if(won() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            
            return false;
        }
            
    }
    
    //método de validação de turno entre humano de computador
    public int turn() {
        if(turn%2 == 1)
            return 1;
        else
            return 2;
    }
    
    //método que valida quem ganhou a partida
    public int won() {
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
        
        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
}
