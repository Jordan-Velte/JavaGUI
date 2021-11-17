package controller;

import java.util.ArrayList;

import model.Auto;
import view.MainWindow;

//Controller gibt an wann welches Fenster erstellt werden soll! Somit kann man besser selbst entscheiden, wann welcher Startzeitpunkt genutzt wird
public class MainController {
    //Hauptfenster
    MainWindow _mainWindow;

    ArrayList<Auto> _autos;


    public MainController(){
        setAutos(new ArrayList<Auto>());
        //Erst Controller erstellen, wenn Hauptview übergebe ich diese --> Rückkanal von view zu controller
        //this = siehe Mainwindow.java --> Objekt des MainControllers wird übergeben (sich selbst) --> View kann somit auf Controller zugreifen. Controller kann auf view zugreifen, weil controller in view gespeichert wird!
        //Controller startet nur mainWindow, aber wie das Window aussieht ist Aufgabe der View
        //Verweis auf sich selbst, aber damit mainWindow der Main Controller übergeben wird!
        setMainWindow(new MainWindow(this));
        //toggleMainWindow = Methode sichtbar machen oder nicht
        getMainWindow().toggleMainWindow();
    }

    //Öffnet und schließt Fenster --> Wechsel der Ansicht
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
    //Hinzufügen eines neuen Autos
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
