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

        DayOfWeek dayOfWeek1 = now.getDayOfWeek();
        System.out.println("dayOfWeek1 = " + dayOfWeek1);
        int dayOfMonth = now.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);


        // 해당 월의 마지막날, 첫번째 날 (일수) 구하기 - 시작

        LocalDate now1 = LocalDate.now();
        // 해당 년의 마지막 일
        int i = now1.lengthOfYear();
        System.out.println("last date current year = " + i);
        // 해당 월의 마지막 일
        int i1 = now1.lengthOfMonth();
        System.out.println("last date current month = " + i1);
        // 해당 월의 1번째 날
        System.out.println("해당 월의 1번째 날");
        LocalDateTime localDate = now1.atStartOfDay().withDayOfMonth(1);
        System.out.println("localDate = " + localDate);
        // 해당 월의 첫번째 날의 요일 숫자로 가져오기
        System.out.println("해당 일의 요일 숫자로 가져오기");
        int value1 = localDate.getDayOfWeek().getValue();
        System.out.println("localDate.getDayOfWeek().getValue() = " + value1);

        // 해당 월의 1번째 날의 마지막 날짜 (무의미하긴 함)
        System.out.println("해당 월의 1번째 날의 마지막 날짜 (무의미하긴 함)");
        LocalDate localDate1 = now1.withDayOfMonth(1);
        int i2 = localDate1.lengthOfMonth();
        System.out.println("lastDate current Month = " + i2);


    }
}
