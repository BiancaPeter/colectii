package exercitii.exercisesS17.employeemanagementEx7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee("Tudor", 6000));
        employeeList1.add(new Employee("Vlad", 3500));
        employeeList1.add(new Employee("David", 9000));
        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(new Employee("Andrada", 4000));
        employeeList2.add(new Employee("Vanessa", 8000));
        employeeList2.add(new Employee("Ionut", 5000));
        List<Employee> employeeList3 = new ArrayList<>();
        employeeList3.add(new Employee("Claudiu", 11000));
        employeeList3.add(new Employee("Silvia", 3000));
        employeeList3.add(new Employee("Ciprian", 8000));
        employeeList3.add(new Employee("Carmen", 7000));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department("productie", "1", employeeList1));
        departments.add(new Department("servicii", "2", employeeList2));
        departments.add(new Department("contabilitate", "3", employeeList3));

        int minSalary = 5000;

        System.out.println("java8: " + getNumberOfEmployeesWithSalaryBiggerThen(departments, minSalary));
        System.out.println(returnNumberOfEmployeesWithSalaryBiggerThen(departments, minSalary));
    }

    public static long getNumberOfEmployeesWithSalaryBiggerThen(List<Department> departments, int minSalary) {
        return departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .filter(employee -> employee.getSalary() > minSalary)
                .count();
    }

    public static int returnNumberOfEmployeesWithSalaryBiggerThen(List<Department> departments, int minSalary) {
        int numberOfEmployeesWithSalaryBiggerThen = 0;
        for (Department department : departments) {
            for (Employee employee : department.getEmployeeList()) {
                if (employee.getSalary() > minSalary) {
                    numberOfEmployeesWithSalaryBiggerThen++;
                }
            }
        }
        return numberOfEmployeesWithSalaryBiggerThen;
    }
}
