public interface MeetingObservable {

    public void add(NotificationObserver notificationObserver);
    public void remove(NotificationObserver notificationObserver);
    public void notifyObservers();
}
