public class Hotel implements Displayable{

   private String hotelName;
   private int count;
   private Reservation[] reservations = new Reservation[100];
   private Room[] rooms = new Room[50];
   private int roomCount;


   public Hotel(String hotelName){ 
      this.hotelName=hotelName;
   }

   public boolean addRoom(Room r){
      if(r == null || roomCount >= rooms.length || searchRoom(r.getRoomNumber()) != null){
         return false;}
      rooms[roomCount++]=r;
      return true;
   }


   public Room searchRoom(int roomNumber){
      for(int i=0; i<roomCount; i++){
         if(rooms[i].getRoomNumber() == roomNumber){
            return rooms[i];
         }}
      return null;
   }

   public void displayAvailableRooms(){
      boolean found = false;
      for(int i=0; i<roomCount ; i++){
         if(rooms[i].isAvailable()){
            System.out.println("=======================================");
            rooms[i].displayInfo();
            found = true;
         }}
      if(!found){
         System.out.println("No available rooms.");
      }
   }


   public boolean makeReservation(int id ,Guest guest, Room room, int nights){
      if(count >= reservations.length || guest ==null || room== null || nights <=0 || !room.isAvailable() || searchReservation(id) != null ){
         return false;}
      reservations[count++]= new Reservation(id,guest,room,nights);
      return true;
   }


   public boolean removeReservation(int id){
      for(int i=0; i<count; i++){
         if(reservations[i].getReservationId()==id){//search for the givin id Reservation number, if found then delete Reservation & return true, if not found then return false 
            reservations[i].cancelReservation();
            for(int j=i ; j<count-1;j++){//start shiftting
               reservations[j]=reservations[j+1];
            }
            reservations[count-1]=null ;//delete Reservation & end shiftting
            count--;
         //end search
            return true;
         }}
      return false;
   }

   public Reservation searchReservation(int id){
      for(int i=0; i<count; i++){
         if(reservations[i].getReservationId()==id){
            return reservations[i];
         }
      }
      return null;
   }


   public double totalRevenue(){ ////recursive method
      return totalRevenue(0);
   }

   private double totalRevenue(int index){
      if(index==count)
         return 0;
      return reservations[index].getTotalCost() + totalRevenue(index+1);
   }////end recursive method



   public void displayInfo(){//override
      System.out.println("HOTEL Name: "+hotelName );
      for(int i =0; i<count; i++){
      reservations[i].getGuest().displayInfo();
         System.out.println("Booking type:  "+ reservations[i].getRoom().getRoomType());
         System.out.println("=======================================");
      }//end loop
   }

   public String getHotelName(){
      return hotelName;
   }

   public int getCount(){
      return count;
   }


}//end class Hotel