package demo.streams;

import demo.streams.helperclasses.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReductionOp {
    public static void main(String[] args) {
        List<Integer> transactions = List.of(20, 40, -60, 5);
        //1. printeaza maximul din lista de numere
        Optional<Integer> optionalMax = findMaxOfTransactions(transactions);
        System.out.println("java8: " + optionalMax.orElse(0));
        //    ---VARIANTA CLASICA---
        Integer max = getMaxOfTransactions(transactions);
        System.out.println(max);
        System.out.println();

        //2. printeaza suma numerelor din lista
        Optional<Integer> optionalSum = findSumOfNumbers(transactions);
//        if (optionalSum.isPresent()){
//            System.out.println(optionalSum.get());
//        }
        System.out.println("java8: " + optionalSum.orElse(0));
        //    ---VARIANTA CLASICA---
        Integer sum = getSumOfNumbers(transactions);
        System.out.println(sum);
        System.out.println();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "India"));
        employeeList.add(new Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new Employee("Ryan", 53, 54000, "Libya"));
        //3. printeaza suma salariilor angajatilor din lista
        //-1.streem din lista de angajati
        //-2.mapam lista de angajati la lista de salarii
        //-3.folosim reduce pentru a calcula suma salarilor
        System.out.println("java8: " + findSumOfSalary(employeeList).orElse(0));
        //    ---VARIANTA CLASICA---
        System.out.println(getSumOfSalary(employeeList));
    }

    //ex1
    public static Optional<Integer> findMaxOfTransactions(List<Integer> transactions) {
        return transactions.stream()
                .max((number1, number2) -> number1.compareTo(number2));
    }

    //    ---VARIANTA CLASICA---
    public static Integer getMaxOfTransactions(List<Integer> transactions) {
        Integer max = transactions.get(0);
        for (int i = 1; i < transactions.size(); i++) {
            if (transactions.get(i) > max) {
                max = transactions.get(i);
            }
        }
        return max;
    }

    //ex2
    public static Optional<Integer> findSumOfNumbers(List<Integer> transactions) {
        return transactions.stream()
                .reduce((sum, transaction) -> sum + transaction);
    }

    //    ---VARIANTA CLASICA---
    public static Integer getSumOfNumbers(List<Integer> transactions) {
        Integer sum = 0;
        for (Integer number : transactions) {
            sum += number;
        }
        return sum;
    }

    //ex3
    public static Optional<Integer> findSumOfSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce((sum, salary) -> sum + salary);
    }

    //    ---VARIANTA CLASICA---
    public static Integer getSumOfSalary(List<Employee> employeeList) {
        Integer sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getSalary();
        }
        return sum;
    }
}
