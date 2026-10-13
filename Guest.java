public class Guest implements Displayable {
    private int id;
    private String name;
    private String phone;

    public Guest(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    
    public void displayInfo() {
        System.out.println("Guest ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }

    public int getGuestId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setGuestId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }
}