/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.awt.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;


/**
 *
 * @author Ahmed Diab
 */
public class TeamMember {

    private String name;
    private String role;
    private String email;
    private int activityCompleted;
    private char gender;
    private Button btn;
    private Image genderImage;
    private ObservableList<Activities> data;
    private StackPane root;
    
    /**
     * constructor
     * @param name
     * @param role
     * @param g
     * @param email
     * @param ac 
     */
    public TeamMember(String name, String role, char g, String email, int ac) {
        setName(name);
        setRole(role);
        setEmail(email);
        setActivityCompleted(ac);
        setGender(g);
        btn = new Button();
        btn.setShape(new Circle(10)); // set the shape of the button.
        btn.setMinSize(140, 140);
        btn.setTextAlignment(TextAlignment.CENTER);           // center the text inside the button.
        btn.setText(getName() + '\n');                        // write member name inside the button.
        btn.setText(btn.getText() + getRole() + '\n');        // write member role inside the button.
        double t = getActivityCompleted()/  (double)100;
        
        // create a progress indicator.
        ProgressIndicator indicator = new ProgressIndicator(t);
        indicator.setMinSize(200, 200);
        indicator.setStyle(getColor(getActivityCompleted()));
        indicator.setTranslateY(8);
        
        // create a stack pane and add the indicator and the button to it, so they appear on top of each other.
        root = new StackPane();
        root.getChildren().add(indicator);
        root.getChildren().add(btn);
        // if gender = m, then temp = image2.jpeg. Otherwise, temp = image1.jpg.
        String temp = gender == 'm' ? "image2.jpeg" : "image1.jpg";
        genderImage = new Image(temp);
        data = FXCollections.observableArrayList();
    }
    

    /**
     * set name.
     * @param name 
     */
    public void setName(String name) {       
        this.name = name;
    }
    
    /**
     * set gender.
     * @param g 
     */
    public void setGender(char g) {
        this.gender = g;
    }
    
    /**
     * set role.
     * @param role 
     */
    public void setRole(String role) {
        this.role = "(" + role + ")";
    }
    
    /**
     * set email.
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set activityCompleted.
     * @param activityCompleted 
     */
    public void setActivityCompleted(int activityCompleted) {
        this.activityCompleted = activityCompleted;
    }

    /**
     * access to name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * access to gender
     * @return 
     */
    public char getGender() {
        return gender;
    }
    
    /**
     * access to role.
     * @return 
     */
    public String getRole() {
        return role;
    }

    /**
     * access to email.
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * access to activityCompleted.
     * @return 
     */
    public int getActivityCompleted() {
        return activityCompleted;
    }
    
    /**
     * access to genderImage.
     * @return 
     */
    public Image getGenderImage() {
        return genderImage;
    }
    
    /**
     * access to btn.
     * @return 
     */
    public Button getBtn() {
        return btn;
    }
    
    /**
     * access to root.
     * @return 
     */
    public StackPane getRoot(){
        return root;
    }

    /**
     * method that add activity to the observableArrayList data.
     * @param activity 
     */
    public void addActivity(Activities activity){
        data.add(activity);
    }
    
    /**
     * access to data,
     * @return 
     */
    public ObservableList getActivityList(){
        return data;
    }
    
    /**
     * method that returns the color of the progress indicator.
     * @param activityCompleted
     * @return 
     */
    private String getColor(int activityCompleted){
        String color = "";
        // if activity completed is less than or equal 25, set the color of the progress indicator to indianred.
        if(activityCompleted <= 25){
            color = " -fx-progress-color: indianred;";
        }
        // if activity completed is in the range of (25 - 50), set the color of the progress indicator to lightsalmon.
        else if(activityCompleted > 25 && activityCompleted <=50){
            color = " -fx-progress-color: lightsalmon;";
        }
        // if activity completed is in the range of (50 - 75), set the color of the progress indicator to lightgreen.
        else if(activityCompleted > 50 && activityCompleted <=75){
            color = " -fx-progress-color: lightgreen;";
        }
        // if activity completed is in the range of (75 - 100), set the color of the progress indicator to green.
        else if(activityCompleted > 75 && activityCompleted <=100){
            color = " -fx-progress-color: green;";
        }
        return color;
    }
}
