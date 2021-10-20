package board;

//cria classe tabuleiro
public class Board {
    private int[][] board= new int[3][3];
    
    //chama m�todo que limpa tabuleiro
    public Board() {
        cleanBoard();
    }
    
    //cria m�todo para limpar tabuleiro
    public void cleanBoard() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = 0;
    }
    
    //exibe o tabuleiro com os preenchimentos ap�s cada jodada
    public void renderBoard() {
        System.out.println();
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                
                if(board[i][j] == -1) {
                    System.out.print(" X ");
                } else if(board[i][j] == 1) {
                    System.out.print(" O ");
                } else if(board[i][j] == 0) {
                    System.out.print("   ");
                }
                
                if(j == 0 || j == 1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }
    
    //captura posi��o no tabuleiro
    public int getPosition(int[] attempt) {
        return board[attempt[0]][attempt[1]];
    }
    
    //envia seta posi��o no tabuleiro
    public void setPosition(int[] attempt, int player) {
        if(player == 1)
            board[attempt[0]][attempt[1]] = -1;
        else
            board[attempt[0]][attempt[1]] = 1;
        
        renderBoard();
    }
    
    //verifica quais linhas est�o preenchidas e define pontua��o
    public int checkLines() {
        for(int i = 0; i < 3; i++) {

            if( (board[i][0] + board[i][1] + board[i][2]) == -3)
                return -1;
            if( (board[i][0] + board[i][1] + board[i][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    //verifica quais colunas est�o preenchidas e define pontua��o
    public int checkColumns() {
        for(int j = 0; j < 3; j++) {

            if( (board[0][j] + board[1][j] + board[2][j]) == -3)
                return -1;
            if( (board[0][j] + board[1][j] + board[2][j]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    //verifica quais diagonais est�o preenchidas e define pontua��o
    public int checkDiagonals() {
        if( (board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if( (board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if( (board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if( (board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    //verifica se tabuleiro est� completo
    public boolean boardCompleted() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[i][j] == 0)
                    return false;
        return true;
    }
}
