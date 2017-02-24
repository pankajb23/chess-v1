package com.dejected.soldiers;

import com.dejected.moves.MovesFactory;
import com.dejected.player.Player;
import com.dejected.soldiers.impl.*;

/**
 * Created on 24/02/17 by dark magic.
 */
public class SoldierFactory {
    public static Soldier getSoldier(SoldierType soldierType, Player.PlayerType playerType) {
        switch (soldierType) {
            case PAWN:
                return new Pawn(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.PAWN_MOVE));
            case ELEPHANT:
                return new Elephant(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.STRAIGHT_MOVE));
            case CAMEL:
                return new Bishop(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.SLANT_MOVE));
            case HORSE:
                return new Horse(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.HORSE_MOVE));
            case KING:
                return new King(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.SLANT_AND_STRAIGHT_DISPLACEMENT_1));
            case QUEEN:
                return new Queen(playerType, MovesFactory.getMoves(MovesFactory.MOVE_TYPE.SLANT_AND_STRAIGHT));
            default:
                throw new RuntimeException("Error in soldier type");
        }
    }

    public enum SoldierType {
        PAWN,
        ELEPHANT,
        CAMEL,
        HORSE,
        KING,
        QUEEN
    }
}
