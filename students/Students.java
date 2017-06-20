
package students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Students {
public static Scanner sc = new Scanner(System.in);
public static int ask = 0;
public static String addinfo="";
public static String namepath="";
public static String add="";
public static String addname="";
public static String ppl="";
public static int choose=0;
public static String line="";


    public static void menushow(){
         System.out.println("1.show\n"
                    +"2.add\n"
                    +"===================="); 
         ask();
 
    }
    
    private static void ask() {
       ask = sc.nextInt();
	    if(ask == 1){
	    list();   
	    }
	    else if(ask == 2){
	    add();    
	    }
	    else if(ask != 1 || ask != 2){
	    menushow();    
	    }
     }
     
    public static void buffReadPeople(){
       try {
	    		String thisLine = "";
	    		BufferedReader br = new BufferedReader(new FileReader("people.txt"));
	    		while ((thisLine = br.readLine()) != null) {
	    		ppl = ppl + thisLine;
	    		}
	    		br.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    }
    
    

     public static void list(){
	    	System.out.println("");
	    	buffReadPeople();
	     	String[] AddArray = ppl.split("_"); 
	     	int i=0;
	     	int num=1;
	     	while(i != AddArray.length){
	     	System.out.println(num + " " +AddArray[i] + " " + AddArray[i+1]);
	     	num++;
	     	i++;
	     	i++;
	     	}
	     	
	     	System.out.println("choose:");
	     	choose=sc.nextInt();
	     	
	   	if(choose >= num){
	     		System.out.println("wrong number");
	     		menushow();
	     		
	     	}              
	     	int first=0;
	     	if(choose==1){
	     	first=0;	
	     	}
	     	if(choose==2){
		     	first=2;	
	     	}
	     	else if(choose != 1 || choose !=2){
	     		first=(choose-1)*2;
	     	}
	     	String newpath = AddArray[first] + "_" +AddArray[first+1] +".txt";
                
                
	     	try {
	     		
	    		String thisLine = "";
	    		BufferedReader br = new BufferedReader(new FileReader(newpath));
	    		while ((thisLine = br.readLine()) != null) {
	    		line = line + thisLine;
	    		}
	    		br.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
                
	     	String[] AddArray2 = line.split(",");
	     	String splito=AddArray2[2];
                // System.out.println(splito); ddmmyy

                
                
                
	     	String gender="";
	     	if(AddArray[2].equals("5")){
	     		gender = "Female";
	     		
	     	}
	     	else{
	     		gender = "Male";
	     	}

	     	line=line.replace(",", " ");
	     	System.out.println(" ");
	     	System.out.println(line + " " +gender);

	    }
     
   
     
     
     public static void add(){
         
                 System.out.println("meno");
	            add = sc.next();
	            addinfo = add; 
	            namepath = add;
        
                 System.out.println("priezvisko");
	            addinfo=addinfo+","; 
	            add = sc.next();
	            addinfo =addinfo+ add;
	            addname = namepath + "_" + add;
	           namepath=namepath + "_" + add + ".txt"; 
	           
                   
                System.out.println("number");
	            addinfo=addinfo+","; 
	            add = sc.next();
	            addinfo = addinfo+ add;
	            
	            System.out.println(namepath);
	            
                    intoFile();
     }
     
     private static void intoFile() {
        
        File file = new File(namepath);
       	    		try {
	    			if (file.createNewFile()) {
	    				System.out.println("File created.\n");		
	    				

	    				try (BufferedWriter bw = new BufferedWriter(new FileWriter(namepath, true))) {
	    					

	    					bw.write(addinfo);
	    					bw.newLine();				
	    					bw.flush();
	    					bw.close();
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    				
	    				try (BufferedWriter bw = new BufferedWriter(new FileWriter("people.txt",true))) {
	    					

	    					bw.write(addname + "_");
	    					bw.flush();
	    					bw.close();
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    				
	    				
	    			} else {
	    				System.out.println("");
	    			}
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		
	            
	            menushow();
	            
	            
	            
	            }
    
    public static void main(String[] args) {
        menushow();
    }
	            }