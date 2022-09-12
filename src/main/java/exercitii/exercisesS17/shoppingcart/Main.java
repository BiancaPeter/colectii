package exercitii.exercisesS17.shoppingcart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Product("iaurt", 5, Category.LACTATE);
        Product product2 = new Product("banane", 7, Category.LEGUMEFRUCTE);
        Product product3 = new Product("sunca", 5, Category.MEZELURI);
        Product product4 = new Product("lapte", 11, Category.LACTATE);
        Product product5 = new Product("portocale", 4, Category.LEGUMEFRUCTE);

        shoppingCart.addProduct(product1,2);
        shoppingCart.addProduct(product2, 3);
        shoppingCart.addProduct(product3, 5);
        shoppingCart.addProduct(product4, 1);
        shoppingCart.addProduct(product5, 7);

        System.out.println(shoppingCart);

        System.out.println("Total price of shopping cart is: " + shoppingCart.calculateTotalPriceOfShoppingCart());

        shoppingCart.deleteAProductCompletelyFromTheShoppingCart(product1);
        System.out.println(shoppingCart);

        shoppingCart.deleteANumberOfProductFromTheShoppingCart(product3,2);
        System.out.println(shoppingCart);
    }

}
