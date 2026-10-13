package Chapter8;

/**
 * thrown when there is a high price increase on a {@code Product}
 */
public class HighPriceIncreaseException extends Exception{
    public HighPriceIncreaseException(String message) {
        super(message);
    }
}
