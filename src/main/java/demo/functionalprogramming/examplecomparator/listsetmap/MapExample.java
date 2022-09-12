package demo.functionalprogramming.examplecomparator.listsetmap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> productsMap = new HashMap<>();

        productsMap.put(1000, "Notebook");
        productsMap.put(2000, "Phone");
        productsMap.put(3000, "Keyboard");

        System.out.println(productsMap);

        System.out.println(productsMap.get(1000));

        productsMap.remove(1000);

        System.out.println(productsMap.get(1000));

        productsMap.putIfAbsent(3000, "Mouse");

        System.out.println(productsMap.get(3000));

        System.out.println(productsMap.containsKey(3000));


        for (Integer productCode : productsMap.keySet()) {
            System.out.println(productsMap.get(productCode));
        }

        for (String productName : productsMap.values()) {
            System.out.println(productName);
        }

        for (Map.Entry<Integer, String> set: productsMap.entrySet()){
            System.out.println(set.getKey() + " " + set.getValue());
        }

        Map<String, Set<String>> synonyms = new HashMap<>();

        Set<String> set1 = new HashSet<>();
        set1.add("mirobolant");
        Set<String> set2 = new HashSet<>();
        set2.add("perspicace");
        set2.add("iute");
        Set<String> set3 = new HashSet<>();
        set3.add("facil");
        set3.add("lejer");
        synonyms.put("frumos", set1);
        synonyms.put("rapid", set2);
        synonyms.put("simplu", set3);

        System.out.println(synonyms);

//        String newString = "a";
//        String newKey = "simplu";
//        //adaugam in valoarea de la new Key (adica intr-un set) pe newString
//        synonyms.get(newKey).add(newString);
//        System.out.println(synonyms);

        String newString = "s";
        String key = "k";

        //adaugam in valoarea de la cheia newKey (adica intr-un set) pe newString
        if (!synonyms.containsKey(key)) {
            Set<String> value = new HashSet<>();
            value.add(newString);
            synonyms.put(key, value);
        } else {
            synonyms.get(key).add(newString);
        }
        System.out.println(synonyms);


        //crearea unei mape imutabile
        Map<Integer, String> immutableMap = Map.of(2000,"Keyboard",3000,"Mouse");
        System.out.println(immutableMap);
        //nu putem modifica map-uri imutabile. Se va genera UnsupportedOperationException
        //immutableMap.add(4000,"Display");
    }
}
