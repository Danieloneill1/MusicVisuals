package ie.tudublin;

//import ie.tudublin.*;

public class CoolVis extends Visual
{
    public Timer timer;
    Cubes cube;
    Spheres Sphere;
    Cones Cone;
    Waves Wave;


    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");
        strokeWeight(2);

        cube = new Cubes();
        Sphere = new Spheres();
        Cone = new Cones();
        Wave = new Waves();
        
        // Controls when each visuals happen
        Timer timer = new Timer(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            timer.start();
        }
    }

    public void draw()
    {
        background(0);

        //calculateAverageAmplitude();
        
        if (!timer.running){
            cube.render();
        }

        if(timer.seconds() < 6){
            Sphere.render();
        }

        if (timer.seconds() >= 6 && timer.seconds() <= 13){
            Cone.render();
        }

        if (timer.seconds() > 13 && timer.seconds() + 0.5f < 21){
            Wave.render();
        }
 
    }

    
}