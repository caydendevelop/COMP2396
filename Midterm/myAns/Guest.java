import java.time.Year;
import java.util.ArrayList;

public class Guest {

  public String name = "";
  public ArrayList<Event> joinedEvent = new ArrayList<Event>();

  Guest(String name) {
    this.name = name;
  }

  public void joinEvent(Event eventName, String venue) {
    this.joinedEvent.add(eventName);
   
  }

  public boolean hasCloseContactWith(Guest otherPerson) {
    int size = 0;
    if (this.joinedEvent.size() >= otherPerson.joinedEvent.size()){
      size = this.joinedEvent.size();
    }
    else{
      size = otherPerson.joinedEvent.size();
    }
    for (int i = 0; i < size; i++) 
    {
      for (int j = 0; j < size; j++) 
      { 
        System.out.println(this.joinedEvent.get(i).name);
        System.out.println(this.joinedEvent.get(j).name);
        if (this.joinedEvent.get(i).equals(otherPerson.joinedEvent.get(j))) 
        { // same Event
          // System.out.println(this.joinedEvent.get(i).name);
          // System.out.println(otherPerson.joinedEvent.get(j).name);
          Event x = this.joinedEvent.get(i);
          Event y = otherPerson.joinedEvent.get(j);
          int sizeL = 0;
          if (x.venueList.size() >= y.venueList.size()){
            sizeL = x.venueList.size();
          }
          else{
            sizeL = y.venueList.size();
          }
          for (int a = 0; a < sizeL; a++) 
          {
            for (int b = 0; b < sizeL; b++) 
            {
              if (x.venueList.get(a).equals(y.venueList.get(b))) 
              { // same Venue
                // System.out.println(x.venueList.get(a));
                // System.out.println(y.venueList.get(b));
                return true;
              }     
            }
          }
        }
      } 
    }
    return false;
  }
}