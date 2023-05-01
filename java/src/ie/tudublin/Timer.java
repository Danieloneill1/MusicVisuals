package ie.tudublin;

public class Timer {
    int start = 0;
    boolean running = false;
    CoolVis cv;

    public Timer(CoolVis cv){
        this.cv = cv;
    }

    public void start(){
        start = cv.millis();
        running = true;
    }

    public void stop(){
        running = false;
    }

    public int how_long(){
        int how_long = (cv.millis()-start);
        return how_long;
    }

    public int seconds(){
        return how_long() / 1000;
    }
}