import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Reservation {
    public String reservationName;
    public int numOfPeople;
    public String timeBooked;
    public Date timeBookedDate;
    public Date timeScheduledDate;
    public String timeScheduled;
    public int priority; //numbers 1-5 will denote priority
    public int timeScheduledInt;
    public int timeBookedInt;

    public Reservation(String pReservationName, int pNumOfPeople, String pTimeBooked, String pTimeScheduled) {
        reservationName=pReservationName;
        numOfPeople=pNumOfPeople;
        timeBooked =pTimeBooked;
        timeScheduled =pTimeScheduled;

        DateFormat dateFormat = new SimpleDateFormat("kk:mm");
        try {
            timeBookedDate = dateFormat.parse(pTimeBooked);
            timeScheduledDate=dateFormat.parse(pTimeScheduled);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //making date scheduled into int to sort the reservations
        String[] timeScheduledNewString=timeBooked.split(":");
        int hourScheduled=Integer.parseInt(timeScheduledNewString[0]);
        int minuteScheduled=Integer.parseInt(timeScheduledNewString[1]);
        timeScheduledInt = (60 * minuteScheduled) + (3600 * hourScheduled);

        //making date booked into int to set priority based on who scheduled first
        String[] timeBookedNewString=timeBooked.split(":");
        int hourBooked=Integer.parseInt(timeScheduledNewString[0]);
        int minuteBooked=Integer.parseInt(timeScheduledNewString[1]);
        timeBookedInt = (60 * minuteBooked) + (3600 * hourBooked);


        //do an if then for if the time it's scheduled is before the current time then cancel the reservation
        //calculate priority
    }
public String toString(){
        return("Name: "+reservationName+"\nNumber of people: "+ numOfPeople+ "\nTime Booked: "+timeBooked+"\nTime Scheduled "+timeScheduled+"\nPriority: "+priority+"\n");

     }



}
//constructor
//print method,
//new class reservation system
//add reservation, cancel reservation, sort reservation, "public void"
//define an array list for the reservation
//add reservation adds reservation to the array
//psvm manually adds and cencels reservation
//add input from the user
//display reservation



//to do when done with basic system:
//intigrate real time,
//add switch method to print method