package org.telran.prof.com.homework28.tripsOther;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class Logger implements Runnable {

    private File file;
    private String path;
    private BufferedWriter bufferedWriter;


    private InformationBox informationBox;

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setInformationBox(InformationBox informationBox) {
        this.informationBox = informationBox;
    }

    public Logger(String path) throws IOException {
        this.path = path;
        bufferedWriter = new BufferedWriter(new FileWriter(path));
    }

    @Override
    public void run() {
        file = new File(path);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.currentThread().sleep(2000);
                while (!informationBox.getBufferedQueue().isEmpty()) {
                    try {
                        bufferedWriter.write(informationBox.getBufferedQueue().poll());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (InterruptedException e) {
                if (!informationBox.getBufferedQueue().isEmpty()) {
                    try {
                        bufferedWriter.write(informationBox.getBufferedQueue().poll());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("The thread is interrupted");
                break;
            }
        }
        if (Thread.currentThread().isInterrupted()) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
