package VendingMachineUppgift;

public abstract class Product {
    private int price;
    private String productName;
    private String productCalories;
    private int productNumber;
    private String allergens;

    public Product(int price, String productName, String productCalories, int productNumber, String allergens) {
        this.price = price;
        this.productName = productName;
        this.productCalories = productCalories;
        this.productNumber = productNumber;
        this.allergens = allergens;
    }



    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCalories() {
        return productCalories;
    }

    public String getAllergens() {
        return allergens;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public abstract String useProduct();

    public abstract String examine();
}