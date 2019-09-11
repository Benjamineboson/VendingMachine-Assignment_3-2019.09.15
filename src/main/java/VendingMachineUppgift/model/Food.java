package VendingMachineUppgift.model;

import VendingMachineUppgift.Product;

public class Food extends Product {

    public Food(int price, String productName, String productCalories, int productNumber, String allergens) {
        super(price, productName, productCalories, productNumber, allergens);
    }

    @Override
    public String examine(){
        return "-------------------PRODUCT INFO-------------------\nName: "+getProductName()+"\nCalories: "+getProductCalories()
                +"\nPrice: "+getPrice()+"\nAllergens: "+getAllergens()+"\nProduct number: "+getProductNumber();
    }

    //Test This
    @Override
    public String useProduct(){
    return "You eat your "+getProductName()+"...";
    }
}
