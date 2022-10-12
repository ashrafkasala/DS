package MISC;

import java.util.ArrayList;

public class ThreeColorsMaxTriangle {

    public static void main(String[] args) {
        int[][] colors = {{1,2,3,1,2},
                {2,2,3,1,2},
                {3,2,3,1,2},
                {1,2,2,1,2}
        };
        int rows = colors.length,cols = colors[0].length;
        int[][] rowWiseOccurences =  new int[3][2*rows];
        int[][] colWiseOccurences =  new int[3][2*cols];

        for(int i = 0;i<rows;i++) {
            for(int j= 0;j<colors[0].length;j++){
                int curr = colors[i][j];

                switch(curr){
                    //red
                    case 1:

                        rowWiseOccurences[0][2*i] = Math.min(j,rowWiseOccurences[0][2*i]);
                        rowWiseOccurences[0][2*i+1] = Math.max(j,rowWiseOccurences[0][2*i+1]);


                        colWiseOccurences[0][2*j] = Math.min(i,colWiseOccurences[0][2*j]);
                        colWiseOccurences[0][2*j+1] = Math.max(i,colWiseOccurences[0][2*j+1]);
                        break;
                        //green
                    case 2:


                        rowWiseOccurences[1][2*i] = Math.min(j,rowWiseOccurences[1][2*i]);
                        rowWiseOccurences[1][2*i+1] = Math.max(j,rowWiseOccurences[1][2*i+1]);


                        colWiseOccurences[1][2*j] = Math.min(i,colWiseOccurences[1][2*j]);
                        colWiseOccurences[1][2*j+1] = Math.max(i,colWiseOccurences[1][2*j+1]);
                        break;
                        //blue
                    case 3:


                        rowWiseOccurences[2][2*i] = Math.min(j,rowWiseOccurences[2][2*i]);
                        rowWiseOccurences[2][2*i+1] = Math.max(j,rowWiseOccurences[2][2*i+1]);


                        colWiseOccurences[2][2*j] = Math.min(i,colWiseOccurences[2][2*j]);
                        colWiseOccurences[2][2*j+1] = Math.max(i,colWiseOccurences[2][2*j+1]);
                        break;
                        default:
                }


            }
        }
        //fix row as base and finding max height
         int maxArea = 0;
         for(int row = 0;row<rows;row++){
             //find max base
             // r g combination
             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[0][2*row] - rowWiseOccurences[1][2*row+1]),row,colWiseOccurences,cols,2));
             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[0][2*row+1] - rowWiseOccurences[1][2*row]),row,colWiseOccurences,cols,2));

             //r b combination
             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[0][2*row] - rowWiseOccurences[2][2*row+1]),row,colWiseOccurences,cols,1));
             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[0][2*row+1] - rowWiseOccurences[2][2*row]),row,colWiseOccurences,cols,1));

             // g b combination

             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[1][2*row] - rowWiseOccurences[2][2*row+1]),row,colWiseOccurences,cols,0));
             maxArea = Math.max(maxArea,getAreaWhileRow(Math.abs(rowWiseOccurences[1][2*row+1] - rowWiseOccurences[2][2*row]),row,colWiseOccurences,cols,0));

         }

        //fix col as base and finding max height
        for(int col = 0;col<cols;col++){
            //find max base
            // r g combination
            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[0][2*col] - colWiseOccurences[1][2*col+1]),col,rowWiseOccurences,cols,2));
            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[0][2*col+1] - colWiseOccurences[1][2*col]),col,rowWiseOccurences,cols,2));

            //r b  combination
            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[0][2*col] - colWiseOccurences[2][2*col+1]),col,rowWiseOccurences,cols,1));
            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[0][2*col+1] - colWiseOccurences[2][2*col]),col,rowWiseOccurences,cols,1));

            // g b  combination

            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[1][2*col] - colWiseOccurences[2][2*col+1]),col,rowWiseOccurences,cols,0));
            maxArea = Math.max(maxArea,getAreaWhileCol(Math.abs(colWiseOccurences[1][2*col+1] - colWiseOccurences[2][2*col]),col,rowWiseOccurences,cols,0));

        }

        System.out.println(maxArea);
    }


    static int getAreaWhileRow(int baseArea,int currRow,int[][] colWiseOccurences,int cols,int toSearch){

        int maxHeight = 0;

        for(int i =0;i<cols;i++){

            if(colWiseOccurences[toSearch][2*i]  != currRow){//first occurence
                maxHeight = Math.max(maxHeight,colWiseOccurences[toSearch][2*i]);

            }

            if(colWiseOccurences[toSearch][2*i+1]  != currRow){//second occurence
                maxHeight = Math.max(maxHeight,colWiseOccurences[toSearch][2*i+1]);

            }

        }

        return 1/2*baseArea*maxHeight;

    }


    static int getAreaWhileCol(int baseArea,int currCol,int[][] rowWiseOccurences,int rows,int toSearch){

        int maxHeight = 0;

        for(int i =0;i<rows;i++){

            if(rowWiseOccurences[toSearch][2*i]  != currCol){//first occurence
                maxHeight = Math.max(maxHeight,rowWiseOccurences[toSearch][2*i]);

            }

            if(rowWiseOccurences[toSearch][2*i+1]  != currCol){//second occurence
                maxHeight = Math.max(maxHeight,rowWiseOccurences[toSearch][2*i+1]);

            }

        }
        return 1/2*baseArea*maxHeight;
    }





}

