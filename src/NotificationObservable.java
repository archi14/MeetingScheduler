public interface NotificationObservable {

    public void subscribe(NotificationObserver notificationObserver);
    public void unsubscribe(NotificationObserver notificationObserver);
    public void notifyObservers(Meeting meeting);
}
