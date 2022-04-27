package org.apcsp.portfolio;

import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {


    public LineChart_AWT(String title, String cpu_usage) {
        super(title);
    }

    static DefaultCategoryDataset createDataset() {
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

//TODO: initialize line chart to start