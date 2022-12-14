package ntnu.no.idata1001.ejhasler;

import java.util.Objects;

/**
 * Represent an item in the item register, where it contains information
 * that is needed to describe an item. The items are using accessors and
 * mutators to set and get the value of the private fields.
 *
 * @since 2022-10-12
 * @version 09.12.2022
 * @author Candidate 10002
 */
public class Item {

  /*Consist of letters and numbers*/
  private String itemNr;
  /*Description of the item*/
  private String itemDescription;
  /*Color of the item*/
  private String itemColor;
  /*Consist of which brand*/
  private String itemBrand;
  /*Weight in kilograms*/
  private double itemWeight;
  /*Length of the item*/
  private double itemLength;
  /*Height of the item*/
  private double itemHeight;
  /*Price of the item*/
  private int itemPrice;
  /*Amount of items in the storage*/
  private int itemAmount;
  /*Category of the item*/
  private int itemCategory;

  // Use static final variables to define the itemCategory values.
  public static final int FLOOR_LAMINATION = 1;
  public static final int WINDOWS = 2;
  public static final int DOORS = 3;
  public static final int WOOD_LOAD = 4;

  /**
   * Creates an instance of an Item.
   *
   * @param itemNr          the unique number of the item (e.g., "234R8")
   * @param itemDescription the description of the item (e.g., "This is a glass window")
   * @param itemColor       the color of the item (e.g., "Red")
   * @param itemBrand       the brand name of the item (e.g., "Hunton")
   * @param itemWeight      the weight of the item in kilograms (measured in kilogram)
   * @param itemLength      the length of the item (measured in meters)
   * @param itemHeight      the height of the item (measured in meters)
   * @param itemPrice       the price of the item (measured in kroner)
   * @param itemAmount      the amount of items in the storage (e.g., 59)
   * @param itemCategory    the category of the item (e.g., "Windows")
   */
  public Item(String itemNr, String itemDescription, String itemColor, String itemBrand,
              double itemWeight, double itemLength, double itemHeight, int itemPrice,
              int itemAmount,
              int itemCategory) {
    setItemNr(itemNr);
    setItemDescription(itemDescription);
    setItemColor(itemColor);
    setItemBrand(itemBrand);
    setItemWeight(itemWeight);
    setItemLength(itemLength);
    setItemHeight(itemHeight);
    setItemPrice(itemPrice);
    setItemAmount(itemAmount);
    setItemCategory(itemCategory);
  }

  // Gets the different fields

  /**
   * Returns an item number object that is unique.
   *
   * @return the itemNr of the item
   */
  public String getItemNr() {
    return this.itemNr;
  }

  /**
   * Returns the itemDescription of the item.
   *
   * @return the itemDescription of the item
   */
  public String getItemDescription() {
    return this.itemDescription;
  }

  /**
   * Returns the itemColor of the item.
   *
   * @return the itemColor of the item
   */
  public String getItemColor() {
    return this.itemColor;
  }

  /**
   * Returns the itemBrand of the item.
   *
   * @return the itemBrand of the item
   */
  public String getItemBrand() {
    return this.itemBrand;
  }

  /**
   * Returns the itemWeight of the item.
   *
   * @return the itemWeight of the item
   */
  public double getItemWeight() {
    return this.itemWeight;
  }

  /**
   * Returns the itemLength of the item.
   *
   * @return the itemLength of the item
   */
  public double getItemLength() {
    return this.itemLength;
  }

  /**
   * Returns the itemHeight of the item.
   *
   * @return the itemHeight of the item
   */
  public double getItemHeight() {
    return this.itemHeight;
  }

  /**
   * Returns the itemPrice of the item.
   *
   * @return the itemPrice of the item
   */
  public int getItemPrice() {
    return this.itemPrice;
  }

  /**
   * Returns the itemAmount of the item.
   *
   * @return the itemAmount of the item
   */
  public int getItemAmount() {
    return this.itemAmount;
  }

  /**
   * Returns the itemCategory of the item.
   *
   * @return the itemCategory of the item
   */
  public int getItemCategory() {
    return this.itemCategory;
  }

  // Sets the different fields

  /**
   * Set the unique number of an item.
   *
   * @param itemNr the unique number of an item.
   */
  public void setItemNr(String itemNr) {
    checkFields(itemNr, "itemNr");
    this.itemNr = itemNr;
  }

  /**
   * Set the itemDescription of an item.
   *
   * @param itemDescription the itemDescription of an item
   */
  public void setItemDescription(String itemDescription) {
    checkFields(itemDescription, "itemDescription");
    this.itemDescription = itemDescription;
  }

  /**
   * Set the itemColor of an item.
   *
   * @param itemColor the itemColor of an item
   */
  public void setItemColor(String itemColor) {
    checkFields(itemColor, "itemColor");
    this.itemColor = itemColor;
  }

  /**
   * Set the itemBrand of an item.
   *
   * @param itemBrand the itemBrand of an item
   */
  public void setItemBrand(String itemBrand) {
    checkFields(itemBrand, "itemBrand");
    this.itemBrand = itemBrand;
  }

  /**
   * Set the itemWeight of an item.
   *
   * @param itemWeight the itemWeight of an item
   */
  public void setItemWeight(double itemWeight) {
    checkFields(itemWeight + "", "itemWeight");
    this.itemWeight = itemWeight;
  }

  /**
   * Set the itemLength of an item.
   *
   * @param itemLength the itemLength of an item.
   */
  public void setItemLength(double itemLength) {
    checkFields(itemLength + "", "itemLength");
    this.itemLength = itemLength;
  }

  /**
   * Set the itemHeight of an item.
   *
   * @param itemHeight the itemHeight of an item
   */
  public void setItemHeight(double itemHeight) {
    checkFields(itemHeight + "", "itemHeight");
    this.itemHeight = itemHeight;
  }

  /**
   * Set itemPrice of an item.
   *
   * @param itemPrice the itemPrice for an item
   */
  public void setItemPrice(int itemPrice) {
    checkFields(itemPrice + "", "itemPrice");
    this.itemPrice = itemPrice;
  }

  /**
   * Set the itemAmount for an item.
   *
   * @param itemAmount the itemAmount for an item
   * @throws IllegalArgumentException if the itemAmount is negative
   */
  public void setItemAmount(int itemAmount) {
    checkFields(itemAmount + "", "itemAmount");
    this.itemAmount = itemAmount;
  }

  /**
   * Set itemCategory for an item.
   *
   * @param itemCategory the itemCategory for an item
   */
  public void setItemCategory(int itemCategory) {
    switch (itemCategory) {
      case FLOOR_LAMINATION -> this.itemCategory = itemCategory;
      case WINDOWS -> this.itemCategory = itemCategory;
      case DOORS -> this.itemCategory = itemCategory;
      case WOOD_LOAD -> this.itemCategory = itemCategory;
      default -> throw new IllegalArgumentException("Item Category must be between 1 and 4");
    }
  }

  /**
   * To check if the different fields are valid.
   *
   * @param field The field representing the value.
   * @param type The type of the field.
   * @throws IllegalArgumentException if the fields input
   *                                  is invalid.
   */
  private void checkFields(String field, String type) {
    boolean valid = true;

    switch (type) {
      case "itemNr",
           "itemDescription",
           "itemColor",
           "itemBrand":
        if (field.isBlank()) {
          valid = false;
        }
        break;

      case "itemWeight",
           "itemLength",
           "itemHeight",
           "itemPrice",
           "itemAmount":
        if (Double.parseDouble(field) < 0) {
          valid = false;
        }
        break;

      case "itemCategory":
        if (Integer.parseInt(field) < 1 && Integer.parseInt(field) > 4) {
          valid = false;
        }
        break;

      default:
        if (field.isBlank()) {
          valid = false;
        }
        break;
    }
    if (!valid) {
      throw new IllegalArgumentException("Input is invalid" + field);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item item)) {
      return false;
    }
    return Double.compare(item.getItemWeight(), getItemWeight()) == 0
        && Double.compare(item.getItemLength(), getItemLength()) == 0
        && Double.compare(item.getItemHeight(), getItemHeight()) == 0
        && getItemPrice() == item.getItemPrice()
        && getItemAmount() == item.getItemAmount()
        && getItemCategory() == item.getItemCategory()
        && getItemNr().equals(item.getItemNr())
        && getItemDescription().equals(item.getItemDescription())
        && getItemColor().equals(item.getItemColor())
        && getItemBrand().equals(item.getItemBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItemNr(), getItemDescription(), getItemColor(), getItemBrand(),
        getItemWeight(), getItemLength(), getItemHeight(), getItemPrice(), getItemAmount(),
        getItemCategory());
  }

  @Override
  public String toString() {
    return "Item{"
        + "itemNr='" + itemNr + '\''
        + ", itemDescription='" + itemDescription + '\''
        + ", itemColor='" + itemColor + '\''
        + ", itemBrand='" + itemBrand + '\''
        + ", itemWeight=" + itemWeight
        + ", itemLength=" + itemLength
        + ", itemHeight=" + itemHeight
        + ", itemPrice=" + itemPrice
        + ", itemAmount=" + itemAmount
        + ", itemCategory=" + itemCategory
        + '}';
  }
}