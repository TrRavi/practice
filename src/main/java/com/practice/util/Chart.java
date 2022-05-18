package com.practice.util;

import io.quickchart.QuickChart;

import java.io.IOException;

public class Chart {

    public static void main(String[] args) throws IOException {
        QuickChart chart = new QuickChart();
        chart.setWidth(500);
        chart.setHeight(300);
        chart.setConfig("{"
                + "    type: 'bar',"
                + "    data: {"
                + "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
                + "        datasets: [{"
                + "            label: 'Users',"
                + "            data: [50, 60, 70, 180]"
                + "        },{label: 'Users_1',data: [25, 40, 30, 100]}]"
                + "    }"
                + "}"
        );
        chart.toFile("C:\\Users\\kumar\\Desktop\\Circle Clause\\java-chart.png");

        System.out.println(chart.getUrl());
    }

    static String  getChart(){
        QuickChart chart = new QuickChart();
        chart.setWidth(500);
        chart.setHeight(300);
        chart.setConfig("{"
                + "    type: 'bar',"
                + "    data: {"
                + "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
                + "        datasets: [{"
                + "            label: 'Users',"
                + "            data: [50, 60, 70, 180]"
                + "        },{label: 'Users_1',data: [25, 40, 30, 100]}]"
                + "    }"
                + "}"
        );
        return chart.getUrl();
    }
}
