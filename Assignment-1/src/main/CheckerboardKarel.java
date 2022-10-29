package main;
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

    // You fill in this part

    /**
     * precondition: Karel faces east at 1 x 1 postcondition: Karel faces north on top left corner
     */
    public void run() {
        putBeeper();
        // in case of 1x* world
        if (frontIsBlocked()) {
            turnLeft();
            while (frontIsClear()){
                putBeepersAlongStreet();
            }
        }
        while (frontIsClear()) {
            moveEast();
            if (frontIsClear()) {
                moveWest();
            }
        }
    }


    /**
     * move along east. If there is a street above, turn left, move, and turn left;
     */
    private void moveEast() {
        putBeepersAlongStreet();
        turnLeft();
        if (frontIsClear()) {
            if (noBeepersPresent()) {
                move();
                putBeeper();
            } else {
                move();
            }
            turnLeft();
        }
    }


    /**
     * move along west. If there is a street above, turn left, move, and turn left;
     */
    private void moveWest() {
        putBeepersAlongStreet();
        turnRight();
        if (frontIsClear()) {
            if (noBeepersPresent()) {
                move();
                putBeeper();
            } else {
                move();
            }
            turnRight();
        }
    }


    private void putBeepersAlongStreet() {
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                move();
                putBeeper();
            }
            if (frontIsClear()) {
                move();
            }
        }
    }

}
