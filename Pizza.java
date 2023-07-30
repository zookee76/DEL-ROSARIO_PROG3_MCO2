import java.util.ArrayList;
/**
 * Pizza class which has the attributes of each pizza
 */
public class Pizza 
{
    private String pizzaType;
    private ArrayList<String> totalToppingsChosen;
    private int totalCost;

    /**
     * Constructor of the Pizza class.
     * @param pizzaType is the type of crust of the pizza.
     * @param chosenToppings are the toppings included on the pizza.
     * @param totalCost is total cost of the pizza.
     */
    public Pizza(String pizzaType, ArrayList<String> chosenToppings, int totalCost) 
    {
        this.totalToppingsChosen = new ArrayList<>(chosenToppings);
        this.pizzaType = pizzaType;
        this.totalCost = totalCost;
    }

    public String getPizzaType() 
    {
        return pizzaType;
    }

    public ArrayList<String> getTotalToppingsChosen() 
    {
        return totalToppingsChosen;
    }

    public int getTotalCost()
    {
        return totalCost;
    }
}
