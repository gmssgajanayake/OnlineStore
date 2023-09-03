import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class OnlineStore {

    private Product[] store;

    public OnlineStore() {
        store = new Product[0];
    }

    // Add some new products to store
    public void addProduct(@NotNull Product product) {
        // Before adding the product check whether the given ID is unique or not for that particular product
        if (isValidProductId(product.getId())) {
            // Error message --> The ID already has been used
            System.out.println("The given product ID is already used, Please give an unique ID for this product");
            return;
        }
        // Increase the array size by one, to store the new product
        upStoreSize();
        // Store that new product in the store array
        store[store.length - 1] = product;
    }

    // Change the quantity by using the product ID
    public void updateQuantity(int productId, int newQuantity) {
        for (Product product : store) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
                // Prints a message saying, that product quantity was successfully changed
                System.out.println(response(true));
                return;
            }
        }
        // Prints a message saying, that product is not found
        System.out.println(response(false));
    }

    // Print all products details
    public String displayInventory() {
        StringBuilder storeData = new StringBuilder();
        for (int i = 0; i < store.length; i++) {
            storeData.append("\n\t").append(i + 1).append(") ").append(store[i].displayInfo()).append("\n");
        }
        return "Our Inventory - \n" + storeData;
    }

    // Prints a product details by their name
    public String searchProductByName(String productName) {
        for (Product product : store) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product.displayInfo();
            }
        }
        return "Your searched product is not here";
    }

    // Calculate the total value of the store
    public double calculateTotalValue() {
        double total = 0.0;
        for (Product product : store) {
            total += product.getQuantity() * product.getPrice();
        }
        return total;
    }

    // Before adding the product check whether the given ID is unique or not for that particular product
    private boolean isValidProductId(int id) {
        for (Product product : store) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Contract(pure = true)
    private @NotNull String response(boolean res) {
        return res ? "Successfully" : "Try again";
    }

    // Increase the array size by one, to store the new product
    private void upStoreSize() {
        Product[] tempStore = store;
        store = new Product[tempStore.length + 1];
        System.arraycopy(tempStore, 0, store, 0, tempStore.length);
    }

}