package ie.atu.lambda;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        //MathOperation addition = new Addition();
        MathOperation addition = (a,b) -> a + b;
        //StringOperation toUpper= new ToUpperCase();
        StringOperation toUpper = (test) -> test.toUpperCase();

        System.out.println("Addition: " + addition.operate(6,7));
        System.out.println("30 seconds into imposter: "+ toUpper.apply("oscar's dead"));


        /*Runnable task = new Runnable() {
            public void run() {
                System.out.println("Thread is running");
            }
        };
        
        Thread thread = new Thread(task);
        thread.start();*/

        Runnable task = () -> System.out.println("Thread is running");
        
        Thread thread = new Thread(task);
        thread.start();

        Runnable greeting = () -> System.out.println("Hello");
        
        Thread greet = new Thread(greeting);
        greet.start();

        Calculator square = (int x) -> x * x;
        
        int result = square.calculate(4);
        System.out.println("Square of 4 is: " + result);

        Function<String, String> trim = s -> s.trim();
        Function<String, String> replaceSpaces = s -> s.replace(" ", "-");
        Function<String, String> toLowerCase = s -> s.toLowerCase();

        // Combine the lambdas
        Function<String, String> combinedOperation = trim.andThen(replaceSpaces).andThen(toLowerCase);

        // Test the combined operation
        String resultb = combinedOperation.apply("   Hello World From Lambda   ");
        System.out.println("Result: " + resultb);
    }

}
