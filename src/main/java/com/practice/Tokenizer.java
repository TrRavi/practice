package com.practice;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class is thread safe.
 */
public class Tokenizer {

    //we can use ReadWriteLock it will allow only single thread to write and multiple thread(concurrent) to read.
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    private File file;
    public synchronized void setFile(File f) throws IOException {
        //while setting file need to check 'if the file denoted by this abstract pathname exists and is a normal file'
        if(f.isFile()){
            file = f;
        }else{
            throw new IOException("In-valid File");
        }

    }
    public synchronized File getFile() {
        return file;
    }

    public String getContent() throws IOException {
        readWriteLock.readLock().lock();
        try {
            FileInputStream i = new FileInputStream(file);
            StringBuilder output = new StringBuilder();
            int data;
            while ((data = i.read()) > 0) {
                output.append((char) data);
            }
            return output.toString();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }


    public String getContentWithoutUnicode() throws IOException {
        readWriteLock.readLock().lock();
        try {
            FileInputStream i = new FileInputStream(file);
            StringBuilder output = new StringBuilder();
            int data;
            while ((data = i.read()) > 0) {
                if (data < 0x80) {
                    output.append((char) data);
                }
            }
            return output.toString();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
    public void saveContent(String content) throws IOException {
        readWriteLock.writeLock().lock();
        try{
            FileOutputStream o = new FileOutputStream(file);
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }


}

