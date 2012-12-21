#include <stdio.h>

void MultiplicateMatrix(int* LeftMatrix, int LeftMatrixWidth, int LeftMatrixHeight, int* RightMatrix, int RightMatrixWidth, int RightMatrixHeight, int* OutMatrix)
{

}

void DisplayMatrix(int* Matrix, int MatrixWidth, int MatrixHeight)
{

}

int main(void)
{

    int leftMatrix[5][10] = { {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11} };
    int leftMatrixWidth = 5;
    int leftMatrixHeight = 10;

    int rightMatrix[5][10] = { {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11}, {5, 6, 7, 3, 7, 8, 1, 2, 11} };
    int rightMatrixWidth = 5;
    int rightMatrixHeight = 10;

    static int outputMatrix[5][10];
    //memset()


    MultiplicateMatrix(&leftMatrix, leftMatrixWidth, leftMatrixHeight, &rightMatrix, rightMatrixWidth, rightMatrixHeight, &outputMatrix);
    DisplayMatrix(&outputMatrix);


    return 0;
}

