package org.example;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootTable extends JFrame{

    private JPanel rootPane;

    private JButton button1;
    private JScrollPane scroll;
    private JTable table1;
    private JTextField textField1;
    private JButton button2;
    private JTextField textField2;
    private JButton colorButton;


    public RootTable(){
        setContentPane(rootPane);
        setTitle("Hellow i am rootFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



     //1.   scroll.setViewportView(createJTableUIComponents());
        //2. custom create createUIComponents()
        //3.
        TableModel model = new DefaultTableModel(cells,columnNames)
        {

           public Class getColumnClass(int column) {
                Class returnvalue;
                if((column>0)&&(column<getColumnCount())) {returnvalue =getValueAt(0,column).getClass();}
               else {returnvalue = Object.class;}
                return returnvalue;
            }
        }
        ;
        table1.setModel(model);
        //4. without  IDEA GUI Designer, JTable = new JTable(calls,columNames);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //table1.setAutoCreateRowSorter(true);
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table1.setCellSelectionEnabled(true);
        table1.setColumnSelectionAllowed(true);
        var sorter = new TableRowSorter<>(model);

        table1.setRowSorter(sorter);
        button1.setText("Поиск");



        sorter.setSortable(0,false);
       button1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String text  = textField1.getText();
               Integer a = Integer.valueOf(text);

               if(text.length()==0){
                   sorter.setRowFilter(null);
               }else{
                   sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.AFTER,a,2));
               }
           }
       });



        pack();

        setVisible(true);


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableColumnModel columnModel = table1.getColumnModel();
                TableColumn column = columnModel.getColumn (Integer.parseInt(textField2.getText()));
                table1.removeColumn(column);
                table1.addColumn(new TableColumn(Integer.parseInt(textField2.getText()))) ;
            }
        });
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
            }
        });
    }





     Object[][] cells =
                {
                        {
                                "Mercury", 2440.0, 2, false, Color.YELLOW },{
                        "Venus", 6052.0, 1 , false, Color.YELLOW }};

       String[] columnNames = new String[]{ "Planet" , "Radius", "Moons",
                "Gaseous" , "Color" } ;



}



