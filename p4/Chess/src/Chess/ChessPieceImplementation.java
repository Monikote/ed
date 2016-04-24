package Chess;

public class ChessPieceImplementation implements ChessPiece {

    Color myColor;
    Type myType;
    boolean pieceMoved = false;
    
    public ChessPieceImplementation( Color color, Type tipo){
       myColor = color;
       myType =  tipo;
    }
            
    @Override
    public Color getColor(){
        return myColor;
    }

    @Override
    public Type getType() {
        return myType;
    }

    @Override
    public void notifyMoved() {
        pieceMoved = true;
    }

    @Override
    public boolean wasMoved() {
        return pieceMoved;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        // Movement depends of type piece
        if (myType == Type.BISHOP)
            return ChessMovementManager.getAvailablePositionsOfBishop(this, aBoard);  
        if (myType == Type.KING)
            return ChessMovementManager.getAvailablePositionsOfKing(this, aBoard);
        if (myType  == Type.KNIGHT)
            return ChessMovementManager.getAvailablePositionsOfKnight(this, aBoard);
        if (myType  == Type.QUEEN)
            return ChessMovementManager.getAvailablePositionsOfQueen(this, aBoard);
        if (myType  == Type.ROOK)
            return ChessMovementManager.getAvailablePositionsOfRook(this, aBoard);
        else 
            return ChessMovementManager.getAvailablePositionsOfPawn(this, aBoard);
    }
}