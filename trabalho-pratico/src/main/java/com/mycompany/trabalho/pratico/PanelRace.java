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
    
    private ArrayList<Point> points = new ArrayList<Point>();
    
    public PanelRace()
    {
//        addMouseMotionListener(
//        new MouseMotionAdapter()
//        {
//            @Override
//            public void mouseDragged(MouseEvent event)
//            {
//                points.add(event.getPoint());
//                repaint();
//            }
//        }
//        );
        
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.fillRect(100, 100, 800, 2);
//        for(Point point: points)
//        {
//            g.fillOval(point.x, point.y, 4, 4);
//        }
    }
}
