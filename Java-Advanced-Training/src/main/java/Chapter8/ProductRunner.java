package Chapter8;

public class ProductRunner {
    static void main() {


        try {
            Product p = new Product(5, "code123", "microwave", 500);

            p.increasePrice(1);
            p.sell(4);
            System.out.println(p);
        } catch (IllegalArgumentException | HighPriceIncreaseException | LowStockException e) {
            System.err.println(e.getMessage());
        }

    }
}
