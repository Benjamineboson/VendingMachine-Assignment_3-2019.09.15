package VendingMachineUppgift;

import java.util.Scanner;

public class UseVendingMachine implements IVendingMachine {
    private int moneyPool;
    private Product[] productArray;

    public UseVendingMachine(Product[] productArray) {
        this.moneyPool = 0;
        this.productArray = productArray;
    }

    @Override
    public void addCurrency(int amount) {
    if (amount == 1 || amount == 5 || amount == 10 || amount == 20 || amount == 50 || amount == 100 || amount == 500 || amount == 1000){
        moneyPool += amount;
        System.out.println("Current balance: "+moneyPool);
        }else{
        System.out.println("Var god för in accepterad valör: [1kr] [5kr] [10kr] [20kr] [50kr] [100kr] [500kr] [1000kr]");
    }
    }

    @Override
    public Product request(int productNumber) {
        for (Product product:productArray) {
            if(productNumber == product.getProductNumber()){
                System.out.println(product.getProductName());
                moneyPool -= product.getPrice();
                return product;
            }
        }
        System.out.println("Enter a valid product number");
        return null;
    }

    @Override
    public boolean endSession() {
        return false;
    }

    @Override
    public String getDescription(int productNumber) {
        for (Product product : productArray) {
            if (productNumber == product.getProductNumber()) {
                return product.examine();
            }
        }
        return "Product not found";
    }

    @Override
    public int getBalance() {
        return moneyPool;
    }

    @Override
    public String[] getProducts() {
        String [] temp = new String[productArray.length];
        for (int i = 0; i < productArray.length ; i++) {
            temp[i] = productArray[i].getProductName()+" - Product #"+productArray[i].getProductNumber();
        }
        return temp;
    }

    public void choose(UseVendingMachine user){
        Scanner scan = new Scanner(System.in);
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("-------------------WELCOME-------------------\nCurrent balance: "+moneyPool+
                    "\nTo make a purchase press                  (1)" +
                    "\nTo add currency press                     (2)" +
                    "\nTo get the description of a product press (3)" +
                    "\nTo get list of products press             (4)" +
                    "\nTo end session press                      (5)" +
                    "\n-------------------WELCOME-------------------");
            int choice = scan.nextInt();
            if (choice == 1)
            {
                System.out.println("\nCoca-Cola 33cl - [15kr] - #1" +
                                   "\nSnickers 100g  - [10kr] - #2" +
                                   "\nChicken BLT    - [25kr] - #3" +
                                   "\n------------------------------");
                System.out.println("Enter the product #: ");
                int productChoice = scan.nextInt();
                if (moneyPool < productArray[productChoice-1].getPrice()){
                    System.out.println("Insufficient funds");
                }else {
                    System.out.print("Thank you for your purchase: ");
                    request(productChoice);
                    System.out.println("\nRemaining balance: " + getBalance());
                    System.out.println("\nTo shop again press any key, to eat/drink your product press 2: ");
                    int eatOrNot = scan.nextInt();
                    if (eatOrNot == 2) System.out.println(productArray[productChoice - 1].useProduct());
                }
            }
            else if (choice == 2)
            {
                System.out.println("Enter amount you want to add\nAcceptable currencies: [1kr] [5kr] [10kr] [20kr] [50kr] [100kr] [500kr] [1000kr]");
                int currency = scan.nextInt();
                user.addCurrency(currency);
            }
            else if (choice == 3)
            {
                System.out.println("\nCoca-Cola 33cl - [15kr] - #1" +
                        "\nSnickers 100g  - [10kr] - #2" +
                        "\nChicken BLT    - [25kr] - #3" +
                        "\n------------------------------");
                System.out.println("Enter the product #: ");
                int productChoice = scan.nextInt();
                System.out.println(getDescription(productChoice));
            }else if (choice == 4){
                System.out.println("List of available products:");
                for (String print:getProducts()){
                    System.out.println(print);
                }

            }
            else if (choice == 5){
                System.out.println("Thank you for your purchase, your change is: "+user.getBalance());
                isAlive = user.endSession();
                }
            }
        }
    }


