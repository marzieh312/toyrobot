package com.jora.toyrobot;

public enum Direction {
    NORTH {
        @Override
        public Direction turnLeft() {
            return Direction.WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    WEST {
        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    }, SOUTH {
        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    }, EAST {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    };

    public abstract Direction turnLeft();

    public abstract Direction turnRight();
}
