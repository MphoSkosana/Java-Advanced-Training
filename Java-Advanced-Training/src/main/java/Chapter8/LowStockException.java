package Chapter8;

/**
 * thrown when a {@code, Product} has a low quantity in stock
 */
public class LowStockException extends Exception{
    public LowStockException(String message) {
        super(message);
    }
}
