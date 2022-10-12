package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class courseschedule2 {

    public static void main(String[] args) {
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = {{1,0}};

        System.out.println(Arrays.toString(findOrder(3,prerequisites)));
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        ArrayList<Integer> tempList = new ArrayList<>();
        //initialize adj map
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        //populate the map
        for(int[] prerequisite : prerequisites){
            int first = prerequisite[1];
            int second = prerequisite[0];
            adj.get(first).add(second);
            inDegree[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //find root
        for(int i =0;i< numCourses;i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        int resIndex = 0;
        int courseCount = 0;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            res[resIndex++] = temp;
            tempList = adj.get(temp);
            courseCount++;
            for(int course : tempList){

                inDegree[course]--;
                if(inDegree[course] == 0){
                    queue.offer(course);
                }
            }

        }

        if(courseCount == numCourses)
            return  res;
        else {
            int[] ints = new int[1];
            return ints;
        }

    }
}
