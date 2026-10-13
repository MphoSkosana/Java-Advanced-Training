package Chapter8;

public class Product {

    private String code, description;
    private double price;
    private int qtyInStock;

    public Product(int qtyInStock, String code, String description, double price) {
        setQtyInStock(qtyInStock);
        setCode(code);
        setDescription(description);
        setPrice(price);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    /**
     * set the description of the product
     * @param description product description
     * @throws IllegalArgumentException when a product description is less than 5 characters long
     */
    public void setDescription(String description) throws IllegalArgumentException{
        if (description.length() < 5){
            throw new IllegalArgumentException("Description should be at least 5 characters long." +
                     "\nCurrent description: [" + description + "]");
        }
        this.description = description;
    }

    /**
     * sells the product by subtracting the requested quantity from the current quantity in stock
     * @param qtyToSell requested quantity to sell
     * @throws LowStockException when the requested quantity is more than the available quantity in stock
     */
    public void sell(int qtyToSell) throws LowStockException {
        if (qtyInStock <= qtyToSell){
            throw new LowStockException("Not enough quantity to sell." +
                    "\nCurrent Quantity In Stock: [" + qtyInStock + "]" +
                    "\nRequested Quantity to sell: [" + qtyToSell + "]");
        }
        this.qtyInStock -= qtyToSell;
    }

    /**
     * increase the product price by a percentage
     * @param percentage percentage to increase the price by
     * @throws HighPriceIncreaseException when the price increase is more than or equal to 10
     */
    public void increasePrice(double percentage) throws HighPriceIncreaseException{
        double increase = this.price * (percentage / 100);

        if(increase >= 10){
            throw new HighPriceIncreaseException("The price increase on " + getDescription() +
                    " is too high [" + increase + "]\nIncrease should be less than 10.00");
        }
        this.price += increase;
    }

    @Override
    public String toString() {
        return String.format("""
                ============= Product Details For %s [%s]
                Code            :   %s
                Description     :   %s
                Price           :   %.2f
                Qty In Stock    :   %d""", getDescription(), getCode(), getCode(), getDescription(), getPrice(), getQtyInStock());
    }
}
