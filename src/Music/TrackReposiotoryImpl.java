package Music;

import java.util.HashMap;
import java.util.Map;

public class TrackReposiotoryImpl implements TrackRepository {

    Map<String, Track> data = new HashMap<>();

    @Override
    public Track findById(String id) {
        return data.get(id);
    }

    public void saveData(Track track){
        data.put(track.getId(), track);
    }
}
