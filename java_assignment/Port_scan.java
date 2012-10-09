       

import java.net.*;
import java.io.*;


public class Port_scan {

  public static void main(String[] args) {
    
    Socket theSocket;
    String host = "localhost";

    if (args.length > 0) {
      host = args[0];
    }
    for (int i = 0; i < 100; i++) {
      try {
        System.out.println("Looking for "+ i);
        theSocket = new Socket(host, i);
        System.out.println("There is a server on port " + i + " of " + host);
      }
      catch (UnknownHostException e) {
        System.err.println(e);
        break;
      }
      catch (IOException e) {
        System.out.println(" must not be a server on this port");
      }
    }
  }
}
