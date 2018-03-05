package mainPackage;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MyPanel extends JPanel{
	private boolean imageUp;
	private Image theImage;
	
	public MyPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		System.out.println("Painting");
		super.paintComponent(g);
		if(imageUp)
		{
			//undraw Image
			System.out.println("Will Undraw Image");
			imageUp = false;
		}
		else
		{
			System.out.println("FoReal");
			//draw Image
			g.drawImage(theImage, 10, 10, getWidth(), getHeight(), null);
			imageUp = true;
		}
	}
	
	protected void alternateImage(Image input)
	{
		theImage = input;
		repaint();
	}
	
	
}
