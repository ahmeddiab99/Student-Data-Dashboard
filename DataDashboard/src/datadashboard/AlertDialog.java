/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

/**
 *
 * @author leonz
 */
public class AlertDialog {
    
    public void alertBox(String title,String message)
    {
        
        Stage windows=new Stage();
        
        windows.setTitle(title);
        windows.initModality(Modality.APPLICATION_MODAL);
        
        Label messageLabel=new Label(message);
        messageLabel.alignmentProperty();
        
        messageLabel.setWrapText(true);
        
        Button conformBtn=new Button("Ok");
        conformBtn.setOnAction(e->windows.close());
        GridPane pane=new GridPane();
        
        
        Image warrningImage=new Image("file:src/warrning.png");
        ImageView iv=new ImageView();
        iv.setImage(warrningImage);
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        
        
        pane.add(iv, 0, 0,1,3);
        
        pane.alignmentProperty();
        pane.add(new Text(""),1,0);
        pane.add(messageLabel,1,1);
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        pane.add(conformBtn,1,2);
        GridPane.setHalignment(conformBtn, HPos.CENTER);
        pane.setHgap(15);
        pane.setVgap(15);
        pane.add(new Text(""),0,3);
        
        Scene scene=new Scene(pane);
        scene.setFill(Color.WHITE);
        
        windows.setScene(scene);
        windows.showAndWait();
        
    }
    
    
}
