public class ExecutionTimeCalculator {
    public static void measureExecutionTime(Runnable method) {
        long startTime = System.currentTimeMillis();
        method.run();
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
