public class SingleRoom extends Room{
   private boolean hasExtraBed;
   public SingleRoom (int roomNumber,double pricePerNight,boolean hasExtraBed){
      super(roomNumber,pricePerNight);
      this.hasExtraBed=hasExtraBed;
   }


   public double calculateCost(int nights){//Override
      double totalCost=pricePerNight*nights;
      if(hasExtraBed){
         totalCost+=100*nights;
      }
      return totalCost;
   }

   public String getRoomType(){//Override
      return "Single Room ";
   }

   public void displayInfo(){//Override
      super.displayInfo();
      System.out.println("Extra bed: "+ hasExtraBed);
   }


   public boolean isHasExtraBed(){
      return hasExtraBed;
   }
   public void setHasExtraBed(boolean hasExtraBed){
      this.hasExtraBed=hasExtraBed;
   }


}//end class Room