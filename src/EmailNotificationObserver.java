public class EmailNotificationObserver implements NotificationObserver{
   @Override
    public void update(Meeting meeting) {
        for(User user: meeting.getParticipants())
        {
            System.out.println("[Email] To:" +  user.getEmail() + " meeting schedules for " + meeting.getInterval().start + " to " + meeting.getInterval().end);
        }
    }
}
