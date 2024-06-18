#include <stdio.h>
#include <string.h>

int main() {
    unsigned int enc[3][3] = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}};
    unsigned int dec[3][3] = {{8, 5, 10}, {21, 8, 21}, {21, 12, 8}};

    unsigned int pt[3];
    unsigned int ct[3];
    unsigned int res[3];

    char plaintext[20];
    printf("Enter plaintext (3 characters): ");
    fgets(plaintext, sizeof(plaintext), stdin);

    // Ensure plaintext is at least 3 characters and uppercase
    for(int i = 0; i < 3; i++) {
        pt[i] = (plaintext[i] - 'A') % 26;
    }

    // Encryption:
    for(int i = 0; i < 3; i++) {
        int sum = 0;
        for(int j = 0; j < 3; j++) {
            sum += pt[j] * enc[i][j];
        }
        ct[i] = sum % 26;
    }

    printf("Ciphertext: ");
    for(int i = 0; i < 3; i++) {
        printf("%c", ct[i] + 'A');
    }
    printf("\n");

    // Decryption:
    for(int i = 0; i < 3; i++) {
        int sum = 0;
        for(int j = 0; j < 3; j++) {
            sum += ct[j] * dec[i][j];
        }
        res[i] = sum % 26;
    }

    printf("Decrypted text: ");
    for(int i = 0; i < 3; i++) {
        printf("%c", res[i] + 'A');
    }
    printf("\n");

    return 0;
}
