#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "Day12.h"

void executeInstruction(Ship *ship, char action, int value) {
    switch (action) {
        case 'L':
            rotateShipLeft(ship, value);
            break;

        case 'R':
            rotateShipRight(ship, value);
            break;

        case 'F':
            moveShipForward(ship, value);
            break;

        case 'N':
            moveShipNorth(ship, value);
            break;

        case 'E':
            moveShipEast(ship, value);
            break;

        case 'S':
            moveShipSouth(ship, value);
            break;

        case 'W':
            moveShipWest(ship, value);
            break;
    }
}

void rotateShipLeft(Ship *ship, int value) {
    switch (ship->direction) {
        case NORTH:
            rotateShipLeftFromNorth(ship, value);
            break;
        case EAST:
            rotateShipLeftFromEast(ship, value);
            break;
        case SOUTH:
            rotateShipLeftFromSouth(ship, value);
            break;
        case WEST:
            rotateShipLeftFromWest(ship, value);
            break;
    }
}

void rotateShipLeftFromNorth(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = WEST;
            break;
        case 180:
            ship->direction = SOUTH;
            break;
        case 270:
            ship->direction = EAST;
            break;
    }
}

void rotateShipLeftFromEast(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = NORTH;
            break;
        case 180:
            ship->direction = WEST;
            break;
        case 270:
            ship->direction = SOUTH;
            break;
    }
}

void rotateShipLeftFromSouth(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = EAST;
            break;
        case 180:
            ship->direction = NORTH;
            break;
        case 270:
            ship->direction = WEST;
            break;
    }
}

void rotateShipLeftFromWest(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = SOUTH;
            break;
        case 180:
            ship->direction = EAST;
            break;
        case 270:
            ship->direction = NORTH;
            break;
    }
}

void rotateShipRight(Ship *ship, int value) {
    switch (ship->direction) {
        case NORTH:
            rotateShipRightFromNorth(ship, value);
            break;
        case EAST:
            rotateShipRightFromEast(ship, value);
            break;
        case SOUTH:
            rotateShipRightFromSouth(ship, value);
            break;
        case WEST:
            rotateShipRightFromWest(ship, value);
            break;
    }
}

void rotateShipRightFromNorth(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = EAST;
            break;
        case 180:
            ship->direction = SOUTH;
            break;
        case 270:
            ship->direction = WEST;
            break;
    }
}

void rotateShipRightFromEast(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = SOUTH;
            break;
        case 180:
            ship->direction = WEST;
            break;
        case 270:
            ship->direction = NORTH;
            break;
    }
}

void rotateShipRightFromSouth(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = WEST;
            break;
        case 180:
            ship->direction = NORTH;
            break;
        case 270:
            ship->direction = EAST;
            break;
    }
}

void rotateShipRightFromWest(Ship *ship, int value) {
    switch (value) {
        case 90:
            ship->direction = NORTH;
            break;
        case 180:
            ship->direction = EAST;
            break;
        case 270:
            ship->direction = SOUTH;
            break;
    }
}

void moveShipForward(Ship *ship, int value) {
    switch (ship->direction) {
        case NORTH:
            moveShipNorth(ship, value);
            break;
        case EAST:
            moveShipEast(ship, value);
            break;
        case SOUTH:
            moveShipSouth(ship, value);
            break;
        case WEST:
            moveShipWest(ship, value);
            break;
    }
}

void moveShipNorth(Ship *ship, int value) {
    ship->southPosition -= value;
    if (ship->southPosition < 0) {
        ship->northPosition += abs(ship->southPosition);
        ship->southPosition = 0;
    }
}

void moveShipEast(Ship *ship, int value) {
    ship->westPosition -= value;
    if (ship->westPosition < 0) {
        ship->eastPosition += abs(ship->westPosition);
        ship->westPosition = 0;
    }
}

void moveShipSouth(Ship *ship, int value) {
    ship->northPosition -= value;
    if (ship->northPosition < 0) {
        ship->southPosition += abs(ship->northPosition);
        ship->northPosition = 0;
    }
}

void moveShipWest(Ship *ship, int value) {
    ship->eastPosition -= value;
    if (ship->eastPosition < 0) {
        ship->westPosition += abs(ship->eastPosition);
        ship->eastPosition = 0;
    }
}

int calculateManhattanDistance(Ship *ship) {
    return ship->northPosition + ship->eastPosition + ship->southPosition + ship->westPosition;
}

void freeMemory(Ship *ship) {
    free(ship);
}