package socketProgram;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	
	private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String args[]) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        System.out.println("Client Connected to Server.");
        Boolean exit = false;
        String message = "";
        String response = "";
        while(exit == false){
            
            message = scanner.nextLine();
            
            if(message.equals("/end")){
                response = client.sendMessage("/end");
                exit = true;
                break;
                
            }else{
                response = client.sendMessage(message);
            }

               
        }
     
       scanner.close();
        
       // String response = client.sendMessage("hello from client 1");
        
        System.out.println(response);
	}
}
