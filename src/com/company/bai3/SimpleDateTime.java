package com.company.bai3;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SimpleDateTime {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap ngày: yyyy-MM-dd hh:mm:ss\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateInString = scanner.nextLine();
        System.out.println(StringtoDate(dateInString, sdf));
        dayOfMonth(dateInString,sdf);
        System.out.println("timestamp:");
        System.out.println(stringToTimestamp(dateInString, sdf));
        System.out.println("chuỗi định dạng mới:\n");
        newFormetter(dateInString, sdf);

        System.out.print("Nhap ngày a: yyyy-MM-dd HH:mm:ss\n");
        String datea =
                scanner.nextLine();
        System.out.print("Nhap ngày b: yyyy-MM-dd HH:mm:ss\n");
        String dateb =
                scanner.nextLine();
        comparetor(datea,dateb,sdf);
        dateDiff(datea,dateb,sdf);
//2019-10-12 12:12:12
//   2014-12-13 14:42:12
    }

    static Date StringtoDate(String str, SimpleDateFormat sdf) throws Exception {
        Date date = sdf.parse(str);
        return date;
    }


    static Calendar datetoCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    static Date calendartoDate(Calendar calendar) {
        return calendar.getTime();
    }


    static int getIntMonth(String date) {
        return Integer.parseInt(date.substring(5, 7));
    }

    static int getIntYear(String date) {
        return Integer.parseInt(date.substring(0, 4));
    }

    static void dayOfMonth(String str, SimpleDateFormat sdf) throws Exception {
        Date date = StringtoDate(str, sdf);
        Calendar calendar = datetoCalendar(date);
        System.out.print(getIntMonth(str));
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        int daystartofmonth = calendar.getActualMinimum(calendar.DATE);
        calendar.set(getIntYear(str), getIntMonth(str), daystartofmonth);
        System.out.println("ngày đầu tiên của tháng \t :" + simpleDateFormat1.format(calendar.getTime()));

        int dayfinaltomoth = calendar.getActualMaximum(calendar.DATE);
        calendar.set(getIntYear(str), getIntMonth(str), dayfinaltomoth);
        System.out.println("ngày cuối cùng của tháng\t :" + simpleDateFormat1.format(calendar.getTime()));

        int startweek = calendar.getFirstDayOfWeek();
        calendar.set(getIntYear(str), getIntMonth(str) - 1, startweek);
        System.out.println(" đầu tuần\t :" + simpleDateFormat1.format(calendar.getTime()));

        calendar.add(Calendar.DATE, 100);
        Date date1 = calendartoDate(calendar);
        String stringDate = simpleDateFormat1.format(date1);
        System.out.println("100 ngày sau:\t " + stringDate);

    }
    static void dateDiff(String date1, String date2, SimpleDateFormat formatter) throws Exception {
        Date d1 = formatter.parse(date1);
        Date d2 = formatter.parse(date2);

        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffMonths = diff / (24 * 60 * 60 * 1000) % 12;
        long diffYears = diffDays % 365;

        System.out.print(diffYears + " years,");
        System.out.print(diffMonths + " months,");
        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.print(diffSeconds + " seconds.");
    }

    static void comparetor(String date1, String date2, SimpleDateFormat sdf) throws ParseException {
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        if (d1.compareTo(d2) < 0) {
            System.out.print("date a < date b \t");
        } else if (d1.compareTo(d2) == 0) {
            System.out.print("date a = date b\t");

        } else {
            System.out.print("date a > date b\t");

        }

    }

    static java.sql.Timestamp stringToTimestamp(String string, SimpleDateFormat sdf) throws Exception {
        Date prdate = sdf.parse(string);
        java.sql.Timestamp timestamp = new Timestamp(prdate.getTime());
        return timestamp;
    }

    static void newFormetter(String str, SimpleDateFormat sdf) throws Exception {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\n");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss\n");
        Date date = StringtoDate(str, sdf);
        String str1 = simpleDateFormat1.format(date);
        String str2 = simpleDateFormat2.format(date);
        System.out.println("yyyy-MM-dd HH:mm:ss\n" + str1);
        System.out.println("MMM yyyy,dd HH:mm:ss\n" + str2);
    }

}
