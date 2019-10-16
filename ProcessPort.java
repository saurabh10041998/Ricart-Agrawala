

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
//import Process.getNumber;

/**
 *
 * @author efi
 */
public class ProcessPort implements Runnable{

    private final PrintWriter       out;
    private final Socket            clientSocket;
    
    public ProcessPort(Socket c) throws IOException
    {
        this.clientSocket = c;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }
    
    @Override
    public void run() {
        out.println(Process.getNumber());
        out.flush();
        out.close();
    }
    
}
