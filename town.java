import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TimeSlot {
    String start;
    String end;

    public TimeSlot(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlapsWith(TimeSlot other) {
        return this.start.compareTo(other.end) < 0 && this.end.compareTo(other.start) > 0;
    }
}

public class Town {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<TimeSlot> timeSlots = new ArrayList<>();//can grow or shrink in size as needed

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

            boolean overlapFound = false;
            for (TimeSlot slot : timeSlots) {
                if (slot.overlapsWith(newSlot)) {
                    overlapFound = true;
                    break;
                }
            }

            if (overlapFound) {
                System.out.printf("%s - %s は重複しています",s,e);
                System.out.println();
            } else {
                timeSlots.add(newSlot);
                System.out.printf("%s - %s は重複しません",s,e);
                System.out.println();
            }
        }
        System.out.println("Successfully added time slots:");
        for (TimeSlot slot : timeSlots) {
            System.out.printf("%s - %s", slot.start, slot.end);
            System.out.println();
        }
        sc.close();
    }

}