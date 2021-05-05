package com.company.Assignment3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculations {

    Scanner scanner = new Scanner(System.in);

    public void seatPattern(String[][] twoDArray) {

        int counter = 1;

        for (String[] strings : twoDArray) {
            System.out.print(Enhancment.RESET + counter + " ");
            for (int j = 0; j < 4; j++) {
                if (strings[j].charAt(1) == '0') {
                    System.out.print(Enhancment.RESET + strings[j].charAt(2) + " ");
                } else {
                    System.out.print(Enhancment.RESET + strings[j].charAt(1) + " ");

                }
            }
            counter++;


        }
    }

    public void seatReservation(String[][] twoDArray, ArrayList<String> arrayListStr) {

        int validationCounter = 0;

        TravelerInfo travelerInfo = new TravelerInfo();
        System.out.println(Enhancment.RESET + "Please Enter Your Information\n ");
        System.out.println("Enter CNIC: ");
        String CNIC = scanner.nextLine();


        //CNIC  validation
        boolean check = true;
        for (int i = 0; i < CNIC.length(); i++) {
            char ch = CNIC.charAt(i);
            if ((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                check = false;
            }
        }
        if (check == false) {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + "Invalid CNIC");
        } else {
            travelerInfo.setCNIC(CNIC);
            validationCounter++;
        }
        System.out.println(Enhancment.RESET + "Enter Name: ");
        String name = scanner.nextLine();

        //Name validation
        if (name != null) {
            travelerInfo.setName(name);
            validationCounter++;
        } else {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + "Name can't be empty");
        }

        System.out.println(Enhancment.RESET + "Enter Date of Travel: ");
        String dateOfTravel = scanner.nextLine();

        //TravelDate validation
        if (dateOfTravel != null) {
            validationCounter++;
            travelerInfo.setDateOfTravelling(dateOfTravel);
        } else {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + "Date of Travel can't be empty");
        }
        System.out.println(Enhancment.RESET + "Enter Source");
        String sourceAirport = scanner.nextLine();

        //SourceAirport validation
        if (sourceAirport != null) {
            if (sourceAirport.equals("Lahore") || sourceAirport.equals("lahore") || sourceAirport.equals("Karachi") || sourceAirport.equals("karachi")) {
                validationCounter++;
                travelerInfo.setSource(sourceAirport);
            } else {
                System.out.println(Enhancment.RED_BOLD_BRIGHT + "Sorry! we dont entertain any flight outside Lahore/Karachi.");
            }
        } else {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + "Source City can't be empty");
        }


        System.out.println(Enhancment.RESET + "Enter Destination: ");
        String destinationAirport = scanner.nextLine();

        //Destination Validation

        if (destinationAirport != null) {
            if (destinationAirport.equals("Lahore") || destinationAirport.equals("lahore") || destinationAirport.equals("Karachi") || destinationAirport.equals("karachi")) {
                validationCounter++;
                travelerInfo.setDestination(destinationAirport);
            } else {
                System.out.println(Enhancment.RED_BOLD_BRIGHT + "Sorry! we dont entertain any flight outside Lahore/Karachi.");
            }
        } else {
            System.out.println(Enhancment.RESET + "Destination City can't be empty");
        }


        System.out.println(Enhancment.RESET + "is one-Way? true/false ");
        travelerInfo.setOneWay(scanner.nextBoolean());

        LocalDate localDate = LocalDate.now();
        System.out.println("Date of booking is: " + localDate);
        scanner.nextLine();

        travelerInfo.setDateOfBooking(localDate);

        if (validationCounter == 5) {  // True if provided information by user is correct.

            System.out.println(Enhancment.RESET + "Enter Seat Number: ");
            String userInput = scanner.nextLine();

            //This is just a helping addition and it has nothing to do with ticket booking.
            arrayListStr.add("11A");
            int flagCheck = 1;

            do {

                int value = userInput.charAt(0) + userInput.charAt(1);
                for (int i = 49; i <= 58; i++) {
                    System.out.print(Enhancment.RESET + (char) i + " ");
                    for (int j = 65; j < 69; j++) {
                        int fValue = (char) j;
                        int sValue = (char) i;
                        if (value == (fValue + sValue) && sValue == userInput.charAt(0)) {

                            for (String s : arrayListStr) {
                                if (userInput.equals(s)) {
                                    flagCheck = 0;
                                    break;
                                } else {
                                    flagCheck = 1;
                                }
                            }

                            if (flagCheck == 1) {
                                arrayListStr.add(userInput);
                            } else {
                                System.out.println(Enhancment.RED_BOLD_BRIGHT + "\nThis seat (" + userInput + ") Already Booked!\n");
                            }
                            System.out.print(Enhancment.RESET + "X ");
                        } else {
                            System.out.print(Enhancment.RESET + (char) j + " ");

                        }
                    }
                    System.out.println();
                }
                System.out.println("Enter Seat Number: ");
                userInput = scanner.nextLine();

            } while (!userInput.equals("0"));

            travelerInfo.setBookedSeats(arrayListStr);
            InterfaceClass.userInfoList.add(travelerInfo);
            showSeats(twoDArray, arrayListStr);

        } else {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + "YOUR INFORMATION IS NOT CORRECT! PLEASE TRY AGAIN.");
        }

    }

    public void showSeats(String[][] twoDArray, ArrayList<String> arrayListStr) {

        String array[] = new String[arrayListStr.size()];
        for (int i = 0; i < arrayListStr.size(); i++) {
            array[i] = arrayListStr.get(i);
        }


        int flag = 0;
        int counter = 1;

        for (String[] strings : twoDArray) {
            System.out.print(Enhancment.BLUE_BOLD_BRIGHT + counter + " ");
            for (int j = 0; j < 4; j++) {

                for (int k = 0; k < array.length; k++) {
                    if (strings[j].equals(array[k])) { // 1D = ?
                        flag = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 1) {
                    System.out.print(Enhancment.RED_BOLD_BRIGHT + "X ");
                } else {
                    if (strings[j].charAt(1) == '0') {
                        System.out.print(Enhancment.RESET + strings[j].charAt(2) + " ");
                    } else {
                        System.out.print(Enhancment.RESET + strings[j].charAt(1) + " ");
                    }
                }

            }
            System.out.println();
            counter++;
        }
    }

    public void availableSeats(String[][] twoDArray, ArrayList<String> arrayListStr) {

        String array[] = new String[arrayListStr.size()];
        for (int i = 0; i < arrayListStr.size(); i++) {
            array[i] = arrayListStr.get(i);
        }


        int flag = 0;
        int counter = 1;

        for (int i = 0; i < twoDArray.length; i++) {
            System.out.print(Enhancment.RESET + counter + " ");
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
                    System.out.print(Enhancment.RESET + "X ");
                } else {
                    if (twoDArray[i][j].charAt(1) == '0') {
                        System.out.print(Enhancment.GREEN_BOLD_BRIGHT + twoDArray[i][j].charAt(2) + " ");
                    } else {
                        System.out.print(Enhancment.GREEN_BOLD_BRIGHT + twoDArray[i][j].charAt(1) + " ");
                    }
                }

            }
            System.out.println();
            counter++;
        }
    }

    public void reservedSeats(String[][] twoDArray, ArrayList<String> arrayListStr) {
        String array[] = new String[arrayListStr.size()];
        for (int i = 0; i < arrayListStr.size(); i++) {
            array[i] = arrayListStr.get(i);
        }


        int flag = 0;
        int counter = 1;

        for (int i = 0; i < twoDArray.length; i++) {
            System.out.print(Enhancment.RESET + counter + " ");
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
                    System.out.print(Enhancment.RED_BOLD_BRIGHT + "X ");
                } else {
                    if (twoDArray[i][j].charAt(1) == '0') {
                        System.out.print(Enhancment.RESET + twoDArray[i][j].charAt(2) + " ");
                    } else {
                        System.out.print(Enhancment.RESET + twoDArray[i][j].charAt(1) + " ");
                    }
                }

            }
            System.out.println();
            counter++;
        }

    }

    public void seatCancellation(ArrayList<TravelerInfo> userInfoList, ArrayList<String> arrayListStr) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(Enhancment.RESET + "Enter your CNIC: ");
        String CNIC = scanner.nextLine();

        int flag = 0;
        for (TravelerInfo travelerInfo : userInfoList) {
            if (CNIC.equals(travelerInfo.getCNIC())) {
                System.out.println(Enhancment.RESET + "Enter Seat Number: ");
                String seatNo = scanner1.next();
                for (int k = 0; k < travelerInfo.getBookedSeats().size(); k++) {

                    if (seatNo.equals(travelerInfo.getBookedSeats().get(k))) {
                        flag = 1;
                    }
                }

                if (flag == 1) {
                    System.out.println(Enhancment.GREEN_BOLD_BRIGHT + "Seat Has Been Cancelled");
                    arrayListStr.remove(seatNo);
                } else {
                    System.out.println(Enhancment.RED_BOLD_BRIGHT + "Sorry, " + seatNo + " does not belong to you! ");
                }
            }

        }
    }

    public void searchReservation(ArrayList<String> arrayListStr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Enhancment.RESET + "Enter Seat Number: ");
        String seatNo = scanner.nextLine();

        int flag = 0;
        for (int i = 0; i < arrayListStr.size(); i++) {
            if (seatNo.equals(arrayListStr.get(i))) {
                flag = 1;
            }
        }

        if (flag == 1) {
            System.out.println(Enhancment.RED_BOLD_BRIGHT + seatNo + " seat is Not Available");
        } else {
            System.out.println(Enhancment.GREEN_BOLD_BRIGHT + seatNo + " seat is Available");
        }


    }
}