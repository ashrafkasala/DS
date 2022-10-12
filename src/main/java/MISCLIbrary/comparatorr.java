package MISCLIbrary;



import MISCLIbrary.Model.Employee;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class comparatorr {


    public static void main(String[] args) throws ParseException {

        String paymentHistoryProfile = "X12CWH";
        List<String> dpdList = new ArrayList<>();
            for (int i = 0; i < paymentHistoryProfile.length(); i++) {
                dpdList.add(String.valueOf(paymentHistoryProfile.charAt(i)));
            }
            String x = String.join(",", dpdList);
        System.out.println(x);


        dateformat();

        List<Employee> employeeList = new ArrayList<>();

        for(int i=0;i<10;i++){
            Employee e = new Employee(String.valueOf(i),i+10,"name"+String.valueOf(i));
            employeeList.add(e);
        }
        employeeList.add(new Employee("4",14,"name44"));

        employeeList =  employeeList.stream().sorted(((o1, o2) -> {if (o2.getScore() != o1.getScore()) {
            return o1.getScore()-o2.getScore();
        } else {
            return o1.getName().compareTo(o2.getName());
        }
        })).collect(Collectors.toList());

        for(Employee e : employeeList){
            System.out.println(e.toString());
        }

        int[][] arr = {{1,2},{4,5},{3,121}};

        Arrays.sort(arr,((o1, o2) -> o2[0] -o1[0]));
        System.out.println(Arrays.deepToString(arr));
        System.out.println("priority queue");
        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o2.getScore() != o1.getScore()) {
                    return o2.getScore()-o1.getScore();
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

//        employeePriorityQueue.
        for(int i=10;i<20;i++){
            Employee e = new Employee(String.valueOf(i),Math.abs(new Random().nextInt()),"name"+String.valueOf(i));
            employeePriorityQueue.add(e);
        }

        Iterator iterator = employeePriorityQueue.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());

        }




    }


    public static void dateformat() throws ParseException {

        String sDate1 = "2017-1-2";

        SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
        Date date1=formatter1.parse(sDate1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date1);
        System.out.println(format);
    }
}

