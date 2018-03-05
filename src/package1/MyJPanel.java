package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	
	public MyJPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		g.setColor(Color.RED);
		g.drawString("Testing Testing 123", 100, 20);
	}
}
