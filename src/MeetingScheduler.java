import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingScheduler implements NotificationObservable {
    List<MeetingRoom> rooms;
    List<NotificationObserver> notificationObservers;
    public MeetingScheduler()
    {
        rooms = new ArrayList<>();
        notificationObservers = new ArrayList<>();
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
            List<User> availableUsers = new ArrayList<>();
            for(int i=0;i<participants.size();i++)
            {
                if(participants.get(i).isAvailable(interval))
                {
                    System.out.println(participants.get(i).getName() + "is Available");
                    availableUsers.add(participants.get(i));
                }else {
                    System.out.println(participants.get(i).getName() + " has a conflicting meeting during the interval");
                }
            }

            if(availableUsers.isEmpty())
            {
                System.out.println("All participants have a conflicting meeting");
                return false;
            }else {
                Meeting meeting = new Meeting(UUID.randomUUID().toString(), interval, room, availableUsers);
                for(int i=0;i<participants.size();i++)
                {
                    availableUsers.get(i).getCalender().addMeeting(meeting);
                }
                notifyObservers(meeting);
                room.bookRoom(meeting);
                return true;
            }

        }
        return false;
    }

    @Override
    public void subscribe(NotificationObserver notificationObserver) {
        notificationObservers.add(notificationObserver);
    }

    @Override
    public void unsubscribe(NotificationObserver notificationObserver) {
        notificationObservers.remove(notificationObserver);
    }

    @Override
    public void notifyObservers(Meeting meeting) {
            for(int i=0;i<notificationObservers.size();i++)
            {
                notificationObservers.get(i).update(meeting);
            }
    }
}
