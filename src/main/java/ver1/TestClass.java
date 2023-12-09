package ver1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestClass {
    public static void main(String[] args) {

        LocalDate dayWalk = LocalDate.now();
        DayOfWeek dayOfWeek = dayWalk.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println("value = " + value); // value = 4
        System.out.println("---------------");


        while (dayWalk.getDayOfWeek().getValue() != 1) {
            dayWalk = dayWalk.plusDays(1);
        }
        System.out.println("firstMondayIs = " + dayWalk.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        // firstMondayIs = 2023-12-11

        System.out.println("---------------");

        dayWalk = LocalDate.of(2023, 12, 29);
        while (dayWalk.getDayOfWeek().getValue() != 4) {
            dayWalk = dayWalk.plusDays(1);
        }
        System.out.println("from 2023-12-29 next Thursday = " + dayWalk.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        // from 2023-12-29 next Thursday = 2024-01-04

        System.out.println("-----------");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime firstTarget = LocalDateTime.of(2023, 12, 31, 0, 0, 0);
        LocalDate secondTarget = LocalDate.of(2022, 12, 31);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        boolean before = now.isBefore(firstTarget);
        System.out.println("firstTarget = " + firstTarget.format(dtf));
        System.out.println("before = " + before);
        System.out.println("after = " + now.isAfter(firstTarget));

        before = now.isBefore(secondTarget.atStartOfDay());
        System.out.println("secondTarget.atStartOfDay() = " + secondTarget.atStartOfDay().format(dtf));
        System.out.println("before = " + before);
        System.out.println("after = " + now.isAfter(secondTarget.atStartOfDay()));

    }
}
