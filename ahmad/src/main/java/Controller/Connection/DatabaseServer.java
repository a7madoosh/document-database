package Controller.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseServer {

    private static ArrayList<ClientHandler>Students=new ArrayList<>();

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {


            ServerSocket serverSocket =new ServerSocket(8000);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("the connection is done");
                ClientHandler studentThread = new ClientHandler(socket);
                Students.add(studentThread);
                pool.execute(studentThread);
            }
    }

}
