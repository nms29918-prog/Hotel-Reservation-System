import java.util.Scanner;
public class HotelTester{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
   
   
   // THE HOTEL
      Hotel ritz =new Hotel("The Ritz");
   
   // Room objects
      ritz.addRoom(new SingleRoom(101, 110.00, true));
      ritz.addRoom(new DoubleRoom(202, 220.00, 2));
      ritz.addRoom(new SuiteRoom(303, 330.00, true));
      ritz.addRoom(new SuiteRoom(404, 440.00, false));
      ritz.addRoom(new LuxurySuiteRoom(505, 505.00, true , false));
      SuiteRoom r6 = (new LuxurySuiteRoom(606, 606.00,false , true));//poly
      ritz.addRoom(r6);
   
   
   
      System.out.println("****************** Hotel Booking System ******************");
      int choice;
      do{
         System.out.println("\nWelcome to "+ ritz.getHotelName()+" hotel ! \nWhat can we help you with today? ");
         System.out.println("1.Display avalilable rooms: ");
         System.out.println("2.Make a reservation: ");
         System.out.println("3.Find a reservation: ");
         System.out.println("4.Cancel a reservation: ");
         System.out.println("5.Display all guests: ");
         System.out.println("6.Display total revenue: ");
         System.out.println("7.Exit");
         System.out.println("Your choice is:");
         choice= input.nextInt();
         input.nextLine();//garbage
      
      
      
         switch(choice){
            case 1:
               System.out.println("------------------ Avalilable rooms ------------------");
               ritz.displayAvailableRooms();
               break;
         
            case 2:{////////////////////
               System.out.println("------------------ make a reservation ------------------");
               System.out.println("Enter reservation ID: ");
               int resId = input.nextInt();
               input.nextLine();//garbage
               if(ritz.searchReservation(resId)!=null){
                  System.out.println("This reservation ID already exists. ");
                  break;
               }
               System.out.println("Enter Guest name: ");
               String name = input.nextLine();
               System.out.println("Enter Guest ID: ");
               String guestId = input.nextLine();
               System.out.println("Enter Guest phone num#: ");
               String phone = input.nextLine();
            
            
               ritz.displayAvailableRooms();
               System.out.println("Enter room number: ");
               int roomNumber = input.nextInt();
               input.nextLine();//garbage
            
               Room room= ritz.searchRoom(roomNumber);////////////////////////////////////// maf 
               if(room== null){
                  System.out.println("Room not found.");
                  break;
               }
               System.out.println("Enter number of nights: ");
               int nights = input.nextInt();
               input.nextLine();//garbage
            
               if(ritz.makeReservation(resId, new Guest(guestId, name, phone),room,nights)){
                  System.out.println("Reservation added sucessfully!");
               }else{
                  System.out.println("Erorr.. Could not add the reservation.");
               }
               break;
         
            }
         
            case 3:{
               System.out.println("Enter the reservation ID: ");
               int findId = input.nextInt();
               Reservation found = ritz.searchReservation(findId);
               if(found != null){
                  found.displayInfo();
               }
               else{
                  System.out.println("Reservation not found. ");
               }
               break;
            }
            case 4: {
               System.out.println("Enter the reservation ID to cancel:");
               int cancelId = input.nextInt();
               if(ritz.removeReservation(cancelId)){
                  System.out.println("Reservation canceled:");
               }
               else{
                  System.out.println("Reservation not canceled:");
               }
               break;
            }
            case 5:{
               ritz.displayInfo();
               break;
            }
            case 6:{
               System.out.println("The Ritz total revenue "+ ritz.totalRevenue());
               break;
            }
            case 7:{
               System.out.println("Thank you for using our system... Goodbye! ");
               break;
            }
            default:
               System.out.println("Invalid option, try again");
         
         }//end switch
      }while(choice !=7 );//end do
   
   
   
   }//end main
}//end class HotelTester