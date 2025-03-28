public class User {
    int id;
    String name;
    Calender calender;

    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
        calender = new Calender();
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
}
