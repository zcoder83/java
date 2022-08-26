package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ChatGateway implements ChatConstants {

    private PrintWriter outputToServer;
    private BufferedReader inputFromServer;
    private TextArea textArea;

    // Establish the connection to the server.
    public ChatGateway(TextArea textArea) {
    	this.textArea = textArea;
    	try {
    		Socket socket = new Socket("localhost", 8000);
    		
    		outputToServer = new PrintWriter(socket.getOutputStream());
    		inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	} catch (IOException ex) {
    		Platform.runLater( ()-> textArea.appendText("Exceptionin gateway constructor: " + ex.toString() + "\n"));
    	}
    }

    // Start the chat by sending in the user's handle.
    public synchronized void sendHandle(String handle) {
    	outputToServer.println(SEND_HANDLE);
    	outputToServer.println(handle);
    	outputToServer.flush();
    }

    // Send a new comment to the server.
    public synchronized void sendComment(String comment) {
    	outputToServer.println(SEND_COMMENT);
    	outputToServer.println(comment);
    	outputToServer.flush();
    }

    // Ask the server to send us a count of how many comments are
    // currently in the transcript.
    public synchronized int getCommentCount() {
    	outputToServer.println(GET_COMMENT_COUNT);
    	outputToServer.flush();
    	int count = 0;
    	try {
    		count = Integer.parseInt(inputFromServer.readLine());
    		
    	} catch(IOException ex) {
    		Platform.runLater( ()-> textArea.appendText("Error in getCommentCount: " + ex.toString() + "\n"));
    	}
    	return count;
    }

    // Fetch comment n of the transcript from the server.
    public synchronized String getComment(int n) {
    	outputToServer.println(GET_COMMENT);
    	outputToServer.println(n);
    	outputToServer.flush();
    	String comment = "";
    	try {
    		comment = inputFromServer.readLine();
    	} catch(IOException ex) {
    		Platform.runLater( ()-> textArea.appendText("Error in getComment: " + ex.toString() + "\n"));
    	}
    	return comment;
    }
}








