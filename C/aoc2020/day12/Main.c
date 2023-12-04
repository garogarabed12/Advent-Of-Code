#include <stdio.h>
#include <stdlib.h>
#include "Day12.h"

int main() {
    puts("Part 1:");

    FILE *input = fopen("dayTwelveInput.txt", "r");
    if (!input) {
        fclose(input);
        return 1;
    }

    Ship *ship = malloc(sizeof(*ship));
    ship->direction = EAST;
    ship->northPosition = 0;
    ship->eastPosition = 0;
    ship->southPosition = 0;
    ship->westPosition = 0;

    char navigationInstruction[100];
    char action;
    int value;

    while (fscanf(input, "%s", navigationInstruction) != EOF) {
        action = navigationInstruction[0];
        value = atoi(&navigationInstruction[1]);
        executeInstruction(ship, action, value);
    }
    printf("The Manhattan Distance is: %d\n", calculateManhattanDistance(ship));

    freeMemory(ship);
    fclose(input);
    puts("================================================");
    puts("Part 2");


    return 0;
}