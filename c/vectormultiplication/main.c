#include <stdio.h>
#include <stdlib.h>

int MultiplicateMatrix(float* LeftMatrix, int LeftMatrixWidth, int LeftMatrixHeight, float* RightMatrix, int RightMatrixWidth, int RightMatrixHeight, float* OutMatrix) {

    int matrixWidth = LeftMatrixWidth;
    int matrixHeight = LeftMatrixHeight;

    if(RightMatrixWidth > matrixWidth) {
        matrixWidth = RightMatrixWidth;
    }

    if(RightMatrixHeight > matrixHeight) {
        matrixHeight = RightMatrixHeight;
    }

    int outMatrixLength = matrixWidth;
    if(matrixHeight < matrixWidth) {
        outMatrixLength = matrixHeight;
    }

    float* outMatrix = malloc(outMatrixLength * outMatrixLength * sizeof(int));
    int columnNumber, rowNumber = 0;
    for(columnNumber = 0; columnNumber < matrixWidth; columnNumber++) {
        if ((columnNumber < LeftMatrixWidth) && (columnNumber < RightMatrixWidth)) {
            for(rowNumber = 0; rowNumber < matrixHeight; rowNumber++) {
                if((rowNumber < LeftMatrixHeight) && (rowNumber < RightMatrixHeight)) {
                    int k = 0;
                    int multiplicationSum = 0;
                    for (k = 0; k < outMatrixLength; k++) {
                            int leftIndex = rowNumber * LeftMatrixWidth + k;
                            int leftValue = LeftMatrix[leftIndex];
                            printf("leftIndex is %d * %d + %d = %d with leftValue %d\n", rowNumber, LeftMatrixWidth, k, leftIndex, leftValue);

                            int rightIndex = k * RightMatrixWidth + columnNumber;
                            int rightValue = RightMatrix[rightIndex];
                            printf("right index is %d * %d + %d = %d with rightValue %d\n", k, RightMatrixWidth, columnNumber, rightIndex, rightValue);

                            multiplicationSum += (leftValue * rightValue);
                            printf("%d\n", multiplicationSum);
                        //}
                    }
                    outMatrix[rowNumber * outMatrixLength + columnNumber] = multiplicationSum;
                    //printf("%d|", multiplicationSum);
                    printf("\n");
                }
            }
        }
        printf("\n\n");
    }
    return outMatrixLength;
}

void DisplayMatrix(float* Matrix, int MatrixWidth, int MatrixHeight) {

}

int main(void) {

    float leftMatrix[2][3] = { {1,2,3}, {4,5,6}};
    int leftMatrixWidth = 3;
    int leftMatrixHeight = 2;

    float rightMatrix[3][2] = { {7,8}, {9,10}, {11,12} };
    int rightMatrixWidth = 2;
    int rightMatrixHeight = 3;

    float* outMatrix;


    MultiplicateMatrix(&leftMatrix, leftMatrixWidth, leftMatrixHeight, &rightMatrix, rightMatrixWidth, rightMatrixHeight, outMatrix);
    //DisplayMatrix(&outputMatrix, );


    return 0;
}

