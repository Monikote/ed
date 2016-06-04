package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard {

    // create board
    String board[][] = new String[3][3];
    
    //rellemanos
    public  NoughtsAndCrossesBoardImplementation()
    {
/**
* Esta es una version del tres en raya. La diferencia con el juego original es 
* que el tablero empieza ya con todas las fichas en el tablero y mueven las rojas.
* Las fichas se representan con una R las rojas, con una B las blancas, y con 
* una V la casilla vacía
* El tablero empieza así:
* R V B
* B R V
* R V B
*/
        board[0][0] ="R";
        board[1][0] ="V";
        board[2][0] ="B";
        
        board[0][1] ="B";
        board[1][1] ="R";
        board[2][1] ="V";
        
        board[0][2] ="R";
        board[1][2] ="V";
        board[2][2] ="B";
       
    }
    
    @Override
    public boolean isGameOver() {
        // columns  
        for ( int col =0; col < 3; col++)
          if ( board[0][col]!= "V" && board[0][col] == board[1][col] 
                  && board[0][col] == board[2][col] ) 
            return true;    

      // rows 
        for ( int row =0; row < 3; row++)
          if ( board[row][0] != "V" &&board[row][0] == board[row][1] 
                  && board[row][0] == board[row][2] ) 
            return true; 

      // diagonal
        if ( board[0][0] != "V" && board[0][0] == board[1][1] && board[0][0] == board[2][2] )
            return true;    
        if ( board[2][0] != "V" && board[2][0] == board[1][1] && board[2][0] == board[0][2] )
            return true;

        return false;
          
    }

    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        // is valid move and empty
        if (isValidPos(toX,toY) && isValidPos(fromX,fromY) ){
            if (canMovePieceAt(fromX,fromY))
                if(board [toX][toY] == "V" || board[toX][toY] == null){
                    board[toX][toY]=board[fromX][fromY];
                    board[fromX][fromY] = "V";
                    return true;
                }
        }
        return false; 
    }

    @Override
    public Color getPieceAt(int x, int y) { 
        if ( isValidPos(x,y) && board[x][y] != null && board[x][y] != "V" )
            return getColor(board[x][y]);
        else
            return Color.VOID;
    }

    @Override
    public boolean canMovePieceAt(int x, int y) {
        
        if ( board[x][y] != "V" || board[x][y] != null  &&  isValidPos(x,y))
            return true;
        else
            return false;
    }

    public Color getColor(String piece)
    {
        Color ncolor;
        switch(piece)
        {
            case "R":
                ncolor = Color.RED;
                break;
            case "B":
                ncolor = Color.WHITE;
                break;
            default:
                ncolor = Color.VOID;
                break;
        }
        return ncolor; 
    }
    public boolean isValidPos(int x ,int y)
    {
        if (x >= 0 && x < 3 && y >= 0 && y < 3)
            return true;
        else
            return false;
    }
}