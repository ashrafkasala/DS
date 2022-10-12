//package walmart;
//
//public class program {
//
//    public static void main(String[] args) {
//
//
//
////        [0, 1, 1, 0, 1 
////        1, 1, 0, 1, 0 
////        0, 1, 1, 1, 0
////        1, 1, 1, 1, 0 
////        1, 1, 1, 1, 1 
////        0, 0, 0, 0, 0]
//
////       int[][] matrix = { 0 1  1  0  1
////        1 1  0  1  0
////        0 1  1  1  0
////        1 1  2  2  0
////        1 2  2  3  1
////        0 0 0  0   0
//
////
////        int[][] matrix = {
////                {0, 1, 1, 0, 1},
////                {1, 1, 0, 1, 0},
////                {0, 1, 1, 1, 0},
////                {1, 1, 1, 1, 0},
////                {1, 1, 1, 0, 1},
////                {0, 0, 0, 0, 0}};
////
//////        int[][] matrix = {{1}};
////
////        int maxSize = Integer.MIN_VALUE;
////        for (int i = 0; i < matrix.length; i++) {
////            for (int j = 0; j < matrix[0].length; j++) {
////                if (matrix[i][j] == 0)
////                    continue;
////                if (i - 1 >= 0 && j - 1 >= 0) {
////                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
////                }
////                maxSize = Math.max(maxSize, matrix[i][j]);
////            }
////        }
////
////
////        System.out.println(maxSize);
////
//
//
//
//        jobs - [1, 2, 3, 4] deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4,3]] Result - [1, 4, 3, 2] or  [4, 1, 3, 2]
//
//
////        1 - {}
////        2 - {}
////        3 -{}
////        4 - {}
//
//         map (count, list<jobs>)
//
//        0  ->
//        result 4 , 1, 3,2
//
//
//
//    }
//
//
//}
