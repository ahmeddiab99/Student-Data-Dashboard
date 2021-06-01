/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.io.*;
import java.util.*;
import java.util.List;
import jxl.Cell;

import jxl.Workbook;
import jxl.Sheet;


/**
 *
 * @author leonz
 */
public class FileInputAndOutput {
    
    
    Workbook workbook;  
   
    /***
     * 
     * @param numRow how many rows per page read from excel data
     * @param numColumn how many columns in excel data
     * @param page count data beginning row number : numRows * page
     * @sheetName sheetName is the sheets name in excel file.
     * @return return two dimension cell class array for display table
     * @throws FileNotFoundException decide reading status, if reading fail, will return null
     */
    public ArrayList<LinkedList> readExcelData(int numRow, int numColumn, int page, String sheetName) throws FileNotFoundException
    {
       
        ArrayList<LinkedList> table=new ArrayList();
            
            
       
        File fis=new File("C:\\Users\\diabo\\Documents\\NetBeansProjects\\DataDashboard\\src\\511.xls");
            try{
        /////////////////////changing end here////////////////////////////////        
                workbook=Workbook.getWorkbook(fis);
                
                Sheet[] sheets=workbook.getSheets();
                //System.out.println(sheetName);
                
                for(Sheet s :  sheets)
                {
                    if(s.getName().equals(sheetName))
                    {
                        
                        ///////-----------adding code for title line---------
                        Cell[] title=s.getRow(0);
                        LinkedList<String> titleList=new LinkedList(); 
                        for(int j = 0; j < numColumn ; j++ )
                        {
                          
                            titleList.add(j,title[j].getContents().toString());

                        }
                        table.add(0, titleList);
                        
                        for(int i=1; i < numRow+1; i++ )
                        {
                            Cell[] c=s.getRow(i);
                            LinkedList<String> map=new LinkedList(); 
                            for(int j = 0; j < numColumn ; j++ )
                            {
                                
                                map.add(j,c[j].getContents().toString()) ;

                            }
                            table.add(i, map);
                        }
                    }
                    
                }
                
                

            }catch(Exception e)
            {
                e.printStackTrace();
                return table;
            }
 
        return table;
    }
    
    
}



