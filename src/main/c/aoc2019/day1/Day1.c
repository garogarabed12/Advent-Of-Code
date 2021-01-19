#include <stdio.h>
#include <math.h>
#include "Day1.h"

long calculateFuelNeededForModule(long mass);

int main() {
    FILE *input = fopen("DayOneInput.txt", "r");
    if (!input) return 1;

    long mass;
    long totalFuelRequirement = 0;
    while (fscanf(input, "%ld", &mass) == 1) {
        totalFuelRequirement += calculateFuelNeededForModule(mass);
    }
    puts("The sum of the fuel requirements for all of the modules on your spacecraft is:");
    printf("%ld\n", totalFuelRequirement);
    return 0;
}

long calculateFuelNeededForModule(long mass) {
    return ((long) floor(mass / 3)) - 2;
}