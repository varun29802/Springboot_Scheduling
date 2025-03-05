package com.project.scheduling.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Scheduler {

    // This method is scheduled to run based on a Cron expression.
    // It will run every 20 seconds as per the cron expression: "*/20 * * * * *"
    // Cron expression explanation:
    // <seconds> <minutes> <hours> <day-of-month> <month> <day-of-week> <year>
    // Benefit: Precise scheduling of tasks at specific times.
    // Drawback: It doesn't take into account how long the task takes to execute.
    // If the task takes longer than 20 seconds, it will not wait for completion.
    @Scheduled(cron = "*/20 * * * * *")
    public void scheduleTask(){
        // Format current date and time with milliseconds
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        // Get the formatted date and time
        String strDate = simpleDateFormat.format(new Date());

        // Print the date and time when the job is running
        System.out.println("Cron job Scheduler From scheduleTask: Job running at - "+ strDate);
    }

    // This method is scheduled to run every 2 seconds using fixedRate.
    // fixedRate runs the task at fixed intervals, regardless of how long the previous task took.
    // Benefit: Ensures regular execution at fixed intervals (every 2 seconds in this case).
    // Drawback: If the task takes longer than the interval (2 seconds), overlapping executions may occur, leading to resource contention.
    @Scheduled(fixedRate = 2000)
    public void scheduleTask2(){
        // Format current date and time with milliseconds
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        // Get the formatted date and time
        String strDate = simpleDateFormat.format(new Date());

        // Print the date and time when the job is running
        System.out.println("Cron job Scheduler scheduleTask2 Using FixedRate: Job running at - "+ strDate);
    }

    // This method is scheduled to run with a fixed delay of 5000 milliseconds (5 seconds),
    // and it will wait for 5 seconds before the first execution (initialDelay = 5000).
    // Benefit: Prevents overlapping executions. The next execution will start only after the previous task finishes.
    // Drawback: The interval between task executions is not fixed, as it depends on how long the task takes.
    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void scheduleTask3(){
        // Format current date and time with milliseconds
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        // Get the formatted date and time
        String strDate = simpleDateFormat.format(new Date());

        // Print the date and time when the job is running
        System.out.println("Cron job Scheduler scheduleTask3 Using FixedDelay and InitialDelay: Job running at - "+ strDate);
    }
}
