package MISCLIbrary;



import MISCLIbrary.Model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class comparatorr {


    public static void main(String[] args) {

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

        for(int i=10;i<20;i++){
            Employee e = new Employee(String.valueOf(i),i+10,"name"+String.valueOf(i));
            employeePriorityQueue.add(e);
        }

        Iterator iterator = employeePriorityQueue.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());

        }




    }
}

