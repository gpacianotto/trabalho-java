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
    private ArrayList<DisplayModule> winnersList;
    private int winners = 0;
    private int locationX;
    private int locationY;
    private final int distanceBetweenDisplays = 15;
    private final int displayHeight = 30;

    public PanelRace(int numberOfCars, int locationX, int locationY) {
        Config config = Config.getInstance();
        this.displays = new ArrayList<>();
        this.winnersList = new ArrayList<>();
        this.locationX = locationX;
        this.locationY = locationY;
        
        for(int i = 0; i < numberOfCars; i++)
        {
            this.displays.add(new DisplayModule(this.locationX, this.locationY + (i + 1)* (displayHeight + distanceBetweenDisplays), i+1));
        }
        
        System.out.println("Quantidade de Carros: "+ config.getNumberOfCars());
        System.out.println("Quantidade de Voltas: "+ config.getNumberOfLaps());
        System.out.println("Probabilidade de Quebrar: "+ config.getProbBreak() + "%");
        System.out.println("Probabilidade de Abastecer: "+ config.getProbFuel() + "%");
        
        while(winnersList.size() < numberOfCars) {
        	for(DisplayModule displayCar : displays)
	        {
	            
	            if(displayCar.getCarLocation() < 1000) {
	            	displayCar.carMoves();
	            	if(displayCar.getCarLocation() > 999) {
	            		if(displayCar.getCarLaps() >= config.getNumberOfLaps()) {
		            		this.winnersList.add(displayCar);
		            		winners++;
		            	}else {
		            		displayCar.addCarLaps();
		            		System.out.println("Carro N" + displayCar.getCarNumber() + " completou a sua " + displayCar.getCarLaps() + " volta!");
		            	}
	            		
	            	}
	            }
	        }
        }
        for(DisplayModule podium : winnersList)
        {
        	
        	 System.out.println("Ganhador carro N" +  podium.getCarNumber());
            
        }
        
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        //g.fillRect(posiçãoX, posiçãoY
        for(DisplayModule display: this.displays)
        {
           display.paintDisplay(g); 
        }
        
//        for(Point point: points)
//        {
//            g.fillOval(point.x, point.y, 4, 4);
//        }
    }
}
