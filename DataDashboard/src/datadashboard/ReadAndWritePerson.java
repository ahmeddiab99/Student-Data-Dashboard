/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



/**
 *
 * @author leonz
 * 
 * Leon Additional class
 * 
 * 
 */
public class ReadAndWritePerson {
    
    public ArrayList<Person> perNormal=new ArrayList<Person>();
    
    private Person[] per;
    
    private int personLength;
    
    public ReadAndWritePerson() throws IOException
    {
        //readAndWriteNormalData();
    }
    
    
    
    public ArrayList<Person> readNormalData() throws IOException
    {
        File wxdataF=new File("Person.txt");
        if(perNormal.size()>0)
        {
            perNormal.clear();
        }
        if(wxdataF.exists())
        {
            System.out.println("Source File src/data/Person.txt"
                            +" exit");
            
            try(
                BufferedInputStream is=new BufferedInputStream(new FileInputStream(wxdataF));
                
                )
            {
                
                Scanner input=new Scanner(is);
                
                String str="";
                int r=0,countLine=0;
                
                while(input.hasNextLine())
                {
                    str+=input.nextLine();
                    r++;
                }
                
                String[] personStr=str.split("-");
                personLength=r;
                
                for(int i=0 ; i < personStr.length ; i++)
                {
                    Person personInRow=new Person();
                    if(!personStr[i].isEmpty())
                    {
                        String[] element = personStr[i].split(",");

                        for(int j=0; j < element.length ; j++)
                        {
                            String[] cellStr=element[j].split("=");
                            switch(j)
                            {
                                case 0:
                                    personInRow.setusername(cellStr[1]);
                                    break;
                                case 1:
                                    personInRow.setpassword(cellStr[1]);
                                    break;
                                case 2:
                                    personInRow.setuserId(Integer.valueOf(cellStr[1]));
                                    break;

                            }

                        }
                        if(perNormal.isEmpty())
                        {
                            perNormal=new ArrayList<Person>();
                            perNormal.add(countLine, personInRow);
                        }else
                        {
                            if(perNormal.size()+1==countLine)
                            {
                                perNormal.set(countLine, personInRow);
                            }else
                            {
                                perNormal.add(countLine, personInRow);
                            }
                        }
                        countLine++;
                    }
                }
                
            }
        }
        return perNormal;
    }
    
    
    
    
    public Person[] readFile()
    {
        File nwxdataF=new File("Personbin.dat");
        //String str="";
                
        if(nwxdataF.exists())
        {
            System.out.println("Source File src/data/Personbin.dat"
                            +" exit");
            
            
            //FileInputStream inputFile=new FileInputStream(nwxdataF);
            try
            {
                FileInputStream fis=new FileInputStream(nwxdataF);
                ObjectInputStream oisr=new ObjectInputStream(fis);
                //BufferedInputStream
                
                //Person[] pr=(Person[])(oisr.readObject());
                Person[] pr=new Person[255];                
                int r = 0;
                
                try{
                    while((pr[r]=(Person)oisr.readObject())!=null)
                    {
                        r++;
                    }
                }catch(Exception e)
                {
                    
                    per=new Person[r];
                    
                    for(int i=0 ; i < r ; i++)
                    {
                        per[i]= pr[i];
                    }
                    personLength=r;
                }
                                
             oisr.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            //inputFile.close();
                
        }
        
        return per;
        
    }
    
    
    public void writeNormalData(Person personWrite) throws FileNotFoundException, IOException
    {
        File wxdataF=new File("Person.txt");
                
        if(wxdataF.exists())
        {
            System.out.println("Source File src/data/Person.txt"
                            +" exit");
            
            try(
                
                BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(wxdataF,true));
                )
            {
                
                Date ctime=new Date();
                SimpleDateFormat formatId=new SimpleDateFormat("YYYYMMddhhmmss");
                String id=formatId.format(ctime).toString()+
                        String.valueOf(personWrite.getuserId());
                    os.write(("-Id:"+id+":Username="+
                            personWrite.getusername()+",").getBytes());
                    os.write(("Password="+personWrite.getpassword()+",").getBytes());
                    os.write(("User Id=").getBytes());
                    String ageStr=String.valueOf(personWrite.getuserId());
                    os.write(ageStr.getBytes());
                    
                    os.write(("\n").getBytes());
            }
        }
    }
        
        
    
    
    public void addMultipelPersonNormalData(ArrayList<Person> personWrite) throws FileNotFoundException, IOException
    {
        File wxdataF=new File("Person.txt");
                
        if(wxdataF.exists())
        {
            System.out.println("Source File src/data/Person.txt"
                            +" exit");
            
            try(
                
                BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(wxdataF));
                )
            {
                for(int i=0; i < personWrite.size() ; i++ )
                {
                    Date ctime=new Date();
                    SimpleDateFormat formatId=new SimpleDateFormat("YYYYMMddhhmmss");
                    String id=formatId.format(ctime).toString()+
                        String.valueOf(personWrite.get(i).getuserId());
                    os.write(("-Id:"+id+":Username="+
                            personWrite.get(i).getusername()+",").getBytes());
                    os.write(("Password="+personWrite.get(i).getpassword()+",").getBytes());
                    os.write(("User Id=").getBytes());
                    String ageStr=String.valueOf(personWrite.get(i).getuserId());
                    os.write(ageStr.getBytes());
                    os.write(("\n").getBytes());
                }
            }
        }
        
        
    }
    
    
    public void addSinglePersonInBin(Person personWrite) throws FileNotFoundException, IOException
    {
        
        File nwxdataF=new File("Personbin.dat");
        
        if(nwxdataF.exists())
        {
            System.out.println("Source File src/data/Personbin.dat"
                            +" exit");
            
            //String [] str=datas.titleLine.split("\t");
            FileOutputStream outputFile=new FileOutputStream(nwxdataF,true);


            try(
                ObjectOutputStream output=new ObjectOutputStream(outputFile);
            )
            {
                output.writeObject(personWrite);
                    
                output.close();
            }
            outputFile.close();
        }else
        {
            System.out.println("Can not find nwxData012015.txt file");
            nwxdataF.createNewFile();
            addSinglePersonInBin(personWrite);
        }

    }
    
    
    public void addMultiplePersonInBin(Person[] personWrite) throws FileNotFoundException, IOException
    {
        
        File nwxdataF=new File("Personbin.dat");
        
        if(nwxdataF.exists())
        {
            System.out.println("Source File src/data/Personbin.dat"
                            +" exit");
            
            FileOutputStream outputFile=new FileOutputStream(nwxdataF,true);


            try(
                ObjectOutputStream output=new ObjectOutputStream(outputFile);
            )
            {
                
                for(int i=0; i < personWrite.length ; i++)
                {
                    output.writeObject(personWrite[i]);
                }   
                output.close();
            }
            outputFile.close();
        }else
        {
            System.out.println("Can not find nwxData012015.txt file");
            nwxdataF.createNewFile();
            addMultiplePersonInBin(personWrite);
        }

    }
    
}
