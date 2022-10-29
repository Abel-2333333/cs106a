package main;/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

    // You fill in this part

    /**
     * 1. put beepers along 1st street
     * 2. continuously pick them up from two ends
     */
    @Override
    public void run() {
        putBeepersAlongStreet();
        pickUpBeepers();
    }

    private void pickUpBeepers() {
        if (frontIsClear()) {
            // stand on where there is a beeper
            if (noBeepersPresent()) {
                move();
            }
            while (beepersPresent()) {
                moveAndPick();
            }
            moveAndPick();
        } else {
            // in case of 1x1 world
            putBeeper();
        }
    }

    private void moveAndPick() {
        while (beepersPresent()) {
            move();
        }
        turnAndPick();
    }

    private void turnAndPick() {
        turnAround();
        move();
        if (beepersPresent()) {
            pickBeeper();
            move();
        } else {
            putBeeper();
        }
    }

    /**
     * precondition: Karel is at 1x1, facing east
     * postcondition: Karel is at 1x1, facing east with beepers along the street except for two ends
     */
    private void putBeepersAlongStreet() {
        while (frontIsClear()) {
            putBeeper();
            move();
        }
        // go back and pick up leftmost beeper
        pickUpFirstBeeper();
    }

    private void pickUpFirstBeeper() {
        if (frontIsBlocked()) {
            turnAround();
            while (frontIsClear()) {
                move();
            }
            if (beepersPresent()) {
                pickBeeper();
            }
            turnAround();
        }
    }
}
