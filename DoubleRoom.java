public class DoubleRoom extends Room{
private int numberOfBeds;
public DoubleRoom (int roomNumber,double pricePerNight,int numberOfBeds){
super(roomNumber,pricePerNight);
this.numberOfBeds=numberOfBeds;
}
@Override
public double calculateCost(int nights){
return pricePerNight*nights;
}
public int getNumberOfBeds(){
return numberOfBeds;
}
public void setNumberOfBeds(int numberOfBeds){
this.numberOfBeds=numberOfBeds;
}
}