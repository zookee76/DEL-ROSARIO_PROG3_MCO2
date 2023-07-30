/**
 * Transaction class which has attributes of each transaction.
 */
public class Transaction
{
    private String itemName;
    private int quantitySold;
    private int amountCollected;

    /**
     * Constructor of Transaction class.
     * @param itemName is the name of the item in the transaction.
     * @param quantitySold is the quantity sold of the item in the transaction.
     * @param amountCollected is the amount collected when the item was sold in the transaction.
     */
    public Transaction(String itemName, int quantitySold, int amountCollected) 
    {
        this.itemName = itemName;
        this.quantitySold = quantitySold;
        this.amountCollected = amountCollected;
    }

    /**
     * Getter for the item name in the transaction.
     * @return the item name.
     */
    public String getItemName() 
    {
        return itemName;
    }

    /**
     * Setter for the item name in the transaction.
     * @param itemName is the name of the item.
     */
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    /**
     * Getter for quantity sold of the item in the transaction.
     * @return the quantity sold.
     */
    public int getQuantitySold() 
    {
        return quantitySold;
    }

    /**
     * Setter for the quantity sold of the item in the transaction.
     * @param quantitySold is the quantity sold of the item.
     */
    public void setQuantitySold(int quantitySold) 
    {
        this.quantitySold = quantitySold;
    }

    /**
     * Getter for the amount collected in each transaction.
     * @return the amount collected.
     */
    public int getAmountCollected() 
    {
        return amountCollected;
    }

    /**
     * Setter for the amount collected in each transaction.
     * @param amountCollected the amount collected for each transaction.
     */
    public void setAmountCollected(int amountCollected) 
    {
        this.amountCollected = amountCollected;
    }
}