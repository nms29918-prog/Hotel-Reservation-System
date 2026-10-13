public class Reservation implements Displayable{

   private int reservationId;
   private Guest guest;
   private Room room;
   private int numberOfNights;


   public Reservation(int id, Guest g,Room r, int nights ){//Constructor
      this.reservationId=id;
      guest=g;
      room=r;
      numberOfNights=nights;
      room.bookRoom();// to make the room unavilable (from class Room) 
   }


   public double getTotalCost(){
      return room.calculateCost(numberOfNights);
   }



   public void cancelReservation(){// to cancel the room unavilable (from class Room) 
      room.releaseRoom();
   }


   public void displayInfo(){//override
      System.out.println("Reservation ID:"+ reservationId);
      guest.displayInfo();
      room.displayInfo();
      System.out.println("Number Of Nights:"+ numberOfNights);
      System.out.println("Total cost:"+ getTotalCost());
   
   }




//getters

   public int getReservationId(){
      return reservationId;
   }

   public Guest getGuest(){
      return guest;
   }

   public Room getRoom(){
      return room;
   }

   public int getNumberOfNights(){
      return numberOfNights;
   }
}//end class Reservation