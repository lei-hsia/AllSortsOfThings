package ap.chapter3.questions;

import java.util.Scanner;
/*
 *    q9
 * */
public class BirthdayStuff {
//    public static Date findBirthdate() {
//        /* code to get birthDate */
//        return birthDate;
//    }

    public static Date findBirthdate() {
        int m = new Scanner(System.in).nextInt();
        int d = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        Date birthDate = new Date(m, d, y);
        return birthDate;
    }

    public static Date findBirthdate2() {
        Date birthDate = new Date();
//        int birthDate.month() = new Scanner(System.in).nextInt();
//        int birthDate.day() = new Scanner(System.in).nextInt();
//        int birthDate.year() = new Scanner(System.in).nextInt();


        birthDate.setMonth(new Scanner(System.in).nextInt());
        birthDate.setDay(new Scanner(System.in).nextInt());
        birthDate.setYear(new Scanner(System.in).nextInt());

        return birthDate;
    }

    public static void main(String[] args) {
        Date d = findBirthdate();
    }
}
