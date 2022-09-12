package exercitii.stockmarketanalysis;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private Map<String, Integer> pricesByCompany;

    public StockMarket() {
        this.pricesByCompany = new HashMap<>();
    }

    public void addStockEntry(String company, Integer sharePrice) {
        pricesByCompany.put(company, sharePrice);
    }

    public Map<String, Integer> getPricesByCompany() {
        return pricesByCompany;
    }

    public void setPricesByCompany(Map<String, Integer> pricesByCompany) {
        this.pricesByCompany = pricesByCompany;
    }

    public String getMostExpensiveCompany() {
        int maxPrice = 0;
        String companyName = "";

        //var.1 parcurgerea mapei
//        for (Map.Entry<String, Integer> entry : priceByCompany.entrySet()) {
//            if (maxPrice < entry.getValue()) {
//                maxPrice = entry.getValue();
//                companyName = entry.getKey();
//            }
//        }

        //var.2 parcurgerea cheii din mapa
        for (String company : pricesByCompany.keySet()) {
            if (maxPrice < pricesByCompany.get(company)) {
                maxPrice = pricesByCompany.get(company);
                companyName = company;
            }
        }
        return companyName;
    }

    public double getAverageSharePrice() {
        double sum = 0;
        for (Integer price : pricesByCompany.values()) {
            sum += price;
        }
        return sum / pricesByCompany.size();
    }
}
