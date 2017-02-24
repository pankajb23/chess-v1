package com.dejected.moves;

/**
 * Created on 23/02/17 by dark magic.
 */
public class MovesFactory {
    private static int SINGLE_MOVE = 1;
    private static int MULTIPLE_MOVE = 8;

    public static Move getMoves(MOVE_TYPE move_type) {
        switch (move_type) {
            case PAWN_MOVE:
                return new PawnMoves();
            case HORSE_MOVE:
                return new HorseMoves();
            case SLANT_AND_STRAIGHT:
                return new StraightAndSlantMoves(new StraightMoves(MULTIPLE_MOVE), new SlantMoves(MULTIPLE_MOVE));
            case SLANT_MOVE:
                return new SlantMoves(MULTIPLE_MOVE);
            case STRAIGHT_MOVE:
                return new StraightMoves(MULTIPLE_MOVE);
            case SLANT_AND_STRAIGHT_DISPLACEMENT_1:
                return new StraightAndSlantMoves(new SlantMoves(SINGLE_MOVE), new StraightMoves(SINGLE_MOVE));
            case SLANT_MOVE_DISPLACEMENT_1:
                return new SlantMoves(SINGLE_MOVE);
            case STRAIGHT_MOVE_DISPLACEMENT_1:
                return new StraightMoves(SINGLE_MOVE);
            default:
                throw new RuntimeException("No valid Move for the given type");
        }
    }

    public enum MOVE_TYPE {
        PAWN_MOVE,
        HORSE_MOVE,
        SLANT_MOVE_DISPLACEMENT_1,
        STRAIGHT_MOVE_DISPLACEMENT_1,
        SLANT_AND_STRAIGHT_DISPLACEMENT_1,
        SLANT_MOVE,
        STRAIGHT_MOVE,
        SLANT_AND_STRAIGHT
    }
}
