package dateandtimetester;

import java.util.Scanner;

public class Date {
	public static void main(String[] args) {
	    new Date().run();
	}
    // Handles user input and output
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a date and time (MM/DD hh:mm) and I will determine if it is valid");
            String input = sc.nextLine();
            if (input == null) input = "";
            input = input.trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye");
                break;
            }

            boolean valid = isValid(input);
            if (valid) {
                System.out.println("The date and time is valid!");
            } else {
                System.out.println("The date and time is not valid");
            }

            System.out.println("Would you like to exit? Type \"quit\" to exit or press [ENTER] to continue");
            String decision = sc.nextLine();
            if (decision == null) decision = "";
            if (decision.trim().equalsIgnoreCase("quit")) {
                System.out.println("Goodbye");
                break;
            }
        }

        // Do NOT close System.in scanner here if driver may reuse System.in
        // sc.close();
    }

    // Validates a full date and time string "MM/DD hh:mm"
    public boolean isValid(String dateTime) {
        if (dateTime == null) return false;
        dateTime = dateTime.trim();
        if (dateTime.isEmpty()) return false;

        String[] parts = dateTime.split("\\s+");
        if (parts.length != 2) return false;

        String datePart = parts[0];
        String timePart = parts[1];

        return isValidDate(datePart) && isValidTime(timePart);
    }

    // Validates the date portion "MM/DD"
    public boolean isValidDate(String date) {
        if (date == null) return false;
        date = date.trim();
        if (date.isEmpty()) return false;

        int slashIdx = date.indexOf('/');
        if (slashIdx < 0) return false;

        int month = getMonth(date);
        int day = getDay(date);

        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        int maxDay;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDay = 31; break;
            case 4: case 6: case 9: case 11:
                maxDay = 30; break;
            case 2:
                maxDay = 28; break;
            default:
                return false;
        }

        return day <= maxDay;
    }

    // Validates the time portion "hh:mm"
    public boolean isValidTime(String time) {
        if (time == null) return false;
        time = time.trim();
        if (time.isEmpty()) return false;

        int colonIdx = time.indexOf(':');
        if (colonIdx < 0) return false;

        int hour = getHour(time);
        int minute = getMinute(time);

        if (hour < 1 || hour > 12) return false;
        if (minute < 0 || minute > 59) return false;

        return true;
    }

    // Extracts month from "MM/DD"
    public int getMonth(String date) {
        if (date == null) return -1;
        date = date.trim();
        int slashIdx = date.indexOf('/');
        if (slashIdx < 0) return -1;

        String monthStr = date.substring(0, slashIdx).trim();
        if (monthStr.isEmpty()) return -1;

        try {
            return Integer.parseInt(monthStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Extracts day from "MM/DD"
    public int getDay(String date) {
        if (date == null) return -1;
        date = date.trim();
        int slashIdx = date.indexOf('/');
        if (slashIdx < 0) return -1;

        String dayStr = date.substring(slashIdx + 1).trim();
        if (dayStr.isEmpty()) return -1;

        try {
            return Integer.parseInt(dayStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Extracts hour from "hh:mm"
    public int getHour(String time) {
        if (time == null) return -1;
        time = time.trim();
        int colonIdx = time.indexOf(':');
        if (colonIdx < 0) return -1;

        String hourStr = time.substring(0, colonIdx).trim();
        if (hourStr.isEmpty()) return -1;

        try {
            return Integer.parseInt(hourStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Extracts minute from "hh:mm"
    public int getMinute(String time) {
        if (time == null) return -1;
        time = time.trim();
        int colonIdx = time.indexOf(':');
        if (colonIdx < 0) return -1;

        String minStr = time.substring(colonIdx + 1).trim();
        if (minStr.isEmpty()) return -1;

        try {
            return Integer.parseInt(minStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}