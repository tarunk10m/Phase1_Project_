package com.phase1;
import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int option,op;
		System.out.println("!!!WELCOME!!!");
		System.out.println();
		System.out.println("LockedMe.com");
		System.out.println("Developer Details:");
		System.out.println("Tarun Kislay\nComviva");
		
		System.out.println();
		//Creating Menu for user
		do {
		System.out.println("Please select one of the options given below to proceed:");
		System.out.println("1.Return the current file names in ascending order");
		System.out.println("2.More Options");
		System.out.println("3.Close the application");
		 op = sc.nextInt();
		switch(op) {
		case 1:
			ReturnCurrentFileName();
			break;
		case 2:
			//creating sub-menu for user
			do {
			System.out.println("1.Add a file to the existing directory list");
			System.out.println("2.Delete a user specified file from the existing directory list");
			System.out.println("3.Search a user specified file from the main directory");
			System.out.println("4.Navigate back to main context\n");
			
			option = sc.nextInt();
			switch(option) {
			case 1:
				AddFile();  //method to add file 
				break;
			case 2:
				DeleteFile();  //method to delete file
				break;
			case 3:
				SearchFile();  //method to search file
				break;
			case 4:
				break;		
			}			
		}while(option!=4);
			break;
			
		case 3:
			System.exit(0);
		}
		}while(op!=3);
		
		
	}
	
	public static void ReturnCurrentFileName() {
		File dir = new File("D:\\SampleFolder\\");  //change the directory name as per your convenience while running the application
		if(dir.isDirectory())
	    {
	      
	      File[] files = dir.listFiles();
	
	      FileFilter fileFilter = new FileFilter()
	      {
	        @Override
	        public boolean accept(File file) {
	          return !file.isDirectory();
	        }
	      };
	   
	   files = dir.listFiles(fileFilter);
	     
	      Arrays.sort(files, new Comparator()
	      {
	        @Override
	        public int compare(Object f1, Object f2) {
	          return ((File) f1).getName().compareTo(((File) f2).getName());
	        }
	      });
	      try {
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }

}
}
	public static void AddFile(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of your file with proper extension");
        String fileName = input.nextLine();
        String path = "D:\\SampleFolder\\";  ////change the directory name as per your convenience while running the application
        path = path + fileName;
        File file = new File(path);
        boolean result;  
        try   
        {  
        result = file.createNewFile();  
        if(result)       
        {  
        System.out.println("file added");
        }  
        else  
        {  
        System.out.println("File already exist at location");  
        }  
        }   
        catch (IOException e)   
        {  
        e.printStackTrace();
        }  
        
        
	}
	
	public static void DeleteFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the file to delete with proper extension");
        String fileName = input.nextLine();
        String path = "D:\\SampleFolder\\"; ////change the directory name as per your convenience while running the application
        path = path + fileName;
        try  
        {         
        File f= new File(path);           
        if(f.delete())                        
        {  
        System.out.println("File deleted");  
        }  
        else  
        {  
        System.out.println("File not found");  
        }  
        }  
        catch(Exception e)  
        {  
        e.printStackTrace();  
        }  
        
	}
	
	public static void SearchFile() {
		File directory = new File("D:\\SampleFolder\\");  ////change the directory name as per your convenience while running the application
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the file to be searched with proper extension");
        String fileName = input.nextLine();
        String[] filelist = directory.list();
        int flag = 0;
        if (filelist == null) {
            System.out.println("Empty directory");
        }
        else {
            for (int i = 0; i < filelist.length; i++) {
                String filename = filelist[i];
                if (filename.equals(fileName)) {
                    System.out.println(filename + " is found");
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("File not found");
        }
        
	}
}
