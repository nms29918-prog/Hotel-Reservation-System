public abstract class Room implements Displayable {
   protected int roomNumber;
   protected double pricePerNight;
   protected boolean isAvailable;
   public Room(int roomNumber,double pricePerNight){
      this.roomNumber=roomNumber;
      this.pricePerNight=pricePerNight;
      this.isAvailable=true;
   }
   
   //abstract
   public abstract double calculateCost(int nights);
   
   public abstract String getRoomType(); 
   
   
   
   
   public void bookRoom(){
      this.isAvailable=false;
   }
   public void releaseRoom(){
      this.isAvailable=true;
   }
   public int getRoomNumber(){
      return roomNumber;
   }
   public double getPricePerNight(){
      return pricePerNight;
   }
   public boolean isAvailable(){
      return isAvailable;
   }
   
   public void displayInfo(){//override
      System.out.println("Room Number: " + roomNumber);
      System.out.println("Price Per Night: " + pricePerNight);
      System.out.println("Available: " + isAvailable);
   
   }
   
}