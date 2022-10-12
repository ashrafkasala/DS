package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthsmallestinsortedmatrix {

    public static void main(String[] args) {
        kthsmallestinsortedmatrix kthsmallestinsortedmatrix = new kthsmallestinsortedmatrix();
        int[][] matrix = {{1,6,8},
                            {5,9,20},
                            {6,10,23}};
        kthsmallestinsortedmatrix.kthSmallest(matrix,6);
    }

        public int kthSmallest(int[][] matrix, int k) {

            PriorityQueue<Node> pqueue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.value - o2.value;
                }
            });


            for(int i=0;i<matrix[0].length;i++){
                pqueue.offer(new Node(0,i,matrix[0][i]));
            }

            int count  =0 ;
            Node node = null;
            while (count < k){

                 node = pqueue.poll();
                count++;
                if(node.row+1 == matrix.length)
                    continue;
                pqueue.offer(new Node(node.row+1,node.col,matrix[node.row+1][node.col]));
            }
            System.out.println(node.value);

            return node.value;
        }

        public class Node{

        int row;
        int col;
        int value;
        Node(int row,int col,int value){
            this.row =row;
            this.col = col;
            this.value = value;
        }
        }

}
