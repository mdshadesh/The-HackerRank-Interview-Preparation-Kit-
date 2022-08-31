#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>


int main() {

    FILE * in = stdin;
    FILE * out = stdout;
   
    int command;
    int k;
    char buf[1000000];
    char ** undos;
    int n, i, ptr = 0;
    size_t len;
    fscanf(in, "%d", &n);
    undos = calloc(sizeof(char *), n);
    undos[ptr] = malloc(sizeof(char));
    strcpy(undos[ptr], "");
    for (i = 0; i < n; ++i) {
        fscanf(in, "%d", &command);
        switch(command) {
            case 1:
                fscanf(in, "%1000000s\n", buf);
                ++ptr;
                undos[ptr] = malloc(sizeof(char) * (strlen(undos[ptr-1]) + strlen(buf) + 1));
                strcpy(undos[ptr], undos[ptr-1]);
                strcat(undos[ptr], buf);
                break;
            case 2:
                fscanf(in, "%d", &k);
                ++ptr;
                undos[ptr] = malloc(sizeof(char) * (strlen(undos[ptr - 1]) - k + 1));
                len = strlen(undos[ptr - 1]);
                memcpy(undos[ptr], undos[ptr-1], strlen(undos[ptr - 1]) - k);
                undos[ptr][len - k] = 0;
                break;
            case 3:
                fscanf(in, "%d", &k);
                fprintf(out, "%c\n", undos[ptr][k-1]);
                break;
            case 4:
                --ptr;
                break;
        }
    }
    return 0;
}