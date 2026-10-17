package uber;

public class Vehicle {
    private int id;
    private String registrationNumber;
    private String model;
    private int seatingCapacity;

    public Vehicle(int id, String registrationNumber,
                   String model, int seatingCapacity) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.seatingCapacity = seatingCapacity;
    }

    public int getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
