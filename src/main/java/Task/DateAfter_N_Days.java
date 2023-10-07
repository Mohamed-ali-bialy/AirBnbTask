package Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateAfter_N_Days {
    public static void main(String[] args) {
        // Get the current date
        Date currentDate = new Date();

        // Calculate the date 7 days later
        Date dateAfter7Days = getDateAfterNDays(currentDate, 7);

        // Format the date and print it
        String formattedDate = formatDate(dateAfter7Days);
        System.out.println(formattedDate);
    }

    public static Date getDateAfterNDays(Date currentDate, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        return calendar.getTime();
    }

    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd, EEEE, MMMM yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    public static String Onlyday(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd", Locale.ENGLISH);
        return dateFormat.format(date);
    }
}