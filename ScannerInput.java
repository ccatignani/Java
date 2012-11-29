package scannerinput;
// Chris Catignani Demo
import java.util.Scanner;
public class ScannerInput {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter First Name:");
      String sFirstName = sc.next();

      System.out.print("Enter Last Name:");
      String sLastName = sc.next();
      String sRestOfLastName = sc.nextLine(); // returns any remaing input on the curent line as string
      
      System.out.print("Enter Address:");
      int iAddressNo = sc.nextInt();
      String sRestOfAddress = sc.nextLine(); // returns any remaing input on the curent line as string
            
      System.out.print("Enter Total:");
      double dTotal = sc.nextDouble();
      
      System.out.print("\n");
      System.out.print("Name:" + sFirstName + " " + sLastName + sRestOfLastName + "\n");
      System.out.print("Address:" + iAddressNo + sRestOfAddress + "\n");
      System.out.print("Total:" + dTotal + "\n");
   }
}
