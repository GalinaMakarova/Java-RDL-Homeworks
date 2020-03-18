public class Bank {

    private int moneyAmount = 100;

    public void transferMoney(int amount) throws TransferMoneyException {
        if (!hasEnoughMoney(amount)) {
            throw new TransferMoneyException();
        }
        moneyAmount = moneyAmount - amount;
    }

    public boolean hasEnoughMoney(int amount) {
        return amount <= moneyAmount;
    }
}
