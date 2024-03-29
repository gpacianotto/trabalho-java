/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.pratico;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author guilh
 */
public class PanelRace extends JPanel {

	private ArrayList<DisplayModule> displays;
	private int locationX;
	private int locationY;
	private final int distanceBetweenDisplays = 15;
	private final int displayHeight = 30;
        private JButton button;
        private JTextArea textAreaLog;
        private Config config;
	private ArrayList<DisplayModule> winnersList;
	

	public PanelRace(int numberOfCars, int locationX, int locationY, JButton button, JTextArea textAreaLog) {
		this.config = Config.getInstance();
		this.displays = new ArrayList<>();
		this.locationX = locationX;
		this.locationY = locationY;
                this.button = button;
                this.textAreaLog = textAreaLog;

		for (int i = 0; i < numberOfCars; i++) {
			this.displays.add(new DisplayModule(this.locationX,
					this.locationY + (i + 1) * (displayHeight + distanceBetweenDisplays), i + 1));
		}

		System.out.println("Quantidade de Carros: " + config.getNumberOfCars());
		System.out.println("Quantidade de Voltas: " + config.getNumberOfLaps());
		System.out.println("Probabilidade de Quebrar: " + config.getProbBreak() + "%");
		System.out.println("Probabilidade de Abastecer: " + config.getProbFuel() + "%");

		this.winnersList = new ArrayList<>();

		this.button.addActionListener(new ActionListener() {;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        Thread t = new Thread() {
                            public void run(){
                                try {  
                                    paintDisplays();
                                } catch (InterruptedException ex) {
                                    //Logger.getLogger(PanelRace.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        };
                        
                        t.start();
                        
                    }
                });

	}
        
        public void paintDisplays() throws InterruptedException
        {
            for (; winnersList.size() < 3; ) {
                Thread.sleep(500);
                for (DisplayModule displayCar : displays) {

                    if (displayCar.getCarLocation() < 1000) {
                            config.addMsgLog(displayCar.carMoves());

                        if (displayCar.getCarLocation() > 999) {
                            if (displayCar.getCarLaps() >= config.getNumberOfLaps()) {
                                    winnersList.add(displayCar);
                                    displayCar.setCarLocation(1000);
                            } else {
                                displayCar.addCarLaps();
                                config.addMsgLog("Carro N" + displayCar.getCarNumber() + " completou a sua "
                                    + displayCar.getCarLaps() + " volta!\n");
                                System.out.println("Carro N" + displayCar.getCarNumber() + " completou a sua "
                                    + displayCar.getCarLaps() + " volta!");
                            }

                        }
                    }

                }
                
                textAreaLog.setText(config.getMsgLog());
                repaint();
            }
            
            int i = 1;
            for (DisplayModule podium : winnersList) {

                config.addMsgLog("Ganhador carro N" + podium.getCarNumber() + " em "+ i+"º Lugar!"+ "\n");
                System.out.println("Ganhador carro N" + podium.getCarNumber());
                textAreaLog.setText(config.getMsgLog());
                i++;
            }
            
        }
        
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.fillRect(posiçãoX, posiçãoY
		for (DisplayModule display : this.displays) {
			display.paintDisplay(g);
		}

//        for(Point point: points)
//        {
//            g.fillOval(point.x, point.y, 4, 4);
//        }
	}
}
