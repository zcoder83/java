package server;

import static application.ChatConstants.GET_COMMENT;
import static application.ChatConstants.GET_COMMENT_COUNT;
import static application.ChatConstants.SEND_COMMENT;
import static application.ChatConstants.SEND_HANDLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class PrimaryController implements Initializable {
	
	
	
	@FXML
	private TextArea textArea;
	
	private int clientNo = 0;
	private Transcript transcript;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		transcript = new Transcript();
//		Thread thread = new Thread();
//		thread.start();
		Thread thread = new Thread( ()-> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				while (true) {
					
					Socket socket = serverSocket.accept(); 
					clientNo++;
					Platform.runLater(()->textArea.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n"));
					
					new Thread(new HandleAClient(socket, transcript, textArea)).start();
				}
			} catch(IOException ex) {
				System.err.println(ex);
			}
		});
		thread.start();
	}
}
class HandleAClient implements Runnable, ChatConstants {
    private Socket socket; // A connected socket
    private Transcript transcript; // Reference to shared transcript
    private TextArea textArea;
    private String handle;

    public HandleAClient(Socket socket,Transcript transcript,TextArea textArea) {
      this.socket = socket;
      this.transcript = transcript;
      this.textArea = textArea;
    }

    public void run() {
      try {
        // Create reading and writing streams
        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputToClient = new PrintWriter(socket.getOutputStream());

        // Continuously serve the client
        while (true) {
          // Receive request code from the client
          int request = Integer.parseInt(inputFromClient.readLine());
          // Process request
          switch(request) {
              case SEND_HANDLE: {
                  handle = inputFromClient.readLine();
                  break;
              }
              case SEND_COMMENT: {
                  String comment = inputFromClient.readLine();
                  transcript.addComment(handle + "> " + comment);
                  break;
              }
              case GET_COMMENT_COUNT: {
                  outputToClient.println(transcript.getSize());
                  outputToClient.flush();
                  break;
              }
              case GET_COMMENT: {
                  int n = Integer.parseInt(inputFromClient.readLine());
                  outputToClient.println(transcript.getComment(n));
                  outputToClient.flush();
              }
          }
        }
        
      }
      catch(IOException ex) {
          Platform.runLater(()->textArea.appendText("Exception in client thread: "+ex.toString()+"\n"));
      }
    }
    
  }