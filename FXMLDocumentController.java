/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingeditingsaving;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author SUSHMA
 */
public class FXMLDocumentController implements Initializable {
    
   
     int number = 100;
    @FXML
    private AnchorPane paneBackground;
    @FXML
    private TableView<patient> tableView;
    @FXML
    private TableColumn<patient, Integer> tableId;
    @FXML
    private TableColumn<patient, String> tableName;
    @FXML
    private TableColumn<patient, Integer> tableAge;
    @FXML
    private TableColumn<patient, Integer> tableWeight;
    @FXML
    private TableColumn<patient, Double> tableHeight;
    @FXML
    private TableColumn<patient, String> tableBloodType;
    
    @FXML
    TextField idInput;
    @FXML
    TextField nameInput;
    @FXML
    TextField ageInput;
    @FXML
    TextField weightInput;
    @FXML
    TextField heightInput;
    @FXML
    TextField bloodTypeInput;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button addBtn;
    
    private IntegerProperty Index = new SimpleIntegerProperty();
    @FXML
    private TextField searchTxtField;
    @FXML
    private Button searchBtn;
    @FXML
    private Button saveBtn;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Index.set(-1);
        tableId.setCellValueFactory(new PropertyValueFactory<patient, Integer>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<patient, String>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<patient, Integer>("age"));
        tableWeight.setCellValueFactory(new PropertyValueFactory<patient, Integer>("weight"));
        tableHeight.setCellValueFactory(new PropertyValueFactory<patient, Double>("height"));
        tableBloodType.setCellValueFactory(new PropertyValueFactory<patient, String>("bloodType"));
        tableView.setItems(people);
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
            @Override
            public void changed(ObservableValue<?>Observable, Object oldvalue, Object newValue){
            Index.set(people.indexOf(newValue));
            System.out.println("The Index is: " + people.indexOf(newValue));
            }
        });
    }
        //public ObservableList<patient> getpatient(){
           
           final ObservableList<patient>people = FXCollections.observableArrayList(
            new patient(number++, "Julietta Charleston", 32, 189, 5.6, "O+"),
            new patient(number++, "Terisa Llewellyn", 65, 120, 5.9, "A-"),
            new patient(number++, "Nelda Dawe", 58, 205, 5.4, "B+"),
            new patient(number++, "Meryl Delaughter", 89, 365, 4.9, "O-"),
            new patient(number++, "Haydee Mabee", 85, 182, 6.0, "AB+"),
            new patient(number++, "Erinn Dillingham", 63, 177, 5.8, "B-"),
            new patient(number++, "Charlotte Gulyas", 21, 125, 6.1, "A+"),
            new patient(number++, "Kristie Turck", 75, 365, 5.7, "O"),
            new patient(number++, "John Smith", 26, 187, 5.9, "B+"),
            new patient(number++, "Rubye Windham", 19, 251, 5.5, "AB-"),
            new patient(number++, "Masako Askew", 9, 220, 5.8, "O+"),
            new patient(number++, "Julian Kim", 28, 186, 6.3, "B+"),
            new patient(number++, "Darcel Darosa", 37, 176, 5.9, "A-"),
            new patient(number++, "Reena Carle", 51, 158, 5.6, "O-"),
            new patient(number++, "Oscar Norsworthy", 92, 169, 5.5, "AB+"),
            new patient(number++, "Dorla Mcdougall", 38, 188, 6.0, "B-"),
            new patient(number++, "Luana Peek", 32, 145, 5.1, "A+"));
           
           FilteredList filter = new FilteredList(people, e->true);
           
           
    @FXML
        public void onAddItem(ActionEvent Event){
            
        patient entry = new patient(Integer.parseInt(idInput.getText()), nameInput.getText(), Integer.parseInt(ageInput.getText()),
        Integer.parseInt(weightInput.getText()), Double.parseDouble(heightInput.getText()), bloodTypeInput.getText());
        
        people.add(entry);
        
        clearForm();
        }
    @FXML
        public void ondeleteItem(ActionEvent Event){
            int i = Index.get();
            if(i > -1){
            people.remove(i);
            tableView.getSelectionModel().clearSelection();
            }
        }
     
    private void clearForm() {
        idInput.clear();
        nameInput.clear();
        ageInput.clear();
        weightInput.clear();
        heightInput.clear();
        bloodTypeInput.clear();
         
    }

    @FXML
    private void onSaveitem(ActionEvent event) {
//        String filePath = "C:\\Users\\SUSHMA\\Desktop\\Sushma\\Patient_Information.txt";
//        File file = new File(filePath);
//        try{
//           FileWriter fw = new FileWriter(file); 
//           for(int i = 0; i<tableView.getItems().size();i++){
//               for(int j = 0; j<tableView.TableColumn();j++){
//               }
//               
//           }
//        }
//        catch(IOException ex){
//            
//        }
  }

    @FXML
    private void search(KeyEvent event) {
        searchTxtField.textProperty().addListener((observable, oldValue, newValue)->
        {
            filter.setPredicate((Predicate<? super patient>)(patient Patient)->{
                
                if(newValue.isEmpty() || newValue == null){
                    return true;
                }
                else if(Patient.getName().toLowerCase().contains(newValue) || 
                        Patient.getId().toString().contains(newValue)|| 
                        Patient.getName().contains(newValue)){
                return true;
                }
                
                return false;
                });
            });
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sort);
        }
    
    }
        
        
        
        
        
        
     
    

