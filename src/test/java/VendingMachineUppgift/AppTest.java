package VendingMachineUppgift;

import VendingMachineUppgift.model.Beverage;
import VendingMachineUppgift.model.Candy;
import VendingMachineUppgift.model.Food;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AppTest 
{
    private IVendingMachine testObject;
    Product coke = new Beverage(15, "Coca-Cola", "139",1, "No known allergens.");
    Product snickers = new Candy(10, "Snickers chocolate bar", "488", 2,"Peanuts, may contain traces of Almonds.");
    Product chickenBLT = new Food(25, "Chicken BLT sandwich", "540", 3,"Egg, Milk, Soy and Wheat");
    Product[] test = {coke,snickers,chickenBLT};

    @Before
    public void init() {
        testObject = new UseVendingMachine(test);
    }

    @Test
    public void test_Request (){
        int testProductNumber = 3;
        Product expected = test[2];
        Product actual = testObject.request(testProductNumber);
        assertEquals(expected,actual);
    }

    @Test
    public void test_Request_To_Fail(){
        int testProductNumber = 5;
        Product actual = testObject.request(testProductNumber);
        assertEquals(null,actual);
    }

    @Test
    public void test_Add_Currency (){
        int input = 50;
        int expected = 50;
        testObject.addCurrency(input);
        int actual = testObject.getBalance();
        assertEquals(expected,actual);
}

    @Test
    public void test_End_Session (){
        testObject.addCurrency(50);
        int expected = 50;
        int actual = testObject.endSession();
        assertEquals(expected,actual);
        assertEquals(0,testObject.endSession());
    }

    @Test
    public void test_Get_Description(){
        int testProductNumber = 1;
        String expected = test[0].examine();
        String actual = testObject.getDescription(testProductNumber);
        assertEquals(expected,actual);
    }

    @Test
    public void test_Get_Despriction_To_Fail(){
        int testProductNumber = 5;
        String expected = "Product not found";
        String actual = testObject.getDescription(testProductNumber);
        assertEquals(expected,actual);
    }

    @Test
    public void test_Get_Balance(){
        int expected = 0;
        int actual = testObject.getBalance();
        assertEquals(expected,actual);
    }

    @Test
    public void test_Get_Products(){
        String[] expected = {"Coca-Cola","Snickers chocolate bar","Chicken BLT sandwich"};
        String[] actual = testObject.getProducts();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void test_Examine(){
        String expected = "-------------------PRODUCT INFO-------------------\nName: "+coke.getProductName()+"\nCalories: "+coke.getProductCalories()
                +"\nPrice: "+coke.getPrice()+"\nAllergens: "+coke.getAllergens()+"\nProduct number: "+coke.getProductNumber();
        String actual = test[0].examine();
        assertEquals(expected,actual);
    }

    @Test
    public void test_Use_Product(){
        String expected = "You drink your "+coke.getProductName()+"...";
        String actual = test[0].useProduct();
        assertEquals(expected,actual);
    }
}
