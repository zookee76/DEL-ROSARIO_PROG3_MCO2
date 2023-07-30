/**
 * Item class which has the properties of each item.
 */
public class Item 
{
    private String itemName;
    private int itemPrice;
    private int itemStock;
    private int itemCalories;

    /**
     * Constructor of Item class.
     * @param itemName is the name of the item.
     * @param itemPrice is the price of the item.
     * @param itemStock is the stock of the item.
     * @param itemCalories is the calories of the item.
     */
    public Item(String itemName, int itemPrice, int itemStock, int itemCalories) 
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemCalories = itemCalories;
    }

    /**
     * Getter for the item name.
     * @return the item name.
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Getter for the item price.
     * @return the item price.
     */
    public int getItemPrice() 
    {
        return itemPrice;
    }

    /**
     * Getter for the item stock.
     * @return the item stock.
     */
    public int getItemStock() 
    {
        return itemStock;
    }

    /**
     * Getter for the item calories.
     * @return the item calories.
     */
    public int getItemCalories() 
    {
        return itemCalories;
    }

    /**
     * Setter for the item name.
     * @param itemName is the item name.
     */
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    /**
     * Setter for the item price.
     * @param itemPrice is the item price.
     */
    public void setItemPrice(int itemPrice) 
    {
        this.itemPrice = itemPrice;
    }

    /**
     * Setter for the item stock.
     * @param itemStock is the number of stock of the item.
     */
    public void setItemStock(int itemStock) 
    {
        this.itemStock = itemStock;
    }

    /**
     * Setter for the item calories.
     * @param itemCalories is the number of calories of the item.
     */
    public void setItemCalories(int itemCalories) 
    {
        this.itemCalories = itemCalories;
    }  
}