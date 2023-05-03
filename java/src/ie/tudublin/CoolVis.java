package ie.tudublin;

import processing.core.PApplet;

public class CoolVis extends Visual
{
    public Timer timer;
    Cubes cube;
    Spheres Sphere;
    Cones Cone;
    Waves Wave;
    float x;
    float y;


    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        startMinim();
        
        //loadAudio("heroplanet.mp3");
        startListening();
        /*
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");
        //strokeWeight(2);

        cube = new Cubes(this);
        Sphere = new Spheres();
        Cone = new Cones();
        Wave = new Waves();
        
        // Controls when each visuals happen
        Timer timer = new Timer(this);*/
        cube = new Cubes(this);
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
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        cube.render();
    }

}