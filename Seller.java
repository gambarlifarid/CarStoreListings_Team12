public class Seller {
    private String fullname;
    private String city;
    private String number;

    public Seller(String fullname, String city, String number) {
        this.fullname = fullname;
        this.city = city;
        this.number = number;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Name and Surname: " + fullname + " \n" + "City: " + city + " \n"+ "Number: "+  number;
    }

}
