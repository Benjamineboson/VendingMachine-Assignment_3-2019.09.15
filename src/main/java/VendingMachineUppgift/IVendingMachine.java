package VendingMachineUppgift;

public interface IVendingMachine {
    void addCurrency(int amount);
    Product request(int productNumber);
    int endSession();
    String getDescription(int productNumber);
    int getBalance();
    String[] getProducts();
}
