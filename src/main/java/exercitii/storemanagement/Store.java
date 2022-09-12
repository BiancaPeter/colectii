package exercitii.storemanagement;

import java.util.*;

public class Store {
    private Map<Category, List<Product>> productsByCategory;

    public Store() {
        this.productsByCategory = new HashMap<>();
    }

    public Map<Category, List<Product>> getProductsByCategory() {
        return productsByCategory;
    }

    public void setProductsByCategory(Map<Category, List<Product>> productsByCategory) {
        this.productsByCategory = productsByCategory;
    }

    public void addProduct(Product product) {
        if (!productsByCategory.containsKey(product.getCategory())) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            productsByCategory.put(product.getCategory(), products);
        } else {
            productsByCategory.get(product.getCategory()).add(product);
        }
    }

    public List<Product> getProductByCategory(Category category) {
        return productsByCategory.get(category);
    }

    public Set<Category> getAllCategories() {
        return productsByCategory.keySet();
    }

//    Varianta - in care primim numele produsului
//    public void deleteProduct(String nameProduct) {
//        for (List<Product> products : productsByCategory.values()) {
//            for (int i = 0; i < products.size(); i++) {
//                if (products.get(i).getName().equals(nameProduct)) {
//                    products.remove(products.get(i));
//                }
//            }
//        }
//    }

    public void deleteProduct(Product product) {
        productsByCategory.get(product.getCategory()).remove(product);
    }

    @Override
    public String toString() {
        return "Store{" +
                "productsByCategory=" + productsByCategory +
                '}';
    }
}
