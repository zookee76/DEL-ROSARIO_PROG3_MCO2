import javax.swing.JOptionPane;

/**
 * Class for the User which mainly contains methods concerning the manipulation of the user's wallet.
 */
public class User
{ 
    private int[] userWallet;
    
    /**
     * Constructor for the User class which initializes the user's wallet.
     */
    public User() 
    {
        userWallet = new int[3];
        userWallet[0] = 50; // 1 peso
        userWallet[1] = 50; // 5 pesos
        userWallet[2] = 50; // 10 pesos
    }
    
    /**
     * Getter for the user's wallet.
     * @return the user wallet.
     */
    public int[] getUserWallet() 
    {
        return userWallet;
    }

    /**
     * Setter for an individual user wallet.
     * @param index is the index of wallet to be manipulated.
     * @param value is the value to be added to wallet.
     */
    public void setIndivUserWallet(int index, int value) 
    {
        if (index >= 0 && index < userWallet.length) 
        {
            userWallet[index] += value;
        }
    }

    /**
     * Setter for the whole user wallet.
     * @param userWallet is the user wallet.
     */
    public void setUserWallet(int[] userWallet) 
    {
        this.userWallet = userWallet;
    }

    /**
     * Method which deducts money from the user's wallet
     * @param denomination is which denomination to deduct from the user's wallet.
     * @param quantity is how much of that denomination to deduct from the user's wallet.
     * @return 1.
     */
    public int takeCoins(int denomination, int quantity) 
    {
        if (denomination == 1 && userWallet[0] >= quantity) 
        {
            userWallet[0] -= quantity;
        } 
        
        else if (denomination == 5 && userWallet[1] >= quantity) 
        {
            userWallet[1] -= quantity;
        } 
        
        else if (denomination == 10 && userWallet[2] >= quantity) 
        {
            userWallet[2] -= quantity;
        } 
        
        else 
        {
            System.out.println("Insufficient coins!");
            return 0;
        }

        return 1;
    }
    
    /**
     * Method which adds money to the user's wallet.
     * @param denomination is which denomination to add to the user's wallet.
     * @param quantity is how much quantity to add to the user's wallet.
     */
    public void addCoinsToWallet(int denomination, int quantity) 
    {
        if (denomination == 1) 
        {
            userWallet[0] += quantity;
        } 
        
        else if (denomination == 5) 
        {
            userWallet[1] += quantity;
        } 
        
        else if (denomination == 10) 
        {
            userWallet[2] += quantity;
        }
    }

    /**
     * Method to display the user's wallet.
     */
    public void displayUserWallet() 
    {
        StringBuilder userWalletInfo = new StringBuilder();
        userWalletInfo.append("\nUser Wallet:\n");
        userWalletInfo.append("1 Peso: ").append(userWallet[0]).append("\n");
        userWalletInfo.append("5 Pesos: ").append(userWallet[1]).append("\n");
        userWalletInfo.append("10 Pesos: ").append(userWallet[2]).append("\n");

        int totalCash = (userWallet[0] * 1) + (userWallet[1] * 5) + (userWallet[2] * 10);
        userWalletInfo.append("Total Pesos: ").append(totalCash).append("\n");

        JOptionPane.showMessageDialog(null, userWalletInfo);
    }

}