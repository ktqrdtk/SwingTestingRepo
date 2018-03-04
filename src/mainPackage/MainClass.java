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
	private JFrame frame;
	private boolean picUp;
	JButton b1;
	JButton b2;
	JButton b3;
	MyPanel newContentPane;
	
	private Image lftImg;
	private ImageIcon lftIcon;
	private JLabel lftLabel;
	private Image rgtImg;
	private ImageIcon rgtIcon;
	private JLabel rgtLabel;
	private Image mdlImg;
	private ImageIcon mdlIcon;
	private JLabel mdlLabel;
	private Image myPicImg;
	private ImageIcon myPicIcon;
	private JLabel myPicLabel;
	
	private void addButtons()
	{
		picUp = false;
		b1 = new JButton("Turn off middle button.");
		b1.setIcon(lftIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.setMnemonic(KeyEvent.VK_LEFT);
		b1.setActionCommand("disable");
		b1.setEnabled(true);
		
		b2 = new JButton("Alternates Picture");
		b2.setIcon(mdlIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_DOWN);
		b2.setActionCommand("run");
		b2.setEnabled(true);
		
		b3 = new JButton("Turn on middle button.");
		b3.setIcon(rgtIcon);
		b3.setVerticalTextPosition(AbstractButton.CENTER);
		b3.setHorizontalTextPosition(AbstractButton.TRAILING);
		b3.setActionCommand("enable");
		b3.setEnabled(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b1.setToolTipText("Disables Middle Button");
		b3.setToolTipText("Enables Middle Button");
		b2.setToolTipText("Alternates Picture");
		
		newContentPane.add(b1);
		newContentPane.add(b2);
		newContentPane.add(b3);
	}
	
	private void addImages()
	{
		try
		{
			lftImg = ImageIO.read(getClass().getResource("/images/rightArrow.png"));
			lftIcon = new ImageIcon(lftImg.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
			lftLabel = new JLabel(lftIcon);
			rgtImg = ImageIO.read(getClass().getResource("/images/leftArrow.png"));
			rgtIcon = new ImageIcon(rgtImg.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
			rgtLabel = new JLabel(rgtIcon);
			myPicImg = ImageIO.read(getClass().getResource("/images/thePic.jpg"));
			myPicIcon = new ImageIcon(myPicImg);
			myPicLabel = new JLabel(myPicIcon);
			mdlImg = ImageIO.read(getClass().getResource("/images/middleButton.png"));
			mdlIcon = new ImageIcon(mdlImg.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
			mdlLabel = new JLabel(mdlIcon);
		}
		catch(IOException ex)
		{
			System.out.println("Exception in addImages: " + ex);
		}

	}
	
	private void createAndShowGUI() 
    {
        frame = new JFrame("Button & Image Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //JPanel contentPane = new JPanel();
		//contentPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//frame.setContentPane(contentPane);
		
		newContentPane = new MyPanel();
		addImages();
		addButtons();
		frame.add(newContentPane);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
			newContentPane.alternateImage(myPicImg);
		}
		
	}
	
}

//edit one
