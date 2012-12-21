#include <stdio.h>

void MultiplicateMatrix(int* LeftMatrix, int LeftMatrixWidth, int LeftMatrixHeight, int* RightMatrix, int RightMatrixWidth, int RightMatrixHeight, int* OutMatrix) {

    int matrixWidth = LeftMatrixWidth;
    int matrixHeight = LeftMatrixHeight;

    if(RightMatrixWidth > matrixWidth) {
        matrixWidth = RightMatrixWidth;
    }

    if(RightMatrixHeight > matrixHeight) {
        matrixHeight = RightMatrixHeight;
    }

    int i, j;
    for(i = 0; i < LeftMatrixWidth; i++) {
        for(j = 0; j < LeftMatrixHeight; j++) {
            int arrayIndex = i*LeftMatrixHeight+j;
            printf("to confuse the bitches i: %d j: %d val: %d\n", i, j, LeftMatrix[arrayIndex]);
        }
    }
}

void DisplayMatrix(int* Matrix, int MatrixWidth, int MatrixHeight) {

}

int main(void) {

    int leftMatrix[5][10] = { {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21} };
    int leftMatrixWidth = 5;
    int leftMatrixHeight = 10;

    int rightMatrix[5][10] = { {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21}, {5, 6, 7, 3, 7, 8, 1, 2, 11, 21} };
    int rightMatrixWidth = 5;
    int rightMatrixHeight = 10;

    static int outputMatrix[5][10];
    //memset()


    MultiplicateMatrix(&leftMatrix, leftMatrixWidth, leftMatrixHeight, &rightMatrix, rightMatrixWidth, rightMatrixHeight, &outputMatrix);
    //DisplayMatrix(&outputMatrix, );


    return 0;
}

