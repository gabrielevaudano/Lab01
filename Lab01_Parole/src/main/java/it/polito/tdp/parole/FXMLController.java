package it.polito.tdp.parole;
import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	// Si potrebbe migliorare usando dei boolean e registrando i casi in cui 
	// le funzioni non vadano a buon fine per errori utente o sistema
	// Cosi i tempi di rimozione verrebbero  mostrati solo se l'operazione andasse a
	// buon finee effettivamemte
	Parole elenco = new Parole();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private Button rimuovi;

    @FXML
    private TextArea txtPrestazioni;
    
    @FXML
    void doRemove(ActionEvent event) {
    	long startTime = System.nanoTime();
    	
    	String s = txtResult.getSelectedText();
    	elenco.rimuoviParola(s);
    	txtResult.setText(elenco.getElencoString());

    	txtPrestazioni.appendText("Tempo rimozione elemento: " + (System.nanoTime()-startTime) + " nanosecondi\n");
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	long startTime = System.nanoTime();
    	
    	String daInserire = txtParola.getText(); 	
    	elenco.addParola(daInserire);
    	txtResult.setText(elenco.getElencoString());
    	
    	txtPrestazioni.appendText("Tempo inserimento elemento: " + (System.nanoTime()-startTime) + " nanosecondi \n");

    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	
    	elenco.reset();
    	txtResult.setText(elenco.getElencoString());
    	
    	txtPrestazioni.appendText("Tempo rimozione lista: " + (System.nanoTime()-startTime) + " nanosecondi \n");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
