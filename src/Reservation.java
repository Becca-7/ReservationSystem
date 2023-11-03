 class Reservation {
    public String reservationName;
    public int numOfPeople;
    public double timeBooked;
    public double timeScheduled;
    public int priority; //numbers 1-5 will denote priority

    public Reservation(String pReservationName,int pNumOfPeople, double pTimeBooked,double pTimeScheduled, int pPriority){
        reservationName=pReservationName;
        numOfPeople=pNumOfPeople;
        timeBooked =pTimeBooked;
        timeScheduled =pTimeScheduled;
        priority =pPriority;

    }
public String toString(){
        return("Name: "+this.reservationName+"\n Number of people: "+ this.numOfPeople+ "\n Time Booked: "+this.timeBooked+"\n Time Scheduled "+timeScheduled+"\n\n");

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