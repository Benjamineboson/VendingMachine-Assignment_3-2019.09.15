package VendingMachineUppgift;

public interface IVendingMachine {
    void addCurrency(int amount);
    Product request(int productNumber);
    boolean endSession();
    String getDescription(int productNumber);
    int getBalance();
    String[] getProducts();
}
