import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

class Meeting {
    String title;
    String date;
    String startTime;
    String endTime;
    String description;

    public Meeting(String title , String date , String startTime , String endTime , String description){
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
}

class DepartmentMeetingScheduler {

    public static boolean scheduleMeeting(Meeting x , Hashtable<String,ArrayList<Meeting>> meets){
        if (meets.get(x.date) == null){
            ArrayList<Meeting> y = new ArrayList<>();
            y.add(x);
            meets.put(x.date , y);
            return true;
        }
        int start = Q3.stringToIntTime(x.startTime);
        int end = Q3.stringToIntTime(x.endTime);
        for(Meeting meet : meets.get(x.date)){
            int mStart = Q3.stringToIntTime(meet.startTime);
            int mEnd = Q3.stringToIntTime(meet.endTime);
            if ((start >= mStart && start < mEnd) || (end > mStart && end <= mEnd)){
                return false;
            }
        }
        meets.get(x.date).add(x);
        return true;
    }

    public static void displayMeetings(String date , Hashtable<String,ArrayList<Meeting>> meets){
        if (meets.get(date) == null){
            // System.out.println("No meetings scheduled!");
            return;
        }
        System.out.print("On " + date + " ");
        for(Meeting meet : meets.get(date)){
        
            System.out.println("from " + meet.startTime + " to " + meet.endTime + " : " + meet.title + " : " + meet.description);
        }
    }



}

public class Q3 {
    public static int stringToIntTime(String s){
        s = s.replaceAll(":" , "");
        return Integer.parseInt(s);
    }
    public static void main (String[] args) {
        Hashtable<String,ArrayList<Meeting>> meets = new Hashtable<>();
        System.out.println("1. Schedule Meeting\n2. List Meetings\n3. Exit");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nEnter your choice : ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            if (choice == 1){
                System.out.print("Title - ");
                String title = sc.nextLine().trim();
                System.out.print("Date - ");
                String date = sc.nextLine().trim();
                System.out.print("Start time - ");
                String startTime = sc.nextLine().trim();
                System.out.print("End time - ");
                String endTime = sc.nextLine().trim();
                System.out.print("Description - ");
                String description = sc.nextLine().trim();
                Meeting x = new Meeting(title , date , startTime , endTime , description);
                if (DepartmentMeetingScheduler.scheduleMeeting(x , meets)){
                    System.out.println("Scheduled successfully");
                    continue;
                }
                System.out.println("Collision! Already another meeting is scheduled");
                continue;
            }
            if(choice == 2){
                System.out.print("Enter date - ");
                String date = sc.nextLine().trim();
                DepartmentMeetingScheduler.displayMeetings(date, meets);
                continue;
            }
            if (choice == 3){
                sc.close();
                break;
            }
        }
    }
}