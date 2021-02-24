package eci.arsw.covidanalyzer;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CovidAnalyzerThread extends Thread{
    private int limInf;
    private int limSup;
    private AtomicInteger amountOfFilesProcessed;
    private  TestReader testReader;
    private ResultAnalyzer resultAnalyzer;
    private List<File>resultFiles;
    private AtomicBoolean paused;

    public CovidAnalyzerThread(int limInf, int limSup, AtomicInteger amountOfFilesProcessed, TestReader testReader,ResultAnalyzer resultAnalyzer, List<File>resultFiles){
        this.limInf=limInf;
        this.limSup=limSup;
        this.amountOfFilesProcessed=amountOfFilesProcessed;
        this.testReader=testReader;
        this.resultAnalyzer=resultAnalyzer;
        this.resultFiles=resultFiles;
        this.paused=new AtomicBoolean(false);


    }
    @Override
    public void run(){
        for (File resultFile : resultFiles) {
            List<Result> results = testReader.readResultsFromFile(resultFile);
            for (Result result : results) {
                while(paused.get()){
                    synchronized (this){
                        try {

                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(result);
                resultAnalyzer.addResult(result);
            }
            amountOfFilesProcessed.incrementAndGet();
        }
    }

    public synchronized void wakeUpSleep() {
        if(paused.get()) {
            this.notify();
        }
        paused.getAndSet(!paused.get());


    }
}
