package uber;

public class Rider {
    private int id;
    private String name;
    private Location location;

    public Rider(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }
}
