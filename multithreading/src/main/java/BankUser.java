import java.util.Random;

public class BankUser extends Thread {

    public static int currentId = 1;
    public static int allMoney = 0;
    public int id;
    public Bank bank;

    public BankUser(Bank bank) {
        this.id = currentId;
        this.bank = bank;
        currentId++;
    }

    public void withdraw(int amount) throws TransferMoneyException {
        if (bank.hasEnoughMoney(amount)) {
            bank.transferMoney(amount);
            allMoney = allMoney + amount;
        } else {
            throw new TransferMoneyException();
        }
    }

    @Override
    public void run() {
        while (bank.hasEnoughMoney(0)) {
            try {
                Thread.sleep(new Random().nextInt(200));
                int amount = 1;
                withdraw(amount);
                System.out.println("BankUser#" + id + " takes " + amount + ". All money: " + allMoney);
            } catch (TransferMoneyException | InterruptedException e) {
                System.out.println(e.getMessage());
                System.out.println("Total amount: " + allMoney);
                break;
            }
        }
    }

    public static void startTransfer(Bank bank) {
        int count = new Random().nextInt(8) + 2;
        for (int i = 0; i < count; i++) {
            new BankUser(bank).start();
        }
    }
}
