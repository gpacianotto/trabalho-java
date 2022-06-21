package com.mycompany.trabalho.pratico;

import java.util.ArrayList;

public class Race {

	private ArrayList<DisplayModule> displays;
    private ArrayList<DisplayModule> winnersList;
    Config config = Config.getInstance();
    
    public Race(ArrayList<DisplayModule> displays) {
    	this.displays = displays;
    	this.winnersList = new ArrayList<>();
    	
    	
    	while(winnersList.size() < config.getNumberOfCars()) {
         	for(DisplayModule displayCar : displays)
 	        {
 	            
 	            if(displayCar.getCarLocation() < 1000) {
 	            	displayCar.carMoves();
 	            	if(displayCar.getCarLocation() > 999) {
 	            		if(displayCar.getCarLaps() >= config.getNumberOfLaps()) {
 		            		this.winnersList.add(displayCar);
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

}
