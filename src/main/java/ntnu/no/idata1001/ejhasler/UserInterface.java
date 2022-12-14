package ntnu.no.idata1001.ejhasler;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Represent the main class of the Smart House application.
 * An object of this class is responsible for starting the application
 * and being the user interface (UI) for the application.
 * The class has been structured in terms of subtasks
 * to be performed. Hence, the following methods have been implemented:
 * <ul>
 *   <li><code>init()</code> - Is responsible for initialising the app-object,
 *                             by creating the internal Item Register-instance,
 *                             and filling the item register with dummies (for debug).
 *   </li>
 *   <li><code>start()</code> - Is the starting point of the application object.
 *                              After an instance of Item Register-class have
 *                              been created, this method should be called.
 *                              The start-method will then be in charge of running
 *                              the app until the user decides to quit.
 *   </li>
 * </ul>
 *
 * @since 2022-10-12
 * @version 09.12.2022
 * @author Candidate 10002
 */
public class UserInterface {
  // A class constant used to hold th version of the application.
  // Set too public to enable access from outside the class.
  public static final String VERSION = "v1.0";

  // The object handling the collection of items
  private ItemRegister itemRegister;

  private static final Scanner sc = new Scanner(System.in);

  // Constants used for the menu choice. Kept private, since
  // the items should always only be used internally in this class.
  private static final int ADD_ITEM = 1;
  private static final int SEARCH_FOR_ITEMS = 2;
  private static final int SEARCH_FOR_ITEMS_DESCRIPTION = 3;
  private static final int CHANGE_PRICE_OF_ITEM = 4;
  private static final int CHANGE_DISCOUNT_OF_ITEM = 5;
  private static final int CHANGE_ITEM_DESCRIPTION = 6;
  private static final int CHANGE_AMOUNT_OF_ITEM = 7;
  private static final int DELETE_ITEM = 8;
  private static final int LIST_ALL_ITEMS = 9;
  private static final int EXIT = 10;

  /**
   * Creates an instance of ItemRegisterUI.
   *
   * @see #main(String[])
   */
  public UserInterface() {
    this.itemRegister = new ItemRegister();
  }

  /**
   * Initializes the application. This method fill the
   * Item Register with default items, used to test the robustness
   * and functionality of the application.
   * Must be called prior {@code start()}
   */
  private void init() {
    // Initialise instances variables
    this.fillInventory();
  }

  /**
   * Displays the menu for the user, followed by awaiting the menu choice
   * chose by the user, which is then returned. The choice by the user
   * is returned as a positive number from 1 to 9.
   *
   * <p> If the user inputs an invalid choice, 0 is returned.</p>
   *
   * @return the menu choice of the user as an integer between 1 and 9.
   *         If the user has entered an invalid choice, 0 is returned.
   */
  private int showMenu() {
    int userChoice = 0;

    System.out.println("\n**** Smart Home Application v1.0 ***" + VERSION + "****\n");
    System.out.println("========================================================");
    System.out.println("1. Add new item to the Item Register.");
    System.out.println("2. Search for items by item number.");
    System.out.println("3. Search for items by item description.");
    System.out.println("4. Change the price on the item.");
    System.out.println("5. Change the discount on the item.");
    System.out.println("6. Change the description on the item.");
    System.out.println("7. Change the amount on the selected item");
    System.out.println("8. Delete item from the Item Register.");
    System.out.println("9. List all the items inside the Item Register.");
    System.out.println("10. EXIT the application.");

    Scanner input = new Scanner(System.in);

    // Make sure that the user did input and an int
    if (input.hasNextInt()) {
      userChoice = input.nextInt(); // Make sure to empty the input buffer.
    } else {
      // If the input given by the user cannot be interpreted as an int,
      // a message is printed to the user.
      System.err.println("Sorry, you seem to have entered a invalid input."
          + "\nYou must enter a number between 1 and 9");
    }
    return userChoice;
  }

  /**
   * "Starts" the application, by representing a menu for the user.
   * The user can choose from the menu, and for each choice,
   * a task is performed, and the menu is displayed again.
   *
   * <p>When the user wants to terminate/exit the application,
   * he/she chooses the Exit-alternative in the menu, and the
   * application terminates.</p>
   */
  public void start() {
    boolean finished = false;

    // The while-loop will run as long as the user has not selected
    // to quit the application.
    while (!finished) {
      // Receive the selected menu from the user.
      int menuChoice = this.showMenu();

      switch (menuChoice) {
        case ADD_ITEM -> addItem();
        case SEARCH_FOR_ITEMS -> findItemByItemNumber();
        case SEARCH_FOR_ITEMS_DESCRIPTION -> findItemByDescription();
        case CHANGE_PRICE_OF_ITEM -> changePriceOfItem();
        case CHANGE_DISCOUNT_OF_ITEM -> changeDiscountOfItem();
        case CHANGE_ITEM_DESCRIPTION -> changeItemDescription();
        case CHANGE_AMOUNT_OF_ITEM -> changeAmountOfItem();
        case DELETE_ITEM -> deleteItem();
        case LIST_ALL_ITEMS -> listAllItems();
        case EXIT -> {
          System.out.println("Thank you for using the Smart Home App!");
          finished = true;
        }
        default -> System.err.print("\nPlease try again");
      }
    }
  }

  // The methods below are "delegates", I.e. methods having been delegated
  // work by the main loop.

  /**
   * Executes the "Add item" menu choice.
   *
   * <p> Requests necessary information from the user to be able
   * to create a new item which is added to the item register. </p>
   */
  private void addItem() {
    // Local variables used to gather the necessary information
    // to be able to create an Item instance.
    String itemNr = "";
    String itemDescription = "";
    double itemWeight = 0.0;
    double itemLength = 0.0;
    double itemHeight = 0.0;
    int itemPrice = 0;
    int itemAmount = 0;
    int itemCategory = 0;

    System.out.println("ADD NEW ITEM TO THE REGISTER");

    // Get item number
    do {
      System.out.println("Please enter item number: ");
        itemNr = sc.nextLine().trim();
    } while (!validateStringInput(itemNr));

    // Get item description
    do {
      System.out.println("Please enter item description: ");
      itemDescription = sc.nextLine().trim();
    } while (!validateStringInput(itemDescription));

    String itemColor = "";
    // Get item color
    do {
      System.out.println("Please enter item color: ");
      itemColor = sc.nextLine().trim();
    } while (!validateStringInput(itemColor));

    String itemBrand = "";
    // Get item brand
    do {
      System.out.println("Please enter item brand: ");
      itemBrand = sc.nextLine().trim();
    } while (!validateStringInput(itemBrand));

    // Get item weight
    boolean validInput = false;
    do {
      System.out.println("Please enter item weight: ");
      if (sc.hasNextInt()) {
        itemWeight = sc.nextInt();

        validInput = validateDoubleInput(itemWeight, 0, Double.MAX_VALUE);
        sc.nextLine();
      } else {
        System.out.println("You have not entered a positive number.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);

    // Get item length
    validInput = false;
    do {
      System.out.println("Please enter item length: ");
      if (sc.hasNextInt()) {
        itemLength = sc.nextInt();

        validInput = validateDoubleInput(itemLength, 0, Double.MAX_VALUE);
        sc.nextLine();
      } else {
        System.out.println("You have not entered a positive number.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);

    // Get item height
    validInput = false;
    do {
      System.out.println("Please enter item height: ");
      if (sc.hasNextInt()) {
        itemHeight = sc.nextInt();

        validInput = validateDoubleInput(itemHeight, 0, Double.MAX_VALUE);
        sc.nextLine();
      } else {
        System.out.println("You have not entered a positive number.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);

    // Get item price
    validInput = false;
    do {
      System.out.println("Please enter item price: ");
      if (sc.hasNextInt()) {
        itemPrice = sc.nextInt();

        validInput = validateIntInput(itemPrice, 0, Integer.MAX_VALUE);
        sc.nextLine();
      } else {
        System.out.println("You have not entered a positive number.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);


    // Get item amount
    validInput = false;
    do {
      System.out.println("Please enter item amount: ");
      if (sc.hasNextInt()) {
        itemAmount = sc.nextInt();

        validInput = validateIntInput(itemAmount, 0, Integer.MAX_VALUE);
        sc.nextLine();
      } else {
        System.out.println("You have not entered a positive number.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);

    // Get item category
    validInput = false;
    do {
      System.out.println("Please enter item category: ");
      if (sc.hasNextInt()) {
        itemCategory = sc.nextInt();
        // Check the input
        validInput = validateIntInput(itemCategory, 1, 4);
        // Empty the Scanner
        sc.nextLine();
      } else {
        System.out.println("You must enter a number between 1 and 4.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!validInput);

    // Create an object of the item and add it to the register.
    Item item = new Item(itemNr, itemDescription, itemColor, itemBrand,
                          itemWeight, itemLength, itemHeight, itemPrice,
                          itemAmount, itemCategory);
    this.itemRegister.insertItem(item);

      System.out.println("The item with the number " + item.getItemNr()
          + " has been added to the register.");
  }

  /**
   * Executes the "List all items" menu choice, by
   * printing all items to the console window.
   *
   * <p>This method is using <b>Iterator</b> and
   * <b>while</b> loop, so the iterator from the
   * item register instead of retrieving the entire
   * HashMap makes the ItemRegisterUI and the ItemRegister
   * class have much <b>looser coupling</b></p>
   */
  private void listAllItems() {
    System.out.println("List of the items in the Smart Home: \n");

    Iterator<Item> it = this.itemRegister.getIterator();

    System.out.printf("%-10s  %-10s  %-10s  %-30s  %-10s  %-10s   %-10s  %-10s  %-10s  %-10s%n",
        "Item Number", "Description", "Color", "Brand", "Weight", "Length",
        "Height", "Price", "Amount", "Category");
    System.out.println("-------------------------------------------------------------------"
        + "----------------------------------------------------------------------------");

    while (it.hasNext()) {
      Item item = it.next();

      System.out.printf("%-10s  %-10s  %-10s  %-30s  %-10s  %-10s   %-10s  %-10s  %-10s  %-10s%n",
                        item.getItemNr(), item.getItemDescription(), item.getItemColor(),
                        item.getItemBrand(), item.getItemWeight(), item.getItemLength(),
                        item.getItemHeight(), item.getItemPrice(), item.getItemAmount(),
                        item.getItemCategory());
      System.out.println();
    }
  }

  /**
   * Executes the "Search for items" menu choice by
   * searching items with item number.
   */
  private Item findItemByItemNumber() {
    Item foundItem = null;
    System.out.println("Search item by item number:");

    System.out.println("Please enter the item number to search for:");

    String itemNr = sc.nextLine();

    if (itemNr.isEmpty()) {
      System.out.println("The item number entered was empty. Search canceled.");
    } else {
      foundItem = this.itemRegister.searchItemByItemNumber(itemNr);
      if (null == foundItem) {
        System.out.println("No item was found matching the item number: " + itemNr);
      } else {
        System.out.println("The following item was found matching the item number: " + itemNr);
        this.printAllItemsDetails(foundItem);
      }
    }
    return foundItem;
  }

  /**
   * Executes the "Search for item" menu choice by
   * searching items with item description. The user will
   * be asked for the item number of the item to search for.
   * The item found is also returned by this method.
   *
   * @return the item matching the item number,
   *         or {@code null} if no book was found
   */
  private Item findItemByDescription() {
    // Selects the item chosen to change description
    Item foundItem = null;
    System.out.println("Search item by description:");

    System.out.println("Please enter the title to search for:");

    String itemDescription = sc.nextLine();

    if (itemDescription.isEmpty()) {
      System.out.println("The description entered was empty. Search canceled.");
    } else {
      foundItem = this.itemRegister.searchItemByDescription(itemDescription);
      if (null == foundItem) {
        System.out.println("No book was found matching the title: " + itemDescription);
      } else {
        System.out.println("The following book was found matching the title: " + itemDescription);
        this.printAllItemsDetails(foundItem);
      }
    }
    return foundItem;
  }

  /**
   * Executes the "Change price of item" menu choice by
   * selecting the item first by searching after it. When
   * selected the item by item number, the method lets the
   * user change the item price value.
   *
   * @throws NullPointerException if the input is not valid.
   */
  private void changePriceOfItem() {
    System.out.println("Select item (Change price): ");

    // Prompt the user for an item number until a valid one is entered
    String itemNr;
    Item itemFound = null;
    do {
      itemNr = sc.nextLine();
      itemFound = this.itemRegister.searchItemByItemNumber(itemNr);
      if (itemFound == null) {
        System.out.println("No item in the register!"
                            + "\nTry again: ");
      }
    } while (itemFound == null);

    // Print all the item's details and prompt the user for a new price
    printAllItemsDetails(itemFound);
    System.out.println("You are changing value on the following item: " + itemNr);
    System.out.println("\nNew price: ");
    String input = sc.nextLine();

    // Parse the user's input and ensure it is a positive integer
    int newPrice = 0;
    try {
      newPrice = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      System.err.println("Please enter a valid number (Integer)");
    }
    if (newPrice < 0) {
      System.err.println("Please enter a positive number (Integer)");
    }
    itemRegister.changePriceItem(newPrice);
    System.out.println("\nPrice set to " + newPrice + ".");
  }

  /**
   * Executes the "Change discount of item" menu choice by
   * selecting an item by item number. Then the user can change
   * the discount of the item.
   *
   * @throws NumberFormatException if the input is invalid.
   */
  private void changeDiscountOfItem() {
    System.out.println("Select item (Change Discount): ");

    // Prompt the user for an item number until a valid one is entered
    String itemNr;
    Item itemFound = null;
    do {
      itemNr = sc.nextLine();
      itemFound = this.itemRegister.searchItemByItemNumber(itemNr);
      if (itemFound == null) {
        System.out.println("No item in the register!");
      }
    } while (itemFound == null);

    // Print the item's details and prompt the user for a new discount
    printAllItemsDetails(itemFound);
    System.out.println("You are adding discount on the following item: " + itemNr);
    System.out.println("Add the discount: ");
    String input = sc.nextLine();

    int discount = 0;
    try {
      discount = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number. Start over!");
    }
    if (discount < 0 || discount > 100) {
      System.err.println("Please enter a number between 0 and 100");
    }

    double remainder = 100 - discount;
    int newPrice = (int) (itemRegister.getCurrentItem().getItemPrice() * (remainder / 100));
    itemRegister.getCurrentItem().setItemPrice(newPrice);
    System.out.println("\nPrice set to " + newPrice + ".");
  }

  /**
   * Executes the "Change item description" on the menu choice
   * by selecting an item first by item number. Then the user
   * can change the item description, where the user can see
   * both the old description and the new one after changed
   * description.
   *
   * @throws NullPointerException if the input is invalid.
   */
  private void changeItemDescription() {
    // Selects the chosen item
    System.out.println("Select an item you want to do changes: ");
    boolean valid;

    // Prompt the user for an item number until a valid one is entered
    String itemNr;
    Item itemFound = null;
    do {
      itemNr = sc.nextLine().trim();
      itemFound = this.itemRegister.searchItemByItemNumber(itemNr);
      if (itemFound == null) {
        valid = false;
        System.out.println("No item in the register");
      }
    } while (itemFound == null);
    // Print the item's details and prompt the user for the operation to perform
    printAllItemsDetails(itemFound);
    System.out.println("You are changing the description on the following item: " + itemNr);
    valid = false;
    String newDescription;
    do {
      System.out.println("Enter the new description: ");
      newDescription = sc.nextLine().trim();
    } while (!validateStringInput(newDescription));

    itemRegister.changeItemDescription(newDescription);
    System.out.println("The item description is changed to: " + newDescription);
  }

  /**
   * Executes the "change amount of item" menu choice
   * by asking if the user want to decrease, increase or none.
   *
   * @throws NumberFormatException if the input value is invalid.
   */
  private void changeAmountOfItem() {
    // Selects the chosen item
    System.out.println("Select the item (Change amount): ");
    boolean valid;

    // Prompt the user for an item number until a valid one is entered
    int value = 0;
    String itemNr;
    Item itemFound = null;
    do {
      itemNr = sc.nextLine().trim();
      itemFound = this.itemRegister.searchItemByItemNumber(itemNr);
      if (itemFound == null) {
        valid = false;
        System.out.println("No item in the register");
      }
    } while (itemFound == null);
    String operation;
    // Print the item's details and prompt the user for the operation to perform
    printAllItemsDetails(itemFound);
    System.out.println("You are changing the description on the following item: " + itemNr);
    do {
      System.out.println("Do you want to decrease, increase or do nothing with item? (d/i/none): ");
      operation = sc.nextLine().trim();
    } while (!validateStringInput(operation));
    // Prompt the user for the value to be added or subtracted from the item's amount
    valid = false;
    do {
      System.out.println("Enter the value: ");
      if (sc.hasNextInt()) {
        value = Integer.parseInt(sc.nextLine());
        valid = validateIntInput(value, 0, Integer.MAX_VALUE);
      } else {
        System.out.println("Number must be positive.");
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    } while (!valid);
    // Calculate the new item amount based on the user's input and print a
    // confirmation message
    int currentAmount = itemRegister.getCurrentItem().getItemAmount();
    if ("d".equalsIgnoreCase(operation)) {
      int newDecreaseAmount = currentAmount - value;
      itemRegister.changeItemAmount(newDecreaseAmount);
      System.out.println("\nItem amount decreased by " + value + ".");
      System.out.println("\nItem amount as changed to " + newDecreaseAmount + ".");
    } else if ("i".equalsIgnoreCase(operation)) {
      int newIncreaseAmount = currentAmount + value;
      itemRegister.changeItemAmount(newIncreaseAmount);
      System.out.println("\nItem amount was increased by " + value + ".");
      System.out.println("\nItem amount was changed to " + newIncreaseAmount + ".");
    } else if ("none".equalsIgnoreCase(operation)) {
      System.out.println("No changes have been done. Returned to main page.");
      showMenu();
    } else {
      System.out.println("You must increase, decrease or choose none!");
    }
  }

  /**
   * Executes "Delete item" menu choice by selecting
   * item by the item number. If the item is not found
   * in the register, the user is notified accordingly.
   * If the item is found, the item is deleted from the
   * registry and the user is notified accordingly.
   *
   * @throws NullPointerException if the input value is invalid.
   */
  private void deleteItem() {
    // Selects the chosen item to remove
    System.out.println("Delete item:");

    System.out.println("Please enter the item number of the item to delete:");

    String itemNr = sc.nextLine();

    if (itemNr.isEmpty()) {
      System.out.println("The item number entered was empty. Delete canceled.");
    } else {
      Item foundItem = this.itemRegister.searchItemByItemNumber(itemNr);
      if (null == foundItem) {
        System.out.println("No item was found matching the item number: " + itemNr);
      } else {
        System.out.println("The following item was found matching the item number: " + itemNr);
        this.printAllItemsDetails(foundItem);
        System.out.println("Do you want to delete this item (Y/N) ?");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
          if (itemRegister.deleteItem(foundItem)) {
            System.out.println("The item was deleted successfully.");
          } else {
            System.out.println("Something went wrong. The item was not deleted.");
          }
        } else {
          System.out.println("Ok, the item will remain in the register.");
        }
      }
    }
  }

  /**
   * Prints all the info needed about an item to the console.
   *
   * @param item items in the item register.
   */
  private void printAllItemsDetails(Item item) {
    // Use String.format() to print the details of the item in a well-formatted
    // manner
    System.out.println("\nItem number       : " + item.getItemNr());
    System.out.println("\nItem description  : " + item.getItemDescription());
    System.out.println("\nItem color        : " + item.getItemColor());
    System.out.println("\nItem brand        : " + item.getItemBrand());
    System.out.println("\nItem weight       : " + item.getItemWeight());
    System.out.println("\nItem length       : " + item.getItemLength());
    System.out.println("\nItem height       : " + item.getItemHeight());
    System.out.println("\nItem price        : " + item.getItemPrice());
    System.out.println("\nItem amount       : " + item.getItemAmount());
    System.out.println("\nItem category     : " + item.getItemCategory());
    System.out.println();
  }

  /**
   * Checks for a valid input string. A string is valid if the length
   * of the trimmed string is larger than 0.
   *
   * @param inputString the string to validate
   * @return <code>true</code> if the inputString is valid. <code>false</code> if not valid
   */
  private boolean validateStringInput(String inputString) {
    boolean validString = false;
    if (inputString.trim().length() == 0) {
      System.out.println("Text cannot be empty, please try again..");
    } else {
      validString = true;
    }
    return validString;
  }

  /**
   * Returns <code>true</code> if the int value is within the range defined by
   * the parameters <code>min</code> and <code>max</code>.
   *
   * @param value the value to be checked
   * @param min minimum value allowed (inclusive)
   * @param max maximum value allowed (inclusive)
   * @return <code>true</code> if value is within the
   *         min.max range. <code>false</code> if not within the range.
   */
  private boolean validateIntInput(int value, int min, int max) {
    boolean validInt = false;
    if ((value < min) || (value > max)) {
      System.out.println("The value must be between "
          + min + " and " + max + ". Please try again...");
    } else {
      validInt = true;
    }
    return validInt;
  }

  /**
   * Returns <code>true</code> if double value is within the range defined
   * by the parameters <code>min</code> and <code>max</code>.
   *
   * @param value the value to be checked
   * @param min minimum value allowed (inclusive)
   * @param max maximum value allowed (inclusive)
   * @return <code>true</code> if value is within the min.max range.
   *         <code>false</code> if not within the range.
   */
  private boolean validateDoubleInput(double value, double min, double max) {
    boolean validInt = false;
    if ((value < min) || (value > max)) {
      System.out.println("The value must be between "
          + min + " and " + max + ". Please try again...");
    } else {
      validInt = true;
    }
    return validInt;
  }

  private boolean uniqueItemNr(String value){
    boolean validString = false;
    String itemNr = "";
    if(itemNr == itemRegister.getCurrentItem().getItemNr()){
      System.out.println("The item number must be unique!");
      validString = false;
    } else {
      validString = true;
    }
    return validString;
  }

  /**
   * Fill up the inventory in the item register
   * so that we can use dummy data to check the robustness of
   * the program.
   */
  public void fillInventory() {
    this.itemRegister.insertItem(new Item("1D2", "Dørhåndtak", "Brun", "Bygg", 5,
                                          0.23, 0.2, 100, 20, 4));
    this.itemRegister.insertItem(new Item("2A1", "Gulv", "Grå", "Glass Fabrikk", 50,
                                          1.5, 2.3, 500, 50, 2));
    this.itemRegister.insertItem(new Item("3D1", "Dør", "Brun", "Maxbo", 70,
                                          2.1, 2.7, 1000, 100, 1));
  }

  /**
   * The main starting point of the application. The operating system
   * of the computer expects to find a publicly available method it can call
   * without having to create objects firs
   *
   * <p> This method is standardized across languages and operating systems
   * and must have the signature below. </p>
   *
   * @param args args an fixed array of strings holding arguments provided
   *             from the command line during the startup of the application.
   *             In this appliation, args is no being used, and can be ignored.
   */
  public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();

    userInterface.init();
    userInterface.start();
  }
}
