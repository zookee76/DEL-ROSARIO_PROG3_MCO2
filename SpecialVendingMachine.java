import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of the Special Vending Machine.
 */
public class SpecialVendingMachine
{
    private Item[] itemssItems;
    private int[] vendingWallet;
    private ArrayList<Transaction> transactions;
    private Item[] startingInventory;
    private int quantityTopping;
    private ArrayList<Pizza> specialTransactions;
    private ArrayList<Toppings> chosenToppings;
    private ArrayList<String> totalToppingsChosen;
    private Toppings[] toppings;
    private Toppings[] startingToppingInventory;
    private ArrayList<Toppings> initialChosenToppings;
    private JPanel labelsPanel;
    private ArrayList<ToppingTransaction> toppingTransactions;
    
    /**
     * Constructor of SpecialVendingMachine, also initializes the starting inventory.
     */
    public SpecialVendingMachine() 
    {
        itemssItems = new Item[8];
        startingInventory = new Item[8];
        startingToppingInventory = new Toppings[11];
        vendingWallet = new int[3];
        vendingWallet[0] = 50; // 1 peso
        vendingWallet[1] = 50; // 5 pesos
        vendingWallet[2] = 50; // 10 pesos
        transactions = new ArrayList<Transaction>();
        specialTransactions = new ArrayList<Pizza>();
        labelsPanel = new JPanel();
        toppingTransactions = new ArrayList<ToppingTransaction>();

        itemssItems[0] = new Item("Coke Zero", 72, 10, 0);
        itemssItems[1] = new Item("Apple Juice", 35, 10, 117);
        itemssItems[2] = new Item("Garlic Bread", 72, 10, 288);
        itemssItems[3] = new Item("Sparkling Water", 100, 10, 0);
        itemssItems[4] = new Item("Balsamic Vinegar", 115, 10, 240);
        itemssItems[5] = new Item("Basil", 35 , 10, 111);
        itemssItems[6] = new Item("Pineapple", 72, 10, 194);
        itemssItems[7] = new Item("Bottled Mineral Water", 25, 10, 0);

        toppings = new Toppings[] {
            new TomatoSauce(),
            new MozzarellaCheese(),
            new Ham(),
            new Sausage(),
            new Beef(),
            new Onions(),
            new Pineapple(),
            new Anchovies(),
            new Burrata(),
            new ThinCrust(),
            new HandTossed()
        };
        
        for (int i = 0; i < itemssItems.length; i++) 
        {
            Item originalItem = itemssItems[i];
            Item copiedItem = new Item(originalItem.getItemName(), originalItem.getItemPrice(), originalItem.getItemStock(), originalItem.getItemCalories());
            startingInventory[i] = copiedItem;
        }

        for (int i = 0; i < toppings.length; i++)
        {
            Toppings originalTopping = toppings[i];
            Toppings copiedTopping = new Toppings(originalTopping.getName(), originalTopping.getPrice(), originalTopping.getStock(), originalTopping.getToppingCalories());
            startingToppingInventory[i] = copiedTopping;
        }
    }

    /**
     * Displays the items of the regular vending machine.
     */
    public void displayItemsGUI(JPanel displayPanel, JFrame itemsFrame) 
    {
        for (int i = 0; i < itemssItems.length; i++) 
        {
            if (itemssItems[i] != null) 
            {
                String itemInfo = (i + 1) + ": " + itemssItems[i].getItemName() + " - Php " + itemssItems[i].getItemPrice() + " (" + itemssItems[i].getItemStock() + " left)" + " (" + itemssItems[i].getItemCalories() + " Calories)";
                JLabel label = new JLabel(itemInfo);
                JLabel label2 = new JLabel("\n");
                displayPanel.add(label);
                displayPanel.add(label2);
            }
        }
        
        itemsFrame.setTitle("Items in Vending Machine");
        itemsFrame.setSize(600, 600);
        itemsFrame.setLocationRelativeTo(null); 
        itemsFrame.setLayout(new BorderLayout());
        itemsFrame.add(displayPanel, BorderLayout.WEST);
        itemsFrame.setVisible(true);  
    }

    /**
     * Method to display the toppings
     * @param displayPanel is the panel where the toppings are to be displayed.
     * @param toppingsFrame is the frame where the panel is going to be placed.
     */
    public void displayToppingsGUI(JPanel displayPanel, JFrame toppingsFrame) 
    {
        for (int i = 0; i < toppings.length; i++) 
        {
            if (toppings[i] != null && !toppings[i].getName().equals("Thin Crust") && !toppings[i].getName().equals("Hand Tossed")) 
            {
                String toppingInfo = (i + 1) + ": " + toppings[i].getName() + " - Php " + toppings[i].getPrice() + " (" + toppings[i].getStock() + " left)" + " (" + toppings[i].getToppingCalories() + " Calories)";
                JLabel label = new JLabel(toppingInfo);
                JLabel label2 = new JLabel("\n");
                displayPanel.add(label);
                displayPanel.add(label2);
            }
        }
        
        toppingsFrame.setTitle("Toppings in Special Vending Machine");
        toppingsFrame.setSize(600, 600);
        toppingsFrame.setLocationRelativeTo(null); 
        toppingsFrame.setLayout(new BorderLayout());
        toppingsFrame.add(displayPanel, BorderLayout.WEST);
        toppingsFrame.setVisible(true);  
    }

    /**
     * Method to display all the special items in the special vending machine.
     * @param displayPanel is the panel where the items are going to be displayed.
     * @param toppingsFrame is the frame where the panel is going to be added.
     */
    public void displayToppingsWithCrustGUI(JPanel displayPanel, JFrame toppingsFrame) 
    {
        for (int i = 0; i < toppings.length; i++) 
        {
            if (toppings[i] != null) 
            {
                String toppingInfo = (i + 1) + ": " + toppings[i].getName() + " - Php " + toppings[i].getPrice() + " (" + toppings[i].getStock() + " left)" + " (" + toppings[i].getToppingCalories() + " Calories)";
                JLabel label = new JLabel(toppingInfo);
                JLabel label2 = new JLabel("\n");
                displayPanel.add(label);
                displayPanel.add(label2);
            }
        }
        
        toppingsFrame.setTitle("Special Items in Special Vending Machine");
        toppingsFrame.setSize(600, 600);
        toppingsFrame.setLocationRelativeTo(null); 
        toppingsFrame.setLayout(new BorderLayout());
        toppingsFrame.add(displayPanel, BorderLayout.WEST);
        toppingsFrame.setVisible(true);  
    }

    /**
     * Getter for Special Transactions.
     * @return
     */
    public ArrayList<Pizza> getSpecialTransactions() 
    {
        return specialTransactions;
    }

    /**
     * Getter for Transactions.
     * @return
     */
    public ArrayList<Transaction> getTransactions() 
    {
        return transactions;
    }

    /**
     * Method to update stocks and other item components within a panel
     * @param displayPanel is the panel wherein the main components are.
     * @param labelsPanel is the panel to be added to the main panel to replace the existing labels with updated ones.
     */
    public void updateItemStocks(JPanel displayPanel, JPanel labelsPanel) 
    {
        removeAllLabels(displayPanel);

        displayPanel.setLayout(new BorderLayout());

        labelsPanel.removeAll();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < itemssItems.length; i++) 
        {
            if (itemssItems[i] != null) 
            {
                String itemInfo = (i + 1) + ": " + itemssItems[i].getItemName() + " - Php " + itemssItems[i].getItemPrice() + " (" + itemssItems[i].getItemStock() + " left)" + " (" + itemssItems[i].getItemCalories() + " Calories)";
                JLabel label = new JLabel(itemInfo);
                JLabel label2 = new JLabel("\n");
                labelsPanel.add(label);
                labelsPanel.add(label2);
            }
        }

        displayPanel.add(labelsPanel, BorderLayout.PAGE_START);

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Method to update topping stocks and other item components within a panel
     * @param displayPanel is the panel wherein the main components are.
     * @param labelsPanel is the panel to be added to the main panel to replace the existing labels with updated ones.
     */
    public void updateToppingsStocks(JPanel displayPanel, JPanel labelsPanel) 
    {
        removeAllLabels(displayPanel);

        displayPanel.setLayout(new BorderLayout());

        labelsPanel.removeAll();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < toppings.length; i++) 
        {
            if (toppings[i] != null && !toppings[i].getName().equals("Thin Crust") && !toppings[i].getName().equals("Hand Tossed")) 
            {
                String toppingsInfo = (i + 1) + ": " + toppings[i].getName() + " - Php " + toppings[i].getPrice() + " (" + toppings[i].getStock() + " left)" + " (" + toppings[i].getToppingCalories() + " Calories)";
                JLabel label = new JLabel(toppingsInfo);
                JLabel label2 = new JLabel("\n");
                labelsPanel.add(label);
                labelsPanel.add(label2);
            }
        }

        displayPanel.add(labelsPanel, BorderLayout.PAGE_START);

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Method to update topping stocks and other item components within a panel
     * @param displayPanel is the panel where the items are going to be displayed.
     * @param labelsPanel is the panel to be added to the main panel to replace the existing labels with updated ones.
     */
    public void updateToppingsStocksWithCrust(JPanel displayPanel, JPanel labelsPanel) 
    {
        removeAllLabels(displayPanel);

        displayPanel.setLayout(new BorderLayout());

        labelsPanel.removeAll();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < toppings.length; i++) 
        {
            if (toppings[i] != null) 
            {
                String toppingsInfo = (i + 1) + ": " + toppings[i].getName() + " - Php " + toppings[i].getPrice() + " (" + toppings[i].getStock() + " left)" + " (" + toppings[i].getToppingCalories() + " Calories)";
                JLabel label = new JLabel(toppingsInfo);
                JLabel label2 = new JLabel("\n");
                labelsPanel.add(label);
                labelsPanel.add(label2);
            }
        }

        displayPanel.add(labelsPanel, BorderLayout.PAGE_START);

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Method to remove labels from a panel.
     * @param displayPanel is the panel which has the labels to be removed.
     */
    public void removeAllLabels(JPanel displayPanel) 
    {
        for (int i = displayPanel.getComponentCount() - 1; i >= 0; i--) 
        {
            if (displayPanel.getComponent(i) instanceof JLabel) 
            {
                displayPanel.remove(i);
            }
        }
    }

    /**
     * Method to restock an item and update the starting inventory.
     * @param user is the User.
     * @param restockIndex is which item the user want's to restock.
     * @param scanner is a scanner parameter passed to use a scanner.
     */
    public void restockItem(User user, int restockIndex, JPanel restockPanel)
    {
        int restockAmount = 0;

        while (true) 
        {
            String input = JOptionPane.showInputDialog(null, "How much of " + itemssItems[restockIndex].getItemName() + " would you like to replenish?:");

            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }
        
            try 
            {
                restockAmount = Integer.parseInt(input);
                if (restockAmount < 1) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                    continue;
                } 
                
                else 
                {
                    break;
                }
            } 
            
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                continue;
            }
        }

        int restockSelection = restockAmount;
        int currentStock = itemssItems[restockIndex].getItemStock();
        int updatedStock = currentStock + restockSelection;
        itemssItems[restockIndex].setItemStock(updatedStock);

        String restockMessage = "Stocks of " + itemssItems[restockIndex].getItemName() + ": " + updatedStock;
        JOptionPane.showMessageDialog(null, restockMessage, "Stock Information", JOptionPane.INFORMATION_MESSAGE);

        updateItemStocks(restockPanel, labelsPanel);

        for (int i = 0; i < itemssItems.length; i++) 
        {
            Item originalItem = itemssItems[i];
            Item copiedItem = new Item(originalItem.getItemName(), originalItem.getItemPrice(), originalItem.getItemStock(), originalItem.getItemCalories());
            startingInventory[i] = copiedItem;
        }
        
        if (transactions != null)
        {
            transactions.clear();
        }
    }

    /**
     * Method to restock a topping
     * @param user is the current user
     * @param restockIndex is the index of the topping to be restocked
     * @param scanner is a scanner to be used
     */
    public void restockTopping(User user, int restockIndex, JPanel specialRestockPanel) 
    {
        int restockAmount = 0;

        while (true) 
        {
            String input = JOptionPane.showInputDialog(null, "How much of " + toppings[restockIndex].getName() + " would you like to replenish?:");

            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }
        
            try 
            {
                restockAmount = Integer.parseInt(input);
                if (restockAmount < 1) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                    continue;
                } 
                
                else 
                {
                    break;
                }
            } 
            
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                continue;
            }
        }

        toppings[restockIndex].increaseStock(restockAmount);;
        System.out.printf("Stocks of " + toppings[restockIndex].getName() + ": " + toppings[restockIndex].getStock() + "\n\n");

        updateToppingsStocksWithCrust(specialRestockPanel, labelsPanel);

        for (int i = 0; i < toppings.length; i++)
        {
            Toppings originalTopping = toppings[i];
            Toppings copiedTopping = new Toppings(originalTopping.getName(), originalTopping.getPrice(), originalTopping.getStock(), originalTopping.getToppingCalories());
            startingToppingInventory[i] = copiedTopping;
        }

        if (specialTransactions != null)
        {
            specialTransactions.clear();
        }
    }

    /**
     * Method to change the price of an item.
     * @param user is the User.
     * @param chPriceIndex is which item the user wants to change the price of.
     * @param scanner is a scanner parameter passed to use a scanner.
     */
    public void changePrices(User user, int chPriceIndex, JPanel setPricePanel) 
    {
        int priceChange = 0;

        while (true) 
        {
            String input = JOptionPane.showInputDialog(null, "What would the new price of " + itemssItems[chPriceIndex].getItemName() + " be?:");

            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }
        
            try 
            {
                priceChange = Integer.parseInt(input);
                if (priceChange < 1) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                    continue;
                } 
                
                else 
                {            
                    break;
                }
            } 
            
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                continue;
            }
        }

        int chPriceSelection = priceChange;
        itemssItems[chPriceIndex].setItemPrice(chPriceSelection);

        updateItemStocks(setPricePanel, labelsPanel);
    }

    /**
     * Method to change the selected toppings price
     * @param user is the user
     * @param chPriceIndex is the index of the item to be modified
     * @param scanner
     */
    public void changeToppingPrice(User user, int chPriceIndex, JPanel setToppingPricePanel)
    {
        int priceChange = 0;

        while (true) 
        {
            String input = JOptionPane.showInputDialog(null, "What would the new price of " + toppings[chPriceIndex].getName() + " be?:");

            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }
        
            try 
            {
                priceChange = Integer.parseInt(input);

                if (priceChange < 1) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                    continue;
                } 
                
                else 
                {            
                    break;
                }
            } 
            
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                continue;
            }
        }

        int chPriceSelection = priceChange;
        toppings[chPriceIndex].setToppingPrice(chPriceSelection);

       updateToppingsStocksWithCrust(setToppingPricePanel, labelsPanel);
    }

    /**
     * Method to collect the money in the vending machine.
     * @param user is the User object passed to manipulate the user's wallet.
     */
    public void collectMoney(User user) 
    {
        if (vendingWallet[0] > 0 && vendingWallet[1] > 0 && vendingWallet[2] > 0)
        {
            int[] userWallet = user.getUserWallet();

            userWallet[0] = userWallet[0] + vendingWallet[0];
            vendingWallet[0] = 0;

        
            userWallet[1] = userWallet[1] + vendingWallet[1];
            vendingWallet[1] = 0;

            
            userWallet[2] = userWallet[2] + vendingWallet[2];;
            vendingWallet[2] = 0;

            user.setUserWallet(userWallet);

            displayVendingWallet();

            user.displayUserWallet();
        }

        else
        {
            JOptionPane.showMessageDialog(null, "No money in the vending machine.");
        }
    }

    /**
     * Method to display the wallet of the vending machine.
     */
    public void displayVendingWallet() 
    {
        StringBuilder vendingWalletInfo = new StringBuilder();
        vendingWalletInfo.append("\nVending Machine Wallet:\n");
        vendingWalletInfo.append("1 Peso: ").append(vendingWallet[0]).append("\n");
        vendingWalletInfo.append("5 Pesos: ").append(vendingWallet[1]).append("\n");
        vendingWalletInfo.append("10 Pesos: ").append(vendingWallet[2]).append("\n");
    
        int totalCash = (vendingWallet[0] * 1) + (vendingWallet[1] * 5) + (vendingWallet[2] * 10);
        vendingWalletInfo.append("Total Pesos: ").append(totalCash).append("\n");

        JOptionPane.showMessageDialog(null, vendingWalletInfo.toString(), "Vending Machine Wallet", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Method to replenish the money of the vending machine.
     * @param scanner is a scanner parameter passed to be able to use a scanner.
     */
    public void replenishMoney() 
    {
        displayVendingWallet();

        int chosenDenomination = 0;

        String[] moneyoptions = {"1 Peso", "5 Peso", "10 Peso"};

        while (true)
        {
            int denominationSelection = JOptionPane.showOptionDialog(null, "Select the denomination:", "Denomination Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, moneyoptions, moneyoptions[0]);

            if (denominationSelection == JOptionPane.CLOSED_OPTION || denominationSelection == 3) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }

            else if (denominationSelection == 0)
            {
                chosenDenomination = 1;
                break;
            }

            else if (denominationSelection == 1)
            {
                chosenDenomination = 2;
                break;
            }

            else if (denominationSelection == 2)
            {
                chosenDenomination = 3;
                break;
            }
        }

        if (chosenDenomination == 1)
        {
            int denominationCount = 0;

            while (true)
            {
                String input2 = JOptionPane.showInputDialog(null, "How many 1 Peso coins would you like to replenish?");

                if (input2 == null) 
                {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    break;
                } 
                
                else 
                {
                    try 
                    {
                        denominationCount = Integer.parseInt(input2);
                        if (denominationCount < 1) 
                        {
                            JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                        } 
                        
                        else 
                        {
                            break;
                        }
                    } 
                    
                    catch (NumberFormatException e) 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                        continue;
                    }
                }
            }

            vendingWallet[0] = vendingWallet[0] + denominationCount;
        }

        if (chosenDenomination == 2)
        {
            int denominationCount = 0;
            while (true)
            {
                String input2 = JOptionPane.showInputDialog(null, "How many 5 Peso coins would you like to replenish?");

                if (input2 == null) 
                {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    break;
                } 
                
                else 
                {
                    try 
                    {
                        denominationCount = Integer.parseInt(input2);
                        if (denominationCount < 1) 
                        {
                            JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                        } 
                        
                        else 
                        {
                            break;
                        }
                    } 
                    
                    catch (NumberFormatException e) 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                        continue;
                    }
                }
            }

            vendingWallet[1] = vendingWallet[1] + denominationCount;
        }

        if (chosenDenomination == 3)
        {
            int denominationCount = 0;
            while (true)
            {
                String input2 = JOptionPane.showInputDialog(null, "How many 10 Peso coins would you like to replenish?");

                if (input2 == null) 
                {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    break;
                } 
                
                else 
                {
                    try 
                    {
                        denominationCount = Integer.parseInt(input2);
                        if (denominationCount < 1) 
                        {
                            JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a positive number.");
                        } 
                        
                        else 
                        {
                            break;
                        }
                    } 
                    
                    catch (NumberFormatException e) 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
                        continue;
                    }
                }
            }

            vendingWallet[2] = vendingWallet[2] + denominationCount;
        }

        displayVendingWallet();
    }

    /**
     * Method to display the starting inventory of the vending machine..
     */
    public void displayStartingInv(JTextArea startingInvText) 
    {
        startingInvText.setText("Starting Inventory: \n");

        for (int i = 0; i < startingInventory.length; i++) 
        {
            startingInvText.append("Item Name: " + startingInventory[i].getItemName() + "\n");
            startingInvText.append("Stocks: " + startingInventory[i].getItemStock() + "\n\n");
        }
    }

    /**
     * Method to display the current inventory of the vending machine.
     */
    public void displayCurrentInv(JTextArea currentInvText) 
    {
        currentInvText.setText("Current Inventory: \n");

        for (int i = 0; i < itemssItems.length; i++) 
        {
            currentInvText.append("Item Name: " + itemssItems[i].getItemName() + "\n");
            currentInvText.append("Stocks: " + itemssItems[i].getItemStock() + "\n\n");
        }
    }

    /**
     * Method to display the starting inventory of toppings
     */
    public void displayToppingStartingInv(JTextArea specialStartingInvText)
    {
        specialStartingInvText.setText("Starting Inventory: \n");
        for (int i = 0; i < startingToppingInventory.length; i++)
        {
            if (!startingToppingInventory[i].getName().equals("Hand Tossed") && !startingToppingInventory[i].getName().equals("Thin Crust"))
            {
                specialStartingInvText.append("Topping Name: " + startingToppingInventory[i].getName() + "\n");
                specialStartingInvText.append("Stocks: " + startingToppingInventory[i].getStock() + "\n\n");
            }

            else
            {
                specialStartingInvText.append("Pizza Crust: " + startingToppingInventory[i].getName() + "\n");
                specialStartingInvText.append("Stocks: " + startingToppingInventory[i].getStock() + "\n\n");
            }
        }
    }

    /**
     * Method to display the current inventory of toppings
     */
    public void displayToppingCurrentInv(JTextArea specialCurrentInvText)
    {
        specialCurrentInvText.setText("Current Toppings Inventory: \n");
        for (int i = 0; i < toppings.length; i++)
        {
            if (!toppings[i].getName().equals("Hand Tossed") && !toppings[i].getName().equals("Thin Crust"))
            {
                specialCurrentInvText.append("Topping Name: " + toppings[i].getName() + "\n");
                specialCurrentInvText.append("Stocks: " + toppings[i].getStock() + "\n\n");
            }

            else
            {
                specialCurrentInvText.append("Pizza Crust: " + toppings[i].getName() + "\n");
                specialCurrentInvText.append("Stocks: " + toppings[i].getStock() + "\n\n");
            }
        }
    }
    
    /**
     * Method which assigns the value of the attributes of the Transaction array list to a variable in a summarized version, then displays a brief summary of the transactions starting from the previous stocking.
     */
    public void computeTransactions(JTextArea startingInvText, JTextArea transactionText, JTextArea currentInvText) 
    {
        if (transactions.size() > 0)
        {
            displayStartingInv(startingInvText);

            for (int i = 0; i < transactions.size(); i++) 
            {
                Transaction transaction = transactions.get(i);
                int totalQuantitySold = transaction.getQuantitySold();
                int totalAmountCollected = transaction.getAmountCollected();
                boolean alreadyDisplayed = false;
            
                for (int j = 0; j < i; j++) 
                {
                    Transaction previousTransaction = transactions.get(j);
                    if (previousTransaction.getItemName().equals(transaction.getItemName())) 
                    {
                        alreadyDisplayed = true;
                        break;
                    }
                }

                if (!alreadyDisplayed) 
                {
                    for (int j = i + 1; j < transactions.size(); j++) 
                    {
                        Transaction otherTransaction = transactions.get(j);
                        if (otherTransaction.getItemName().equals(transaction.getItemName())) 
                        {
                            totalQuantitySold += otherTransaction.getQuantitySold();
                            totalAmountCollected += otherTransaction.getAmountCollected();
                        }
                    }
                    
                    displayTransactions(transaction.getItemName(), totalQuantitySold, totalAmountCollected, transactionText);
                }
            }

            displayCurrentInv(currentInvText);
        }

        else
        {
            JOptionPane.showMessageDialog(null, "No transaction has been made.", "No Transactions", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Method which displays the summary of transactions.
     * @param itemName is the item name of the transaction.
     * @param totalQuantitySold is the total quantity sold of each item.
     * @param totalAmountCollected is the total amount collected for each sale of each item.
     */
    public void displayTransactions(String itemName, int totalQuantitySold, int totalAmountCollected, JTextArea transactionText) 
    {
        transactionText.append("Item: " + itemName + "\n");
        transactionText.append("Quantity Sold: " + totalQuantitySold + "\n");
        transactionText.append("Total Amount Collected: Php " + totalAmountCollected + "\n\n");
    }

    /**
     * Method which adds a transaction to the transaction array list.
     * @param index to identify which item in the item array is to be added to the transaction array list.
     */
    public void addTransaction(int index)
    {
        Transaction transaction = new Transaction(itemssItems[index].getItemName(), 1, itemssItems[index].getItemPrice());

        transactions.add(transaction);
    }

    /**
     * Method which adds the toppings of the purchased pizza into an array list.
     * @param chosenToppings are the toppings of the pizza.
     */
    public void addToppingTransaction(ArrayList<Toppings> chosenToppings)
    {
        for (int i = 0; i < chosenToppings.size(); i++)
        {
            Toppings currentTopping = chosenToppings.get(i);

            ToppingTransaction toppingTransaction = new ToppingTransaction(currentTopping.getName(), 1, currentTopping.getPrice());

            toppingTransactions.add(toppingTransaction);
        }
    }

    /**
     * Method which adds a special transaction to the special transaction array list.
     * @param pizzaType is the type of pizza
     * @param chosenToppings is the toppings included in the pizza
     * @return
     */
    public int addSpecialTransaction(int pizzaType, ArrayList<Toppings> chosenToppings, int totalCost)
    {
        String pizzaTypee;
        int count = 1;

        if (pizzaType == 9)
        {
            pizzaTypee = "Thin Crust";
        }

        else
        {
            pizzaTypee = "Hand Tossed";
        }

        ArrayList<String> totalToppingsChosen = new ArrayList<>();

        for (int i = 0; i < chosenToppings.size(); i++) 
        {
            Toppings currentTopping = chosenToppings.get(i);
            boolean alreadyDisplayedSpecial = false;
            
            for (int j = 0; j < i; j++) 
            {
                Toppings otherTopping = chosenToppings.get(j);
                if (currentTopping.getName().equals(otherTopping.getName())) 
                {
                    alreadyDisplayedSpecial = true;
                    break;
                }
            }

            if (!alreadyDisplayedSpecial)
            {                
                count = 1;
                for (int j = i + 1; j < chosenToppings.size(); j++) 
                {
                    Toppings otherTopping = chosenToppings.get(j);
                    if (currentTopping.getName().equals(otherTopping.getName())) 
                    {
                        count = count + 1;
                    }
                }
                
                String totalTopp = currentTopping.getName() + " - " + count;
                String toppingName = currentTopping.getName();

                if (!toppingName.equals("Thin Crust") && !toppingName.equals("Hand Tossed"))
                {
                    totalToppingsChosen.add(totalTopp);
                }
            }
        }

        Pizza pizza = new Pizza(pizzaTypee, totalToppingsChosen, totalCost);
        specialTransactions.add(pizza);

        return 0;
    }

    /**
     * Method that displays the special transactions
     * @param specialTransactionText is the text area where the special transactions will be displayed
     */
    public void displaySpecialTransaction(JTextArea specialTransactionText) 
    {    
        for (int i = 0; i < specialTransactions.size(); i++) 
        {
            Pizza pizza = specialTransactions.get(i);
            
            specialTransactionText.append("Total Cost of Pizza: " + pizza.getTotalCost() + "\n");
            specialTransactionText.append("Pizza Type: " + pizza.getPizzaType() + "\n");
            specialTransactionText.append("Toppings: \n");
    
            for (int j = 0; j < pizza.getTotalToppingsChosen().size(); j++) 
            {
                String topping = pizza.getTotalToppingsChosen().get(j);
                specialTransactionText.append(topping + "\n");
            }
    
            specialTransactionText.append("\n");
        }
    }

    /**
     * Method that computes the summary of number of toppings sold.
     * @param specialToppingSummaryText is the text area wherein the summary is going to be displayed
     */
    public void computeToppingSummary(JTextArea specialStartingInvText, JTextArea specialTransactionText, JTextArea specialToppingSummaryText, JTextArea specialCurrentInvText) // IN PROGRESS
    {
        if (toppingTransactions.size() > 0)
        {
            displayToppingStartingInv(specialStartingInvText);
            displaySpecialTransaction(specialTransactionText);

            for (int i = 0; i < toppingTransactions.size(); i++) 
            {
                ToppingTransaction toppingtransaction = toppingTransactions.get(i);
                int totalQuantitySold = toppingtransaction.getQuantitySold();
                int totalAmountCollected = toppingtransaction.getAmountCollected();
                boolean alreadyDisplayed = false;
            
                for (int j = 0; j < i; j++) 
                {
                    ToppingTransaction previousToppingTransaction = toppingTransactions.get(j);
                    if (previousToppingTransaction.getToppingName().equals(toppingtransaction.getToppingName())) 
                    {
                        alreadyDisplayed = true;
                        break;
                    }
                }

                if (!alreadyDisplayed) 
                {
                    for (int j = i + 1; j < toppingTransactions.size(); j++) 
                    {
                        ToppingTransaction otherToppingTransaction = toppingTransactions.get(j);
                        if (otherToppingTransaction.getToppingName().equals(toppingtransaction.getToppingName())) 
                        {
                            totalQuantitySold += otherToppingTransaction.getQuantitySold();
                            totalAmountCollected += otherToppingTransaction.getAmountCollected();
                        }
                    }
                    
                    displayToppingSummaryTransactions(toppingtransaction.getToppingName(), totalQuantitySold, totalAmountCollected, specialToppingSummaryText);
                }
            }

            displayToppingCurrentInv(specialCurrentInvText);
        }

        else
        {
            JOptionPane.showMessageDialog(null, "No transaction has been made.", "No Transactions", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Method that displays the summary of special items sold.
     * @param toppingName is the name of the item.
     * @param totalQuantitySold is the total quantity sold of the item.
     * @param totalAmountCollected is the total amount collected of the item.
     * @param specialToppingSummaryText is the text area where it will be displayed.
     */
    public void displayToppingSummaryTransactions(String toppingName, int totalQuantitySold, int totalAmountCollected, JTextArea specialToppingSummaryText) 
    {
        specialToppingSummaryText.append("Item: " + toppingName + "\n");
        specialToppingSummaryText.append("Quantity Sold: " + totalQuantitySold + "\n");
        specialToppingSummaryText.append("Total Amount Collected: Php " + totalAmountCollected + "\n\n");
    }

    /**
     * Method which purchases an item from the vending machine and dispenses change.
     * @param user is the user object passed to manipulate the user's wallet.
     * @param index is which item is to be purchased.
     * @param displayPanel is the panel where the items are displayed.
     */
    public void purchaseItem(User user, int index, JPanel displayPanel)
    {
        int amountReceived = 0;
        int numberOfDenomination = 0;
        boolean stopInserting = false;
        int denomination = -1;

        while (true) 
        {
            String[] moneyoptions = {"1 Peso", "5 Peso", "10 Peso", "Done with Insertion"};

            while (true)
            {
                int denominationSelection = JOptionPane.showOptionDialog(null, "Select the denomination:", "Denomination Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, moneyoptions, moneyoptions[0]);

                if (denominationSelection == JOptionPane.CLOSED_OPTION || denominationSelection == 4) 
                {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    break;
                }

                else if (denominationSelection == 0)
                {
                    denomination = 1;
                    break;
                }

                else if (denominationSelection == 1)
                {
                    denomination = 5;
                    break;
                }

                else if (denominationSelection == 2)
                {
                    denomination = 10;
                    break;
                }

                else if (denominationSelection == JOptionPane.CLOSED_OPTION) 
                {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    break;
                }

                else 
                {
                    stopInserting = true;
                    break;
                }
            }

            if (stopInserting == true)
            {
                break;
            }

            while (true) 
            {
                String numberOfDenominationInput = JOptionPane.showInputDialog(null, "Enter the number of " + denomination + " pesos:");
                numberOfDenomination = Integer.parseInt(numberOfDenominationInput);

                if (numberOfDenomination < 1) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Value. Try Again.");
                } 

                else if (denomination == 1)        
                {
                    vendingWallet[0] += numberOfDenomination;
                    amountReceived += denomination * numberOfDenomination;
                    JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                    break;
                }

                else if (denomination == 5)
                {
                    vendingWallet[1] += numberOfDenomination;
                    amountReceived += denomination * numberOfDenomination;
                    JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                    break;
                }

                else if (denomination == 10)
                {
                    vendingWallet[2] += numberOfDenomination;
                    amountReceived += denomination * numberOfDenomination;
                    JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                    break;
                }
            }
            
            if (user.takeCoins(denomination, numberOfDenomination) == 0)
            {
                continue;
            }
        }

        if (stopInserting == true)
        {
            if (index >= 0 && index <= itemssItems.length && itemssItems[index] != null) 
            {
                if (itemssItems[index].getItemStock() == 0) 
                {
                    JOptionPane.showMessageDialog(null,"Item out of stock!");
                } 
                
                else if (amountReceived < itemssItems[index].getItemPrice()) 
                {
                    JOptionPane.showMessageDialog(null,"Insufficient amount received!");

                    while (amountReceived != 0)
                    {
                        if (amountReceived >= 10)
                        {
                            amountReceived = amountReceived - 10;
                            user.setIndivUserWallet(2, 1);
                            vendingWallet[2] = vendingWallet[2] - 1;
                        }

                        else if (amountReceived >= 5 && amountReceived < 10)
                        {
                            amountReceived = amountReceived - 5;
                            user.setIndivUserWallet(1, 1);
                            vendingWallet[1] = vendingWallet[1] - 1;
                        }

                        else if (amountReceived >= 1 && amountReceived < 5)
                        {
                            amountReceived = amountReceived - 1;
                            user.setIndivUserWallet(0, 1);
                            vendingWallet[0] = vendingWallet[0] - 1;
                        }
                    }
                } 
                
                else 
                {
                    int change = amountReceived - itemssItems[index].getItemPrice();
                    int[] changeDenominations = calculateChange(change);
                    StringBuilder message = new StringBuilder();

                    if (changeDenominations != null) 
                    {
                        itemssItems[index].setItemStock(itemssItems[index].getItemStock() - 1);
                        message.append("\nDispensing Change....\n");

                        message.append("Change: Php ").append(change).append("\n\n");
                        message.append("Change denominations:\n");
                        message.append("1 Peso: ").append(changeDenominations[0]).append("\n");
                        message.append("5 Pesos: ").append(changeDenominations[1]).append("\n");
                        message.append("10 Pesos: ").append(changeDenominations[2]);

                        JOptionPane.showMessageDialog(null, message.toString(), "Change Dispenser", JOptionPane.INFORMATION_MESSAGE);

                        user.addCoinsToWallet(1, changeDenominations[0]);
                        user.addCoinsToWallet(5, changeDenominations[1]);
                        user.addCoinsToWallet(10, changeDenominations[2]);

                        user.displayUserWallet();

                        addTransaction(index);
                    }

                    else
                    {
                       JOptionPane.showMessageDialog(null,"Not enough money to produce change.");
                    }
                }
            }
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(null,"Invalid item selection!");
        }

        updateItemStocks(displayPanel, labelsPanel);
    }

    /**
     * Method that calculates the change of the user as well as the respective denominations of change to be dispensed.
     * @param change is the total amount of change to be dispensed.
     * @return changeDenominations returns the amount of denominations to be dispensed for change.
     */
    private int[] calculateChange(int change)
    {
        int[] changeDenominations = new int[3];
        int[] availableDenominations = { vendingWallet[2], vendingWallet[1], vendingWallet[0] }; 
        changeDenominations[0] = 0;
        changeDenominations[1] = 0;
        changeDenominations[2] = 0;

        int remainingChange = (int) change;
        
        while(remainingChange != 0)
        {
            if (remainingChange >= 10 && availableDenominations[0] >= (int)(remainingChange/10))
            {
                changeDenominations[2] += (int)(remainingChange/10);
                availableDenominations[0] -= (int)(remainingChange/10);
                vendingWallet[2] -= (int)(remainingChange/10);
                remainingChange -= (10 * (int)(remainingChange/10));
            }
            else if (remainingChange >= 5 && availableDenominations[1] >= (int)(remainingChange/5))
            {
                changeDenominations[1] += (int)(remainingChange/5);
                availableDenominations[1] -= (int)(remainingChange/5);
                vendingWallet[1] -= (int)(remainingChange/5);
                remainingChange -= (5 * (int)(remainingChange/5));
            }

            else if (remainingChange >= 1 && availableDenominations[2] >= remainingChange)
            {
                changeDenominations[0] += remainingChange;
                availableDenominations[1] -= remainingChange;
                vendingWallet[0] -= remainingChange;
                remainingChange -= remainingChange;
            }

            else
            {
                return null;
            }
        }

        return changeDenominations;
    }

    /**
     * Method used to purchase from the special vending machine
     * @param user is the user object passed to manipulate the user's wallet.
     * @param scanner is a scanner parameter passed to be able to use a scanner.
     */
    public void purchaseSpecialItem(User user, JPanel specialDisplayPanel, JFrame loadSpecialMachineFrame, JButton exitButton) 
    {
        int amountReceived = 0;
        ArrayList<Toppings> chosenToppings = new ArrayList<>();
        boolean ordered = false;
        ArrayList<Toppings> initialChosenToppings = new ArrayList<>();
        boolean cancelled = false;
        
        String[] options = { "Thin Crust - Php: " + toppings[9].getPrice() + " (" + toppings[9].getStock() + " left) " + "(" + toppings[9].getToppingCalories() + " Calories)",
        "Hand Tossed - Php: " + toppings[10].getPrice() + " (" + toppings[10].getStock() + " left) " + "(" + toppings[10].getToppingCalories() + " Calories)"};

        int totalCost = 0;
        int pizzaType = -1;
        int totalCalories = 0;

        while (true) 
        {
            int pizzaTypee = JOptionPane.showOptionDialog(null, "Select your pizza type:", "Pizza Order", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (pizzaTypee == JOptionPane.CLOSED_OPTION) 
            {
                JOptionPane.showMessageDialog(null, "No pizza type selected. Order canceled.");
                break;
            }

            pizzaType = 9 + pizzaTypee;

            if (toppings[pizzaType].getStock() < 1) 
            {
                JOptionPane.showMessageDialog(null, "Insufficient stock for " + toppings[pizzaType].getName());
            } 
            
            else 
            {
                JOptionPane.showMessageDialog(null, "Preparing " + toppings[pizzaType].getName() + "...");
                toppings[pizzaType].prep();
                totalCost += toppings[pizzaType].getPrice();
                JOptionPane.showMessageDialog(null, "Added " + toppings[pizzaType].getName() + " to your order.\nTotal cost: Php " + totalCost);
                break;
            }
        }
             
        displayToppingsGUI(specialDisplayPanel, loadSpecialMachineFrame);

        specialDisplayPanel.add(Box.createVerticalGlue());
        specialDisplayPanel.add(exitButton);

        loadSpecialMachineFrame.getContentPane().removeAll();
        loadSpecialMachineFrame.add(specialDisplayPanel, BorderLayout.CENTER);
        loadSpecialMachineFrame.setVisible(true);

        while (true) 
        {
            quantityTopping = 1;
            String[] toppingOptions = {"Tomato Sauce", "Mozarella Cheese", "Ham", "Sausage", "Beef", "Onions", "Pineapple", "Anchovies", "Burrata", "Cancel Order"};

            int toppingChoicee = JOptionPane.showOptionDialog(null, "Select a topping to add to your pizza:", "Toppings Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, toppingOptions, toppingOptions[0]);

            if (toppingChoicee == JOptionPane.CLOSED_OPTION || toppingChoicee == toppingOptions.length - 1)
            {
                JOptionPane.showMessageDialog(null, "Order canceled.");
                cancelled = true;
                break;
            }

            if (quantityTopping > toppings[toppingChoicee].getStock()) 
            {
                JOptionPane.showMessageDialog(null, "Insufficient Stock!", "Insufficient Stock", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            else
            {
                Toppings currentToppingChosen = toppings[toppingChoicee];

                totalCost += toppings[toppingChoicee].getPrice() * quantityTopping;
                totalCalories += toppings[toppingChoicee].getToppingCalories() * quantityTopping;
                
                String prepMessage = "Preparing " + toppings[toppingChoicee].getName() + "...";
                JOptionPane.showMessageDialog(null, prepMessage, "Preparing Topping", JOptionPane.INFORMATION_MESSAGE);

                toppings[toppingChoicee].prep();

                initialChosenToppings.add(currentToppingChosen);
                chosenToppings.add(currentToppingChosen);

                JOptionPane.showMessageDialog(null, "Added " + toppings[toppingChoicee].getName() + " to your order.\nTotal cost: Php " + totalCost + "\n Total Calories: " + totalCalories);
            }
        }
        
        if (cancelled == false)
        {
            while (true) 
            {
                String denominationInput = JOptionPane.showInputDialog(null, "Enter the denomination you want to insert (1, 5, 10) or 0 to stop inserting:");
                int denomination = Integer.parseInt(denominationInput);
                int numberOfDenomination = 0;

                if (denomination == 0) 
                {
                    break;
                } 
                
                else if (denomination != 1 && denomination != 5 && denomination != 10) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid denomination!");
                    continue;
                }

                while (true) 
                {
                    String numberOfDenominationInput = JOptionPane.showInputDialog(null, "Enter the number of " + denomination + " pesos:");
                    numberOfDenomination = Integer.parseInt(numberOfDenominationInput);

                    if (numberOfDenomination < 1) 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Value. Try Again.");
                    } 

                    else if (denomination == 1)        
                    {
                        vendingWallet[0] += numberOfDenomination;
                        amountReceived += denomination * numberOfDenomination;
                        JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                        break;
                    }

                    else if (denomination == 5)
                    {
                        vendingWallet[1] += numberOfDenomination;
                        amountReceived += denomination * numberOfDenomination;
                        JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                        break;
                    }

                    else if (denomination == 10)
                    {
                        vendingWallet[2] += numberOfDenomination;
                        amountReceived += denomination * numberOfDenomination;
                        JOptionPane.showMessageDialog(null, "Amount received: Php " + amountReceived);
                        break;
                    }
                }
                
                if (user.takeCoins(denomination, numberOfDenomination) == 0)
                {
                    continue;
                }
            }
        }

        if (cancelled == false)
        {
            if (totalCost > amountReceived) 
            {
                JOptionPane.showMessageDialog(null,"Insufficient amount received!");

                toppings[pizzaType].increaseStock(quantityTopping);

                for (int i = 0; i < initialChosenToppings.size(); i++) 
                {
                    Toppings currentToppingChosen2 = initialChosenToppings.get(i);
                    
                    if (currentToppingChosen2.getName().equals(toppings[i].getName()))
                    {
                        toppings[i].increaseStock(quantityTopping);
                    }
                    
                    for (int j = i + 1; j < initialChosenToppings.size(); j++) 
                    {
                        Toppings otherTopping = initialChosenToppings.get(j);
                        if (currentToppingChosen2.getName().equals(otherTopping.getName())) 
                        {
                            toppings[i].increaseStock(quantityTopping);
                        }
                    }
                }

                while (amountReceived != 0)
                {
                    if (amountReceived >= 10)
                    {
                        amountReceived = amountReceived - 10;
                        user.setIndivUserWallet(2, 1);
                        vendingWallet[2] = vendingWallet[2] - 1;
                    }

                    else if (amountReceived >= 5 && amountReceived < 10)
                    {
                        amountReceived = amountReceived - 5;
                        user.setIndivUserWallet(1, 1);
                        vendingWallet[1] = vendingWallet[1] - 1;
                    }

                    else if (amountReceived >= 1 && amountReceived < 5)
                    {
                        amountReceived = amountReceived - 1;
                        user.setIndivUserWallet(0, 1);
                        vendingWallet[0] = vendingWallet[0] - 1;
                    }
                }
            }

            else 
            {
                int change = amountReceived - totalCost;
                int[] changeDenominations = calculateChange(change);
                StringBuilder changeMessage = new StringBuilder();

                if (changeDenominations != null) 
                {
                    changeMessage.append("\nDispensing Change....\n");

                    changeMessage.append("Change: Php ").append(change).append("\n\n");
                    changeMessage.append("Change denominations:\n");
                    changeMessage.append("1 Peso: ").append(changeDenominations[0]).append("\n");
                    changeMessage.append("5 Pesos: ").append(changeDenominations[1]).append("\n");
                    changeMessage.append("10 Pesos: ").append(changeDenominations[2]);

                    JOptionPane.showMessageDialog(null, changeMessage.toString(), "Change Dispenser", JOptionPane.INFORMATION_MESSAGE);

                    user.addCoinsToWallet(1, changeDenominations[0]);
                    user.addCoinsToWallet(5, changeDenominations[1]);
                    user.addCoinsToWallet(10, changeDenominations[2]);

                    user.displayUserWallet();

                    addToppingTransaction(chosenToppings);

                    for (int i = 0; i < chosenToppings.size(); i++) 
                    {
                        Toppings currentTopping = chosenToppings.get(i);
                    
                        for (int j = 0; j < toppings.length; j++) 
                        {
                            if (currentTopping.getName().equals(toppings[j].getName())) 
                            {
                                toppings[j].decreaseStock(1);                
                            }
                        }
                    }
                    
                    toppings[pizzaType].decreaseStock(1);

                    if (addSpecialTransaction(pizzaType, chosenToppings, totalCost) == 0)
                    {
                        ordered = true;
                    }
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Not enough money to produce change.");
                }
            }
        }

        if (ordered == true)
        {
            StringBuilder orderedMessage = new StringBuilder();

            orderedMessage.append("Your Custom Pizza has been prepared!\n\n");
            orderedMessage.append("Thank you for using the Special Vending Machine!");
            JOptionPane.showMessageDialog(null, orderedMessage.toString(), "Special Vending Machine end message", JOptionPane.INFORMATION_MESSAGE);

            updateToppingsStocks(specialDisplayPanel, labelsPanel);
        }
    }
}