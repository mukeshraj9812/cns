#include <stdio.h>
#include <string.h>
#include <ctype.h>

void encrypt(const char *pt, const char *key, char *ct) {
    int pt_len = strlen(pt);
    int key_len = strlen(key);
    for(int i = 0, j = 0; i < pt_len; i++, j++) {
        if(j >= key_len) j = 0;

        int shift = toupper(key[j]) - 'A';
        char res = (toupper(pt[i]) - 'A' + shift) % 26 + 'A';
        ct[i] = res;
    }
    ct[pt_len] = '\0';  // Null-terminate the ciphertext
}

void decrypt(const char *ct, const char *key, char *res) {
    int ct_len = strlen(ct);
    int key_len = strlen(key);
    for(int i = 0, j = 0; i < ct_len; i++, j++) {
        if(j >= key_len) j = 0;

        int shift = toupper(key[j]) - 'A';
        char ans = (toupper(ct[i]) - 'A' + 26 - shift) % 26 + 'A';
        res[i] = ans;
    }
    res[ct_len] = '\0';  // Null-terminate the result
}

int main() {
    char pt[128];
    char ct[128];
    char key[16];
    char res[128];

    printf("Enter pt in upper case: ");
    fgets(pt, sizeof(pt), stdin);
    pt[strcspn(pt, "\n")] = '\0';  // Remove trailing newline

    printf("Enter key in upper case: ");
    fgets(key, sizeof(key), stdin);
    key[strcspn(key, "\n")] = '\0';  // Remove trailing newline

    encrypt(pt, key, ct);
    printf("Ciphertext: %s\n", ct);

    decrypt(ct, key, res);
    printf("Decrypted text: %s\n", res);

    return 0;
}
