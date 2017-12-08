package com.jora.toyrobot;

public enum Direction {
    NORTH {
        @Override
        public Direction turnLeft() {
            return Direction.WEST;
        }
    },
    WEST {
        @Override
        public Direction turnLeft() {
            return SOUTH;
        }
    }, SOUTH {
        @Override
        public Direction turnLeft() {
            return EAST;
        }
    }, EAST {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }
    };

    public abstract Direction turnLeft();
}
