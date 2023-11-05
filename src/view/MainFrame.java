
package view;

import controller.*;
import model.*;




import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

public class MainFrame extends JFrame {
    
    
    
    private ShopController shopController; // This would be your controller
    private Inventory inventory;
    
    private ProductPanel selectedProductPanel;
    private ProductPanel movie,music,game;
    private ImageIcon movieTabbedPanelIcon, musicTabbedPanelIcon, gameTabbedPanelIcon;
    
    private WarehousePanel warehousePanel;
    private HomePanel homePanel;
    
    private CartPanel cartPanel;
    private JPanel currentPanel ;
    private JLabel shopName, shopLocation, quotes;  
    private JTabbedPane tabbedPane;
    
    private Inventory selectedProductInventory;
    
    
    
    
    
    public MainFrame(Inventory inventory) {
    	this.inventory = inventory;
    	selectedProductInventory = new Inventory();
    	
    }
    
    
    
    public void showHomePage() {
    	
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(40, 45, 55) );
        
       
        
        
        homePanel = new HomePanel(this);
        homePanel.setLayout(null);
        homePanel.setBackground(new Color(40,45,50));
        homePanel.setBounds(0,0, this.getWidth(), this.getHeight()); 
        contentPane.add(homePanel);        
        
        
        
        
     // Make the changes visible
        revalidate();
        repaint();
    	
    }
    
    
    
    
   
	public void showWarehousePage() {
		
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(10, 110, 120) );

      
        
        shopName = new JLabel("MelodyMart");
        shopName.setFont(new Font("Broadway", Font.BOLD, 60));
        shopName.setBounds(70,30, 500,50);
        shopName.setForeground(Color.black);
        
        
        shopLocation = new JLabel("Dhaka - Bangladesh");
        
        shopLocation.setBounds(70,80, 400,25);
        shopLocation.setForeground(Color.black);
        shopLocation.setFont(new Font("Arial", Font.BOLD, 25));
	        
        quotes = new JLabel("Happy Shopping!");
        quotes.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
        quotes.setBounds(70,115, 300,30);
        quotes.setForeground(Color.yellow);
        
        
        
        
        
        
        
        
       
        
        
        
        
        contentPane.add(shopName);
        contentPane.add(shopLocation);
        contentPane.add(quotes);
        
        
        
       
        
        
        
       
        
        
        
        warehousePanel = new WarehousePanel(inventory, this);
        warehousePanel.setBackground(new Color(40,45,55));
        warehousePanel.setBounds(70, 170,1450,740);
        
        
        
        
        
        
        
        
        
        contentPane.add(warehousePanel);      
        
        
    
        
        // Make the changes visible
        revalidate();
        repaint();
		
	}
    
    
    
    public void showProductPage() {
        // Get the content pane and set its properties
    	
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(10, 110, 120) );

        
        shopName = new JLabel("MelodyMart");
        shopName.setFont(new Font("Broadway", Font.BOLD, 70));
        shopName.setBounds(70,20, 500,60);
        shopName.setForeground(Color.black);
        
        
        shopLocation = new JLabel("Dhaka - Bangladesh");
      
        shopLocation.setBounds(70,90, 400,25);
        shopLocation.setForeground(Color.black);
        shopLocation.setFont(new Font("Arial", Font.BOLD, 25));
	        
        quotes = new JLabel("Happy Shopping!");
        quotes.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
        quotes.setBounds(70,100, 300,100);
        quotes.setForeground(Color.yellow);
        
        
        
      //listSelectedProduct();
        selectedProductPanel = new ProductPanel(inventory,"SelectedProductList", this, selectedProductInventory );
		selectedProductPanel.setBounds(1130,220,380,680);
		selectedProductPanel.setBackground(Color.darkGray);
        contentPane.add(selectedProductPanel);
        
        
        contentPane.add(shopName);
        contentPane.add(shopLocation);
        contentPane.add(quotes);
        
        
       
        
        
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(70, 200,1000,700);

        
        
        contentPane.add(tabbedPane);
        
        movie = new ProductPanel(inventory, "Movie", this, selectedProductInventory);
        movie.setBackground(Color.red);
        
        music = new ProductPanel(inventory, "Music", this , selectedProductInventory);
        music.setBackground(new Color(180,190,185));
        
        game = new ProductPanel(inventory, "Game", this, selectedProductInventory);
        game.setBackground(Color.gray); 
        
        
        
        
        // picture scalling
        
        Image tempImg = Components.movieTabbedPanelIcon.getImage();
    	tempImg = tempImg.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
    	movieTabbedPanelIcon = new ImageIcon(tempImg);
    	
    	
    	tempImg = Components.musicTabbedPanelIcon.getImage();
    	tempImg = tempImg.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
    	musicTabbedPanelIcon = new ImageIcon(tempImg);
    	
    	
    	tempImg = Components.gameTabbedPanelIcon.getImage();
    	tempImg = tempImg.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
    	gameTabbedPanelIcon = new ImageIcon(tempImg);
        
        
        
        tabbedPane.addTab("Movie",movieTabbedPanelIcon,movie);
        tabbedPane.addTab("Music",musicTabbedPanelIcon,music);
        tabbedPane.addTab("Game",gameTabbedPanelIcon,game);
      
       
        
        
    
        
        // Make the changes visible
        revalidate();
        repaint();
    }


    
   

    
    public void switchPanel(JPanel newPanel) {
       
    	if(currentPanel != null)
        remove(currentPanel);  // Remove the current panel
        
        currentPanel = newPanel;
        add(currentPanel);
        
        revalidate();  // This tells the layout manager to reset based on the new component
        repaint();     // This ensures any old drawings are cleared and the component is freshly painted
    }
    
    
    public void addProductToSelectedPanel(StockableProduct product) {
        selectedProductPanel.addProduct(product);
    }
    
    
    




	
}

