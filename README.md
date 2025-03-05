## Springboot_Scheduling 


# Simple Scheduling Service

This project demonstrates how to use Spring Boot’s `@Scheduled` annotation to schedule tasks in a Spring application. It includes examples of three different scheduling mechanisms:

1. **Cron Expression Scheduling**
2. **Fixed Rate Scheduling**
3. **Fixed Delay Scheduling**

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/varun29802/Springboot_Scheduling.git
cd https://github.com/varun29802/Springboot_Scheduling.git
```

### 2. Build the Project



If you are using Maven, build the project by running the following command:

```bash
mvn clean install
```

### 3. Run the Application

To run the Spring Boot application, use the following command:

```bash
mvn spring-boot:run
```

Alternatively, you can run the application directly from your IDE.

## Scheduling Methods

This project demonstrates three types of scheduling tasks:

### 1. **Cron Expression Scheduling (`@Scheduled(cron = "...")`)**

- This method allows you to run tasks at very specific times or intervals using cron expressions.
- Example: Every 20 seconds (as per the cron expression `*/20 * * * * *`).
- **Benefit**: Allows for precise scheduling of tasks.
- **Drawback**: Does not account for how long the task takes to execute. If the task takes longer than the time interval, the next execution could be skipped.

### 2. **Fixed Rate Scheduling (`@Scheduled(fixedRate = ...)`)**

- This method runs tasks at fixed intervals regardless of how long the previous task took to execute.
- Example: Runs every 2 seconds.
- **Benefit**: Executes tasks at regular intervals.
- **Drawback**: If the task takes longer to run than the specified rate, the next task will start before the previous one finishes, which could cause overlapping executions.

### 3. **Fixed Delay Scheduling (`@Scheduled(fixedDelay = ..., initialDelay = ...)`)**

- This method runs tasks after a fixed delay following the completion of the last execution.
- Example: Executes every 5 seconds, with an initial delay of 5 seconds before the first execution.
- **Benefit**: Prevents overlapping executions by ensuring a delay between the end of one execution and the start of the next.
- **Drawback**: The interval between executions is not fixed, as it depends on the duration of the previous task.

## Example Output

When running the application, you’ll see the following types of outputs in the console:

```
Cron job Scheduler From scheduleTask: Job running at - 05-03-2025 12:00:20.000
Cron job Scheduler scheduleTask2 Using FixedRate: Job running at - 05-03-2025 12:00:22.000
Cron job Scheduler scheduleTask3 Using FixedDelay and InitialDelay: Job running at - 05-03-2025 12:00:25.000
```
