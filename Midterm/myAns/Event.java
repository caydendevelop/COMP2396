import java.util.ArrayList;

public class Event {

  public String name = "";
  public ArrayList<String> venueList = new ArrayList<String>();

  Event(String name){
    this.name = name;
  }

  public void addVenue(String venue){
    this.venueList.add(venue);
  }
}
