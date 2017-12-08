package com.jora.toyrobot;

public enum Direction {
    NORTH {
        @Override
        public Direction rotateLeft() {
            return Direction.WEST;
        }
    },
    WEST {
        @Override
        public Direction rotateLeft() {
            return SOUTH;
        }
    }, SOUTH {
        @Override
        public Direction rotateLeft() {
            return EAST;
        }
    }, EAST {
        @Override
        public Direction rotateLeft() {
            return NORTH;
        }
    };

    public abstract Direction rotateLeft();
}
