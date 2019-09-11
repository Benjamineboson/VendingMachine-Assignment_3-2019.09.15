package VendingMachineUppgift;



public class UseVendingMachine implements IVendingMachine {
    private int moneyPool;
    private Product[] productArray;
    private int[] acceptableCurrency = {1,5,10,20,50,100,500,1000};


    public UseVendingMachine(Product[] productArray) {
        this.moneyPool = 0;
        this.productArray = productArray;
    }

    public Product[] getProductArray() {
        return productArray;
    }

    // TESTED
    @Override
    public void addCurrency(int amount) {
    if (amount == acceptableCurrency[0]
            || amount == acceptableCurrency[1]
            || amount == acceptableCurrency[2]
            || amount == acceptableCurrency[3]
            || amount == acceptableCurrency[4]
            || amount == acceptableCurrency[5]
            || amount == acceptableCurrency[6]
            || amount == acceptableCurrency[7]){
        moneyPool += amount;
        }else{
        System.out.println("Enter a valid currency: [1kr] [5kr] [10kr] [20kr] [50kr] [100kr] [500kr] [1000kr]");
    }
    }

    // TESTED & TESTED TO FAIL
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

    //TESTED
    @Override
    public boolean endSession() {
        return false;
    }

    //TESTED & TESTED TO FAIL
    @Override
    public String getDescription(int productNumber) {
        for (Product product : productArray) {
            if (productNumber == product.getProductNumber()) {
                return product.examine();
            }
        }
        return "Product not found";
    }

    //TESTED
    @Override
    public int getBalance() {
        return moneyPool;
    }

    //TESTED
    @Override
    public String[] getProducts() {
        String [] temp = new String[productArray.length];
        for (int i = 0; i < productArray.length ; i++) {
            temp[i] = productArray[i].getProductName();    //+" - Product #"+productArray[i].getProductNumber();
        }
        return temp;
    }

    /** VIKTIG KOD FÖR KONSOLLBASERAT SPEL
     *
     */


//    public void choose(UseVendingMachine user){
//        Scanner scan = new Scanner(System.in);
//        boolean isAlive = true;
//        while (isAlive) {
//            System.out.println("-------------------WELCOME-------------------\nCurrent balance: "+moneyPool+
//                    "\nTo make a purchase press                  (1)" +
//                    "\nTo add currency press                     (2)" +
//                    "\nTo get the description of a product press (3)" +
//                    "\nTo get list of products press             (4)" +
//                    "\nTo end session press                      (5)" +
//                    "\n-------------------WELCOME-------------------");
//            int choice = scan.nextInt();
//            if (choice == 1)
//            {
//                System.out.println("\nCoca-Cola 33cl - [15kr] - #1" +
//                                   "\nSnickers 100g  - [10kr] - #2" +
//                                   "\nChicken BLT    - [25kr] - #3" +
//                                   "\n------------------------------");
//                System.out.println("Enter the product #: ");
//                int productChoice = scan.nextInt();
//                if (moneyPool < productArray[productChoice-1].getPrice()){
//                    System.out.println("Insufficient funds");
//                }else {
//                    System.out.print("Thank you for your purchase: ");
//                    request(productChoice);
//                    System.out.println("\nRemaining balance: " + getBalance());
//                    System.out.println("\nTo shop again press any key, to eat/drink your product press 2: ");
//                    int eatOrNot = scan.nextInt();
//                    if (eatOrNot == 2) System.out.println(productArray[productChoice - 1].useProduct());
//                }
//            }
//            else if (choice == 2)
//            {
//                System.out.println("Enter amount you want to add\nAcceptable currencies: [1kr] [5kr] [10kr] [20kr] [50kr] [100kr] [500kr] [1000kr]");
//                int currency = scan.nextInt();
//                user.addCurrency(currency);
//            }
//            else if (choice == 3)
//            {
//                System.out.println("\nCoca-Cola 33cl - [15kr] - #1" +
//                        "\nSnickers 100g  - [10kr] - #2" +
//                        "\nChicken BLT    - [25kr] - #3" +
//                        "\n------------------------------");
//                System.out.println("Enter the product #: ");
//                int productChoice = scan.nextInt();
//                System.out.println(getDescription(productChoice));
//            }else if (choice == 4){
//                System.out.println("List of available products:");
//                for (String print:getProducts()){
//                    System.out.println(print);
//                }
//
//            }
//            else if (choice == 5){
//                System.out.println("Thank you for your purchase, your change is: "+user.getBalance());
//                isAlive = user.endSession();
//                }
//            }
//        }
    }


