package org.example;

import javax.swing.table.AbstractTableModel;

public class InvestmentTaЬleModel extends AbstractTableModel{
    private static double INITIAL_BALANCE = 100000.0;

    public InvestmentTaЬleModel(int years, int minRate, int maxRate) {
        this.years = years;
        this.minRate = minRate;
        this.maxRate = maxRate;
    }

    private int years;
    private int minRate;
    private int maxRate;

    @Override
    public int getRowCount() {
        return years;
    }

    @Override
    public int getColumnCount() {
        return maxRate - minRate + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double rate = (columnIndex+ minRate) / 100.0;
        int nperiods =rowIndex;
        double futureBalance = INITIAL_BALANCE*Math.pow(1+rate,nperiods);
       return String.format("%.2f",futureBalance);


    }

    @Override
    public String getColumnName(int column) {
        return (column + minRate) + "%";
    }


}
