package exercitii.stockmarketanalysis;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        stockMarket.addStockEntry("google",200);
        stockMarket.addStockEntry("tesla",300);
        stockMarket.addStockEntry("microsoft",450);
        stockMarket.addStockEntry("yahoo",700);

        System.out.println(stockMarket.getMostExpensiveCompany());

        System.out.println(stockMarket.getAverageSharePrice());
    }
}
