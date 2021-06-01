/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonz
 */
public class Person implements Serializable, Externalizable{
    private String username;
    private String password;
    private int userId;
    
    public Person()
    {}

    public Person(String username,String password,int userId)
    {
        this.username=username;
        this.password=password;
        this.userId=userId;
    }
    
    public String getusername()
    {
        return this.username;
    }
    
    public void setusername(String username)
    {
        this.username=username;
    }
    
    public String getpassword()
    {
        return this.password;
    }
    
    public void setpassword(String password)
    {
        this.password=password;
    }
    
    public int getuserId()
    {
        return this.userId;
    }
    
    public void setuserId(int userId)
    {
        this.userId=userId;
    }
    

    
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
        out.writeObject(this.username);
        out.writeObject(this.password);
        out.writeInt(this.userId);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        
        this.username=(String)in.readObject();
        this.password=(String)in.readObject();
        this.userId=in.readInt();
        
    }
}

