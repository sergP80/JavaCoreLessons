/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.network.sockets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FileClient {
    private static String DEFAULT_HOST = "localhost";
    private static int DEFAULT_PORT = 54030;
    private ArrayList<File> fileList = new ArrayList<>();
    private String serverHost = "";
    private int serverPort = 0;
    
    private class FileListFilter implements FileFilter {

        private String dirName = ".";
        private String partOfFileName = "";

        public FileListFilter(String dirName) {
            if (dirName != null && !dirName.isEmpty()) {
                String[] dirNameParts = dirName.trim().split("[\\s]+");
                if (dirNameParts.length > 0 && dirNameParts[0] != null && !dirNameParts[0].isEmpty()) {
                    this.dirName = dirNameParts[0];
                }
                if (dirNameParts.length > 1 && dirNameParts[1] != null && !dirNameParts[1].isEmpty()) {
                    this.partOfFileName = dirNameParts[1];
                }
            }

        }

        public void performList() {
            File[] files = new File(this.dirName).listFiles(this);
            fileList.clear();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    fileList.add(file);
                }
            }
        }

        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory())
                return false;
            if (partOfFileName == null || partOfFileName.isEmpty()) {
                return true;
            }
            return pathname.getName().contains(partOfFileName);
        }
    }

    FileListFilter fileFilter;

    public FileClient(String serverHost, int serverPort, String dirName) {
        this.serverHost = serverHost != null && !serverHost.isEmpty() ? serverHost : DEFAULT_HOST;
        this.serverPort = serverPort > 0 ? serverPort : DEFAULT_PORT;
        fileFilter = new FileListFilter(dirName);
        fileFilter.performList();
    }

    int showMenu() {
        if (fileList == null || fileList.isEmpty()) {
            return -1;
        }
        try (Scanner scan = new Scanner(System.in)) {
            int i = 0;
            for (File file : fileList) {
                try {
                    System.out.println("\t[" + ++i + "]: " + file.getCanonicalPath());
                } catch (IOException ex) {
                    Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print("Select a file: ");
            int index = scan.nextInt();
            return index;
        }
    }
    
    void sendFileToServer(File file){
        if (file == null || !file.exists())
            return;
        
        try(Socket socket = new Socket(this.serverHost, this.serverPort);
            InputStream in = new BufferedInputStream( new FileInputStream(file));
            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
            OutputStream out = new BufferedOutputStream(socket.getOutputStream())){
            //send file name
            objOut.writeObject(file.getName());
            
            byte[] buffer = new byte[1024 * 2];
            long totalSize = file.length();
            long transfered = 0;
            int cn = 0;
            while ((cn = in.read(buffer)) > 0){
                out.write(buffer, 0, cn);
                transfered += cn;
                double percent = (double)transfered/(double)totalSize *100;
                System.out.print("\b\b\b" + (int)percent + "%");
            }
            System.out.println("\nTransfer finished");
        } catch (IOException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public File getFile(int index){
        if (fileList == null || fileList.isEmpty())
            return null;
        if (index >= 0 && index < fileList.size())
            return fileList.get(index);
        else
            return null;
    }
    
    public static void main(String[] args) {
        System.out.print("Enter directory [part of file]: ");
        try (Scanner scan = new Scanner(System.in)) {
            String directoryName = scan.nextLine();
            FileClient client = new FileClient("", -1, directoryName);
            int n = client.showMenu();
            client.sendFileToServer(client.getFile(n - 1));
        }
    }

}
