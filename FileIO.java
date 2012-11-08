// ======== start ==========================   
package fileio;
import java.io.*;
import java.util.Date;
import javax.swing.JOptionPane;
// @author Chris Catignani
 
public class FileIO 
{

// ========================================   
   public static void main(String[] args) 
   {
      //creat a dir if it does not exist
      String sDirName = "H:/java/test/";
      String sLogFile = sDirName + "FileIOLog.txt";      
      Log(sLogFile,"Application start");
      
      File flDir = new File(sDirName);
      if (!flDir.exists())
      {
         flDir.mkdirs();
         sop("Dir created:" + sDirName);
      }
      else
      {
         sop("Dir exists:" + sDirName);
         DirInfo(flDir);
      }
      
      //create a file if it does not exist
      String sFileName = "test.txt";
      File flTest1 = new File(sDirName + sFileName);
      if (!flTest1.exists())
      {  
         try
         {  
            flTest1.createNewFile();
            sop("File created:" + sFileName);
         }
         catch(Exception e)
         {  
            Exit(e.getMessage());
         }
      }
      else
      {
          sop("File exists:" + sFileName);
          FileInfo(flTest1);
      }
      
      // creat a file and write data to it
      File flTest2 = new File (sDirName+"test2.txt");
      try
      {
         PrintWriter pwOut;
         pwOut = new PrintWriter(
                 new BufferedWriter(
                 new FileWriter(flTest2))); 
         pwOut.println("The brown fox jumped over the lazy dog.");
         pwOut.println("The dog looked up and rolled over.");
         pwOut.println("The cat ran into the house and sat on the couch.");
         pwOut.close();
      }
      catch (Exception e)
      {
         Exit(e.getMessage());
      }
 
      
      // Read some data from a file.
      try
      {
         BufferedReader brIn;
         brIn = new BufferedReader(
                new FileReader(flTest2));
         String sLine = brIn.readLine();
         sop("Read from File:" + sLine );
         brIn.close();
      }
      catch (Exception e)
      {
         Exit(e.getMessage());
      }
      
      sop("*****************ReadFile example start test1");
      ReadFile(flTest1);
      sop("*****************ReadFile example start test2");      
      ReadFile(flTest2);
      sop("*****************ReadFile example end");
      
      Log(sLogFile,"Application End");
      LogDump(sLogFile);
   }  // end Main
   
// ========================================
   public static void ReadFile(File flIn)

   {
      BufferedReader brIn = null;
      try
      {
         if (flIn.exists())
         {
            brIn = new BufferedReader(new FileReader(flIn));
            String sLine = brIn.readLine();
            while(sLine !=null)
            {
               sop(sLine);
               sLine = brIn.readLine();
            }
            brIn.close();
         }
         else
         {
            sop("File not found.");
         }
      }
      catch (IOException e)
      {
         Exit(e.getMessage());
      }
      finally
      {
         close(brIn);
      }
   }
// ========================================
   public static void close(Closeable brStream)
   {
      try
      {
         if (brStream !=null) //prevent nul pointer exception
         {
            brStream.close();
         }
      }
      catch (IOException e)
      {
         sop("unable to close stream:" + e.getMessage());
      }
   }

// ========================================   
   public static void FileInfo(File flFile)
   {
      sop("-------------------------------");
      sop("File Name: "+ flFile.getName());
      sop("Absolute Path: "+flFile.getAbsolutePath());
      sop("Is Writable: "+flFile.canWrite());
      sop("Last Modified: "+flFile.lastModified());
      sop("Length: "+flFile.length());
   }

// ========================================   
   public static void DirInfo(File flDir)
   {
      if (flDir.exists() && flDir.isDirectory())
      {
         sop("-------------------------------");
         sop("Dir:"+flDir.getAbsolutePath());
         sop("File List:");
         for (String sFileName : flDir.list())
         {
            sop("     "+sFileName);
         }
      }
   }
   
// ========================================   
   public static void sop(String sMsg)
   {
      System.out.println(sMsg);
   }
   
// ========================================   
   public static void Exit(String sMsg)
   {
      JOptionPane.showMessageDialog(null,sMsg,"Error",JOptionPane.ERROR_MESSAGE);
      System.exit(0);
   }

   // ========================================   
   public static void Log(String sFileName,String sMsg)
   {
     File flLog = new File (sFileName);
      try
      {
         Date dToday = new Date();
         PrintWriter pwOut;
         pwOut = new PrintWriter(
                 new BufferedWriter(
                 new FileWriter(flLog,true))); 
         pwOut.println( dToday +  ":" +sMsg);
         pwOut.close();
      }
      catch (Exception e)
      {
         Exit(e.getMessage());
      }
   }

// ========================================
   public static void LogDump(String sFileName)

   {
      Log(sFileName,"Log Dump");
      File flIn = new File (sFileName);
      BufferedReader brIn = null;
      try
      {
         if (flIn.exists())
         {
            brIn = new BufferedReader(new FileReader(flIn));
            String sLine = brIn.readLine();
            while(sLine !=null)
            {
               sop(sLine);
               sLine = brIn.readLine();
            }
            brIn.close();
         }
         else
         {
            sop("File not found.");
         }
      }
      catch (IOException e)
      {
         Exit(e.getMessage());
      }
      finally
      {
         close(brIn);
      }
   }

   
} // ========  end class FileIO  ==========================