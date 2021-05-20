public class CmdPurchase implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
    if (v.checkProduct(cmdPart) == null)
      return "No this product";
    else {
      Product target = v.checkProduct(cmdPart);
      if (target.getQuantity() == 0)
        return target.getName() + " is out of stock!";
      else if (target.getQuantity() > 0) {
        String changeStatement = v.change(target);
        return changeStatement;
      } else {
        return "GG";
      }
    }
  }
}