public class MeetingRoom {
    int id;
    String location;
    String name;
    int capacity;
    Calender calendar;

    public MeetingRoom(int id, String location, String name, int capacity) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.capacity = capacity;
        calendar  = new Calender();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Calender getCalendar() {
        return calendar;
    }

    public void bookRoom(Meeting meeting)
    {
        calendar.addMeeting(meeting);
    }
    public void cancelBooking(Meeting meeting)
    {
        calendar.removeMeeting(meeting);
    }
}
