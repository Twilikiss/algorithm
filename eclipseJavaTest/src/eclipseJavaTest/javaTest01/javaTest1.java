package eclipseJavaTest.javaTest01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.Test;

public class javaTest1 {
	
@Test
public void server(){
    ServerSocket serverSocket = null;
    Socket socket = null;
    InputStream in = null;
    FileOutputStream file = null;
    try {
        serverSocket = new ServerSocket(22233);
        socket = serverSocket.accept();
        in = socket.getInputStream();
        file = new FileOutputStream(new File("图片1.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1){
            file.write(buffer, 0, len);
        }
        
        System.out.println("传输成功！！");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (serverSocket != null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file != null){
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
}
