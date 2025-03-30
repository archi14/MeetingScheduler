public class User {
    int id;
    String name;
    Calender calender;
    String email;

    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
        calender = new Calender();
        this.email = this.name + "@company.com";
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

    public String getEmail() {
        return email;
    }

    public void removeMeeting(Meeting meeting)
    {
        calender.removeMeeting(meeting);
    }
}
