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

}

//TODO: initialize line chart to start