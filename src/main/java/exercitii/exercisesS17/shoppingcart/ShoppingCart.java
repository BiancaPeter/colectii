package exercitii.exercisesS17.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new HashMap<>();
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<Product, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCart=" + shoppingCart +
                '}';
    }

    public void addProduct(Product newProduct, Integer numberOfNewProducts) {
        if (shoppingCart.containsKey(newProduct)) {
            shoppingCart.put(newProduct, shoppingCart.get(newProduct) + numberOfNewProducts);
        } else {
            shoppingCart.put(newProduct, numberOfNewProducts);
        }
    }

    public Integer calculateTotalPriceOfShoppingCart() {
        Integer totalPriceOfShoppingCart = 0;
        for (Product product : shoppingCart.keySet()) {
            totalPriceOfShoppingCart += product.getPrice() * shoppingCart.get(product);
        }
        return totalPriceOfShoppingCart;
    }

    public void deleteAProductCompletelyFromTheShoppingCart(Product product) {
        shoppingCart.remove(product);
    }

    public void deleteANumberOfProductFromTheShoppingCart(Product product, Integer numberOfProductsToDelete) {
        shoppingCart.put(product, shoppingCart.get(product) - numberOfProductsToDelete);
    }
}
