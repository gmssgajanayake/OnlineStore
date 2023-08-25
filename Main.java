public class Main{
	public static void main(String[] args){
		Product p1=new Electronics(1,"TV",3000.0,7,"Sony");
		Product p2=new Clothing(2,"t-Shirt",54.0,32,"XL");
		Product p3=new Books(3,"HTML",20.0,23,"Edex");
		Product p4=new Books(3,"HTML",20.0,23,"Edex");

		OnlineStore st=new OnlineStore();
		
		st.addProduct(p1);
		st.addProduct(p4);/*This product cannot be saved in the array,
		because the product id that has been used for this product, was already used,
		therefor, it should be shown a message saying enter a new unique ID for this product*/
		st.addProduct(p2);
		st.addProduct(p3);

		System.out.println();
		System.out.println(st.displayInventory());
		System.out.println();
		System.out.println("Total price - $ "+st.calculateTotalValue());
		System.out.println();
		System.out.println(st.searchProductByName("t-Shirt"));

		st.updateQuantity(p1.getId(),20);

		System.out.println();
		System.out.println(st.displayInventory());
		System.out.println();
		System.out.println("Total price - $ "+st.calculateTotalValue());
		
	}
}