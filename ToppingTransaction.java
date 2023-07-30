/**
 * Topping transaction class which has attributes of each topping sold.
 */
public class ToppingTransaction
{
    private String toppingName;
    private int quantitySold;
    private int amountCollected;

    /**
     * Constructor class for ToppingTransaction.
     * @param toppingName is the topping name.
     * @param quantitySold is the quantity sold.
     * @param amountCollected is the amount collected.
     */
    public ToppingTransaction(String toppingName, int quantitySold, int amountCollected)
    {
        this.toppingName = toppingName;
        this.quantitySold = quantitySold;
        this.amountCollected = amountCollected;
    }

    /**
     * Getter for the topping name.
     * @return the topping name.
     */
    public String getToppingName()
    {
        return toppingName;
    }

    /**
     * Getter for the quantity sold.
     * @return the quantity sold.
     */
    public int getQuantitySold()
    {
        return quantitySold;
    }

    /**
     * Getter for the amount collected.
     * @return the amount collected.
     */
    public int getAmountCollected()
    {
        return amountCollected;
    }
}