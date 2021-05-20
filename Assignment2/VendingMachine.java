import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {
  // ArrayList of Integers represents inserted coins in Coin Slot
  private ArrayList<Integer> insertedCoins;

  // ArrayList of Product represents inventories of products
  private ArrayList<Product> products;

  public VendingMachine() {
    insertedCoins = new ArrayList<Integer>();
    products = new ArrayList<Product>();
  }

  public void addProduct(Product p) {
    products.add(p);
  }

  public void insertCoin(Integer c) {
    insertedCoins.add(c);
    Collections.sort(insertedCoins);
  }

  public void reduceSum(Product target) {
    int sum = getSum();
    sum = sum - target.getPrice();
    clearInsertedCoins();
    insertedCoins.add(sum);
  }

  /* You may add other properties and methods */
  public int getSum() {
    int sum = 0;
    for (int i : insertedCoins)
      sum += i;
    return sum;
  }

  public ArrayList<Integer> getAllCoin() {
    return insertedCoins;
  }

  public void clearInsertedCoins() {
    insertedCoins.clear();
  }

  public boolean isEmptyInsertedCoins() {
    return insertedCoins.isEmpty();
  }

  public Product checkProduct(String productName) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getName().equals(productName))
        return products.get(i);
    }
    return null;
  }

  public String change(Product target) {
    int sum = getSum();

    if (target.getPrice() == sum) {
      target.reduceQuantity();
      reduceSum(target); 
      clearInsertedCoins();
      return "Dropped " + target.getName() + ". Paid $" + sum + ". No change.";
    } 
    
    else if (target.getPrice() < sum) {
      target.reduceQuantity();
      reduceSum(target);
      int tempForGetSum = getSum();
      ArrayList<Integer> yourChange = new ArrayList<Integer>();
      while (tempForGetSum > 0) {
        if (tempForGetSum >= 10) {
          yourChange.add(10);
          tempForGetSum = tempForGetSum - 10;
        } else if (tempForGetSum >= 5 && tempForGetSum < 10) {
          yourChange.add(5);
          tempForGetSum = tempForGetSum - 5;
        } else if (tempForGetSum >= 2 && tempForGetSum < 5) {
          yourChange.add(2);
          tempForGetSum = tempForGetSum - 2;
        } else if (tempForGetSum == 1) {
          yourChange.add(1);
          tempForGetSum = tempForGetSum - 1;
        }
      }
      Collections.sort(yourChange);
      String finalChange = "";
      for (int i = 0; i < yourChange.size(); i++) {
        if (i == yourChange.size() - 1)
          finalChange = finalChange + "$" + yourChange.get(i);
        else {
          finalChange = finalChange + "$" + yourChange.get(i) + ", ";
        }
      }
      yourChange.clear();
      clearInsertedCoins();
      return "Dropped " + target.getName() + ". Paid $" + sum + ". Your change: " + finalChange + ".";
    } 
    
    else 
    {
      return "Not enough credit to buy " + target.getName() + "! Inserted $" + sum + " but needs $" + target.getPrice() + ".";
    }
  }
}
