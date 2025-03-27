import java.util.ArrayList;
import java.util.List;

public class Calender {
    List<Meeting> meetings;

    public Calender()
    {
        meetings = new ArrayList<>();
    }
    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting)
    {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting)
    {
        meetings.remove(meeting);
    }

    public boolean hasConflict(Interval interval)
   {

       for(int i=0;i<meetings.size();i++)
       {
           if(interval.start>=meetings.get(i).getInterval().start || interval.end <= meetings.get(i).getInterval().end)
           {
               return true;
           }
       }
       return false;
   }


}
