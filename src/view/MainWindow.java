package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.Auto;

public class MainWindow {
    
    JFrame _mainFrame;
    JPanel _mainPanel;
    JTable _carTable;
    JButton _createCar;

    MainController _mc;

    //Hauptfenster
    public MainWindow(MainController mc){
        setMainController(mc);
        // Neues Hauptfenster erstellen. Gleiches Prinzip wie Zeile 28 NewCarWindow.java: setMainFrame(new JFrame());
        _mainFrame = new JFrame();
        //Titel des Frames
        getMainFrame().setTitle("Hauptfenster");
        // Breite und Höhe des Fensters setzen
        _mainFrame.setSize(700,700);
        createMainOverview();

        // Standard-Operation, wenn das Fenster geschlossen wird
        _mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMainOverview(){        
        // Hauptpanel erstellen und Elemente für das MainWindow hinzufügen
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new FlowLayout());

        

        _createCar = new JButton("Neues Auto");
        //Bereiche, die der Button an Grenzen hat
        _createCar.setBounds(10,10,10,10);
        _createCar.addActionListener(new createCarListener());

        DefaultTableModel model = new DefaultTableModel(); 
        setCarTable(new JTable(model));

        // Create a couple of columns 
        model.addColumn("Marke"); 
        model.addColumn("PS"); 
        model.addColumn("Modell"); 

        getMainPanel().add(getCarTable());
        getMainPanel().add(_createCar);
        getMainFrame().add(getMainPanel());
    }

    public void updateTable(){
        // Autos laden
        DefaultTableModel model = (DefaultTableModel) getCarTable().getModel();

        // Entferne alle aktuellen Elemente
        for(int i = model.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }

        for(Auto a : getMainController().getAutos()){
            model.addRow(new Object[]{a.getMarke(), a.getPs(), a.getTyp()});
        }
    }

    // Zeigt oder versteckt (toggle) das Hauptfenster
    public void toggleMainWindow(){
        if(getMainFrame().isVisible()){
            getMainFrame().setVisible(false);
        }
        else{
            getMainFrame().setVisible(true);
        }
    }

    /**
     * 
     * Action Listener
     */
    class createCarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _createCar){
                System.out.println("Auto erstellen - wechsle Ansicht zu newCarWindow");
                getMainController().changeView("newcarwindow");
            }
        }
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public JFrame getMainFrame() {
        return _mainFrame;
    }

    public void setMainFrame(JFrame _mainFrame) {
        this._mainFrame = _mainFrame;
    }

    public JTable getCarTable() {
        return _carTable;
    }

    public void setCarTable(JTable _carTable) {
        this._carTable = _carTable;
    }

    public void setMainPanel(JPanel _mainPanel) {
        this._mainPanel = _mainPanel;
    }

    public JPanel getMainPanel() {
        return _mainPanel;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }

    public MainController getMainController() {
        return _mc;
    }

}
