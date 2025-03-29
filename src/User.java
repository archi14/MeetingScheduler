import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    Calender calender;
    List<NotificationObserver> notificationObservers;

    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
        calender = new Calender();
        notificationObservers = new ArrayList<>();
        notificationObservers.add(new EmailNotificationObserver(name+"@company.com"));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calender getCalender() {
        return calender;
    }

    public boolean isAvailable(Interval interval)
    {
        return !calender.hasConflict(interval);
    }

    public void addMeeting(Meeting meeting)
    {
        calender.addMeeting(meeting);
    }

    public void removeMeeting(Meeting meeting)
    {
        calender.removeMeeting(meeting);
    }

    public List<NotificationObserver> getNotificationObservers() {
        return notificationObservers;
    }
}
