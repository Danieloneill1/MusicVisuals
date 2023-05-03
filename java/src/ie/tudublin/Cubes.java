package ie.tudublin;

import java.util.Map;

import ddf.minim.analysis.FFT;
import ddf.minim.ugens.Line;
import processing.core.*;

public class Cubes
{
    CoolVis cv;
    float x;
    float y;
    float cy = 0;
    float f = 0;
    int i = 0;
    float j = 0;
    float[] lerpedBuffer;
    float rotationX = 0;
    float rotationY = 0;
    float rotationZ = 0;
    float targetRotationX = 0;
    float targetRotationY = 0;
    float targetRotationZ = 0;

    public Cubes(CoolVis cv)
    {
        this.cv = cv;
        x = this.cv.width;
        y = this.cv.height;
        cy = this.cv.height / 2;
        f = 0;
        lerpedBuffer = new float[this.cv.width];
    }

    
    public void render()
    {
        float growthFactor = (float) 0.5;
        float size = 80;

        int width = 1024;
        int height = 500;

        float centerX = width / 2;
        float centerY = height / 2;
        float LeftX = centerX / 2;
        float LeftY = centerY / 2;
        float RightX = (float) (centerX * 1.5);
        float RightY = (float) (centerY * 1.5);

        cv.stroke(0);
        cv.strokeWeight(2);
        cv.colorMode(PApplet.HSB);
        
        for(int i = 0; i < 43.07; i++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getFrameSize(), 0, 255), 255, 255);
            // Calculate the new size of the square based on the frequency band
            if (i < cv.getSmoothedBands().length) 
            {
                size += cv.getSmoothedBands()[i] * growthFactor;
            }

            float x1 = centerX - size/2;
            float y1 = centerY - size/2;
            float x2 = centerX + size/2;
            float y2 = centerY - size/2;
            float x3 = centerX + size/2;
            float y3 = centerY + size/2;
            float x4 = centerX - size/2;
            float y4 = centerY + size/2;

            float Lx1 = LeftX - size/2;
            float Ly1 = LeftY - size/2;
            float Lx2 = LeftX + size/2;
            float Ly2 = LeftY - size/2;
            float Lx3 = LeftX + size/2;
            float Ly3 = LeftY + size/2;
            float Lx4 = LeftX - size/2;
            float Ly4 = LeftY + size/2;

            float Rx1 = RightX - size/2;
            float Ry1 = RightY - size/2;
            float Rx2 = RightX + size/2;
            float Ry2 = RightY - size/2;
            float Rx3 = RightX + size/2;
            float Ry3 = RightY + size/2;
            float Rx4 = RightX - size/2;
            float Ry4 = RightY + size/2;

            //cv.line(i, cy, i, cy + cy * cv.getAudioBuffer().get(i));
            cv.line(x1, y1, x2, y2);
            cv.line(x2, y2, x3, y3);
            cv.line(x3, y3, x4, y4);
            cv.line(x4, y4, x1, y1);

            cv.line(Lx1, Ly1, Lx2, Ly2);
            cv.line(Lx2, Ly2, Lx3, Ly3);
            cv.line(Lx3, Ly3, Lx4, Ly4);
            cv.line(Lx4, Ly4, Lx1, Ly1);

            cv.line(Rx1, Ry1, Rx2, Ry2);
            cv.line(Rx2, Ry2, Rx3, Ry3);
            cv.line(Rx3, Ry3, Rx4, Ry4);
            cv.line(Rx4, Ry4, Rx1, Ry1);
        }
            
        
    }    
}
