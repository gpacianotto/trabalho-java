/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.pratico;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class PanelRace extends JPanel {
    
    
    private ArrayList<DisplayModule> displays;
    private int locationX;
    private int locationY;
    private final int distanceBetweenDisplays = 5;
    private final int displayHeight = 30;

    public PanelRace(int numberOfCars, int locationX, int locationY) {
        this.displays = new ArrayList<>();
        this.locationX = locationX;
        this.locationY = locationY;
        
        for(int i = 0; i < numberOfCars; i++)
        {
            this.displays.add(new DisplayModule(this.locationX, this.locationY + (i + 1)* (displayHeight + distanceBetweenDisplays)));
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        //g.fillRect(posiçãoX, posiçãoY
        for(DisplayModule display: this.displays)
        {
           g.fillRect(display.getLocationX(), display.getLocationY()+5, 1000, 2); 
           g.fillRect(display.getLocationX(), display.getLocationY(), 1, 10); 
           g.fillRect(display.getLocationX()+100, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+200, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+300, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+400, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+500, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+600, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+700, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+800, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+900, display.getLocationY(), 1, 5); 
           g.fillRect(display.getLocationX()+1000, display.getLocationY(), 1, 10); 
        }
        
//        for(Point point: points)
//        {
//            g.fillOval(point.x, point.y, 4, 4);
//        }
    }
}
