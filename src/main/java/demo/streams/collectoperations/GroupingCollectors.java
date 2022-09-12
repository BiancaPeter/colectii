package demo.streams.collectoperations;


import demo.streams.helperclasses.Account;
import demo.streams.helperclasses.Employee;
import demo.streams.helperclasses.Item;
import demo.streams.helperclasses.Status;


import java.util.*;
import java.util.stream.Collectors;

public class GroupingCollectors {
    public static void main(String[] args) {

        List<Account> accounts = List.of(
                new Account(3333, "530012", Status.REMOVED),
                new Account(15000, "771843", Status.ACTIVE),
                new Account(0, "681891", Status.BLOCKED),
                new Account(2000, "681891", Status.ACTIVE)
        );
        //1. grupeaza conturile din lista dupa status (adica genereaza o mapa in care cheia este statusul, iar valoarea o lista cu toate conturile care au acel status)
//        Map<ObjectInputFilter.Status, List<Account>> accountsByStatus = accounts.stream()
//                .collect(Collectors.groupingBy(account -> account.getStatus()));
//        System.out.println(accountsByStatus);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        //2. grupeaza angajatii din lista dupa tara (adica genereaza o mapa in care cheia este tara, iar valoarea o lista cu toti angajatii din acea tara
        Map<String, List<Employee>> employeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry()));
        System.out.println(employeesByCountry);

        //3. genereaza o mapa in care cheia este tara, iar valoarea este suma salariilor angajatilor din acea tara)
        Map<String, Long> sumOfSalariesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.summingLong(employee -> employee.getSalary())));
        System.out.println(sumOfSalariesByCountry);

        //4. genereaza o mapa in care cheia este tara, iar valoarea este numarul de angajati din acea tara)
        Map<String, Long> numberOfEmployeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.counting()));
        System.out.println(numberOfEmployeesByCountry);

        List<Item> items = Arrays.asList(
                new Item("apple", 10, 9.99),
                new Item("banana", 20, 19.99),
                new Item("orange", 10, 29.99),
                new Item("watermelon", 10, 29.99),
                new Item("papaya", 20, 9.99),
                new Item("apple", 10, 9.99),
                new Item("banana", 10, 19.99),
                new Item("apple", 20, 9.99));
        //5. genereaza o mapa in care cheia este numele produsului, iar valoarea este numarul de produse cu acel nume care se afla in lista
        System.out.println();
        Map<String, Long> numbersOfProductByName = items.stream()
                .collect(Collectors.groupingBy(item -> item.getName(), Collectors.counting()));
        System.out.println("java8: " + numbersOfProductByName);
        System.out.println(getNumberOfProductByName(items));

        //6. genereaza o mapa in care cheia este numele produsului, iar valoarea cantitatea totala a produselor cu acel nume)
        System.out.println();
        Map<String, Long> quantityOfProduct = items.stream()
                .collect(Collectors.groupingBy(item -> item.getName(), Collectors.summingLong(item -> item.getQty())));
        System.out.println("jav8: " + quantityOfProduct);
        System.out.println(getQuantityOfProductsByName(items));

        //7. genereaza o mapa in care cheia este pretul produsului, iar valoarea este lista de produse cu acel pret
        //adica grupeaza produsele dupa pret
        System.out.println();
        Map<Double, List<Item>> productsByPrice = items.stream()
                .collect(Collectors.groupingBy(item -> item.getPrice()));
        System.out.println("java8: " + productsByPrice);
        System.out.println(getAllProductsByPrice(items));
    }

    //5
    public static Map<String, Integer> getNumberOfProductByName(List<Item> items) {
        Map<String, Integer> numberOfProductByName = new HashMap<>();
        for (Item item : items) {
            if (!numberOfProductByName.containsKey(item.getName())) {
                numberOfProductByName.put(item.getName(), 1);
            } else {
                numberOfProductByName.put(item.getName(), numberOfProductByName.get(item.getName()) + 1);
            }
        }
        return numberOfProductByName;
    }

    //6
    public static Map<String, Integer> getQuantityOfProductsByName(List<Item> items) {
        Map<String, Integer> quantityOfProductByName = new HashMap<>();
        for (Item item : items) {
            if (!quantityOfProductByName.containsKey(item.getName())) {
                quantityOfProductByName.put(item.getName(), item.getQty());
            } else {
                quantityOfProductByName.put(item.getName(), quantityOfProductByName.get(item.getName()) + item.getQty());
            }
        }
        return quantityOfProductByName;
    }

    //7
    public static Map<Double, List<Item>> getAllProductsByPrice(List<Item> items) {
        Map<Double, List<Item>> productsByPrice = new HashMap<>();
        for (Item item : items) {
            if (!productsByPrice.containsKey(item.getPrice())) {
                List<Item> list = new ArrayList<>();
                list.add(item);
                productsByPrice.put(item.getPrice(), list);
            } else {
                productsByPrice.get(item.getPrice()).add(item);
            }
        }
        return productsByPrice;
    }

}

