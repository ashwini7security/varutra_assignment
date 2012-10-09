/*Program: nslookup is a Unix utility that converts hostnames to IP addresses and IP addresses to hostnames. It has two modes: interactive and command line. If you enter a hostname on the command line, nslookup prints the IP address of that host. If you enter an IP address on the command line, nslookup prints the hostname. If no hostname or IP address is entered on the command line, nslookup enters interactive mode, in which it reads hostnames and IP addresses from standard input and echoes back the corresponding IP addresses and hostnames until you type "exit"

Author : Ashwini Kumar
Date: 7th september 2012
*/
// Using InetAddress library
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StupidLookup {

  public static void main(String args[]) {

    if (args.length > 0) 
{ // use command line
      for (int i = 0; i < args.length; i++) 
 {
        lookup(args[i]);
 }
}
    else 
{
      DataInputStream myInputStream = new DataInputStream(System.in);
      System.out.println("Enter names and IP addresses. Enter \"exit\" to quit.");
      while (true) 
{
        String s;
        try {
          s = myInputStream.readLine();
        } catch (IOException e) {
          break;
        }
        if (s.equals("exit"))
          break;
        if (s.equals("quit"))
          break;
        if (s.charAt(0) == '\004')
          break; 
        lookup(s);
      }

    }

  } /* end main */

  private static void lookup(String s) {

    InetAddress myComputer;
    byte[] address;

    // get the bytes of the IP address
    try {
      myComputer = InetAddress.getByName(s);
      address = myComputer.getAddress();
    } catch (UnknownHostException ue) {
      System.out.println("Cannot find host " + s);
      return;
    }

    if (isHostname(s)) {
      // Print the IP address
      for (int i = 0; i < address.length; i++) {
        int unsignedByte = address[i] < 0 ? address[i] + 256
            : address[i];
        System.out.print(unsignedByte + ".");
      }
      System.out.println();
    } else { // this is an IP address
      try {
        System.out.println(InetAddress.getByName(s));
      } catch (UnknownHostException e) {
        System.out.println("Could not lookup the address " + s);
      }
    }

  } // end lookup

  private static boolean isHostname(String s) {

    char[] ca = s.toCharArray();
    // if we see a character that is neither a digit nor a period
    // then s is probably a hostname
    for (int i = 0; i < ca.length; i++) {
      if (!Character.isDigit(ca[i])) {
        if (ca[i] != '.') {
          return true;
        }
      }
    }

    // Everything was either a digit or a period
    // so s looks like an IP address in dotted quad format
    return false;

  } // end isHostName

} // end AshwiniStupidLookup



           
         
    
    
    
    
    
    
  
	

