/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.pratico;

/**
 *
 * @author guilh
 */
public class Config {
    private static Config instance;
    
    private int numberOfCars;
    private int numberOfLaps;
    
    private float probBreak;
    private float probFuel;
    
    public Config()
    {
        
    }

    public float getProbBreak() {
        return probBreak;
    }

    public void setProbBreak(float probBreak) {
        this.probBreak = probBreak;
    }

    public float getProbFuel() {
        return probFuel;
    }

    public void setProbFuel(float probFuel) {
        this.probFuel = probFuel;
    }
    
    public static Config getInstance()
    {
        if(instance == null)
        {
            instance = new Config();
        }
        
        return instance;
    }
    
    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }
    
    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    
    
    
}
