package mainPackage;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MainClass implements ActionListener
{
	private Image lftImg;
	private ImageIcon leftButtonIcon;
	private Image rgtImg;
	private ImageIcon rightButtonIcon;
	private Image mdlImg;
	private ImageIcon middleButtonIcon;
	private Image myPicImg;
	private ImageIcon myPicIcon;
	public static final int x = 50;
	public static final int y = 50;
	private JFrame frame;
	private boolean picUp;
	JButton b1;
	JButton b2;
	JButton b3;
	JPanel newContentPane;
	
	private void addButtons()
	{
		picUp = false;
		b1 = new JButton("Turn off middle button.");
		b1.setIcon(leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.setMnemonic(KeyEvent.VK_LEFT);
		b1.setActionCommand("disable");
		b1.setEnabled(true);
		
		b2 = new JButton("Enables Picture", middleButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_DOWN);
		b2.setActionCommand("run");
		b2.setEnabled(true);
		
		b3 = new JButton("Turn on middle button.", rightButtonIcon);
		b3.setVerticalTextPosition(AbstractButton.CENTER);
		b3.setHorizontalTextPosition(AbstractButton.TRAILING);
		b3.setActionCommand("enable");
		b3.setEnabled(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b1.setToolTipText("Disables Middle Button");
		b3.setToolTipText("Enables Middle Button");
		b2.setToolTipText("Enables Picture");
		
		b2.setPreferredSize(new Dimension(1500, 400));
		
		newContentPane.add(b1);
		newContentPane.add(b2);
		newContentPane.add(b3);
	}
	
	private void addImages()
	{
		try
		{
			lftImg = ImageIO.read(getClass().getResource("/images/leftArrow.png"));
			leftButtonIcon = new ImageIcon(lftImg);
			rgtImg = ImageIO.read(getClass().getResource("/images/rightArrow.png"));
			rightButtonIcon = new ImageIcon(rgtImg);
			myPicImg = ImageIO.read(getClass().getResource("/images/thePic.jpg"));
			myPicIcon = new ImageIcon(myPicImg);
			mdlImg = ImageIO.read(getClass().getResource("/images/middleButton.png"));
			middleButtonIcon = new ImageIcon(mdlImg);
		}
		catch(IOException ex)
		{
			System.out.println("Exception: " + ex);
		}

	}
	
    private void createAndShowGUI() 
    {
        frame = new JFrame("Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //JPanel contentPane = new JPanel();
		//contentPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//frame.setContentPane(contentPane);
		
		newContentPane = new JPanel()
		{
			@Override
			public void paint(Graphics g)
			{
				System.out.println("Should enable image..");
				super.paint(g);
				myPicIcon.paintIcon(this, g, 0, 0);
			}
		};
		addImages();
		newContentPane.setOpaque(true);
		addButtons();
		frame.add(newContentPane);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) 
    {
    	MainClass mo = new MainClass();
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                mo.createAndShowGUI();
            }
        }
        );
    }

	public void actionPerformed(ActionEvent e) 
	{
		if("disable".equals(e.getActionCommand()))
		{
			b2.setEnabled(false);
			b1.setEnabled(false);
			b3.setEnabled(true);
		}
		else if("enable".equals(e.getActionCommand()))
		{
			b2.setEnabled(true);
			b1.setEnabled(true);;
			b3.setEnabled(false);
		}
		else if("run".equals(e.getActionCommand()))
		{
			alternatePic(myPicIcon);
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		newContentPane.paintComponents(g);
	}
	
	public void alternatePic(ImageIcon pic)
	{
		if(picUp)
		{
			System.out.println("Should turn off pic");
			myPicImg.
			picUp = false;
		}
		else
		{
			System.out.println("Should turn on pic");
			newContentPane.repaint();
			picUp = true;
		}
	}
}

//edit one
