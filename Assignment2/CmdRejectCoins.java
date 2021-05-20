public class CmdRejectCoins implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
    
    if(v.isEmptyInsertedCoins()){
      return "Rejected no coin!";
    }

    String coinValue = "";
   
      for (int i = 0; i < v.getAllCoin().size(); i++){
        if( i != v.getAllCoin().size()-1)
          coinValue += "$" + v.getAllCoin().get(i) + ", "; 
        else
          coinValue += "$" + v.getAllCoin().get(i) + ". "; 
      }

    // Do something
    // return something. Format: "Inserted a $x coin. $y in total."
    int sum = v.getSum();
    v.clearInsertedCoins();
    return "Rejected "+ coinValue + "$" + sum +" in total.";
    
  }
}