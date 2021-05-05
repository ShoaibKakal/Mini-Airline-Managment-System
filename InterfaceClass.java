package com.company.Assignment3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceClass {

    //Backbone 2D array
    public static String[][] twoDArray = {{"1A", "1B", "1C", "1D"},
            {"2A", "2B", "2C", "2D"},
            {"3A", "3B", "3C", "3D"},
            {"4A", "4B", "4C", "4D"},
            {"5A", "5B", "5C", "5D"},
            {"6A", "6B", "6C", "6D"},
            {"7A", "7B", "7C", "7D"},
            {"8A", "8B", "8C", "8D"},
            {"9A", "9B", "9C", "9D"},
            {"10A", "10B", "10C", "10D"},

    };

    //This ArrayList contains all booked tickets.
    public static ArrayList<String> arrayListStr = new ArrayList<>();

    //This ArrayList contains All users data.
    public static ArrayList<TravelerInfo> userInfoList = new ArrayList<>();

    public static void main(String[] args) {

        //Enhancement is a local class which will be used for making stylish text.
        System.out.print("\t\t\t\t" + Enhancment.BLUE_BACKGROUND_BRIGHT + "                                 " + Enhancment.RESET);
        System.out.print(Enhancment.GREEN_BOLD_BRIGHT + "  SEAT RESERVATION & MANAGEMENT SYSTEM  ");
        System.out.print(Enhancment.BLUE_BACKGROUND_BRIGHT + "                                 " + Enhancment.RESET);

        System.out.println(Enhancment.RESET);


        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\ta. Seat Pattern\n\t\t\t\t\t\t\t\t\t\t\t\t\tb. Seat Reservation\n\t\t\t\t\t\t\t\t\t\t\t\t\tc. Seat Cancellation\n\t\t\t\t\t\t\t\t\t\t\t\t\td. Available Seats\n\t\t\t\t\t\t\t\t\t\t\t\t\te. Reserved Seats\n\t\t\t\t\t\t\t\t\t\t\t\t\tf. Search Reservation\n\t\t\t\t\t\t\t\t\t\t\t\t\tg. Exit\n");
        Calculations calculations = new Calculations();
        Scanner optionInput = new Scanner(System.in);
        String userOption = optionInput.nextLine();

        while (!userOption.equals("g")) {

            switch (userOption) {
                case "a":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Seat Pattern");
                    calculations.seatPattern(twoDArray);
                    break;
                case "b":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Seat Reservation");
                    calculations.seatReservation(twoDArray, arrayListStr);
                    break;
                case "c":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Seat Cancellation");
                    calculations.seatCancellation(userInfoList, arrayListStr);
                    break;
                case "d":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Available seats");
                    calculations.availableSeats(twoDArray, arrayListStr);
                    break;
                case "e":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Reserved Seats");
                    calculations.reservedSeats(twoDArray, arrayListStr);
                    break;
                case "f":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Search Reservation");
                    calculations.searchReservation(arrayListStr);
                    break;
                case "g":
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Exit");
                    break;
                default:
                    System.out.println(Enhancment.RED_BOLD_BRIGHT + "Enter a valid option");
            }
            System.out.println(Enhancment.RESET);

            System.out.print("a. Seat Pattern\nb. Seat Reservation\nc. Seat Cancellation\nd. Available Seats\ne. Reserved Seats\nf. Search Reservation\ng. Exit\n");
            userOption = optionInput.nextLine();

        }

    }
}
