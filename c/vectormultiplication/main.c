#include <stdio.h>
#include <stdlib.h>

int MultiplicateMatrix(int* LeftMatrix, int LeftMatrixWidth, int LeftMatrixHeight, int* RightMatrix, int RightMatrixWidth, int RightMatrixHeight, int* OutMatrix) {

    int matrixWidth = LeftMatrixWidth;
    int matrixHeight = LeftMatrixHeight;

    if(RightMatrixWidth > matrixWidth) {
        matrixWidth = RightMatrixWidth;
    }

    if(RightMatrixHeight > matrixHeight) {
        matrixHeight = RightMatrixHeight;
    }

    int outMatrixLength = LeftMatrixWidth;
    if(RightMatrixWidth < LeftMatrixWidth) {
        outMatrixLength = RightMatrixWidth;
        if(LeftMatrixHeight < RightMatrixHeight) {
            if(LeftMatrixHeight < outMatrixLength) {
                outMatrixLength = LeftMatrixHeight;
            }
        }
    }

    int columnNumber, rowNumber = 0;
    for(columnNumber = 0; columnNumber < matrixWidth; columnNumber++) {
        if ((columnNumber < LeftMatrixWidth) && (columnNumber < RightMatrixWidth)) {
            for(rowNumber = 0; rowNumber < matrixHeight; rowNumber++) {
                if((rowNumber < LeftMatrixHeight) && (rowNumber < RightMatrixHeight)) {
                    int k = 0;
                    int multiplicationSum = 0;
                    for (k = 0; k < matrixWidth; k++) {
                        int leftIndex = rowNumber * LeftMatrixWidth + k;
                        int leftValue = LeftMatrix[leftIndex];
                        printf("leftIndex is %d * %d + %d = %d with leftValue %d\n", rowNumber, LeftMatrixWidth, k, leftIndex, leftValue);

                        int rightIndex = k * RightMatrixWidth + columnNumber;
                        int rightValue = RightMatrix[rightIndex];
                        printf("right index is %d * %d + %d = %d with rightValue %d\n", k, RightMatrixWidth, columnNumber, rightIndex, rightValue);

                        multiplicationSum += (leftValue * rightValue);
                        printf("%d\n", multiplicationSum);
                    }
                    OutMatrix[rowNumber * outMatrixLength + columnNumber] = multiplicationSum;
                    printf("\n");
                }
            }
        }
        printf("\n\n");
    }
    return matrixWidth;
}

void DisplayMatrix(int* Matrix, int MatrixWidth, int MatrixHeight) {
    int i, j;
    for(i = 0; i < MatrixWidth; i++)
    {
        for(j = 0; j < MatrixHeight; j++)
        {
            printf("|%d|", Matrix[j*MatrixWidth+i]);
        }
        printf("\n");
    }
}

int main(void) {

    int leftMatrix[2][3] = { {1,2,3}, {4,5,6}};
    int leftMatrixWidth = 3;
    int leftMatrixHeight = 2;

    int rightMatrix[3][2] = { {7,8}, {9,10}, {11,12} };
    int rightMatrixWidth = 2;
    int rightMatrixHeight = 3;

    int* outMatrix = malloc(2*2*sizeof(int));

    int outMatrixLength = MultiplicateMatrix(&leftMatrix, leftMatrixWidth, leftMatrixHeight, &rightMatrix, rightMatrixWidth, rightMatrixHeight, outMatrix);

    if(outMatrix != 0) {
        DisplayMatrix(outMatrix, 2, 2);
        free(outMatrix);
    }

    return 0;
}

