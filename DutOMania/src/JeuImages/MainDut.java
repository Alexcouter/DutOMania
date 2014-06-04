package JeuImages;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainDut extends JPanel{
	  private Image bg;
	  public MainDut()
	  {
		  setBounds(0, 0, 800, 600);
	    try
	    {
	      this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/MainDut.jpg"));
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  public void paintComponent(Graphics g)
	  {
	      g.drawImage(this.bg, 0, 0, this);
	
	  }


}
