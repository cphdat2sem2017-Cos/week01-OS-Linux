package kasper.osterbye.picowebserver;

///A Simple Web Server (WebServer.java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PicoServer {

    /**
     WebServer constructor.
     */
    protected void start() {
        ServerSocket s;
        int port = 8009;
        System.out.println( "Webserver starting up on port: " + port );
        System.out.println( "(press ctrl-c to exit)" );
        try {
            s = new ServerSocket( port );
        } catch ( IOException e ) {
            System.out.println( "Error: " + e );
            return;
        }

        System.out.println( "Waiting for connection" );
        while ( 2 + 2 == 4 ) {
            try {
                // remote is now the connected socket
                try ( // wait for a connection
                        Socket remote = s.accept() ) {
                    // remote is now the connected socket
                    System.out.println( "Browser sendeing request:" );
                    BufferedReader in = new BufferedReader( new InputStreamReader(
                            remote.getInputStream() ) );
                    PrintWriter out = new PrintWriter( remote.getOutputStream() );

                    String str = ".";
                    while ( !str.equals( "" ) ) {
                        str = in.readLine();
                        System.out.println( "read: " + str );
                    }
                    System.out.println( "**** End of request ****" );

                    out.println( "HTTP/1.0 200 OK" );
                    out.println( "Content-Type: text/html" );
                    out.println( "Server: PicoServer" );

                    out.println( "" );
                    out.println( "<H1>Welcome to the COS Pico-WebServer</H2>" );
                    out.flush();
                }
            } catch ( IOException e ) {
                System.out.println( "Error: " + e );
            }
        }
    }

    /**
     Start the application.

     @param args
     Command line parameters are not used.
     */
    public static void main( String args[] ) {
        PicoServer ws = new PicoServer();
        ws.start();
    }
}
