import java.util.ArrayList;
import java.util.List;

public class Meeting implements MeetingObservable {
    String id;
    Interval interval;
    MeetingRoom room;
    List<User> participants;
    List<NotificationObserver> notificationObservers;

    public Meeting(String id, Interval interval, MeetingRoom room, List<User> participants)
    {
        this.id = id;
        this.interval = interval;
        this.room = room;
        this.participants = participants;
        notificationObservers = new ArrayList<>();
        for(int i=0;i<participants.size();i++)
        {
            notificationObservers.addAll(participants.get(i).getNotificationObservers());
        }
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

    @Override
    public void add(NotificationObserver notificationObserver) {
        notificationObservers.add(notificationObserver);
    }

    @Override
    public void remove(NotificationObserver notificationObserver) {
        notificationObservers.remove(notificationObserver);
    }

    @Override
    public void notifyObservers() {
        for(int i=0;i<notificationObservers.size();i++)
        {
            notificationObservers.get(i).update("Email sent successfully to");
        }

    }
}
