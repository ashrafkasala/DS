package MISC;


import java.util.*;

public class ThreeColorsMaxAreaTraingle2 {

    public static void main(String[] args) {
        char[][] colors = {{'R', 'B', 'G', 'R', 'B'},
                {'R', 'B', 'G', 'R', 'B'},
                {'R', 'B', 'G', 'R', 'B'},
                {'R', 'B', 'G', 'R', 'B'}
        };
        int rows = colors.length, cols = colors[0].length;
        HashMap<Character, Map<Integer, List<Integer>>> rowMap = new HashMap<>();
        HashMap<Character, Map<Integer, List<Integer>>> colMap = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colors[0].length; j++) {

                char color = colors[i][j];

                if (rowMap.containsKey(color)) {

                    if (rowMap.get(color).containsKey(i)) {
                        if (rowMap.get(color).get(i).size() == 1) {
                            rowMap.get(color).get(i).add(j);
                        } else if (rowMap.get(color).get(i).size() == 2) {
                            rowMap.get(color).get(i).remove(1);
                            rowMap.get(color).get(i).add(j);
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        rowMap.get(color).put(i, list);
                    }

                } else {
                    rowMap.put(color, new HashMap<Integer, List<Integer>>());
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    rowMap.get(color).put(i, list);
                }

                if (colMap.containsKey(color)) {

                    if (colMap.get(color).containsKey(j)) {
                        if (colMap.get(color).get(j).size() == 1) {
                            colMap.get(color).get(j).add(i);
                        } else if (colMap.get(color).get(j).size() == 2) {
                            colMap.get(color).get(j).remove(1);
                            colMap.get(color).get(j).add(i);
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        colMap.get(color).put(j, list);
                    }

                } else {
                    colMap.put(color, new HashMap<Integer, List<Integer>>());
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    colMap.get(color).put(j, list);
                }


            }
        }
        //fix row as base and finding max height
        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            Queue<Integer> queue = new LinkedList<>();
            for (char color : rowMap.keySet()) {
                if(rowMap.get(color).get(row) != null) {
                    for (int index : rowMap.get(color).get(row)) {
                        int queSize = queue.size();
                        for (int i = 0; i < queSize; i++) {
                            maxArea = Math.max(maxArea, getAreaWhileBaseRow(color, colMap, row, Math.abs(index - ((LinkedList<Integer>) queue).get(i))));
                        }
                        ((LinkedList<Integer>) queue).push(index);
                    }
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            Queue<Integer> queue = new LinkedList<>();
            for (char color : colMap.keySet()) {
                if(colMap.get(color).get(col) != null) {
                    for (int index : colMap.get(color).get(col)) {
                        int queSize = queue.size();
                        for (int i = 0; i < queSize; i++) {
                            maxArea = Math.max(maxArea, getAreaWhileBaseCol(color, rowMap, col, Math.abs(index - ((LinkedList<Integer>) queue).get(i))));
                        }
                        ((LinkedList<Integer>) queue).push(index);
                    }
                }
            }
        }

        System.out.println(maxArea);

    }





    static int getAreaWhileBaseRow(char toSearch, HashMap<Character, Map<Integer, List<Integer>>> colMap, int currRow,int baseArea) {

        int maxHeight = 0;
        Map<Integer, List<Integer>> colorMap = colMap.get(toSearch);

        for (int key : colorMap.keySet()) {
            for (int i = 0; i < colorMap.get(key).size(); i++) {
                maxHeight = Math.max(maxHeight, Math.abs(colorMap.get(key).get(i) - currRow));
            }
        }
        return 1/2*maxHeight*baseArea;
    }

    static int getAreaWhileBaseCol(char toSearch, HashMap<Character, Map<Integer, List<Integer>>> rowMap, int currCol,int baseArea) {

        int maxHeight = 0;
        Map<Integer, List<Integer>> colorMap = rowMap.get(toSearch);

        for (int key : colorMap.keySet()) {
            for (int i = 0; i < colorMap.get(key).size(); i++) {
                maxHeight = Math.max(maxHeight, Math.abs(colorMap.get(key).get(i) - currCol));
            }
        }
        return 1/2*maxHeight*baseArea;
    }



}

