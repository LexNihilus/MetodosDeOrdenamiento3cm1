/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Burbuja;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Lex VENUS
 */
public class Graficador {
    public JFreeChart grafica;
    public XYSeriesCollection puntos;
    
    public Graficador()
    {
        this.puntos=new XYSeriesCollection();
        this.grafica=ChartFactory.createXYLineChart("Grafica del Polinomio", "x", "y", puntos, PlotOrientation.VERTICAL, true, true, true);
    }
    public void agregarp(ArrayList<Long> a, ArrayList<Long> b)
    {
        XYSeries aux=new XYSeries("Burbuja");
        XYSeries x=new XYSeries("Burbuja Optimizado");
        XYSeries y=new XYSeries("y");
        for(int i=0;i<=a.size()-1;i++)
        {
            aux.add(i, a.get(i));
        }
        for(int i=0; i<b.size()-1;i++)
        {
            x.add(i, b.get(i));
        }
        puntos.addSeries(aux);
        puntos.addSeries(x);
    }
    public void trazar()
    {
        XYPlot p=grafica.getXYPlot();
        XYLineAndShapeRenderer r=new XYLineAndShapeRenderer();
        r.setSeriesPaint(0, Color.RED);
        r.setSeriesPaint(1, Color.BLUE);
        r.setSeriesLinesVisible(0, true);
        r.setSeriesShapesVisible(0, true);
        r.setSeriesLinesVisible(1, true);
        r.setSeriesShapesVisible(1, true);
        p.setRenderer(r);
        ChartPanel pa=new ChartPanel(grafica);
        
        JFrame graph=new JFrame("Grafica");
        graph.setVisible(true);
        graph.setSize(600, 480);
        graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        graph.add(pa);
    }
}
