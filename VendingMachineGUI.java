import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class where GUI variables are initialized.
 */
public class VendingMachineGUI extends JFrame 
{
    private RegularVendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private JPanel displayyPanel;
    private boolean itemsDisplayed = false;
    private JPanel regMaintenancePanel;
    private JPanel restockPanel;
    private JPanel setPricePanel;
    private JPanel TransactionSummaryPanel;
    private JFrame loadFrame;
    private JFrame regMFrame;
    private JPanel loadRegPanel;
    private JTextArea startingInvText;
    private JTextArea transactionText;
    private JTextArea currentInvText;
    private JPanel specialDisplayPanel;
    private JTextArea specialStartingInvText;
    private JTextArea specialTransactionText;
    private JTextArea specialCurrentInvText;
    private JTextArea specialToppingSummaryText;
    private JPanel specialSpecialDisplayPanel;
    private JFrame specialLoadFrame;
    private JPanel loadSpecialPanel;
    private JPanel specialRestockPanel;
    private JPanel specialSetPricePanel;
    private JPanel specialTransactionSummaryPanel;
    private JPanel specialRegTransactionSummaryPanel;
    private JPanel specialMaintenancePanel;
    private JFrame specialMFrame;
    
    /**
     * Constructor class for VendingMachineGUI
     */
    public VendingMachineGUI() 
    {
        setTitle("Vending Machine Factory Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        User user = new User();

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(7, 1));
        JButton createRegularMachineButton = new JButton("Create a Regular Vending Machine");
        JButton loadRegularMachineButton = new JButton("Load Created Regular Vending Machine");
        JButton maintenanceRegularMachineButton = new JButton("Perform Maintenance on a Created Regular Vending Machine");
        JButton createSpecialMachineButton = new JButton("Create a Special Vending Machine");
        JButton loadSpecialMachineButton = new JButton("Load Created Special Vending Machine");
        JButton maintenanceSpecialMachineButton = new JButton("Perform Maintenance on a Created Special Vending Machine");
        JButton exitButton = new JButton("Exit");
        JButton purchaseItemButton = new JButton("Purchase Item");
        JButton purchaseItemLoadButton = new JButton("Purchase Item");

        JRadioButton Item1 = new JRadioButton("Item 1");
        JRadioButton Item2 = new JRadioButton("Item 2");
        JRadioButton Item3 = new JRadioButton("Item 3");
        JRadioButton Item4 = new JRadioButton("Item 4");
        JRadioButton Item5 = new JRadioButton("Item 5");
        JRadioButton Item6 = new JRadioButton("Item 6");
        JRadioButton Item7 = new JRadioButton("Item 7");
        JRadioButton Item8 = new JRadioButton("Item 8");
        JRadioButton Item9 = new JRadioButton("Item 9");
        JRadioButton Item10 = new JRadioButton("Item 10");
        JRadioButton Item11 = new JRadioButton("Item 11");

        JButton restockButton = new JButton("Restock an Item");
        JButton setPriceButton = new JButton("Set a price for an Item");
        JButton collectMoneyButton = new JButton("Collect Money");
        JButton replenishMoneyButton = new JButton("Replenish Money");
        JButton printSummaryTransactionButton = new JButton("Print Summary of Transactions from Last Restock");
        JButton chooseItemRestockButton = new JButton("Restock Item");
        JButton chooseItemSetPriceButton = new JButton("Set Price of Item");

        JButton specialRestockButton = new JButton("Restock an Item");
        JButton specialSetPriceButton = new JButton("Set a price for an Item");
        JButton specialCollectMoneyButton = new JButton("Collect Money");
        JButton specialReplenishMoneyButton = new JButton("Replenish Money");
        JButton specialPrintSummaryTransactionButton = new JButton("Print Summary of Transactions from Last Restock");
        JButton specialChooseItemRestockButton = new JButton("Restock Item");
        JButton specialChooseItemSetPriceButton = new JButton("Set Price of Item");
        JButton specialRegPurchaseButton = new JButton("Purchase Item");
        JButton specialChooseToppingRestockButton = new JButton("Restock Item");
        JButton specialChooseSpecialItemSetPriceButton = new JButton("Set Price of Item");

        chooseItemRestockButton.setPreferredSize(new Dimension(600, 30));
        chooseItemRestockButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        purchaseItemButton.setPreferredSize(new Dimension(600, 30));
        exitButton.setPreferredSize(new Dimension(600, 30));
        purchaseItemButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        exitButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        purchaseItemLoadButton.setPreferredSize(new Dimension(600, 30));
        purchaseItemLoadButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        chooseItemSetPriceButton.setPreferredSize(new Dimension(600, 30));
        chooseItemSetPriceButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        specialChooseItemRestockButton.setPreferredSize(new Dimension(600, 30));
        specialChooseItemRestockButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        specialChooseItemSetPriceButton.setPreferredSize(new Dimension(600, 30));
        specialChooseItemSetPriceButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        specialRegPurchaseButton.setPreferredSize(new Dimension(600, 30));
        specialRegPurchaseButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        specialChooseSpecialItemSetPriceButton.setPreferredSize(new Dimension(600, 30));
        specialChooseSpecialItemSetPriceButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        specialChooseToppingRestockButton.setPreferredSize(new Dimension(600, 30));
        specialChooseToppingRestockButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        createRegularMachineButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (!itemsDisplayed && vendingMachine == null)
                    {
                        JFrame loadMachineFrame = new JFrame();

                        displayyPanel = new JPanel();
                        displayyPanel.setLayout(new BoxLayout(displayyPanel, BoxLayout.Y_AXIS));
                        vendingMachine = new RegularVendingMachine();
                        vendingMachine.displayItemsGUI(displayyPanel, loadMachineFrame);
                        itemsDisplayed = true;

                        displayyPanel.add(Item1);
                        displayyPanel.add(Item2);
                        displayyPanel.add(Item3);
                        displayyPanel.add(Item4);
                        displayyPanel.add(Item5);
                        displayyPanel.add(Item6);
                        displayyPanel.add(Item7);
                        displayyPanel.add(Item8);

                        displayyPanel.add(Box.createVerticalGlue());
                        displayyPanel.add(purchaseItemButton);
                        displayyPanel.add(exitButton); 

                        loadMachineFrame.getContentPane().removeAll();
                        loadMachineFrame.add(displayyPanel, BorderLayout.CENTER);
                        loadMachineFrame.pack(); 
                        loadMachineFrame.setVisible(true);
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "A Regular Vending Machine has already been created!");
                    }
                }
            }
        );

        loadRegularMachineButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (vendingMachine != null) 
                {
                    loadRegPanel = new JPanel();
                    loadFrame = new JFrame();
                   
                    loadRegPanel.setLayout(new BoxLayout(loadRegPanel, BoxLayout.Y_AXIS));
 
                    vendingMachine.displayItemsGUI(loadRegPanel, loadFrame);
                    loadRegPanel.add(Item1);
                    loadRegPanel.add(Item2);
                    loadRegPanel.add(Item3);
                    loadRegPanel.add(Item4);
                    loadRegPanel.add(Item5);
                    loadRegPanel.add(Item6);
                    loadRegPanel.add(Item7);
                    loadRegPanel.add(Item8);
           
                    loadRegPanel.add(Box.createVerticalGlue());
                    loadRegPanel.add(purchaseItemLoadButton);
                    loadRegPanel.add(exitButton);
                    
                    loadFrame.getContentPane().removeAll();
                    loadFrame.add(loadRegPanel, BorderLayout.CENTER);
                    loadFrame.pack(); 
                    loadFrame.setVisible(true);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Regular Vending Machine created.");
                }
            }
        });

        maintenanceRegularMachineButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (vendingMachine != null)
                {
                    regMaintenancePanel = new JPanel(new GridLayout(7, 1));
                    regMFrame = new JFrame("Maintain Regular Vending Machine");
                    regMFrame.setSize(600, 600);
                    regMFrame.setLocationRelativeTo(null);
                    regMFrame.setLayout(new GridLayout(1, 6));
                    
                    regMaintenancePanel.add(restockButton);
                    regMaintenancePanel.add(setPriceButton);
                    regMaintenancePanel.add(collectMoneyButton);
                    regMaintenancePanel.add(replenishMoneyButton);
                    regMaintenancePanel.add(printSummaryTransactionButton);

                    regMFrame.add(regMaintenancePanel);

                    regMFrame.setVisible(true);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Regular Vending Machine created.");
                }
            }
        });

        restockButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                restockPanel = new JPanel();
                JFrame restockFrame = new JFrame();
        
                restockPanel.setLayout(new BoxLayout(restockPanel, BoxLayout.Y_AXIS));
                JLabel restockMsg = new JLabel("Which item would you like to restock?");
                restockPanel.add(restockMsg);
                vendingMachine.displayItemsGUI(restockPanel, restockFrame);
                restockPanel.add(Item1);
                restockPanel.add(Item2);
                restockPanel.add(Item3);
                restockPanel.add(Item4);
                restockPanel.add(Item5);
                restockPanel.add(Item6);
                restockPanel.add(Item7);
                restockPanel.add(Item8);
        
                restockPanel.add(Box.createVerticalGlue());
                restockPanel.add(chooseItemRestockButton);
                restockPanel.add(exitButton);

                restockFrame.getContentPane().removeAll();
                restockFrame.add(restockPanel, BorderLayout.CENTER);
                restockFrame.pack(); 
                restockFrame.setVisible(true);
            }
        });

        specialRestockButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                String[] options = {"Restock Regular Item", "Restock Special Item"};

                int restockChoice = JOptionPane.showOptionDialog(null, "Select Item Type:", "Item Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (restockChoice == 0)
                {
                    specialRestockPanel = new JPanel();
                    JFrame specialRestockFrame = new JFrame();
            
                    specialRestockPanel.setLayout(new BoxLayout(specialRestockPanel, BoxLayout.Y_AXIS));
                    JLabel restockMsg = new JLabel("Which item would you like to restock?");
                    specialRestockPanel.add(restockMsg);
                    specialVendingMachine.displayItemsGUI(specialRestockPanel, specialRestockFrame);
                    specialRestockPanel.add(Item1);
                    specialRestockPanel.add(Item2);
                    specialRestockPanel.add(Item3);
                    specialRestockPanel.add(Item4);
                    specialRestockPanel.add(Item5);
                    specialRestockPanel.add(Item6);
                    specialRestockPanel.add(Item7);
                    specialRestockPanel.add(Item8);
            
                    specialRestockPanel.add(Box.createVerticalGlue());
                    specialRestockPanel.add(specialChooseItemRestockButton);
                    specialRestockPanel.add(exitButton);

                    specialRestockFrame.getContentPane().removeAll();
                    specialRestockFrame.add(specialRestockPanel, BorderLayout.CENTER);
                    specialRestockFrame.pack(); 
                    specialRestockFrame.setVisible(true);
                }

                else if (restockChoice == 1)
                {
                    specialRestockPanel = new JPanel();
                    JFrame specialRestockFrame = new JFrame();
            
                    specialRestockPanel.setLayout(new BoxLayout(specialRestockPanel, BoxLayout.Y_AXIS));
                    JLabel restockMsg = new JLabel("Which item would you like to restock?");
                    specialRestockPanel.add(restockMsg);
                    specialVendingMachine.displayToppingsWithCrustGUI(specialRestockPanel, specialRestockFrame);
                    specialRestockPanel.add(Item1);
                    specialRestockPanel.add(Item2);
                    specialRestockPanel.add(Item3);
                    specialRestockPanel.add(Item4);
                    specialRestockPanel.add(Item5);
                    specialRestockPanel.add(Item6);
                    specialRestockPanel.add(Item7);
                    specialRestockPanel.add(Item8);
                    specialRestockPanel.add(Item9);
                    specialRestockPanel.add(Item10);
                    specialRestockPanel.add(Item11);
            
                    specialRestockPanel.add(Box.createVerticalGlue());
                    specialRestockPanel.add(specialChooseToppingRestockButton);
                    specialRestockPanel.add(exitButton);

                    specialRestockFrame.getContentPane().removeAll();
                    specialRestockFrame.add(specialRestockPanel, BorderLayout.CENTER);
                    specialRestockFrame.pack(); 
                    specialRestockFrame.setVisible(true);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No option selected.");
                }
            }
        });
        
        chooseItemRestockButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected())
                {
                    vendingMachine.restockItem(user, 0, restockPanel);
                }

                else if (Item2.isSelected())
                {
                    vendingMachine.restockItem(user, 1, restockPanel);
                }

                else if (Item3.isSelected())
                {
                    vendingMachine.restockItem(user, 2, restockPanel);
                }

                else if (Item4.isSelected())
                {
                    vendingMachine.restockItem(user, 3, restockPanel);
                }

                else if (Item5.isSelected())
                {
                    vendingMachine.restockItem(user, 4, restockPanel);
                }

                else if (Item6.isSelected())
                {
                    vendingMachine.restockItem(user, 5, restockPanel);
                }
                
                else if (Item7.isSelected())
                {
                    vendingMachine.restockItem(user, 6, restockPanel);
                }

                else if (Item8.isSelected())
                {
                    vendingMachine.restockItem(user, 7, restockPanel);
                }
            }
        });

        specialChooseItemRestockButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected())
                {
                    specialVendingMachine.restockItem(user, 0, specialRestockPanel);
                }

                else if (Item2.isSelected())
                {
                    specialVendingMachine.restockItem(user, 1, specialRestockPanel);
                }

                else if (Item3.isSelected())
                {
                    specialVendingMachine.restockItem(user, 2, specialRestockPanel);
                }

                else if (Item4.isSelected())
                {
                    specialVendingMachine.restockItem(user, 3, specialRestockPanel);
                }

                else if (Item5.isSelected())
                {
                    specialVendingMachine.restockItem(user, 4, specialRestockPanel);
                }

                else if (Item6.isSelected())
                {
                    specialVendingMachine.restockItem(user, 5, specialRestockPanel);
                }
                
                else if (Item7.isSelected())
                {
                    specialVendingMachine.restockItem(user, 6, specialRestockPanel);
                }

                else if (Item8.isSelected())
                {
                    specialVendingMachine.restockItem(user, 7, specialRestockPanel);
                }
            }
        });

        specialChooseToppingRestockButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 0, specialRestockPanel);
                }

                else if (Item2.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 1, specialRestockPanel);
                }

                else if (Item3.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 2, specialRestockPanel);
                }

                else if (Item4.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 3, specialRestockPanel);
                }

                else if (Item5.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 4, specialRestockPanel);
                }

                else if (Item6.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 5, specialRestockPanel);
                }
                
                else if (Item7.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 6, specialRestockPanel);
                }

                else if (Item8.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 7, specialRestockPanel);
                }

                else if (Item9.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 8, specialRestockPanel);
                }

                else if (Item10.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 9, specialRestockPanel);
                }

                else if (Item11.isSelected())
                {
                    specialVendingMachine.restockTopping(user, 10, specialRestockPanel);
                }
            }
        });

        setPriceButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame setPriceFrame = new JFrame();

                setPricePanel = new JPanel();
                setPricePanel.setLayout(new BoxLayout(setPricePanel, BoxLayout.Y_AXIS));
                JLabel setPriceMsg = new JLabel("Which item would you like to set the price for?");
                setPricePanel.add(setPriceMsg);
                vendingMachine.displayItemsGUI(setPricePanel, setPriceFrame);
                setPricePanel.add(Item1);
                setPricePanel.add(Item2);
                setPricePanel.add(Item3);
                setPricePanel.add(Item4);
                setPricePanel.add(Item5);
                setPricePanel.add(Item6);
                setPricePanel.add(Item7);
                setPricePanel.add(Item8);

                setPricePanel.add(Box.createVerticalGlue());
                setPricePanel.add(chooseItemSetPriceButton);
                setPricePanel.add(exitButton);

                setPriceFrame.getContentPane().removeAll();
                setPriceFrame.add(setPricePanel, BorderLayout.CENTER);
                setPriceFrame.pack();
                setPriceFrame.setVisible(true);
            }
        });

        specialSetPriceButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                String[] options = {"Change the Price of a Regular Item", "Change the Price of a Special Item"};

                int setPriceChoice = JOptionPane.showOptionDialog(null, "Select Item Type:", "Item Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (setPriceChoice == 0)
                {
                    specialSetPricePanel = new JPanel();
                    JFrame specialSetPriceFrame = new JFrame();
            
                    specialSetPricePanel.setLayout(new BoxLayout(specialSetPricePanel, BoxLayout.Y_AXIS));
                    JLabel restockMsg = new JLabel("Which item would you like to restock?");
                    specialSetPricePanel.add(restockMsg);
                    specialVendingMachine.displayItemsGUI(specialSetPricePanel, specialSetPriceFrame);
                    specialSetPricePanel.add(Item1);
                    specialSetPricePanel.add(Item2);
                    specialSetPricePanel.add(Item3);
                    specialSetPricePanel.add(Item4);
                    specialSetPricePanel.add(Item5);
                    specialSetPricePanel.add(Item6);
                    specialSetPricePanel.add(Item7);
                    specialSetPricePanel.add(Item8);
            
                    specialSetPricePanel.add(Box.createVerticalGlue());
                    specialSetPricePanel.add(specialChooseItemSetPriceButton);
                    specialSetPricePanel.add(exitButton);

                    specialSetPriceFrame.getContentPane().removeAll();
                    specialSetPriceFrame.add(specialSetPricePanel, BorderLayout.CENTER);
                    specialSetPriceFrame.pack(); 
                    specialSetPriceFrame.setVisible(true);
                }

                else if (setPriceChoice == 1)
                {
                    specialSetPricePanel = new JPanel();
                    JFrame specialSetPriceFrame = new JFrame();
            
                    specialSetPricePanel.setLayout(new BoxLayout(specialSetPricePanel, BoxLayout.Y_AXIS));
                    JLabel restockMsg = new JLabel("Which item would you like to change the price of?");
                    specialSetPricePanel.add(restockMsg);
                    specialVendingMachine.displayToppingsWithCrustGUI(specialSetPricePanel, specialSetPriceFrame);
                    specialSetPricePanel.add(Item1);
                    specialSetPricePanel.add(Item2);
                    specialSetPricePanel.add(Item3);
                    specialSetPricePanel.add(Item4);
                    specialSetPricePanel.add(Item5);
                    specialSetPricePanel.add(Item6);
                    specialSetPricePanel.add(Item7);
                    specialSetPricePanel.add(Item8);
                    specialSetPricePanel.add(Item9);
                    specialSetPricePanel.add(Item10);
                    specialSetPricePanel.add(Item11);
            
                    specialSetPricePanel.add(Box.createVerticalGlue());
                    specialSetPricePanel.add(specialChooseSpecialItemSetPriceButton);
                    specialSetPricePanel.add(exitButton);

                    specialSetPriceFrame.getContentPane().removeAll();
                    specialSetPriceFrame.add(specialSetPricePanel, BorderLayout.CENTER);
                    specialSetPriceFrame.pack(); 
                    specialSetPriceFrame.setVisible(true);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No option selected.");
                }
            }
        });

        chooseItemSetPriceButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected()) 
                {
                    vendingMachine.changePrices(user, 0, setPricePanel);
                } 
                
                else if (Item2.isSelected()) 
                {
                    vendingMachine.changePrices(user, 1, setPricePanel);
                } 
                
                else if (Item3.isSelected()) 
                {
                    vendingMachine.changePrices(user, 2, setPricePanel);
                } 
                
                else if (Item4.isSelected()) 
                {
                    vendingMachine.changePrices(user, 3, setPricePanel);
                } 
                
                else if (Item5.isSelected()) 
                {
                    vendingMachine.changePrices(user, 4, setPricePanel);
                } 
                
                else if (Item6.isSelected()) 
                {
                    vendingMachine.changePrices(user, 5, setPricePanel);
                } 
                
                else if (Item7.isSelected()) 
                {
                    vendingMachine.changePrices(user, 6, setPricePanel);
                } 
                
                else if (Item8.isSelected()) 
                {
                    vendingMachine.changePrices(user, 7, setPricePanel);
                }       
            }
        });

        specialChooseItemSetPriceButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 0, specialSetPricePanel);
                } 
                
                else if (Item2.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 1, specialSetPricePanel);
                } 
                
                else if (Item3.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 2, specialSetPricePanel);
                } 
                
                else if (Item4.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 3, specialSetPricePanel);
                } 
                
                else if (Item5.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 4, specialSetPricePanel);
                } 
                
                else if (Item6.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 5, specialSetPricePanel);
                } 
                
                else if (Item7.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 6, specialSetPricePanel);
                } 
                
                else if (Item8.isSelected()) 
                {
                    specialVendingMachine.changePrices(user, 7, specialSetPricePanel);
                }
            }
        });

        specialChooseSpecialItemSetPriceButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 0, specialSetPricePanel);
                }

                else if (Item2.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 1, specialSetPricePanel);
                }

                else if (Item3.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 2, specialSetPricePanel);
                }

                else if (Item4.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 3, specialSetPricePanel);
                }

                else if (Item5.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 4, specialSetPricePanel);
                }

                else if (Item6.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 5, specialSetPricePanel);
                }
                
                else if (Item7.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 6, specialSetPricePanel);
                }

                else if (Item8.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 7, specialSetPricePanel);
                }

                else if (Item9.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 8, specialSetPricePanel);
                }

                else if (Item10.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 9, specialSetPricePanel);
                }

                else if (Item11.isSelected())
                {
                    specialVendingMachine.changeToppingPrice(user, 10, specialSetPricePanel);
                }
            }
        });

        collectMoneyButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                vendingMachine.collectMoney(user);
            }
        });

        specialCollectMoneyButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                specialVendingMachine.collectMoney(user);
            }
        });

        replenishMoneyButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                vendingMachine.replenishMoney();
            }
        });

        specialReplenishMoneyButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                specialVendingMachine.replenishMoney();
            }
        });

        printSummaryTransactionButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (vendingMachine.getTransactions().size() > 0)
                {
                    TransactionSummaryPanel = new JPanel();
                    JFrame transactionSummaryFrame = new JFrame("Transaction Summary");
                    TransactionSummaryPanel.setLayout(new BoxLayout(TransactionSummaryPanel, BoxLayout.X_AXIS));

                    transactionSummaryFrame.setSize(600, 600);
                    transactionSummaryFrame.setLocationRelativeTo(null); 
                    transactionSummaryFrame.setLayout(new BorderLayout());

                    startingInvText = new JTextArea();
                    transactionText = new JTextArea();
                    currentInvText = new JTextArea();

                    vendingMachine.computeTransactions(startingInvText, transactionText, currentInvText);
                    
                    TransactionSummaryPanel.add(new JScrollPane(startingInvText));
                    TransactionSummaryPanel.add(new JScrollPane(transactionText));
                    TransactionSummaryPanel.add(new JScrollPane(currentInvText));

                    transactionSummaryFrame.add(TransactionSummaryPanel, BorderLayout.WEST);
                    transactionSummaryFrame.setVisible(true);  
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No transactions have been made.");
                }
            }
        });

        specialPrintSummaryTransactionButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                String[] options = {"Summary of Regular Items", "Summary of Special Items"};

                int summaryChoice = JOptionPane.showOptionDialog(null, "Select summary type:", "Summary of Transactions", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                
                if (summaryChoice == 0)
                {
                    if (specialVendingMachine.getTransactions().size() > 0)
                    {
                        specialRegTransactionSummaryPanel = new JPanel();
                        JFrame specialRegTransactionSummaryFrame = new JFrame("Regular Item Transaction Summary");
                        specialRegTransactionSummaryPanel.setLayout(new BoxLayout(TransactionSummaryPanel, BoxLayout.X_AXIS));

                        specialRegTransactionSummaryFrame.setSize(600, 600);
                        specialRegTransactionSummaryFrame.setLocationRelativeTo(null); 
                        specialRegTransactionSummaryFrame.setLayout(new BorderLayout());

                        startingInvText = new JTextArea();
                        transactionText = new JTextArea();
                        currentInvText = new JTextArea();

                        specialVendingMachine.computeTransactions(startingInvText, transactionText, currentInvText);

                        specialRegTransactionSummaryPanel.add(new JScrollPane(startingInvText));
                        specialRegTransactionSummaryPanel.add(new JScrollPane(transactionText));
                        specialRegTransactionSummaryPanel.add(new JScrollPane(currentInvText));

                        specialRegTransactionSummaryFrame.add(specialRegTransactionSummaryPanel, BorderLayout.WEST);
                        specialRegTransactionSummaryFrame.setVisible(true);  
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "No transactions have been made.");
                    }
                }

                else if (summaryChoice == 1)
                {
                    if (specialVendingMachine.getSpecialTransactions().size() > 0)
                    {
                        specialTransactionSummaryPanel = new JPanel();
                        JFrame specialTransactionSummaryFrame = new JFrame("Special Item Transaction Summary");
                        specialTransactionSummaryPanel.setLayout(new BoxLayout(specialTransactionSummaryPanel, BoxLayout.X_AXIS));

                        specialTransactionSummaryFrame.setSize(725, 900);
                        specialTransactionSummaryFrame.setLocationRelativeTo(null); 
                        specialTransactionSummaryFrame.setLayout(new BorderLayout());

                        specialStartingInvText = new JTextArea();
                        specialTransactionText = new JTextArea();
                        specialToppingSummaryText = new JTextArea();
                        specialCurrentInvText = new JTextArea();

                        specialVendingMachine.computeToppingSummary(specialStartingInvText, specialTransactionText, specialToppingSummaryText, specialCurrentInvText);

                        specialTransactionSummaryPanel.add(new JScrollPane(specialStartingInvText));
                        specialTransactionSummaryPanel.add(new JScrollPane(specialTransactionText));
                        specialTransactionSummaryPanel.add(new JScrollPane(specialToppingSummaryText));
                        specialTransactionSummaryPanel.add(new JScrollPane(specialCurrentInvText));

                        specialTransactionSummaryFrame.add(specialTransactionSummaryPanel, BorderLayout.WEST);
                        specialTransactionSummaryFrame.setVisible(true);  
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "No option selected.");
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JPanel panelWithExitButton = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, (Component) e.getSource());
        
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(panelWithExitButton);
                parentFrame.dispose();
            }
        });
        
        purchaseItemButton.addActionListener(new ActionListener() 
        {        
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected())
                {
                    vendingMachine.purchaseItem(user, 0, displayyPanel);
                }

                else if (Item2.isSelected())
                {
                    vendingMachine.purchaseItem(user, 1, displayyPanel);
                }

                else if (Item3.isSelected())
                {
                    vendingMachine.purchaseItem(user, 2, displayyPanel);
                }

                else if (Item4.isSelected())
                {
                    vendingMachine.purchaseItem(user, 3, displayyPanel);
                }

                else if (Item5.isSelected())
                {
                    vendingMachine.purchaseItem(user, 4, displayyPanel);
                }

                else if (Item6.isSelected())
                {
                    vendingMachine.purchaseItem(user, 5, displayyPanel);
                }
                
                else if (Item7.isSelected())
                {
                    vendingMachine.purchaseItem(user, 6, displayyPanel);
                }

                else if (Item8.isSelected())
                {
                    vendingMachine.purchaseItem(user, 7, displayyPanel);
                }
            }
        });

        purchaseItemLoadButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (Item1.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 0, loadRegPanel);
                } 
                
                else if (Item2.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 1, loadRegPanel);
                } 
                
                else if (Item3.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 2, loadRegPanel);
                } 
                
                else if (Item4.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 3, loadRegPanel);
                } 
                
                else if (Item5.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 4, loadRegPanel);
                } 
                
                else if (Item6.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 5, loadRegPanel);
                } 
                
                else if (Item7.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 6, loadRegPanel);
                } 
                
                else if (Item8.isSelected()) 
                {
                    vendingMachine.purchaseItem(user, 7, loadRegPanel);
                }
            }
        });

        specialRegPurchaseButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Item1.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 0, specialDisplayPanel);
                } 
                
                else if (Item2.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 1, specialDisplayPanel);
                } 
                
                else if (Item3.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 2, specialDisplayPanel);
                } 
                
                else if (Item4.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 3, specialDisplayPanel);
                } 
                
                else if (Item5.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 4, specialDisplayPanel);
                } 
                
                else if (Item6.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 5, specialDisplayPanel);
                } 
                
                else if (Item7.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 6, specialDisplayPanel);
                } 
                
                else if (Item8.isSelected()) 
                {
                    specialVendingMachine.purchaseItem(user, 7, specialDisplayPanel);
                }                
            }
        });

        createSpecialMachineButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed (ActionEvent e)
            {
                if (specialVendingMachine == null)
                {
                    JFrame loadRegSpecialMachineFrame = new JFrame();
                    JFrame loadSpecialSpecialMachineFrame = new JFrame();

                    specialVendingMachine = new SpecialVendingMachine();

                    specialDisplayPanel = new JPanel();
                    specialDisplayPanel.setLayout(new BoxLayout(specialDisplayPanel, BoxLayout.Y_AXIS));

                    specialSpecialDisplayPanel = new JPanel();
                    specialSpecialDisplayPanel.setLayout(new BoxLayout(specialSpecialDisplayPanel, BoxLayout.Y_AXIS));

                    String[] options = {"Purchase Regular Item", "Purchase Special Item"};

                    int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Purchase Item Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (choice == 0) 
                    {
                        specialVendingMachine.displayItemsGUI(specialDisplayPanel, loadRegSpecialMachineFrame);

                        specialDisplayPanel.add(Item1);
                        specialDisplayPanel.add(Item2);
                        specialDisplayPanel.add(Item3);
                        specialDisplayPanel.add(Item4);
                        specialDisplayPanel.add(Item5);
                        specialDisplayPanel.add(Item6);
                        specialDisplayPanel.add(Item7);
                        specialDisplayPanel.add(Item8);

                        specialDisplayPanel.add(Box.createVerticalGlue());
                        specialDisplayPanel.add(specialRegPurchaseButton);
                        specialDisplayPanel.add(exitButton);

                        loadRegSpecialMachineFrame.getContentPane().removeAll();
                        loadRegSpecialMachineFrame.add(specialDisplayPanel, BorderLayout.CENTER);
                        loadRegSpecialMachineFrame.pack();
                        loadRegSpecialMachineFrame.setVisible(true);
                    } 
                    
                    else if (choice == 1) 
                    {
                        specialVendingMachine.purchaseSpecialItem(user, specialSpecialDisplayPanel, loadSpecialSpecialMachineFrame, exitButton);
                    } 
                    
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "No option selected.");
                    }
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "A Special Vending Machine has already been created!");
                }
            }
        });

        loadSpecialMachineButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed (ActionEvent e)
            {
                if (specialVendingMachine != null) 
                {
                    String[] options = {"Purchase Regular Item", "Purchase Special Item"};

                    int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Purchase Item Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    
                    if (choice == 0)
                    {
                        loadSpecialPanel = new JPanel();
                        specialLoadFrame = new JFrame();
                    
                        loadSpecialPanel.setLayout(new BoxLayout(loadSpecialPanel, BoxLayout.Y_AXIS));
    
                        specialVendingMachine.displayItemsGUI(loadSpecialPanel, specialLoadFrame);
                        loadSpecialPanel.add(Item1);
                        loadSpecialPanel.add(Item2);
                        loadSpecialPanel.add(Item3);
                        loadSpecialPanel.add(Item4);
                        loadSpecialPanel.add(Item5);
                        loadSpecialPanel.add(Item6);
                        loadSpecialPanel.add(Item7);
                        loadSpecialPanel.add(Item8);
            
                        loadSpecialPanel.add(Box.createVerticalGlue());
                        loadSpecialPanel.add(purchaseItemLoadButton);
                        loadSpecialPanel.add(exitButton);
                        
                        specialLoadFrame.getContentPane().removeAll();
                        specialLoadFrame.add(loadSpecialPanel, BorderLayout.CENTER);
                        specialLoadFrame.pack(); 
                        specialLoadFrame.setVisible(true);
                    }

                    else if (choice == 1) 
                    {
                        loadSpecialPanel = new JPanel();
                        specialLoadFrame = new JFrame();
                        loadSpecialPanel.setLayout(new BoxLayout(loadSpecialPanel, BoxLayout.Y_AXIS));
                        specialVendingMachine.purchaseSpecialItem(user, loadSpecialPanel, specialLoadFrame, exitButton);
                    } 
                
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "No option selected.");
                    }
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Special Vending Machine created.");
                }
            }
        });

        maintenanceSpecialMachineButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (specialVendingMachine != null)
                {
                    specialMaintenancePanel = new JPanel(new GridLayout(7, 1));
                    specialMFrame = new JFrame("Maintain Special Vending Machine");
                    specialMFrame.setSize(600, 600);
                    specialMFrame.setLocationRelativeTo(null);
                    specialMFrame.setLayout(new GridLayout(1, 6));
                    
                    specialMaintenancePanel.add(specialRestockButton);
                    specialMaintenancePanel.add(specialSetPriceButton);
                    specialMaintenancePanel.add(specialCollectMoneyButton);
                    specialMaintenancePanel.add(specialReplenishMoneyButton);
                    specialMaintenancePanel.add(specialPrintSummaryTransactionButton);

                    specialMFrame.add(specialMaintenancePanel);

                    specialMFrame.setVisible(true);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Special Vending Machine created.");
                }
            }
        });
        
       
        mainMenuPanel.add(createRegularMachineButton);
        mainMenuPanel.add(loadRegularMachineButton);
        mainMenuPanel.add(maintenanceRegularMachineButton);
        mainMenuPanel.add(createSpecialMachineButton);
        mainMenuPanel.add(loadSpecialMachineButton);
        mainMenuPanel.add(maintenanceSpecialMachineButton);
        mainMenuPanel.add(exitButton);

        add(mainMenuPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                VendingMachineGUI gui = new VendingMachineGUI();
                gui.setVisible(true);
            }
        });
    }
}
