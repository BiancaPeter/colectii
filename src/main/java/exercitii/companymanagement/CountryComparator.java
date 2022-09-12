package exercitii.companymanagement;

import java.util.Comparator;

public class CountryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCountry().compareTo(o2.getCountry());
    }
}
