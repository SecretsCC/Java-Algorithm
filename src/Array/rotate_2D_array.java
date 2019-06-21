package Array;

public class rotate_2D_array {
    public static void rotate(int[][] matrix){
        int size = matrix.length - 1;
        for(int i = 0; i < matrix.length / 2; ++i) {
            for(int j = i; j < size  - i; ++j) {
                int temp1 = matrix[i][j]; // 00
                int temp2 = matrix[size -  i][size - j]; // 02
                int temp3 = matrix[j][size- i];  //20
                int temp4 = matrix[size - j][i]; //22
                matrix[i][j] = temp4;
                matrix[j][size - i] = temp1;
                matrix[size - j][i] = temp2;
                matrix[size - i][size - j] = temp3;
            }
        }
    }

    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("original matrix");
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("after rotate");
        rotate(matrix);
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
