import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();
        MeetingRoom room1 = new MeetingRoom(1, "ggm", "a", 10);
        MeetingRoom room2 = new MeetingRoom(2, "ggm", "b", 20);

        scheduler.addRoom(room1);
        scheduler.addRoom(room2);
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Please enter the number of participants");
            List<User> participants = new ArrayList<>();
            int count = scanner.nextInt();
            for(int i=0;i<count;i++)
            {
                User user = new User();
                participants.add(user);
            }
            System.out.println("Please enter the start of the time interval");
            int start = scanner.nextInt();
            System.out.println("Please enter the end of the time interval");
            int end = scanner.nextInt();
            Interval interval = new Interval(start, end);
            if(scheduler.scheduleMeeting(participants, interval))
            {
                System.out.println("Meeting was scheduled successfully");
            }else {
                System.out.println("Unable to book the meeting");
            }
        }


    }
}