import java.util.ArrayList;
import java.util.Scanner;


public class ReservationSystem
{
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();


    public static void addReservation(String reservationName, int numOfPeople, String timeBooked, String timeScheduled){
        reservations.add(new Reservation(reservationName, numOfPeople,timeBooked,timeScheduled));

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

    public static void changeReservation(String changeResName, int newNum, String newTime){
        for(int x=0; x<reservations.size(); x++) {
            if (changeResName.equals(reservations.get(x).reservationName)) {
              reservations.get(x).numOfPeople=newNum;
              reservations.get(x).timeScheduled=newTime;
              break;
            }
        }
    }

    public static void Sort(){
        int i, j;
        Reservation temp;
        boolean swapped;
        for (i = 0; i < reservations.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < reservations.size() - i - 1; j++) {
                if (reservations.get(j).timeScheduledInt > reservations.get(j+1).timeScheduledInt) {
                    temp = reservations.get(j);
                    reservations.set(j, reservations.get(j+1));
                    reservations.set((j+1), temp);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }


    }

    public static void automaticReservationCancel(){
//if someone schedules the reservation for before the time they booked it the reservation will automatically cancel

    }

    public static void priority(){
        for (int j=0; j<reservations.size();j++){
            reservations.get(j).priority=j+1;
        }
        int i, j;
        int temp;
        boolean swapped;
        for (i = 0; i < reservations.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < reservations.size() - i - 1; j++) {
                if (reservations.get(j).timeBookedInt > reservations.get(j+1).timeBookedInt) {
                    temp = reservations.get(j).priority;
                    reservations.get(j).priority=reservations.get(j+1).priority;
                    reservations.get(j+1).priority=temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
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
                    System.out.println("Input Current Time (hh:mm in 24h clock):");//CHANGE THE PROMPT
                    String timeBooked = scanner.next();
                    System.out.println("Input Eating Time (hh:mm in 24h clock):");
                    String timeReserved = scanner.next();
                    addReservation(reservationName,numOfPeople,timeBooked,timeReserved);
                    priority();
                    break;

                case 2:
                    priority();
                    Sort();
                    display();
                    break;
                case 3:
                    System.out.println("Input the name of the reservation you would like to change:");
                    String changeResName=scanner.next();
                    System.out.println("Input the new number of people");
                    int newNum=scanner.nextInt();
                    System.out.println("Input the new time");
                    String newTime= scanner.next();
                    changeReservation(changeResName, newNum,newTime);
                    break;



                case 4:
                    System.out.println("Input the name of the reservation you would like to cancel:");
                    String cancelName=scanner.next();
                    cancelReservation(cancelName);
                    break;
                case 5:
                        System.exit(0);


            }

        }

    }



}

//used https://www.geeksforgeeks.org/bubble-sort/ to help with bubble sort
//used https://www.tutorialspoint.com/convert-string-of-time-to-time-object-in-java to help understand times from strings