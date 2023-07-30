import javax.swing.JOptionPane;

/**
 * Class of the Toppings.
 */
public class Toppings 
{
    private String name;
    private int price;
    private int stock; 
    private int calories;

    /**
     * Constructor class for the Toppings.
     * @param name is the topping name.
     * @param price is the price for the topping.
     * @param stock is the stocks for the topping.
     * @param calories is the calorie of the topping.
     */
    public Toppings(String name, int price, int stock, int calories) 
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.calories = calories;
    }

    /**
     * Method to display the preparation of a topping.
     */
    public void prep() 
    {
        System.out.println("Placing a topping");
    }

    /**
     * Getter for the topping calories.
     * @return the topping calories.
     */
    public int getToppingCalories()
    {
        return calories;
    }

    /**
     * Getter for the topping name
     * @return the topping name.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Getter for the topping price.
     * @return the topping price.
     */
    public int getPrice() 
    {
        return price;
    }

    /**
     * Getter for the topping stocks.
     * @return the topping stock.
     */
    public int getStock() 
    {
        return stock;
    }

    /**
     * Method to decrease the stock.
     * @param quantity is the amount of stock to be decreased.
     */
    public void decreaseStock(int quantity) 
    {
        stock -= quantity;
    }

    /**
     * Method to increase the stock.
     * @param quantity is the amount of stock to be increased.
     */
    public void increaseStock(int quantity) 
    {
        stock += quantity;
    }

    /**
     * Setter for the topping price
     * @param toppingPrice is the new topping price.
     */
    public void setToppingPrice(int toppingPrice)
    {
        this.price = toppingPrice;
    }
}

/**
 * Thin Crust sub class of Toppings parent class.
 */
class ThinCrust extends Toppings 
{
    /**
     * Constructor class
     */
    public ThinCrust() 
    {
        super("Thin Crust", 50, 10, 170); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Rolling out the pizza dough thinly...", "Thin Crust Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Hand Tossed sub class of Toppings parent class.
 */
class HandTossed extends Toppings 
{
    /**
     * Constructor class
     */
    public HandTossed() 
    {
        super("Hand Tossed", 50, 10, 250); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Kneading the pizza dough then tossing to achieve the perfect consistency...", "Hand Tossed Crust Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Tomato Sauce sub class of Toppings parent class.
 */
class TomatoSauce extends Toppings 
{
    /**
     * Constructor class
     */
    public TomatoSauce() 
    {
        super("Tomato Sauce", 20, 10, 100); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Spreading the Tomato Sauce across evenly...", "Tomato Sauce Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Mozarella Cheese sub class of Toppings parent class.
 */
class MozzarellaCheese extends Toppings 
{
    /**
     * Constructor class
     */
    public MozzarellaCheese() 
    {
        super("Mozarella Cheese", 20, 10, 125); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Sprinkling a generous amount of mozzarella cheese on top...", "Mozarella Cheese Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Ham sub class of Toppings parent class.
 */
class Ham extends Toppings 
{
    /**
     * Constructor class
     */
    public Ham() 
    {
        super("Ham", 20, 10, 85); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Placing savory ham evenly throughout...", "Ham Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Sausage sub class of Toppings parent class.
 */
class Sausage extends Toppings 
{
    /**
     * Constructor class
     */
    public Sausage() 
    {
        super("Sausage", 20, 10, 85); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Placing sausage evenly throughout...", "Sausage Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Beef sub class of Toppings parent class.
 */
class Beef extends Toppings 
{
    /**
     * Constructor class
     */
    public Beef() 
    {
        super("Beef", 20, 10, 95); 
    }


    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Placing beef evenly throughout...", "Beef Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Onions sub class of Toppings parent class.
 */
class Onions extends Toppings 
{
    /**
     * Constructor class
     */
    public Onions() 
    {
        super("Onions", 20, 10, 45); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Spreading onions for the veggie flavors...", "Onions Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Pineapple sub class of Toppings parent class
 */
class Pineapple extends Toppings 
{
    /**
     * Constructor class
     */
    public Pineapple() 
    {
        super("Pineapple", 20, 10, 50); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Adding pineapples for a sweet addition...", "Pineapple Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Anchovies sub class of Toppings parent class
 */
class Anchovies extends Toppings 
{
    /**
     * Constructor class
     */
    public Anchovies() 
    {
        super("Anchovies", 20, 10, 75); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        JOptionPane.showMessageDialog(null, "Adding savory anchovies for a savoury flavor...", "Anchovy Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Burrata sub class of Toppings parent class
 */
class Burrata extends Toppings 
{
    /**
     * Constructor class
     */
    public Burrata() 
    {
        super("Burrata", 30, 10, 105); 
    }

    /**
     * Override method for an exclusive prep message unique to the topping.
     */
    @Override
    public void prep() 
    {
        System.out.println("Placing Burrata on pizza...");
        JOptionPane.showMessageDialog(null, "Slicing the burrata and spreading it across...", "Burrata Preparation", JOptionPane.INFORMATION_MESSAGE);
    }
}

