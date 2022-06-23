/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.pratico;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author guilh
 */
public class DisplayModule {
    
    private int locationX;
    private int locationY;
    private int carLocation ;
    private int carNumber;
    private int carLaps;
    private JLabel lapLabel;
    
    Config config = Config.getInstance();

    public DisplayModule(int locationX, int locationY, int carNumber) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.carNumber = carNumber;
        this.carLocation = 0;
        this.carLaps = 0;
        
        this.lapLabel = new JLabel("Volta: ");
        
        this.lapLabel.setVisible(true);
        
        this.lapLabel.setLocation(this.locationX, this.locationY + 10);
        
    }
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    public void carMoves()
    {
    	if(getRandomNumber(0, 100) < config.getProbBreak()) {
    		System.out.println("Carro N" + carNumber + " quebrou e está sendo reparado!");
    		return;
    	}
    	if(getRandomNumber(0, 100) < config.getProbFuel()) {
    		System.out.println("Carro N" + carNumber + " precisou reabastecer!");
    		return;
    	}
        if(this.carLocation <= 1000)
        {
        	int moveu = getRandomNumber(0, 3) * 100;
            this.carLocation = this.carLocation + moveu;
            System.out.println("Carro N" + carNumber + " moveu " + moveu + "m!");
            return;
        }
        
    }
    
    public void drawCar(Graphics g, int positionX, int positionY)
    {
        BufferedImage image;
        try{
            image = ImageIO.read(new File("car.png"));
        }
        catch(IOException e){
            image = null;
        }
        
        g.drawImage(image, (locationX + this.carLocation), locationY, null);
    }
    
    public void paintDisplay(Graphics g)
    {
        g.drawString("Volta: " + this.getCarLaps(), this.locationX, this.locationY);
        this.drawCar(g, locationX, locationY);
        g.fillRect(this.getLocationX(), this.getLocationY()+5, 1000, 2); 
        g.fillRect(this.getLocationX(), this.getLocationY(), 1, 10); 
        g.fillRect(this.getLocationX()+100, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+200, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+300, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+400, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+500, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+600, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+700, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+800, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+900, this.getLocationY(), 1, 5); 
        g.fillRect(this.getLocationX()+1000, this.getLocationY(), 1, 10);
        
    }
    
    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

	public int getCarLocation() {
		return carLocation;
	}

	public void setCarLocation(int carLocation) {
		this.carLocation = carLocation;
	}

	public int getCarLaps() {
		return carLaps;
	}

	public void setCarLaps(int carLaps) {
		this.carLaps = carLaps;
	}
    
	public void addCarLaps() {
		this.carLaps = carLaps + 1;
		this.carLocation = carLocation - 900;
	}
	


    
}
