package com.dejected.moves;

import com.dejected.Block;
import com.dejected.soldiers.Soldier;

import java.util.List;
import java.util.Optional;

/**
 * Created on 05/02/17 by dark magic.
 */
public class SoldiersInfo {
    public static SoldiersInfo soldiersInfo = new SoldiersInfo();
    private List<Soldier> soldiers;

    public Optional<Soldier> soldierAtBlock(Block block) {
        for (Soldier soldier : soldiers) {
            if (soldier.currentPosition().equals(block)) {
                return Optional.ofNullable(soldier);
            }
        }

        return Optional.empty();
    }

    public boolean killSoldierAtBlock(Block block) {
        for (Soldier soldier : soldiers) {
            if (soldier.currentPosition().equals(block)) {
                soldiers.remove(soldier);
                return true;
            }
        }
        return false;
    }
}
