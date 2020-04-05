public class Bank {

    private int moneyAmount = 100;

    synchronized void transferMoney(int amount) throws TransferMoneyException {
        if (!hasEnoughMoney(amount)) {
            throw new TransferMoneyException();
        }
        moneyAmount = moneyAmount - amount;
    }

    boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount;
    }
}
