public class OnlineStore{

	private Product[] store;
	
	public OnlineStore(){
		store=new Product[0];
	}

	// Add some new products to store
	public void addProduct(Product product){
		// Before adding the product check whether the given ID is unique or not for that particular product
		if(isValidProductId(product.getId())){
			// Error message --> The ID already has been used
			System.out.println("The given product ID is already used, Please give an unique ID for this product");
			return;
		}
		// Increase the array size by one, to store the new product
		upStoreSize();
		// Store that new product in the store array
		store[store.length-1]=product;
	}

	// Change the quantity by using the product ID
	public void updateQuantity(int productId,int newQuantity){
		for(int i=0;i<store.length;i++){
			if(store[i].getId()==productId){
				store[i].setQuantity(newQuantity);
				// Prints a message saying, that product quantity was successfully changed
				System.out.println(response(true));
				return;
			}
		}
		// Prints a message saying, that product is not found
		System.out.println(response(false));
	}

	// Print all products details
	public String displayInventory(){
		String storeData="";
		for(int i=0;i<store.length;i++){
			storeData+="\n\t"+(i+1)+") "+store[i].displayInfo()+"\n";
		}
		return "Our Inventory - \n"+storeData;
	}

	// Prints a product details by their name
	public String searchProductByName(String productName){
		for(int i=0;i<store.length;i++){
			if(store[i].getName().equalsIgnoreCase(productName)){
				return store[i].displayInfo();
			}
		}
		return "Your searched product is not here";
	}

	// Calculate the total value of the store
	public double calculateTotalValue(){
		double total=0.0;
		for(int i=0;i<store.length;i++){
			total+=store[i].getQuantity()*store[i].getPrice();
		}
		return total;
	}

	// Before adding the product check whether the given ID is unique or not for that particular product
	private boolean isValidProductId(int id) {
		for(int i=0;i<store.length;i++){
			if(store[i].getId()==id){
				return true;
			}
		}
		return false;
	}
	
	private String response(boolean res){
		return res ? "Successfully" : "Try again";
	}

	// Increase the array size by one, to store the new product
	private void upStoreSize(){
		Product[] tempStore=store;
		store=new Product[tempStore.length+1];
		for(int i=0;i<tempStore.length;i++){
			store[i]=tempStore[i];
		}
	}

}