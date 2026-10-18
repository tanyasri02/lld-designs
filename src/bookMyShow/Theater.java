package bookMyShow;

import java.util.HashMap;

public class Theater {
    private int id;
    private String name;
    private String location;

    private HashMap<Integer, Screen> screens = new HashMap<>();

    public Theater(int id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addScreen(Screen screen) {
        screens.put(screen.getId(), screen);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, Screen> getScreen() {
        return screens;
    }

    public String getLocation() {
        return location;
    }

}
