/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalho.pratico;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class TrabalhoPratico {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        JFrame application = new JFrame("Simulação de Corrida");
        
        //PanelRace panel = new PanelRace();
        PanelRace panel = new PanelRace();
        //JMenuBar menuBar = new JMenuBar();
        
        //application.setJMenuBar(menuBar);
        
        //JMenu arquivo = new JMenu("Arquivo");
        //JMenu pinceis = new JMenu("Pinceis");

        //JMenuItem lapis = new JMenuItem("Lápis");
        
        //pinceis.add(lapis);
        
        //menuBar.add(arquivo);
        //menuBar.add(pinceis);
        
        application.add(panel, BorderLayout.CENTER);
        
        application.add(new JLabel("arraste o mouse para desenhar"), BorderLayout.SOUTH);
        
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        application.setSize(1000, 1000);
        
        application.setVisible(true);
    }
}
