public class Books extends Product {
    private String author;

    public Books(int id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n\tAuthor : " + author;
    }

}