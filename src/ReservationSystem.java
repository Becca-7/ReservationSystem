import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReservationSystem
{
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();


    public static void addReservation(String reservationName,int numOfPeople, double timeBooked,double timeScheduled, int priority){
        reservations.add(new Reservation(reservationName, numOfPeople,timeBooked,timeScheduled,priority));

    }

    public static void cancelReservation(String cancelName){
        for(int x=0; x<reservations.size(); x++){
            if(cancelName.equals(reservations.get(x).reservationName)){
                reservations.remove(x);
            }
        }
    }


    public static void display() {
        for (int x = 0; x < reservations.size(); x++) {
            System.out.println(reservations.get(x).toString());
        }
    }

    public static void changeReservation(String changeResName, int newNum, double newTime){
        System.out.println("Input the name of the reservation you would like to cancel:");
        for(int x=0; x<reservations.size(); x++) {
            if (changeResName.equals(reservations.get(x).reservationName)) {
              reservations.get(x).numOfPeople=newNum;
              reservations.get(x).timeScheduled=newTime;
              break;
            }
        }
    }

    public static void Sort(){
  //  Collections.sort(reservations.);

    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Press 1 to make a reservation");
            System.out.println("Press 2 to display reservations");
            System.out.println("Press 3 to change a reservation");
            System.out.println("Press 4 to cancel a reservation");
            System.out.println("Press 5 to exit");

            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Input reservation name:");
                    String reservationName = scanner.next();
                    System.out.println("Input party size:");
                    int numOfPeople = scanner.nextInt();
                    System.out.println("Insert Current time:");
                    double timeBooked = scanner.nextDouble();
                    System.out.println("Input Eating Time:");
                    double timeReserved = scanner.nextDouble();
                    System.out.println("Input priority:");
                    int priority = scanner.nextInt();
                    addReservation(reservationName,numOfPeople,timeBooked,timeReserved,priority);
                    break;

                case 2:
                    display();
                    break;
                case 4:

                  System.out.println("Input the name of the reservation you would like to cancel:");
                  String cancelName=scanner.next();
                  cancelReservation(cancelName);

                  break;
                case 3:
                    System.out.println("Input the name of the reservation you would like to change:");
                    String changeResName=scanner.next();
                    System.out.println("Input the new number of people");
                    int newNum=scanner.nextInt();
                    System.out.println("Input the new time");
                    double newTime= scanner.nextDouble();
                    changeReservation(changeResName, newNum,newTime);
                    break;

                case 5:
                        System.exit(0);


            }

        }

    }



}

//swing
