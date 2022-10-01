package demo.streams.collectoperations;

import demo.streams.helperclasses.Account;
import demo.streams.helperclasses.Employee;
import demo.streams.helperclasses.Status;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingOp {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "India"));
        employeeList.add(new Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new Employee("Ryan", 53, 54000, "Libya"));
        //1. returneaza o lista cu numele tututor angajatilor din lista de angajati
        List<String> employeeNames = employeeList.stream()
//              .map(employee -> employee.getName())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeNames);

        //2. returneaza un set cu tarile tututor angajatilor din lista de angajati
        Set<String> employeeCountries = employeeList.stream()
                .map(employee -> employee.getCountry())
                .collect(Collectors.toSet());
        System.out.println(employeeCountries);
        //3. returneaza o mapa in care cheia este fiecare nume de angajat din lista, ar valoarea tara
        Map<String, String> country = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getCountry()));
        System.out.println(country);

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(3000, "3451231231", Status.ACTIVE));
        accounts.add(new Account(4000, "1233451233", Status.ACTIVE));
        accounts.add(new Account(5000, "1287429134", Status.ACTIVE));
        accounts.add(new Account(6000, "4567831246", Status.ACTIVE));
        accounts.add(new Account(7000, "3467851293", Status.ACTIVE));
        //4. returneaza o lista cu numerele de cont ale tuturor conturilor din lista de conturi
        List<String> numbersOfCount = accounts.stream()
                .map(account -> account.getNumber())
                .collect(Collectors.toList());
        System.out.println(numbersOfCount);

        //5. returneaza suma soldurilor  tuturor conturilor din lista de conturi
        Optional<Integer> sumOfBalance = accounts.stream()
                .map(account -> account.getBalance())
                .reduce((sum, balance) -> sum + balance);
        System.out.println(sumOfBalance.orElse(0));

        Integer sum = accounts.stream().collect(Collectors.summingInt(a -> a.getBalance()));
        System.out.println(sum);

        //6. returneaza o lista cu soldurile conturilor din lista de conturi
        List<Integer> balancesOfCounts = accounts.stream()
                .map(account -> account.getBalance())
                .collect(Collectors.toList());
        System.out.println(balancesOfCounts);
    }
}

