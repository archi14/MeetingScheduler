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
        System.out.println("No room was booked");
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
            List<User> conflictingUsers = new ArrayList<>();
            for(int i=0;i<participants.size();i++)
            {
                if(participants.get(i).isAvailable(interval))
                {
                    System.out.println(participants.get(i).getName() + "is Available");
                    participants.get(i).getCalender().addMeeting(meeting);
                    System.out.println(participants.get(i).getCalender().getMeetings());
                }else {
                    System.out.println(participants.get(i).getName() + " has a conflicting meeting during the interval");
                   conflictingUsers.add(participants.get(i));
                }
            }
            for(int i=0;i<conflictingUsers.size();i++)
            {
                participants.remove(conflictingUsers.get(i));
            }

            if(participants.isEmpty())
            {
                System.out.println("All participants have a conflicting meeting");
                return false;
            }else {
                room.bookRoom(meeting);
                return true;
            }

        }
        return false;
    }
}
