package learn.core;

import java.util.Comparator;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "Akhilesh", 5000, "Software"),
                new Employee(2, "Swapnil", 5000, "Software"),
                new Employee(3, "Mayur", 3000, "QA"),
                new Employee(4, "Shreyas", 1200, "Design")
        );

        //filter
        List<String> softwareDevs = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Software")) //Used to filter out
                .peek(e -> System.out.println("Peek operation:" + e.getName())) //Used to log
                .map(Employee::getName)
                .toList();
        System.out.println(softwareDevs);

        //reduce
        double totalSalaries = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0d, (d1, d2) -> d1 + d2); //Accumulates data by doing some operation
        System.out.println(totalSalaries);

        //sorted & map
        List<String> sortEmp = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getDepartment)) //Based on two parameters should be done with single comparator
                .map(Employee::getName) //Performs operation on each element
                .toList();
        System.out.println(sortEmp);

        //reverse sorting
        List<String> revSortEmp = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed()) //Reverses the order
                .map(Employee::getName)
                .toList();
        System.out.println(revSortEmp);

        //distinct
        List<String> departments = employeeList
                .stream()
                .map(Employee::getDepartment)
                .distinct() //Returns unique elements
                .toList();
        System.out.println(departments);

        //limit
        List<String> top2HighestPaid = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .distinct()
                .limit(2) //Limits to 2 results
                .map(Employee::getName)
                .toList();
        System.out.println(top2HighestPaid);

        List<List<Integer>> intListOfList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9));

        //flatMap
        List<Integer> intList = intListOfList.stream()
                .flatMap(innerList -> innerList.stream()) //Returns stream of the nested element
                .toList();
        System.out.println(intList);

        //sumOfInnerList
        List<Integer> sumOfInnerList = intListOfList.stream()
                .mapToInt(innerList -> innerList.stream().mapToInt(Integer::intValue).sum())
                .boxed()
                .toList();
        System.out.println(sumOfInnerList);
    }
}
