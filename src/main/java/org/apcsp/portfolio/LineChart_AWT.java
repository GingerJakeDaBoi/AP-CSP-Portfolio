package org.apcsp.portfolio;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

    public LineChart_AWT( String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Cpu usage", "CPU Usage", createDataset(), PlotOrientation.VERTICAL, true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 420 , 210 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( ) {
        //dataset.addValue(place holder value for cpu );
        return new DefaultCategoryDataset( );
    }

    public static void main( String[ ] args ) {
        LineChart_AWT chart = new LineChart_AWT("Cpu usage" , "Cpu usage");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}