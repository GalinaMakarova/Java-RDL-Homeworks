public class TransferMoneyException extends Exception {
    @Override
    public String getMessage() {
        return "The requested sum is NOT available.";
    }
}