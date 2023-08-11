package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    private int moveCount = 0;

    public Wombat() {

        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();

        } else {
            int wPosition = this.getX();
            int sPosition = this.getY();
            if (wPosition == 0 && sPosition == 0) {
                this.turnLeft();
                this.move(10);
//                this.setDirection(EAST);
                this.turnLeft();
            } else if (this.getDirection() == WEST) {
                this.turnRight();
                this.move();
                this.turnRight();
            } else if (this.getDirection() == EAST) {
                this.turnLeft();
                this.move();
                this.turnLeft();
            }
        }
    }




    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }


    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
