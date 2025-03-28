import java.util.List;

public class Meeting {
    String id;
    Interval interval;
    MeetingRoom room;
    List<User> participants;

    public Meeting(String id, Interval interval, MeetingRoom room, List<User> participants)
    {
        this.id = id;
        this.interval = interval;
        this.room = room;
        this.participants = participants;
    }

    public String getId() {
        return id;
    }

    public Interval getInterval() {
        return interval;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void removeParticipant(User user)
    {
        participants.remove(user);
    }

    public void addParticipant(User user)
    {
        participants.add(user);
    }
}
