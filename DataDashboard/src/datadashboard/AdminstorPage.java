/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Cursor;
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

/**
 *
 * @author Leon (Zhong Zheng)
 * 
 */
//tell compiler ignore warning when to suppress warnings relative to unchecked operations
//and unused is suppressing warnings relative to unused code
@SuppressWarnings(value={"unchecked","unused"})
public class AdminstorPage {
        
    //primary stage is main window stage for login page
    private Stage primaryStage=new Stage();
    private AlertDialog loginAlter=new AlertDialog();//alert class 
    public boolean loginVerify=false; //this variable to conform login
    public Person loginUser;
    
    /***
     * the main entering page
     */
    public void LoginStart() {
        
        //main login page
        primaryStage.setTitle("login");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        
        //gridpane for distributing all element displaying place
        GridPane mainPage=new GridPane();
        mainPage.setHgap(10);
        mainPage.setVgap(10);
        
        mainPage.setAlignment(Pos.CENTER);
        
        //Text emptySpace=new Text("\t");
        //user name text box
        TextField userNameBox=new TextField("please enter your user name");
        userNameBox.setEditable(true);
        userNameBox.setStyle("-fx-text-fill: LIGHTGRAY");
        
        //password text box
        PasswordField passwordBox=new PasswordField();
        passwordBox.setEditable(true);
        passwordBox.setText("please enter your password");
        passwordBox.setStyle("-fx-text-fill: LIGHTGRAY");
        
        Label userName=new Label("User Name : ");
        Label passWord=new Label("PassWord : ");
        
        userName.setFont(new Font("Cambria",14));
        passWord.setFont(new Font("Cambria",14));
        
        //login  button
        Button loginbtn=new Button(" Login ");//login button
        loginbtn.centerShapeProperty();
        
        //close button
        Button closebtn=new Button(" Close ");//close programm button
        closebtn.centerShapeProperty();
        closebtn.setOnAction(e->primaryStage.close());
        
        //showing practera sign
        Image adminImage=new Image("file:src/practera_logo.png");
        ImageView ivadminImage=new ImageView();
        ivadminImage.setImage(adminImage);
        ivadminImage.setFitWidth(310);
        ivadminImage.setFitHeight(100);
        
        
        //distributing all element displaying place
        mainPage.addRow(0, new Text(" "));
        mainPage.add(ivadminImage, 0, 0,4,3);
        mainPage.add(new Text(""), 1, 0);
        mainPage.add(new Text(""), 2, 0);
        mainPage.add(new Text(""), 3, 0);
        
        mainPage.add(new Text(""), 1, 1);
        mainPage.add(new Text(""), 2, 1);
        mainPage.add(new Text(""), 3, 1);
        
        
        mainPage.add(new Text(""), 0, 2);
        mainPage.add(userName, 1, 2);
        mainPage.add(userNameBox, 2, 2);
        mainPage.add(new Text(""), 3, 2);
        
        mainPage.add(new Text(""), 0, 3);
        mainPage.add(passWord, 1, 3);
        mainPage.add(passwordBox, 2, 3);
        mainPage.add(new Text(""), 3, 3);
        
        
        mainPage.add(new Text("\t"), 0, 4);
        mainPage.add(loginbtn, 1, 4);
        mainPage.add(closebtn, 2, 4);
        mainPage.add(new Text(" "), 3, 4);
        /////////////////////////////////////////////
        
        mainPage.setAlignment(Pos.CENTER); 
        //mouse click event to consider user entering username value
        //default is "please enter your user name" value means is empty 
        userNameBox.setOnMouseClicked(e->{
            
            String strUserName="please enter your user name";
            
            if(e.getButton()== MouseButton.PRIMARY)
            {
                if( userNameBox.getText().equals(strUserName))
                {
                    userNameBox.setText("");//before enter clean up text box
                    userNameBox.setStyle("-fx-text-fill: Black");
                }
                
            }
            
        });
        
        //mouse setOnKeyPressed event to consider user entering username value
        //default is "please enter your user name" value means is empty 
        userNameBox.setOnKeyPressed(e->{
            if(e.getTarget()== userNameBox)
            {
                String strUserName="please enter your user name";
                if(userNameBox.getText().equals(strUserName))
                {
                    userNameBox.setText("");//before enter clean up text box
                    userNameBox.setStyle("-fx-text-fill: Black");
                }
            }
        });
        
        
        //mouse mouse click event to consider user entering password value
        //default is "please enter your user name" value means is empty 
        passwordBox.setOnMouseClicked(e->{
            
            String strUserName="please enter your password";          
            if(e.getButton()== MouseButton.PRIMARY)
            {
                if( passwordBox.getText().equals(strUserName))
                {
                    passwordBox.setText("");
                    passwordBox.setStyle("-fx-text-fill: Black");
                }
            }
        });
        
        
        //mouse setOnKeyPressed event to consider user entering password value
        //default is "please enter your user name" value means is empty 
        passwordBox.setOnKeyPressed(e->{
            String strUserName="please enter your password";
            if(passwordBox.getText().equals(strUserName))
            {
                
                passwordBox.setText("");
                passwordBox.setStyle("-fx-text-fill: Black");
            }
        });
        
        //mouse setOnMouseClicked event to consider user entering value
        //default is "please enter your user name" value means is empty 
        loginbtn.setOnMouseClicked(e->{
            if(isEmpty(userNameBox.getText(),passwordBox.getText()))
            {
                
                //leon change in here 
                try {
                    //System.out.println("admin1mouse");
                    loginVerify = login(userNameBox.getText(),passwordBox.getText());
                } catch (IOException ex) {
                    Logger.getLogger(AdminstorPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("admin2mouse");
                
                //end in here

            }
            
        });
        
        //entering keyboard event for lgoin consider
        Scene scene = new Scene(mainPage, 318, 220);
        scene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.ENTER)
            {
                if(isEmpty(userNameBox.getText(),passwordBox.getText()))
                {
                    //leon change in here 
                    try {
                        //System.out.println("admin1Enter");
                        loginVerify = login(userNameBox.getText(),passwordBox.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(AdminstorPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println("admin2Enter");
                    //end in here
                    
                }
                
                
            }
        });
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.showAndWait();
        //return loginVerify;
    }
    
    //////warning when we didn't enter anything while we clicked button
    public boolean isEmpty(String userName, String passWord)
    {
        if(userName.isEmpty() || passWord.isEmpty() ||
                userName.endsWith("please enter your user name") 
                || passWord.endsWith("please enter your password") )
        {
                    
            loginAlter.alertBox("Error", "User Name or Password is empty,please \nenter "
                + "your Username or password");
            return false;
        }else
        {
            return true;
        }
    }
    
    
    /***
     * login function to read local data with two way
     * @param userName
     * @param passWord
     * @return
     * @throws IOException 
     */
    public boolean login(String userName, String passWord) throws IOException
    {
        
        
            
        
            
        if(userName.equals("admin") && passWord.equals("admin"))
        {
           return true;
        } else{
        return false;
    }
        /////////////////////end in here///////////////////////////
        //return loginVerify;
    }
    
    

    //close main page
    public void close()
    {
        primaryStage.close();
    }
    
}







