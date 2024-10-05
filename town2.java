import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Town2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> timeSlots = new ArrayList<String>();

        while(true){
            if (!sc.hasNextLine()) {
                break;
            }
            String input = sc.nextLine();
            String arr[] = input.split(",");
            if (arr.length != 2){
                System.out.printf("Error: Enter only starting and ending time");
                continue;
            }
            String s = arr[0];
            String e = arr[1];

            TimeSlot newSlot = new TimeSlot(s, e);

        }
        sc.close();
    }

    public static void overlap(int a, int b, List timeslots){
        for (String slots: timeslots)
            e.compareTo(slots)
    }

}