public class EmailNotificationObserver implements NotificationObserver{

    String emailId;

    public EmailNotificationObserver(String emailId) {
        this.emailId =emailId;
    }

    @Override
    public void update(String msg) {
        System.out.println(msg + this.emailId);
    }
}
