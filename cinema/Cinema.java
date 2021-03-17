package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rowsNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();
        char[][] places = new char[rowsNumber][seatsNumber];

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                places[i][j] = 'S';
            }

        }

        String menu = "1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n";

        System.out.println(menu+"\n");
        Integer numberOfPurchasedT = 0;

        Integer currentIncome = 0;
        Integer totalIncome = totalIncomeCalculate(rowsNumber, seatsNumber);


        int input = scanner.nextInt();
        while(input!=0 ) {
            if(input == 1) {
                showPlace(places);
                System.out.println();
                System.out.println(menu);
                input = scanner.nextInt();
            }else if(input == 2) {
                System.out.println("Enter a row number:");
                int rowN = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seatN = scanner.nextInt();
                while ((rowN >rowsNumber || seatN > seatsNumber) || places[rowN-1][seatN-1] == 'B') {

                    if(rowN >rowsNumber || seatN > seatsNumber) {
                        System.out.println("Wrong input!\n");
                        System.out.println("Enter a row number:");
                        rowN = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatN = scanner.nextInt();
                    }else if(places[rowN-1][seatN-1] == 'B') {
                        System.out.println("That ticket has already been purchased!\n");
                        System.out.println("Enter a row number:");
                        rowN = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatN = scanner.nextInt();
                    }

                }



                int price = ticketPrice(null, rowsNumber, seatsNumber,rowN,seatN);
                System.out.println("Ticket price: $"+ticketPrice(null, rowsNumber, seatsNumber,rowN,seatN)+"\n");
                numberOfPurchasedT ++;
                currentIncome+= price;


                updatePlaceWithoutShow(places, rowN, seatN);
                System.out.println(menu);
                input = scanner.nextInt();
            } else if(input==3) {

                double percentage = (double)numberOfPurchasedT*100/ (double)(rowsNumber*seatsNumber);
                System.out.printf("Number of purchased tickets: %d\nPercentage: %.2f%s\nCurrent income: $%d\nTotal income: $%d\n\n",numberOfPurchasedT,percentage,"%",currentIncome,totalIncome);
                System.out.println(menu);
                input = scanner.nextInt();
            }
        }






    }

    public static void makePlace(int rowsNumber, int seatsNumber) {
        char[][] places = new char[rowsNumber][seatsNumber];

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                places[i][j] = 'S';
            }

        }
// System.out.print("Cinema:\n  ");
// for(int i = 1; i <= seatsNumber; i++) {
//     System.out.print(i+" ");
// }
// System.out.println();
//
// for (int i = 0; i < places.length; i++) {
//     System.out.print(i + 1 + " ");
//     for (int j = 0; j < places[i].length; j++) {
//         System.out.print(places[i][j] + " ");
//     }
//     System.out.println();
//
// }
    }
    public static void showPlace(char[][] places) {


        System.out.print("Cinema:\n  ");
        for(int i = 1; i <= places[0].length; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < places.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < places[i].length; j++) {
                System.out.print(places[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void updatePlaceWithoutShow(char[][] places, int a , int b ) {

        places[a-1][b-1] = 'B';


    }

    public static void totalPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rowN = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatN = scanner.nextInt();
        int totalIncome;

        if (rowN * seatN <= 60) {
            totalIncome = rowN * seatN * 10;
        } else {

            if (rowN % 2 == 0) {
                totalIncome = rowN * seatN * 9;
            } else {

                totalIncome = ((rowN / 2 + 1) * seatN * 8) + (rowN / 2 * seatN * 10);
            }

        }

        System.out.println("Total income:\n$" + totalIncome);

    }
    public static int ticketPrice(int[][] places, int rowsNumber, int seatsNumber,int rowN,int seatN) {


        int price;

        if (rowsNumber* seatsNumber<= 60) {
            return 10;
        } else {

            if (rowN <= rowsNumber/2) {
                return 10;
            }

            return 8; }}

    public static int totalIncomeCalculate(int rowsNumber, int seatsNumber) {


        int price;

        if (rowsNumber* seatsNumber<= 60) {
            return rowsNumber * seatsNumber * 10;
        } else {

            return rowsNumber/2*10*seatsNumber + (rowsNumber -rowsNumber/2)*8*seatsNumber;
        }


    }

}