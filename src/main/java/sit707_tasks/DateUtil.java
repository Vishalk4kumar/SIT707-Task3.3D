package sit707_tasks;

/**
 * Utility class for date manipulation.
 */
public class DateUtil {

    // Months in order 0-11 maps to January-December.
    private static final String[] MONTHS = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    /*
     * Constructs object from given day, month and year.
     */
    public DateUtil(int day, int month, int year) {
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Increment one day.
     */
    public void increment() {
        if (day < monthDuration(month, year)) {
            // At least 1 day remaining in current month of year.
            day++;
        } else if (month < 12) {
            // Last day of a month AND month is less than December, so +1d is first day of next month.
            day = 1;
            month++;
        } else {
            // Month is December, so +1d is 1st January next year.
            day = 1;
            month = 1;
            year++;
        }
    }

    /**
     * Decrement one day from current date.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }

    /**
     * Validate if the given day, month, and year form a valid date.
     *
     * @param day   The day of the date.
     * @param month The month of the date.
     * @param year  The year of the date.
     * @throws IllegalArgumentException if the date is invalid.
     */
    private void validateDate(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new IllegalArgumentException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 9999)
            throw new IllegalArgumentException("Invalid year: " + year + ", expected range 1700-9999");
        if (day > monthDuration(month, year))
            throw new IllegalArgumentException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
    }

    /**
     * Calculate duration of current month of year.
     *
     * @param month The month.
     * @param year  The year.
     * @return The number of days in the month.
     */
    public static int monthDuration(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29; // February leap year
        } else if (month == 2) {
            return 28; // Normal February
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; // 30 days' months
        }
        return 31; // Rest are 31 days' months.
    }

    /**
     * Check if a year is a leap year.
     *
     * @param year The year to check.
     * @return True if it's a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Get the day of the date.
     *
     * @return The day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Get the month of the date.
     *
     * @return The month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Get the year of the date.
     *
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * User friendly output.
     */
    @Override
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
}
