

import java.util.*;

public class Timetill {
    public static int secoundsInaDay = 24 * 60 * 60;

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        /*System.out.print("What Year: ");
        int year = scan.nextInt();
        System.out.print("What month: ");
        int month = scan.nextInt();
        System.out.print("What Day: ");
        int day = scan.nextInt();
        System.out.print("What Hour ");
        int hour = scan.nextInt();
        System.out.print("What minute");
        int minute = scan.nextInt();*/
        int year = 2018;
        int month = 11;
        int day = 1;
        int hour = 15;
        int minute = 30;
        if (minute == 00) {
            minute = 60;
        }
        scan.close();
        while (true) {
            Calendar dayOf = Calendar.getInstance();
            dayOf.setTime(new Date(0)); // RestBOYS
            dayOf.set(Calendar.DAY_OF_MONTH, day);
            dayOf.set(Calendar.MONTH, month - 1); // 0-11
            dayOf.set(Calendar.HOUR_OF_DAY, hour);
            dayOf.set(Calendar.MINUTE, minute);
            dayOf.set(Calendar.YEAR, year);

            Calendar today = Calendar.getInstance();
            long diff = dayOf.getTimeInMillis() - today.getTimeInMillis();
            long nano = diff*1000000;
            long diffSec = diff / 1000;

            long days = diffSec / secoundsInaDay;
            long secondsDay = diffSec % secoundsInaDay;
            long seconds = secondsDay % 60;
            long minutes = (secondsDay / 60) % 60;
            long hours = (secondsDay / 3600);
            long secRemaining = (secondsDay + (days * 86400));
            long hoursLeft = diff / (60 * 60 * 1000);
            //long minutesLeft = (diff % (60 * 60 * 1000)) / (60 * 1000);

            if(hours >1)
                System.out.printf("%d hours, %d minutes and %d seconds\n", hours, minutes, seconds);
            else if (hours ==1)
                System.out.printf("%d hour, %d minutes and %d seconds\n", hours, minutes, seconds);
            else
                System.out.printf("%dminutes and %d seconds\n", minutes, seconds);
            System.out.println(nano);
            System.out.printf("%d milliseconds remaining until classes end.\n", diff);
            System.out.printf("%d seconds remaining until classes end.\n", secRemaining);
            System.out.printf("%d minutes remaining until classes end.\n", ((hours * 60) + minutes));
            if (hours>1)
                System.out.printf("%d hours remaining until classes end.", hoursLeft);
            else
                System.out.printf("");

            try {
                Thread.sleep(25);
            }
            catch(Exception e){}
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }
}
