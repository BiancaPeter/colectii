package exercitii.storemanagement;

public class MainProduct {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Product("lapte",7,Category.LACTATE));
        store.addProduct(new Product("iaurt",5,Category.LACTATE));
        store.addProduct(new Product("mere",6,Category.LEGUMEFRUCTE));

        System.out.println(store.getProductsByCategory());

        System.out.println(store.getProductByCategory(Category.LACTATE));

        System.out.println(store.getAllCategories());

//      store.deleteProduct("lapte");
        store.deleteProduct(store.getProductsByCategory().get(Category.LACTATE).get(0));
        System.out.println(store.getProductsByCategory());
    }
}
