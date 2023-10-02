package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Data implements Serializable {
    private int day;
    private String month;
    private int year;

    public Data() throws Exception {
        this(1, "January", 2000);
    }

    public Data(int day, String month, int year) throws Exception {
        setDate(day, month, year);
    }

    public Data(int day, int month, int year) throws Exception {
        setDate(day, month, year);
    }

    public boolean dateOk(int day, String month, int year) {
        month = month.toLowerCase();

        if ((month.equals("february") && (year % 4 != 0 || year % 100 == 0 && year % 400 != 0) && (day > 28 || day < 1))) {
            return false;
        } else if ((month.equals("february") && ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) && (day > 29 || day < 1))) {
            return false;
        } else if (((month.equals("january") || month.equals("march") || month.equals("may") || month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december")) && (day > 31 || day < 1))
                || ((month.equals("april") || month.equals("june") || month.equals("september") || month.equals("november")) && (day > 30 || day < 1))) {
            return false;
        } else if (!(month.equals("january") || month.equals("march") || month.equals("may") || month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december") || month.equals("april") || month.equals("june") || month.equals("september") || month.equals("november") || month.equals("february"))) {
            return false;
        }

        return true;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        int monthInt = 0;

        switch (month.toLowerCase()) {
            case "january":
                monthInt = 1;
                break;
            case "february":
                monthInt = 2;
                break;
            case "march":
                monthInt = 3;
                break;
            case "april":
                monthInt = 4;
                break;
            case "may":
                monthInt = 5;
                break;
            case "june":
                monthInt = 6;
                break;
            case "july":
                monthInt = 7;
                break;
            case "august":
                monthInt = 8;
                break;
            case "september":
                monthInt = 9;
                break;
            case "october":
                monthInt = 10;
                break;
            case "november":
                monthInt = 11;
                break;
            case "december":
                monthInt = 12;
                break;
        }

        return monthInt;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) throws Exception {
        if (!dateOk(day, month, year)) {
            throw new Exception("Wrong date!");
        }

        this.day = day;
    }

    public void setMonth(String month) throws Exception {
        if (!dateOk(day, month, year)) {
            throw new Exception("Wrong date!");
        }

        this.month = month;
    }

    public void setMonth(int month) throws Exception {
        String monthStr = switch (month) {
            case 1 -> "january";
            case 2 -> "february";
            case 3 -> "march";
            case 4 -> "april";
            case 5 -> "may";
            case 6 -> "june";
            case 7 -> "july";
            case 8 -> "august";
            case 9 -> "september";
            case 10 -> "october";
            case 11 -> "november";
            case 12 -> "december";
            default -> "";
        };

        if (!dateOk(day, monthStr, year)) {
            throw new Exception("Wrong date!");
        }

        this.month = monthStr;
    }

    public void setYear(int year) throws Exception {
        if (!dateOk(day, month, year)) {
            throw new Exception("Wrong date!");
        }

        this.year = year;
    }

    public void setDate(int day, String month, int year) throws Exception {
        if (!dateOk(day, month, year)) {
            throw new Exception("Wrong date!");
        }

        this.day = day;

        this.month = month;

        this.year = year;
    }

    public void setDate(int day, int month, int year) throws Exception {
        String monthStr = "";
        monthStr = switch (month) {
            case 1 -> "january";
            case 2 -> "february";
            case 3 -> "march";
            case 4 -> "april";
            case 5 -> "may";
            case 6 -> "june";
            case 7 -> "july";
            case 8 -> "august";
            case 9 -> "september";
            case 10 -> "october";
            case 11 -> "november";
            case 12 -> "december";
            default -> "";
        };

        if (!dateOk(day, monthStr, year)) {
            throw new Exception("Wrong date!");
        }

        this.day = day;

        this.month = monthStr;

        this.year = year;
    }

    public boolean dateBeforeCurrent(Data date) {
        LocalDate current = LocalDate.now();

        if (date.getDay() < current.getDayOfMonth() && date.getMonth() <= current.getMonthValue() && date.getYear() <= current.getYear()) {
            return true;
        } else return date.getDay() > current.getDayOfMonth() && date.getMonth() < current.getMonthValue() && date.getYear() <= current.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Data data = (Data) o;

        return day == data.day && year == data.year && Objects.equals(month, data.month);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "day = " + day + ", month = " + month + ", year = " + year;
    }
}