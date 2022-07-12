package socketProgram;

import java.io.IOException;

public class SocketMain {
	
	
	

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(6666);
		
	}
}
