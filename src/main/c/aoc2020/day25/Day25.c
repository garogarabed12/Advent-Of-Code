#include <stdio.h>
#include <stdlib.h>

int calculateLoopsize(long publicKey);

long makeHandshake(int loopSize, long subjectNumber);

int main() {
    FILE *input = fopen("DayTwentyFiveInput.txt", "r");
    if (!input) {
        fclose(input);
        return 1;
    }

    long doorPublicKey;
    long cardPublicKey;
    fscanf(input, "%ld", &doorPublicKey);
    fscanf(input, "%ld", &cardPublicKey);

    int loopSizeOfDoor = calculateLoopsize(doorPublicKey);
    int loopSizeOfCard = calculateLoopsize(cardPublicKey);

    long doorEncryptionKey = makeHandshake(loopSizeOfCard, doorPublicKey);
    long cardEncryptionKey = makeHandshake(loopSizeOfDoor, cardPublicKey);

    //Both should be equal
    printf("Encryption keys are:\n%ld\n%ld\n", doorEncryptionKey, cardEncryptionKey);

    fclose(input);
    return 0;
}

int calculateLoopsize(long publicKey) {
    long subjectNumber = 7;
    long result = 1;
    int loopSize = 0;
    while(result != publicKey) {
        result *= subjectNumber;
        result = result % 20201227;
        loopSize++;
    }
    return loopSize;
}

long makeHandshake(int loopSize, long subjectNumber) {
    int i = 0;
    long result = 1;
    while (i < loopSize) {
        result = result * subjectNumber;
        result = result % 20201227;
        i++;
    }
    return result;
}