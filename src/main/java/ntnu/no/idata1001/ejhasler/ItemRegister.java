package ntnu.no.idata1001.ejhasler;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Responsible for holding all my items.
 *
 * <p>The item register is accessible through the
 * item register user interface (UI) and is
 * the only class to have direct access to Item class,
 * which makes checks the requirements with
 * <b>loose coupling</b></p>
 *
 * @since 2022-10-12
 * @version 09.12.2022
 * @author Candidate 10002
 */
public class ItemRegister {
  // Holds the collection/map of the items
  private HashMap<String, Item> items;
  private Item currentItem;


  /**
   * Creates an instance of item register and sets
   * the current item to null.
   */
  public ItemRegister() {
    // Create an HashMap-instance
    this.items = new HashMap<>();
    this.currentItem = null;
  }

  /**
   * Gives access to the Item which is currently
   * stored or accessed.
   * Makes it easier to handle the different operations.
   *
   * @return the current item the user have chosen.
   */
  public Item getCurrentItem() {
    return this.currentItem;
  }

  /**
   * List out all the items in the item register.
   *
   * @return all the items.
   */
  public int listAllItems() {
    return items.size();
  }

  /**
   * Searches for the item by the item description in the
   * Item Register and assign as <code>currentItem</code>.
   *
   * @param description The description of the item.
   * @return return the item searched for
   */
  public Item searchItemByDescription(String description) {
    Item foundItems = null;

    Iterator<Item> it = this.items.values().iterator();
    boolean searching = true;

    while (it.hasNext() && searching) {
      Item item = it.next();
      if (description.equals(item.getItemDescription())) {
        foundItems = item;
        searching = false;
      }
    }
    return foundItems;
  }

  /**
   * Returns the first item found in the item
   * register matching the item number by the
   * parameter.
   *
   * @param itemNr the item number of the item to find.
   * @return return the <code>currentItem</code>
   *         matching the item number searched for.
   */
  public Item searchItemByItemNumber(String itemNr) {
    currentItem = null;

    currentItem = this.items.get(itemNr);
    return currentItem;
  }

  /**
   * Adds an item to the item register based
   * on the item number.
   *
   * @param item the item containing the necessary fields.
   * @return success if the item got added successfully.
   */
  public boolean insertItem(Item item) {
    if (null == item) {
      return false;
    }

    if (this.items.containsKey(item.getItemNr())) {
      System.out.print("Must be a unique item number");
      return false;
    }
    this.items.put(item.getItemNr(), item);
    return true;
  }

  /**
   * Deletes the item given by the parameter, from the register.
   * If the item was deleted successfully, {@code true} is returned.
   *
   * @param item The item to delete form the register
   * @return {@code true} if the item was deleted successfully,
   *         {@code false} if not.
   */
  public boolean deleteItem(Item item)  {
    boolean success = false;
    if (null == items.remove(item.getItemNr())) {
      success = false;
    } else {
      success = true;
    }
    return success;
  }

  /**
   * Changes the price of the item in the
   * item register.
   *
   * @param price the price of the item to
   *              change.
   */
  public void changePriceItem(int price) {
    if (currentItem != null) {
      currentItem.setItemPrice(price);
    }
  }

  /**
   * Changes the item description of the current item.
   *
   * @param description the description of the item.
   */
  public void changeItemDescription(String description) {
    if (currentItem != null) {
      currentItem.setItemDescription(description);
    }
  }

  /**
   * Changes the item amount of the current item, that
   * is in the item register.
   */
  public void changeItemAmount(int amount) {
    if (currentItem != null) {
      currentItem.setItemAmount(amount);
    }
  }

  /**
   * Returns the Iterator to the collection of contacts.
   *
   * <p>This gives us a looser coupling between
   * <class>ItemRegisterUI</class> and <class>ItemRegister</class>.</p>
   *
   * @return the iterator to the collection of items.
   */
  public Iterator<Item> getIterator() {
    return this.items.values().iterator();
  }
}
