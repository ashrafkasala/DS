package array;


/*
*
*
* Find first and last positions of an element in a sorted array
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Examples:

Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5

Input : arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125 }
        x = 7
Output : First Occurrence = 6
         Last Occurrence = 6
* */
public class first_last_positions_of_an_element_in_asorted_array {
    public static void main(String[] args) {
        first_last_positions_of_an_element_in_asorted_array obj = new first_last_positions_of_an_element_in_asorted_array();
        int[] ip = {1, 3, 5, 5, 5, 5, 7, 123, 125 };
        int t = 7;
        obj.find(ip,t);
    }
    void find(int[] ip,int tar){
        int low = 0;
        int high = ip.length-1;
        System.out.println("first index :"+first(ip, low,high,tar));
        System.out.println("Second index :"+second(ip, low,high,tar));


    }
    int first(int[] ip, int low,int high, int tar){

        int mid = (low+high)/2;

        if((mid ==0 || tar > ip[mid-1]) && ip[mid] == tar){
            return  mid;
        }
        else if(tar > ip[mid]){
           return first(ip,mid+1,high,tar);
        } else {
            return first(ip,low,mid-1,tar);
        }

    }

    int second(int[] ip, int low,int high, int tar){

        int mid = (low+high)/2;

        if((mid ==high || tar < ip[mid+1]) && ip[mid] == tar){
            return  mid;
        }
        else if(tar < ip[mid]){
            return second(ip,low,mid-1,tar);
        } else {
            return second(ip,mid+1,high,tar);
        }

    }

}
