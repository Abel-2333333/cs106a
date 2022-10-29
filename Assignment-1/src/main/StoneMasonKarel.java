package main;/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

    /**
        precondition: Karel faces east
        postcondition: Karel finishes repairment and faces east. Before him is the wall.
     */
    public void run() {
        while (frontIsClear()) {
            repairOneColumn();
            moveToNextColumn();
        }
        repairOneColumn();
    }

    private void moveToNextColumn() {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    /**
     * Karel goes along the column and repair it. Finally return to his original place
     */
    private void repairOneColumn() {
        repair();
        goBack();
    }

    private void goBack() {
        // turn around and return
        turnAround();
        while (frontIsClear()) {
            move();
        }
        // face east
        turnLeft();
    }

    private void repair() {
        // face north
        turnLeft();
        // repairing
        while (frontIsClear()){
            if (noBeepersPresent()) {
                putBeeper();
            } else {
                move();
            }
        }
        // when Karel reaches the wall, check whether there is a beeper at his place
        if (noBeepersPresent()) {
            putBeeper();
        }
    }
}
