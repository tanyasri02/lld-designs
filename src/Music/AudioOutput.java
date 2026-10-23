package Music;
//AudioOutput -> start,stop,
public interface AudioOutput {
    void play(String audioUri);
    void pause();
    void resume();
    void seek(int positionSeconds);
    void stop();
}