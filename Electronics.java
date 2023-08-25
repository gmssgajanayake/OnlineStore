public class Electronics extends Product {
    private String brand;

    public Electronics(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n\tBrand : " + brand;
    }

}