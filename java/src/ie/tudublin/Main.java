package ie.tudublin;

public class Main
{	
	public void Mine()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CoolVis());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.Mine();			
	}
}