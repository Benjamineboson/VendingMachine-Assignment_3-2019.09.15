package VendingMachineUppgift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import VendingMachineUppgift.model.Beverage;
import VendingMachineUppgift.model.Candy;
import VendingMachineUppgift.model.Food;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{

    private IVendingMachine testObject;
    Product[] test = new Product[3];
    Product coke = new Beverage(15, "Coca-Cola", "139",1, "No known allergens.");
    Product snickers = new Candy(10, "Snickers chocolate bar", "488", 2,"Peanuts, may contain traces of Almonds.");
    Product chickenBLT = new Food(25, "Chicken BLT sandwich", "540", 3,"Egg, Milk, Soy and Wheat");
    @Before
    public void init() {
        testObject = new UseVendingMachine(test);
        test[0] = coke;
        test[1] = snickers;
        test[2] = chickenBLT;

    }

    @Test
    public void testRequest (){
        int testProductNumber = 1;
        Product expected = test[0];
        testObject.request(testProductNumber);
        Product actual = coke;
        assertEquals(expected,actual);
    }

    @Test
    public void testAddCurrency (){
    int input = 50;
    int expected = 50;
    testObject.addCurrency(input);

    int actual = testObject.getBalance();
    Assert.assertEquals(expected,actual);
}

}
