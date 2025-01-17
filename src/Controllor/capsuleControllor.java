package Controllor;

import Entity.capsule;
import Service.ServiceCapsule;
import Helpers.DbConnect;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class capsuleControllor implements Initializable{

    public ImageView imageView;
    public Button user_button;
    String imagePath = null;

    private File file;
    private FileInputStream fin;
    public AnchorPane anchorpane;

    @FXML
    private TextField txt_mat;

    @FXML
    private TextField text_marque;

    @FXML
    private TextField txt_model;

    @FXML
    private TextField txt_color;

    @FXML
    private TextField txt_id;

    @FXML
    private Button button;

    @FXML
    private TextField txt_nbPlace;

    @FXML
    private TextField txt_prix;

    @FXML
    private TableView<capsule> table_users;

    @FXML
    private TableColumn<capsule, Integer> col_id;

    @FXML
    private TableColumn<capsule, String> col_matricule;

    @FXML
    private TableColumn<capsule, String> col_marque;

    @FXML
    private TableColumn<capsule, String> col_modele;

    @FXML
    private TableColumn<capsule, String> colorColn;

    @FXML
    private TableColumn<capsule, String> placeCol;

    @FXML
    private TableColumn<capsule, String> prixColn;

    @FXML
    private TableColumn<capsule, String> imgCol;




    @FXML
    private TextField filterField;


    private Image image;

    @FXML
    private Button toaddfile;

    @FXML
    private Button showRelatedFiles;

    ObservableList<capsule> listM;
    ObservableList<capsule> dataList;




    int index = -1;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    public void Add_users () throws SQLException {

        if(txt_mat.getText().isEmpty()
                || txt_nbPlace.getText().isEmpty()
                || txt_prix.getText().isEmpty()
                || text_marque.getText().isEmpty()
                || txt_model.getText().isEmpty()
                || txt_color.getText().isEmpty()
                || imagePath== null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Insert Failed, information missing");
            alert.show();
        }
        else{
            capsule t = new capsule(null, txt_mat.getText(),
                    txt_nbPlace.getText(),txt_prix.getText(),
                    text_marque.getText(),txt_model.getText(),
                    txt_color.getText(),imagePath);
            ServiceCapsule st= new ServiceCapsule();
            st.add(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Ajout succes");
            alert.show();
            UpdateTable();
            search_user();
        }
        /**********************************added*************************************/

    }


    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
        index = table_users.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_mat.setText(col_matricule.getCellData(index).toString());
        text_marque.setText(col_marque.getCellData(index).toString());
        txt_model.setText(col_modele.getCellData(index).toString());
        txt_color.setText(colorColn.getCellData(index).toString());
        txt_nbPlace.setText(placeCol.getCellData(index).toString());
        txt_prix.setText(prixColn.getCellData(index).toString());




        /**********************************/
        Image image = new Image("file:///"+table_users.getSelectionModel().getSelectedItem().getImage());
        imageView.setImage(image);
        imagePath=table_users.getSelectionModel().getSelectedItem().getImage();

        /*********************************************/

    }

    public void Edit () throws SQLException {

        if(txt_mat.getText().isEmpty()
                || txt_nbPlace.getText().isEmpty()
                || txt_prix.getText().isEmpty()
                || text_marque.getText().isEmpty()
                || txt_model.getText().isEmpty()
                || txt_color.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Update Failed, information missing");
            alert.show();
        }
        else{capsule t = new capsule(table_users.getSelectionModel().getSelectedItem().getId(),
                txt_mat.getText(),
                txt_nbPlace.getText(),
                txt_prix.getText(),
                text_marque.getText(),
                txt_model.getText(),
                txt_color.getText(),
                imagePath);
            ServiceCapsule st= new ServiceCapsule();
            st.update(t);
            UpdateTable();
            search_user();}
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Update succes");
        alert.show();

    }

    public void Delete() throws SQLException {

        ServiceCapsule st= new ServiceCapsule();
        st.delete((long) table_users.getSelectionModel().getSelectedItem().getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Delete Success");
        alert.show();
        UpdateTable();
        search_user();
    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<capsule,Integer>("id"));
        col_matricule.setCellValueFactory(new PropertyValueFactory<capsule,String>("nomcapsule"));
        col_marque.setCellValueFactory(new PropertyValueFactory<capsule,String>("typecapsule"));
        colorColn.setCellValueFactory(new PropertyValueFactory<capsule,String>("longcasule"));
        placeCol.setCellValueFactory(new PropertyValueFactory<capsule,String>("programmecapsule"));
        prixColn.setCellValueFactory(new PropertyValueFactory<capsule,String>("chemincapsule"));
        col_modele.setCellValueFactory(new PropertyValueFactory<capsule,String>("cible"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        listM = DbConnect.getDatausers();
        table_users.setItems(listM);
    }




    @FXML
    void search_user() {
        col_matricule.setCellValueFactory(new PropertyValueFactory<capsule,String>("nomcapsule"));
        placeCol.setCellValueFactory(new PropertyValueFactory<capsule,String>("typecapsule"));
        prixColn.setCellValueFactory(new PropertyValueFactory<capsule,String>("longcasule"));
        col_marque.setCellValueFactory(new PropertyValueFactory<capsule,String>("programmecapsule"));
        col_modele.setCellValueFactory(new PropertyValueFactory<capsule,String>("chemincapsule"));
        colorColn.setCellValueFactory(new PropertyValueFactory<capsule,String>("cible"));

        dataList = DbConnect.getDatausers();
        table_users.setItems(dataList);
        FilteredList<capsule> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getTypecapsule().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (person.getTypecapsule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }else if (person.getLongcasule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                } else if (person.getProgrammecapsule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }else if (person.getChemincapsule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }
                else if (String.valueOf(person.getCible()).indexOf(lowerCaseFilter)!=-1)
                    return true;// Filter matches email

                else
                    return false; // Does not match.
            });
        });
        SortedList<capsule> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_user();
        // Code Source in description
    }

    @FXML
    String Filechooser() {

        FileChooser fc = new FileChooser();

        fc.setInitialDirectory(new File("C:\\Users\\21658\\OneDrive\\Bureau\\mahdijgham\\mahdijgham\\src\\resources"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpeg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("video Files", "*.mp4"));


        File f = fc.showOpenDialog(null);
        if(f != null)
        {
            System.out.println(f);
        }
        imagePath=f.getPath();
        imagePath =imagePath.replace("\\","\\\\");
        return f.getName();
    }


    public void handleButtonAction(ActionEvent event) throws IOException {

        Stage stage = (Stage)anchorpane.getScene().getWindow();

        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
        fc.getExtensionFilters().addAll(ext1,ext2);
        File file = fc.showOpenDialog(stage);

        BufferedImage bf;
        try {
            bf = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bf, null);
            imageView.setImage(image);
            FileInputStream fin = new FileInputStream(file);
            int len = (int)file.length();

        } catch (IOException ex) {
            Logger.getLogger(capsuleControllor.class.getName()).log(Level.SEVERE, null, ex);

        }


    }

    public void multipleFileChooserAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Multiple file dialog");
        Stage stage = (Stage)anchorpane.getScene().getWindow();

        java.util.List<File> list=fileChooser.showOpenMultipleDialog(stage);

        if(list != null)
        {
            for(File file: list)
            {
                Desktop desktop =Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addAttachment(ActionEvent event ) throws Exception {
        Parent root  = FXMLLoader.load(getClass().getResource("../gui/tableViewFile2.fxml"));

        Stage window =(Stage) toaddfile.getScene().getWindow();
        window.setScene(new Scene(root, 1064, 600));
    }

    public void showHandleBtn(ActionEvent event) throws Exception {
        Parent root  = FXMLLoader.load(getClass().getResource("../gui/plateformeUI.fxml"));

        Stage window =(Stage) showRelatedFiles.getScene().getWindow();
        window.setScene(new Scene(root, 1500, 1700));
    }




    /**************************************************************************************/

    /**************************************************************************************/
    /**************************************************************************************/

    /**************************************************************************************/



}
