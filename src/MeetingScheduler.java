import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingScheduler {
    List<MeetingRoom> rooms;

    public MeetingScheduler()
    {
        rooms = new ArrayList<>();
    }
    public void addRoom(MeetingRoom room)
    {
        rooms.add(room);
    }

    public void removeRoom(MeetingRoom room)
    {
        rooms.remove(room);
    }

    public boolean scheduleMeeting(List<User> participants, Interval interval)
    {
        for(MeetingRoom room: rooms)
        {
            if(bookRoom(room, participants, interval))
            {
                return true;
            }
        }
        return false;
    }

    public boolean cancelMeeting(Meeting meeting, MeetingRoom room)
    {
        for(MeetingRoom r: rooms)
        {
            if(r == room)
            {
                r.cancelBooking(meeting);
                return true;
            }
        }
        return false;
    }

    public boolean bookRoom(MeetingRoom room, List<User> participants, Interval interval)
    {
        if(!room.getCalendar().hasConflict(interval) && room.getCapacity() >= participants.size())
        {
            Meeting meeting = new Meeting(UUID.randomUUID().toString(), interval, room, participants);
            room.bookRoom(meeting);
            return true;
        }
        return false;
    }
}
