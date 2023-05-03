package ie.tudublin;

public class CoolVis extends Visual
{
    Cubes cube;
    float x;
    float y;


    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        startMinim();
        //setFrameSize(256);
        loadAudio("/Users/danieloneill/Desktop/OOP_Assignment/MusicVisuals/java/data/Bastille - Pompeii (Official Music Video) (256 kbps).mp3");
        //startListening();

        cube = new Cubes(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
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