import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
 * Class of the Regular Vending Machine.
 */
public class RegularVendingMachine 
{
    private Item[] itemssItems;
    private int[] vendingWallet;
    private ArrayList<Transaction> transactions;
    private Item[] startingInventory;
    private JPanel labelsPanel;

    /**
     * Constructor of RegularVendingMachine, also initializes the starting inventory.
     */
    public RegularVendingMachine() 
    {
        itemssItems = new Item[8];
        startingInventory = new Item[8];
        vendingWallet = new int[3];
        vendingWallet[0] = 50; // 1 peso
        vendingWallet[1] = 50; // 5 pesos
        vendingWallet[2] = 50; // 10 pesos
        transactions = new ArrayList<Transaction>();
        labelsPanel = new JPanel();

        itemssItems[0] = new Item("Coke Zero", 72, 10, 0);
        itemssItems[1] = new Item("Apple Juice", 35, 10, 117);
        itemssItems[2] = new Item("Tomato Sauce", 72, 10, 288);
        itemssItems[3] = new Item("Pepsi", 65, 10, 210);
        itemssItems[4] = new Item("Dough", 78, 10, 240);
        itemssItems[5] = new Item("Cheese", 35 , 10, 111);
        itemssItems[6] = new Item("Pineapple", 72, 10, 194);
        itemssItems[7] = new Item("Bottled Mineral Water", 25, 10, 0);

        for (int i = 0; i < itemssItems.length; i++) 
        {
            Item originalItem = itemssItems[i];
            Item copiedItem = new Item(originalItem.getItemName(), originalItem.getItemPrice(), originalItem.getItemStock(), originalItem.getItemCalories());
            startingInventory[i] = copiedItem;
        }
    }

    /**
     * Method to display the items in GUI
     * @param displayPanel is the panel the items are going to be displayed to.
     * @param itemsFrame is the frame the panel goes into.
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
     * Method to update stocks and other item components within a panel
     * @param displayPanel is the panel wherein the main components are.
     * @param labelsPanel is the panel to be added to the main panel to replace the existing labels with updated ones.
     */
    public void updateStocks(JPanel displayPanel, JPanel labelsPanel) 
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
     * Displays the items of the vending machine.
     */
    public void displayItems() 
    {
        for (int i = 0; i < itemssItems.length; i++) 
        {
            if (itemssItems[i] != null) 
            {
                System.out.println((i + 1) + ": " + itemssItems[i].getItemName() + " - Php " + itemssItems[i].getItemPrice() + " (" + itemssItems[i].getItemStock() + " left)" + " (" + itemssItems[i].getItemCalories() + " Calories)");
            }
        }
        System.out.printf("\n");
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

        updateStocks(restockPanel, labelsPanel);

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

        updateStocks(setPricePanel, labelsPanel);
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

        while (true)
        {
            String input = JOptionPane.showInputDialog(null, "What money denomination would you like to replenish? [1] 1 Peso [2] 5 Peso [3] 10 Peso:");

            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Operation canceled.");
                break;
            }
        
            try 
            {
                chosenDenomination = Integer.parseInt(input);

                if (chosenDenomination != 1 && chosenDenomination != 2 && chosenDenomination != 3) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Choice. Please enter a valid number.");
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

    /*
     * Getter for transactions.
     */
    public ArrayList<Transaction> getTransactions() 
    {
        return transactions;
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
     * Method which purchases an item from the vending machine and dispenses change.
     * @param user is the user object passed to manipulate the user's wallet.
     * @param index is which item is to be purchased.
     * @param scanner is a scanner parameter passed to be able to use a scanner.
     */
    public void purchaseItem(User user, int index, JPanel displayPanel)
    {
        int amountReceived = 0;
        int numberOfDenomination = 0;
        boolean stopInserting = false;

        while (true) 
        {
            String denominationInput = JOptionPane.showInputDialog(null, "Enter the denomination you want to insert (1, 5, 10) or 0 to stop inserting:");
            int denomination = Integer.parseInt(denominationInput);

            if (denomination == 0) 
            {
                stopInserting = true;
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

        if (stopInserting)
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

        updateStocks(displayPanel, labelsPanel);
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
}
