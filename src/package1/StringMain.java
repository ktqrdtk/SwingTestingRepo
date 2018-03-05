package package1;

import java.awt.Dimension;

import javax.swing.JFrame;

public class StringMain {

	public static void main(String[] args) 
	{
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						createAndShowGUI();
					}
				});
	}
	
	public static void createAndShowGUI()
	{
		JFrame frame = new JFrame("String Printing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJPanel panel = new MyJPanel();
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.pack();
        frame.setVisible(true);
	}

}
