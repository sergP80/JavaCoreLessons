/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.network.sockets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FileServer implements Runnable {

    String downloadDir = "." + File.separator + "download";
    private int port = 54030;
    private ServerSocket socket;

    public FileServer(int port, String downloadDir) {
        this.port = port > 0 ? port : 54030;
        try {
            socket = new ServerSocket(this.port);
            new Thread(this).start();
            if (downloadDir != null && !downloadDir.isEmpty()) {
                this.downloadDir = downloadDir;
            }
            checkDownloadDir();
        } catch (IOException ex) {
            Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void checkDownloadDir() {
        File dir = new File(this.downloadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    @Override
    public void run() {
        Socket clientSocket = null;
        while (!socket.isClosed()) {
            try {
                clientSocket = socket.accept();
                new Thread(new ClientSession(clientSocket)).start();
            } catch (IOException ex) {
                Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class ClientSession implements Runnable {

        private Socket sock;

        public ClientSession(Socket sock) {
            this.sock = sock;
        }

        @Override
        synchronized public void run() {
            try (ObjectInputStream oin = new ObjectInputStream(sock.getInputStream());
                    InputStream in = new BufferedInputStream(sock.getInputStream());) {
                //get file name
                String fileName = (String) oin.readObject();
                checkDownloadDir();
                System.out.println("Start receiving file: " + fileName);
                try (OutputStream out = new BufferedOutputStream(new FileOutputStream(downloadDir + File.separator + fileName))) {
                    byte[] buffer = new byte[1024 * 2];
                    int cn = 0;
                    while ((cn = in.read(buffer)) > 0) {
                        out.write(buffer, 0, cn);
                    }
                }
                System.out.println("Finish receiving file: " + fileName);
            } catch (IOException ex) {
                Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        FileServer fileServer = new FileServer(-1, "");
        System.out.println("Server is started");
    }
}
