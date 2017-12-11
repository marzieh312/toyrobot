package com.jora.toyrobot.models;

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

        @Override
        public int getDeltaX() {
            return 0;
        }

        @Override
        public int getDeltaY() {
            return 1;
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

        @Override
        public int getDeltaX() {
            return -1;
        }

        @Override
        public int getDeltaY() {
            return 0;
        }
    },
    SOUTH {
        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }

        @Override
        public int getDeltaX() {
            return 0;
        }

        @Override
        public int getDeltaY() {
            return -1;
        }
    },
    EAST {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }

        @Override
        public int getDeltaX() {
            return 1;
        }

        @Override
        public int getDeltaY() {
            return 0;
        }
    };

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract int getDeltaX();

    public abstract int getDeltaY();
}
