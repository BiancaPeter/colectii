package demo.listsetmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> productMap = new HashMap<>();
        productMap.put(1000, "notebook");
        productMap.put(2000, "phone");
        productMap.put(3000, "keyboard");
        System.out.println(productMap);
        productMap.put(1000, "mouse");
        System.out.println(productMap);

        System.out.println(productMap.get(2000));

        productMap.remove(1000);
        System.out.println(productMap);

        productMap.putIfAbsent(3000, "mouse");
        System.out.println(productMap.get(3000));

        System.out.println(productMap.keySet());

        for (Integer code : productMap.keySet()) {
            System.out.println(productMap.get(code));
        }

        for (String productName : productMap.values()) {
            System.out.println(productName);
        }

        for (Map.Entry<Integer, String> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Set<String>> synonyms = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        set1.add("mirobolant");
        set1.add("extraordinar");
        synonyms.put("frumos", set1);

        Set<String> set2 = new HashSet<>();
        set2.add("perspicace");
        set2.add("iute");
        synonyms.put("rapid", set2);

        Set<String> set3 = new HashSet<>();
        set3.add("facil");
        set3.add("lejer");
        synonyms.put("simplu", set3);

        System.out.println(synonyms);

//        String newString = "a";
//        String newKey = "simplu";
//        //adaugam in valoarea de la new Key (adica intr-un set) pe newString
//        synonyms.get(newKey).add(newString);
//        System.out.println(synonyms);

        String newString = "a";
        String newKey = "k";
        //adaugam in valoarea de la new Key (adica intr-un set) pe newString
        if (!synonyms.containsKey(newKey)) {
            Set<String> value = new HashSet<>();
            value.add(newString);
            synonyms.put(newKey, value);
        } else {
            synonyms.get(newKey).add(newString);
        }
        System.out.println(synonyms);
    }
}
