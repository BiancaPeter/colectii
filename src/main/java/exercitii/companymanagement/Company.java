package exercitii.companymanagement;

import java.util.*;

public class Company {
    List<Employee> employeeList;

    public Company(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> filterByAgeGreaterThan(int age) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getAge() > 50) {
                foundEmployees.add(employeeList.get(i));
            }
        }
        return foundEmployees;
    }

    public List<Employee> foundEmployeesByCountry(String country) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCountry().equals((country))) {
                foundEmployees.add(employeeList.get(i));
            }
        }
        return foundEmployees;
    }

    public void sortByName() {
        Collections.sort(employeeList);
    }

    public void sortByCountry() {
        employeeList.sort(new CountryComparator());
    }

    public Map<String, Integer> groupNumberOfEmployeesByCountry() {
        Map<String, Integer> numberOfEmployeesByCountry = new HashMap<>();
        String country;
        for (int i = 0; i < employeeList.size(); i++) {
            country = employeeList.get(i).getCountry();
            if (!numberOfEmployeesByCountry.containsKey(country)) {
                numberOfEmployeesByCountry.put(country, 1);
            } else {
                numberOfEmployeesByCountry.put(country, numberOfEmployeesByCountry.get(country) + 1);
            }
        }
        return numberOfEmployeesByCountry;
    }

    public Map<String, List<Employee>> groupEmployeesByCountry() {
        Map<String, List<Employee>> employeeByCountry = new HashMap<>();
        String country;
        for (int i = 0; i < employeeList.size(); i++) {
            country = employeeList.get(i).getCountry();
            if (!employeeByCountry.containsKey(country)) {
                //construiesc lista pe care vreau sa o adaug ca valoarea
                List<Employee> employees = new ArrayList<>();
                //adaug in lista angajatul
                employees.add(employeeList.get(i));
                //pun in map cheia country si lista cu primul angajat gasit in acel country
                employeeByCountry.put(country, employees);
            } else {
                //adaug in lista de angajati de la cheia country angajatul curent
                employeeByCountry.get(country).add(employeeList.get(i));
            }
        }
        return employeeByCountry;
    }
}
