/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.network.urls;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user5
 */
public class Downloader {
    private static int BUFFER_SIZE = 1024;
    public Downloader() {
    }
    
    public void download(String urlName, String downloadDirName) 
                         throws DownloadException, IOException{
        if (urlName == null || urlName.isEmpty())
            throw new DownloadException("Empty url");
        URL url = new URL(urlName);
        String fileName = url.getFile();
        if (fileName == null || fileName.isEmpty())
            throw new DownloadException("Invalid url-file-path for download");
        
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        if (fileName == null || fileName.isEmpty())
            throw new DownloadException("Invalid url-file for download");
        
        File downloadDir = new File(downloadDirName);
        if (!downloadDir.exists())
            downloadDir.mkdirs();
        String downloadFileName = downloadDirName + File.separator + fileName;
        try(InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(
                                   new FileOutputStream(downloadFileName, true))){
            long totalSize = url.openConnection().getContentLength();
            long downloaded = 0;
            File existFile = new File(downloadFileName);
            if (existFile.exists()){
                downloaded = existFile.length();
                if (downloaded == totalSize){
                    System.out.println("File " + fileName + " is dowloaded");
                    return;
                }
                System.out.println("Skipping downloaded file...");
                in.skip(downloaded);
            }
            byte[] buffer = new byte[BUFFER_SIZE];
            int cn = 0;
            System.out.println("Downloading file: " + fileName);
            while((cn = in.read(buffer)) > 0){
                out.write(buffer, 0, cn);
                downloaded += cn;
                double percent = (double)downloaded/totalSize;
                if (percent < 0.1)
                    System.out.print("\b\b");
                else
                    System.out.print("\b\b\b");
                System.out.print("" + (int)percent*100 + "%");
            }
            System.out.println("\nDownload completed");
        }
    }
    
    public static void main(String[] args) {
        String urlName = "http://math.hws.edu/eck/cs124/downloads/javanotes5-linked.pdf";
        String downloadDir = ".";
        Downloader downloader = new Downloader();
        try {
            downloader.download(urlName, downloadDir);
        } catch (DownloadException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
