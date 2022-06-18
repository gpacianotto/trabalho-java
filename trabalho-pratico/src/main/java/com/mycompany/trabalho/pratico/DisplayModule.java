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

/**
 *
 * @author guilh
 */
public class DisplayModule {
    
    private int locationX;
    private int locationY;
    private int carLocation ;

    public DisplayModule(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.carLocation = 0;
    }
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    public void carMoves()
    {
        if(this.carLocation <= 1000)
        {
            this.carLocation = this.carLocation + getRandomNumber(0, 3);
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
        
        g.drawImage(image, (locationX + this.carLocation), (locationY + this.carLocation), null);
    }
    
    public void paintDisplay(Graphics g)
    {
        
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

    
}
