typedef enum {
    NORTH = 0, EAST = 90, SOUTH = 180, WEST = 270
} Direction;

typedef struct {
    Direction direction;
    int northPosition;
    int eastPosition;
    int southPosition;
    int westPosition;
} Ship;

void executeInstruction(Ship *ship, char action, int value);

void rotateShipLeft(Ship *ship, int value);

void rotateShipLeftFromNorth(Ship *ship, int value);

void rotateShipLeftFromEast(Ship *ship, int value);

void rotateShipLeftFromSouth(Ship *ship, int value);

void rotateShipLeftFromWest(Ship *ship, int value);

void rotateShipRight(Ship *ship, int value);

void rotateShipRightFromNorth(Ship *ship, int value);

void rotateShipRightFromEast(Ship *ship, int value);

void rotateShipRightFromSouth(Ship *ship, int value);

void rotateShipRightFromWest(Ship *ship, int value);

void moveShipForward(Ship *ship, int value);

void moveShipNorth(Ship *ship, int value);

void moveShipEast(Ship *ship, int value);

void moveShipSouth(Ship *ship, int value);

void moveShipWest(Ship *ship, int value);

int calculateManhattanDistance(Ship *ship);

void freeMemory(Ship *ship);