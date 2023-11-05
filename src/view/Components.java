package view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Components {

	
	public static Font titleFont = new Font("Broadway", Font.BOLD, 40);
	public static Font headingFont = new Font("arival",Font.BOLD, 22);
	public static Font regularFont = new Font("arival", Font.BOLD, 18);
	public static Font smallFont = new Font("Cambria",Font.BOLD, 16 );
	
	private static String imgPath = "E:\\Programming\\Project\\Project\\Inventory_&_Billing_System\\Image";
	
	public static ImageIcon movieImg = new ImageIcon(imgPath + "\\movie.png");
	public static ImageIcon musicImg = new ImageIcon(imgPath + "\\music.png");
	public static ImageIcon gameImg = new ImageIcon(imgPath + "\\game.png");
	
	public static ImageIcon movieTabbedPanelIcon = new ImageIcon(imgPath + "\\movieTabbedPanelIcon.png");
	public static ImageIcon musicTabbedPanelIcon = new ImageIcon(imgPath + "\\musicTabbedPanelIcon.png");
	public static ImageIcon gameTabbedPanelIcon = new ImageIcon(imgPath + "\\gameTabbedPanelIcon.png");
	
	
	
	
	
	
	
	

	
}
