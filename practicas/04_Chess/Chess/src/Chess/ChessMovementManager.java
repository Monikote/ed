package Chess;

public class ChessMovementManager {

    static PiecePosition[] getAvailablePositionsOfPawn(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition auxPosition, position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();
        int direction = aPiece.getColor() == ChessPiece.Color.WHITE ? 1 : -1;

        result.addPositionWithDisplacementIfAvaiable(position, aBoard, 0, direction);
        if (!aPiece.wasMoved())
                result.addPositionWithDisplacementIfAvaiable(position, aBoard, 0, direction * 2);
        ChessPiece piece;
        auxPosition = position.getDisplacedPiece(1, direction);
        piece = aBoard.getPieceAt(auxPosition);
        if(piece!= null && piece.getColor() != aPiece.getColor())
                result.addPosition(auxPosition, 0, 0);

        auxPosition = position.getDisplacedPiece(-1, direction);
        piece = aBoard.getPieceAt(auxPosition);

        return result.getResult();
    }

    static void generateStepMovement(ChessPiece aPiece, ChessBoard aBoard, ChessMovementHelper aResult, 
        PiecePosition aPosition, int columnIncrement, int rowIncrement, int maxTimes) {

        PiecePosition auxPosition;
        int times = maxTimes;

        auxPosition = aPosition.getDisplacedPiece(columnIncrement, rowIncrement);
        while ((times-- > 0) && auxPosition != null && PiecePosition.isAvailable(auxPosition, 0, 0)) {
            // evalua si está disponible
            boolean added = aResult.addPositionWithDisplacementIfAvaiable(auxPosition, aBoard, 0, 0);
            // si no lo está, evalua si hay otra pieza en esa posicion
            if (!added) {
                    ChessPiece piece = aBoard.getPieceAt(auxPosition);
                    // si hay pieza y es de otro color, añade una posición 
                    if (piece != null && piece.getColor() != aPiece.getColor())
                            aResult.addPosition(auxPosition, 0, 0);
                    break;
            }
            auxPosition = auxPosition.getDisplacedPiece(columnIncrement, rowIncrement);
        }
    }

    static PiecePosition[] getAvailablePositionsOfBishop(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();

        // diagonales ascendente derecha e izquierda
        generateStepMovement(aPiece, aBoard, result, position, -1, 1, 8);  
        generateStepMovement(aPiece, aBoard, result, position, -1, -1, 8);

        // diagonales descendente derecha e iquierda
        generateStepMovement(aPiece, aBoard, result, position, 1, 1, 8);
        generateStepMovement(aPiece, aBoard, result, position, 1, -1, 8);

        return result.getResult();
    }
    static PiecePosition[] getAvailablePositionsOfKing(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();
        // horizontales
        generateStepMovement(aPiece, aBoard, result, position, 1, 0, 1);
        generateStepMovement(aPiece, aBoard, result, position, -1, 0, 1);
        // verticales
        generateStepMovement(aPiece, aBoard, result, position, 0, 1, 1);
        generateStepMovement(aPiece, aBoard, result, position, 0, -1, 1);
        // diagonales descendentes y ascendentes
        generateStepMovement(aPiece, aBoard, result, position, 1, 1, 1);
        generateStepMovement(aPiece, aBoard, result, position, 1, -1, 1);
        generateStepMovement(aPiece, aBoard, result, position, -1, 1, 1); 
        generateStepMovement(aPiece, aBoard, result, position, -1, -1, 1);

        return result.getResult();
    }

    static PiecePosition[] getAvailablePositionsOfQueen(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();

        // diagonales
        generateStepMovement(aPiece, aBoard, result, position, 1, 1, 8);
        generateStepMovement(aPiece, aBoard, result, position, 1, -1, 8);
        generateStepMovement(aPiece, aBoard, result, position, -1, 1, 8);
        /* Bug reportado por Chao, confirmo */
        generateStepMovement(aPiece, aBoard, result, position, -1, -1, 8);
        // horizontales
        generateStepMovement(aPiece, aBoard, result, position, -1, 0, 8);
        generateStepMovement(aPiece, aBoard, result, position, 1, 0, 8);
        // verticales
        generateStepMovement(aPiece, aBoard, result, position, 0, 1, 8);
        generateStepMovement(aPiece, aBoard, result, position, 0, -1, 8);

        return result.getResult();
    }

    static PiecePosition[] getAvailablePositionsOfKnight(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();

        generateStepMovement(aPiece, aBoard, result, position, 1, 2, 1);
        generateStepMovement(aPiece, aBoard, result, position, 1, 2, 1);
        generateStepMovement(aPiece, aBoard, result, position, -1, 2, 1);
        generateStepMovement(aPiece, aBoard, result, position, -1, -2, 1);
        generateStepMovement(aPiece, aBoard, result, position, 2, 1, 1);
        generateStepMovement(aPiece, aBoard, result, position, 2, -1, 1);
        generateStepMovement(aPiece, aBoard, result, position, -2, 1, 1);
        generateStepMovement(aPiece, aBoard, result, position, -2, -1, 1);

        return result.getResult();
    }

    static PiecePosition[] getAvailablePositionsOfRook(ChessPiece aPiece, ChessBoard aBoard) {
        PiecePosition position = aBoard.getPiecePosition(aPiece);
        ChessMovementHelper result = new ChessMovementHelper();
        //horizontales
        generateStepMovement(aPiece, aBoard, result, position, 1, 0, 8);
        generateStepMovement(aPiece, aBoard, result, position, -1, 0, 8);
        // verticales
        generateStepMovement(aPiece, aBoard, result, position, 0, 1, 8);
        generateStepMovement(aPiece, aBoard, result, position, 0, -1, 8);

        return result.getResult();
    }
}
