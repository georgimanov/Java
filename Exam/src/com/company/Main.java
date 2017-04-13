package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Future<Institution>> futureInstitutionsList = new ArrayList<>();

        // Setup
        DataManager dataManager = new DataManager();
        LearningSystem learningSystem = new LearningSystem();

        long start = System.currentTimeMillis();

        // Get data from files
        ArrayList<String> files = dataManager.getFilesInDirectory(Constants.BASE_DIR);
        ExecutorService executor = Executors.newFixedThreadPool(files.size());
        for (String filename: files) {
            String fileName = Constants.BASE_DIR + "/" + filename;

            //Create MyCallable instance
            Callable<Institution> callable = new MyFileReader(fileName);

            //submit Callable tasks to be executed by thread pool
            Future<Institution> future = executor.submit(callable);

            //add Future to the list, we can get return value using Future
            futureInstitutionsList.add(future);
        }

        for(Future<Institution> futureInstitution : futureInstitutionsList){
            try {
                // Future.get() waits for task to get completed
                learningSystem.addInstitution(futureInstitution.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        //while(!executor.isTerminated());

        System.out.println("Files read for :: "+(System.currentTimeMillis()-start) + " ms ");

        // Print sorted by criteria
        learningSystem.printSortedByCount();
        learningSystem.printSortedByDate();

        // Save collection to file
        try{
            dataManager.saveInstitutionsCollectionToFile("institutions.txt", learningSystem.getSortedByCount());
        } catch (FileNotFoundException ex){
            //...
        }
    }
}
