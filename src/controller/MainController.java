package controller;

import java.util.ArrayList;

import model.Auto;
import view.MainWindow;

public class MainController {
    //Hauptfenster
    MainWindow _mainWindow;

    ArrayList<Auto> _autos;


    public MainController(){
        setAutos(new ArrayList<Auto>());

        setMainWindow(new MainWindow(this));
        getMainWindow().toggleMainWindow();
    }

    public void changeView(String target){
        System.out.println("Ansicht wechseln auf: " + target);

        getMainWindow().getMainFrame().setVisible(false);

        if(target == "newcarwindow"){
            new NewCarController(this);
        }
        else if(target == "mainwindow"){
            getMainWindow().getMainFrame().setVisible(true);
            getMainWindow().updateTable();
        }
    }

    public void addNewCar(Auto a){
        getAutos().add(a);
        System.out.println("Neues Auto erstellt!");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setMainWindow(MainWindow mainWindow) {
        this._mainWindow = mainWindow;
    }

    public MainWindow getMainWindow() {
        return _mainWindow;
    }

    public ArrayList<Auto> getAutos() {
        return _autos;
    }

    public void setAutos(ArrayList<Auto> _autos) {
        this._autos = _autos;
    }



}
