/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

//import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.PasswordField;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import jxl.Sheet;
import jxl.Workbook;


/**
 *
 * @author leonz
 */
public class readXLSXData {
    private Stage windows=new Stage();
    
    private FileInputAndOutput xlsxFile =new FileInputAndOutput();
    private BorderPane root=new BorderPane();
    
    private String submission_answer_id = "";
    
    public void displayData(Stage s)
    {
        
        Image homeImage=new Image("file:src/home.png");
        Image taskImage=new Image("file:src/task.png");
        Image settingImage=new Image("file:src/setting.png");
    
        
        ImageView ivTopHome=new ImageView();
        ivTopHome.setImage(homeImage);
        ivTopHome.setFitWidth(30);
        ivTopHome.setFitHeight(30);
        
        ImageView ivTopTask=new ImageView();
        ivTopTask.setImage(taskImage);
        ivTopTask.setFitWidth(30);
        ivTopTask.setFitHeight(30);
        
        ImageView ivTopSetting=new ImageView();
        ivTopSetting.setImage(settingImage);
        ivTopSetting.setFitWidth(30);
        ivTopSetting.setFitHeight(30);
        
        FlowPane topGroup=new FlowPane();
        topGroup.setAlignment(Pos.CENTER);
        topGroup.setVgap(30);
        topGroup.setHgap(30);
        topGroup.getChildren().add(ivTopHome);
        topGroup.getChildren().add(ivTopTask);
        topGroup.getChildren().add(ivTopSetting);
        
        root.setTop(topGroup);
        
        root.setLeft(leftDisplay());
        
        root.setCenter(centerDisplay(s));
        
        
        
        Scene scene=new Scene(root);
        windows.setTitle("Data");
        windows.initModality(Modality.APPLICATION_MODAL);
        
        windows.setScene(scene);
        windows.showAndWait();
    }
    
    
    
    
    private Pane leftDisplay()
    {
        Border leftSideBorder = new Border(new BorderStroke(Paint.valueOf("LightBlue"),
                BorderStrokeStyle.DOTTED, new CornerRadii(10), new BorderWidths(3)));
        //------------------Left----------------
        Image taskImage=new Image("file:src/task.png");
        HBox leftBox=new HBox();
        leftBox.setFillHeight(true);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setPrefWidth(200);
        leftBox.setPadding(new Insets(10));
        
        leftBox.setBorder(leftSideBorder);
        
        Image logImage=new Image("file:src/Main_practera_logo.png");
        ImageView ivLog=new ImageView();
        ivLog.setImage(logImage);
        ivLog.setFitWidth(190);
        ivLog.setFitHeight(50);
        
        GridPane tableLeft=new GridPane();
        tableLeft.centerShapeProperty();
        Image adminImage=new Image("file:src/image2.jpeg");
        ImageView ivadminImage=new ImageView();
        ivadminImage.setImage(taskImage);
        ivadminImage.setFitWidth(50);
        ivadminImage.setFitHeight(50);
        
        tableLeft.add(ivLog, 0, 1, 2, 1);
        
        tableLeft.addRow(1, new Text(""));
        tableLeft.addRow(2, new Text(""));
        tableLeft.add(ivadminImage, 0, 3, 1, 3);
        
        tableLeft.add(new Text("User ID:"), 1, 3);
        tableLeft.add(new Text("User Name:Admin"), 1, 4);
        tableLeft.add(new Text("Position"), 1, 5);
        
        leftBox.getChildren().add(tableLeft);
        
        
        
        
        //------------------Left----------------
        return leftBox;
    }
    
    private Pane centerDisplay(Stage s)
    {
         //------------------mid top----------------
        GridPane tableCenter=new GridPane();
        //------------------mid top----------------
        String sheetNam="assess_assessment_subs_answers";
        int row, column, pages;
        
        row=10;
        column=7;
        pages=1;
        try{
            
            tableCenter.setCenterShape(true);
            tableCenter.setHgap(20);
            tableCenter.setVgap(20);
            
            ArrayList<LinkedList> tableValues= xlsxFile.readExcelData((row*pages), column, pages, sheetNam);
            
            
            Button[] bts=new Button[row];
            for(int i=0;i < row; i++)
            {
                LinkedList<String> eachRowValue = tableValues.get(i);
                
                for(int j = 0; j < column ; j++)
                {
                    tableCenter.add(new Text(eachRowValue.get(j).toString()), j, i);
                    if(column-1==j && i != 0)
                    {
                        bts[i]=new Button("Group Infor");
                        bts[i].setOnAction(e->{
                            submission_answer_id = eachRowValue.get(1).toString();
                            windows.close();
                            s.show();//Aham add here too
                        }); 
                        tableCenter.add(bts[i],j+1,i);
                    }
                }
                
                
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return tableCenter;
    }
    
    
    
    public void Show()
    {
        windows.show();
    }
    
}
