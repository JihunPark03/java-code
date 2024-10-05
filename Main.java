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

    public boolean overlapsWith(TimeSlot newSlot) {
        return this.start.compareTo(newSlot.end) < 0 && this.end.compareTo(newSlot.start) > 0;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<TimeSlot> timeSlots = new ArrayList<>();//can grow or shrink

        while(true){
            if (!sc.hasNextLine()) {
                break;
            }
            String input = sc.nextLine();
            String arr[] = input.split(",");
            if (arr.length != 2){
                System.out.printf("エラー: 開始時間と終了時間の両方を入力してください");
                System.out.println();
                continue;
            }
            String s = arr[0];
            String e = arr[1];

            TimeSlot newSlot = new TimeSlot(s, e);

            boolean overlap = false;
            for (TimeSlot slot : timeSlots) {
                if (slot.overlapsWith(newSlot)) {
                    overlap = true;
                    break;
                }
            }

            if (overlap) {
                System.out.printf("%s - %s は重複しています",s,e);
                System.out.println();
            } else {
                timeSlots.add(newSlot);
                System.out.printf("%s - %s は重複しません",s,e);
                System.out.println();
            }
        }
        sc.close();
    }

}