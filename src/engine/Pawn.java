package engine;

import chess.PieceType;
import chess.PlayerColor;

class Pawn extends Piece{

    Pawn(PieceType type, PlayerColor color, Move[] moves, int distance){
        super(type, color, moves, distance);
    }

    @Override
    boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        boolean isValidMove = false;
        int distance = isAlreadyMoved() ? getDistance() : 2; // First time, can move a distance 2
        Direction dirToMove;

        for(Move move : getMoves()){
           dirToMove = move.isValid(fromX, fromY, toX, toY, distance, getColor());
           switch(dirToMove){
               // Move UP possibly OK
               case UP:
                   // Check obstacle etc...
                   // ...
                   // All check ok -> move

                   if(!isAlreadyMoved()){
                       setAlreadyMoved(true);
                   }
                   isValidMove = true;
                   break;
               case DIAG_TOP_LEFT:
                   break;
               case DIAG_TOP_RIGHT:
                   break;
               default:
                   break;
           }
        }

        return isValidMove;
    }


}
