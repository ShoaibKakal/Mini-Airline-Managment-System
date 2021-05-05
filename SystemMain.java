package com.company.Assignment3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemMain {
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

    public static ArrayList<String> arrayListStr = new ArrayList<>();

    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);

        menu();

        //Traveler information
          System.out.println("\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 SYZ INVENTORY PROGRAM \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2");


        TravelerInfo travelerInfo = new TravelerInfo();

        System.out.println("Please Enter Your Information\n ");
        System.out.println("Enter CNIC: ");
        String CNIC = scanner.nextLine();
//        travelerInfo.setCNIC(scanner.nextLine());
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
//        travelerInfo.setName(scanner.nextLine());
        System.out.println("Enter Date of Travel: ");
        String dateOfTravel = scanner.nextLine();
//        travelerInfo.setDateOfTravelling(scanner.nextLine());
        System.out.println("Enter Source");
        String sourceAirport = scanner.nextLine();
//        travelerInfo.setSource(scanner.nextLine());
        System.out.println("Enter Destination: ");
        String destinationAirport = scanner.nextLine();
//        travelerInfo.setDestination(scanner.nextLine());
        System.out.println("is one-Way? ture/false ");
//        travelerInfo.setOneWay(scanner.nextBoolean());
        Boolean isOneWay = scanner.nextBoolean();
        LocalDate localDate = LocalDate.now();
        System.out.println("Date of booking is: " + localDate);
        travelerInfo.setDateOfBooking(localDate);


        int validationCounter = 0;
        CNIC card validation;
        boolean check = true;
        for (int i = 0; i < CNIC.length(); i++) {
            char ch = CNIC.charAt(i);
            if ((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                check = false;
            }
        }
        //ignore below highlighting.
        if (check == false) {
            System.out.println("Invalid CNIC");
        } else {
            travelerInfo.setCNIC(CNIC);
            validationCounter++;
        }

        //Name validation
        if (name != null) {
            travelerInfo.setName(name);
            validationCounter++;
        } else {
            System.out.println("Name can't be empty");
        }

        //Date validation
        if (dateOfTravel != null) {
            validationCounter++;
            travelerInfo.setDateOfTravelling(dateOfTravel);
        } else {
            System.out.println("Date of Travel can't be empty");
        }

        //Source validation
        if (sourceAirport != null) {
            validationCounter++;
            travelerInfo.setSource(sourceAirport);

        } else {
            System.out.println("Source City can't be empty");
        }

        //Destination
        if (destinationAirport != null) {
            validationCounter++;
            travelerInfo.setDestination(destinationAirport);
        } else {
            System.out.println("Destination can't be empty");
        }


        //Seat Pattern and reservation.


        scanner.nextLine();

        validationCounter = 5;
        if (validationCounter == 5) {
            System.out.println("Enter Seat Number: ");
            String userInput = scanner.nextLine();

            arrayListStr.add("11A");
            int flagCheck = 1;


            do {

                int value = userInput.charAt(0) + userInput.charAt(1);
                for (int i = 49; i <= 58; i++) {
                    System.out.print((char) i + " ");
                    for (int j = 65; j < 69; j++) {
                        int fValue = (char) j;
                        int sValue = (char) i;
                        if (value == (fValue + sValue) && sValue == userInput.charAt(0)) {

                            for (int k = 0; k < arrayListStr.size(); k++) {
                                if (userInput.equals(arrayListStr.get(k))) {
                                    flagCheck = 0;
                                    break;
                                } else {
                                    flagCheck = 1;
                                }
                            }

                            if (flagCheck == 1) {
                                arrayListStr.add(userInput);
                            } else {
                                System.out.println("\nThis seat (" + userInput + ") Already Booked!\n");
                            }
                            System.out.print("X ");
                        } else {
                            System.out.print((char) j + " ");

                        }
                    }
                    System.out.println();
                }
                System.out.println("Enter Seat Number: ");
                userInput = scanner.nextLine();

            } while (!userInput.equals("0"));

        } else {
            System.out.println("\nYour Account Information is not Valid\n");
        }


        String array[] = new String[arrayListStr.size()];
        for (int i = 0; i < arrayListStr.size(); i++) {
            array[i] = arrayListStr.get(i);
        }


        int flag = 0;

        for (int i = 0; i < twoDArray.length; i++) {

            for (int j = 0; j < 4; j++) {

                for (int k = 0; k < array.length; k++) {
                    if (twoDArray[i][j].equals(array[k])) { // 1D = ?
                        flag = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 1) {
                    System.out.print("X ");
                } else {
                    if (twoDArray[i][j].charAt(1) == '0') {
                        System.out.print(twoDArray[i][j].charAt(2) + " ");
                    } else {
                        System.out.print(twoDArray[i][j].charAt(1) + " ");
                    }
                }

            }
            System.out.println();


        }
    }//main


    public static void seatReservation() {
        for (String arr : arrayListStr) {
            System.out.println(arr);
        }
    }

    public static void seatCancellation(String seat) {
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (seat.equals(twoDArray[i][j])) {
                    twoDArray[i][j] = "C";
                }
            }
        }
    }

    public static void menu() {

    }


}