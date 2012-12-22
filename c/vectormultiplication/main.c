#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

typedef struct {
  int* matrix;
  int rows;
  int columns;
} MatrixInfo;

void MultiplyMatricesOnHost(
  MatrixInfo* left_matrix,
  MatrixInfo* right_matrix,
  MatrixInfo* result_matrix
);

int main(int argc, char* argv[]) {
  int left_matrix[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9},
  };

  int right_matrix[3][2] = {
    {9, 8},
    {7, 6},
    {5, 4},
  };

  int result_matrix[3][2];

  MatrixInfo left_matrix_info = {(int*)&left_matrix, 3, 3};
  MatrixInfo right_matrix_info = {(int*)&right_matrix, 3, 2};
  MatrixInfo result_matrix_info = {(int*)&result_matrix, 3, 2};

  MultiplyMatricesOnHost(
    &left_matrix_info,
    &right_matrix_info,
    &result_matrix_info
  );

  int i, j;
  for (i = 0; i < result_matrix_info.rows; i++) {
    for (j = 0; j < result_matrix_info.columns; j++) {
      printf("%3d", result_matrix[i][j]);

      if (j < result_matrix_info.columns - 1) {
        printf("\t");
      }
    }
    printf("\n");
  }
}

void MultiplyMatricesOnHost(
  MatrixInfo* left_matrix,
  MatrixInfo* right_matrix,
  MatrixInfo* result_matrix
) {
  int left_matrix_row, right_matrix_column, key;
  for (left_matrix_row = 0; left_matrix_row < left_matrix->rows; left_matrix_row++) {
    for (right_matrix_column = 0; right_matrix_column < right_matrix->columns; right_matrix_column++) {
      int multiplication_sum = 0;

      for (key = 0; key < right_matrix->rows; key++) {
        multiplication_sum +=
          left_matrix->matrix[left_matrix_row * left_matrix->columns + key] *
          right_matrix->matrix[key * right_matrix->columns + right_matrix_column];
      }

      int result_key = left_matrix_row * result_matrix->columns
        + right_matrix_column;

      result_matrix->matrix[result_key] = multiplication_sum;
    }
  }
}
