package exercitii.companymanagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Korea", "Kim", 51));
        employeeList.add(new Employee("India", "Ariel", 36));
        employeeList.add(new Employee("Liban", "Fatima", 28));
        employeeList.add(new Employee("Palestina", "Abdul", 45));
        employeeList.add(new Employee("Romania", "Olimpiu", 25));
        employeeList.add(new Employee("Romania", "Raluca", 50));

        Company company = new Company(employeeList);

        System.out.println(company.filterByAgeGreaterThan(50));
        System.out.println(company.foundEmployeesByCountry("Romania"));
        company.sortByName();
        System.out.println(company.getEmployeeList());

        company.sortByCountry();
        System.out.println(company.getEmployeeList());

        System.out.println(company.groupNumberOfEmployeesByCountry());

        System.out.println(company.groupEmployeesByCountry());
    }
}
