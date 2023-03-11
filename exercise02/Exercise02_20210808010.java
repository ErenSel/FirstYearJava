import java.util.Arrays;

public class Exercise02_20210808010 {

    /*
     * Change the X's in the both file name and class' name to your own
     * student number and submit your file to the assignment given through
     * Teams.
     * 
     * if you do NOT submit your assignment in time, you will recieve 0
     * if your file has compile time errors, and do not compile you will recieve 10
     * if your file does compile but a runtime error occurs, you will recieve 20
     * You MUST NOT change the method headers and comply with their return types
     * 
     * Main method is just there for you to test your program, you will not be evaluated by your main method
     * You can write any method you like, and use them in suitable places but you will only be graded
     * for your work for the questions
     */
    public static void main(String[] args) {
        // Question 1

        int[] students = new int[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = random(0, 100);
        }

        System.out.println("Scores of students:");
        display(students);

        char[] grades = grade(students);

        System.out.println("Grades of students are:");
        display(grades);


        // Question 2

        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random(0, 10);
        }
        display(numbers);
        System.out.println("Average of numbers is: " + average(numbers));

        double[] doubleNumbers = new double[8];
        for (int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = random(-0.5, 0.5);
        }
        display(doubleNumbers);
        System.out.println("Average of numbers is: " + average(doubleNumbers));


        // Question 3

        int[] numbers1 = new int[10];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = random(0, 10, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers are: ");
        display(numbers1);


        // Question 4

        int[] numbers2 = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = random(0, 10, 0, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers with duplicate values are: ");
        display(numbers2);
        int[] nonDuplicateNumbers = eliminateDuplicates(numbers2);
        
        System.out.println("Non duplicate numbers");
        display(nonDuplicateNumbers);


        // Question 5

        int[] numbers3 = new int[10];
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = i;
        }
        System.out.println("is array in sorted order: " + isSorted(numbers3));
        display(numbers3);

        shuffle(numbers3);

        System.out.println("is array in sorted order: " + isSorted(numbers3));
        display(numbers3);


        // Question 6


        int n = 100;
        boolean[] lockers = new boolean[n];
        int[] openLockers = lockers(lockers);

        System.out.println("Open lockers are:");
        display(openLockers);

        System.out.println("for n == 100, open locker amount should be 10: open locker amount: " + openLockers.length);

        n = 1000;
        lockers = new boolean[n];
        openLockers = lockers(lockers);

        System.out.println("for n == 1000, open locker amount should be 31, open locker amount: " + openLockers.length);

    }

    // Question 1: Assign grades
    public static char[] grade(int[] students) {
        /*
         * Write a method that gets student scores and finds the best score
         * then, assigns grades based on the following scheme:
         *      grade is A if score is >= best - 10;
         *      grade is B if score is >= best - 20;
         *      grade is C if score is >= best - 30;
         *      grade is D if score is >= best - 40;
         *      grade is F otherwise
         * 
         * Args: students int[]: array of scores
         * Returns: char[]: array of grades
         */

        // Your code goes here...
        char[] grade = new char[students.length];
        int best = getMax(students);
        for(int i = 0; i <students.length;i++){
            if(students[i] >= (best) -10){
                grade[i] = 'A';
            }
            else if (students[i] >= (best) -20){
                grade[i] = 'B';
            }
            else if(students[i] >= (best) -30){
                grade[i] = 'C';
            }
            else if(students[i] >= (best) - 40){
                grade[i] = 'D';
            }
            else{
                grade[i] = 'F';
            }
        }


        return grade;
    }

    // finds the maximum value from the given array
    public static int getMax(int[] array) {
        /*
         * Helper method for finding the maximum value from an array
         *
         * Args: array int[]: array of integers
         * Returns: int: maximum value in the array
         */

        // Your code goes here...
        int max = array[0];
        for(int i = 1; i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    // Question 2: Average an array
    public static int average(int[] array) {
        /*
         * Write a method that returns the average of an array
         *
         * Args: array int[]: array to average
         * Returns: int: average of the array
         */

        // Your code goes here...
        int average = 0;
        for(int i: array)
            average += i;
        return (average / array.length);
    }


    // Overload the above method for double data type
    public static double average(double[] array) {
        /*
         * Write a method that returns the average of an array
         *
         * Args: array double[]: array to average
         * Returns: double: average of the array
         */

        // Your code goes here...
        double average = 0;
        for(double i: array)
            average += i;
        return (average / array.length);
    }

    // Question 3: Random number chooser
    public static int random(int start, int end, int... exclude) {
        /*
         * Write a method that returns a random number between start and end,
         * excluding the numbers passed in the argument exlude. if a number generated
         * is one of the excluded numbers, then generate another number.
         *
         * Args:
         *      start int: the start of the number to generate
         *      end int: the end of the number to generate
         *      exclude int[optional]: the numbers to exclude
         *
         * Returns: int: the number generated that is not one of the exluded numbers
         */

         // Your code goes here...
        int num = random(start, end);
        int i = 0;
        while (true){
            for(i = 0;i <exclude.length;i++){
                if(num == exclude[i]){
                    num= random(start, end);
                    i = 0;
                    break;
                }
            }
            if(i== exclude.length){
                return num;
            }
        }

    }



    // Question 4: Eliminate duplicates
    public static int[] eliminateDuplicates(int[] array) {
        /*
         * Write a method that returns a new array by eliminating the duplicate
         * values in the array. Order of appearences for numbers must not change
         *
         * Args: array int[]: array containing duplicate elements
         * Returns: int[]: new array that does not contains duplicate elements, but
         * keeps the order of appearences of numbers.
         */

        // Your code goes here...
        int[] list2 = new int[array.length];
        int x = 0;

        for (int i = 0; i < array.length; i++) {

            boolean dup = false;

            for (int k = 0; k < array.length; k++) {
                if (list2[k] == array[i]) {
                    dup = true;
                }
            }
            if (!dup) {

                list2[x++] = array[i];
            }
        }

        int[] finishedArray = new int[x+1];
        for (int i = 0; i < x+1; i++) {
            finishedArray[i] = list2[i];
        }

        return finishedArray;


    }

    // Question 5: Sorted?
    public static boolean isSorted(int[] array) {
        /*
         * Write a method that returns true if the array is already sorted in increasing order,
         * false otherwise
         *
         * Args: array int[]: array of numbers
         * Returns: boolean
         */

        // Your code goes here...
        for(int i = 0; i < array.length -1;i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }


    // shuffle the array randomly
    public static void shuffle(int[] array) {
        /*
         * Write a method that shuffles the array randomly
         */

        // Your code goes here...
        for (int i = 0; i < array.length; i++) {
            int index = random(0, (array.length - 1));
            swap(array,i,index);
        }

    }

    // Question 6: Locker puzzle
    public static int[] lockers(boolean[] locker) {
        /*
         * A school has 100 lockers and 100 students. All lockers are closed on
         * the first day of school. As the students enter, the first student, denoted as
         * S1, opens every locker. Then the second student, S2, begins with the second
         * locker, denoted L2, and closes every other locker (every second locker). Student S3 begins with the
         * third locker, L3, and changes every third locker (closes it if it was open,
         * and opens it if it was closed). Student S4 begins with L4 and changes every fourth
         * locker. S5 starts with L5 and changes every fifth locker, and so on, until student S100 changes L100
         *
         * After all the students have passed through the building and changed the lockers, which lockers are open?
         * find the indicies of lockers that are open and return them as counting numbers(this means index 0 should be 1,
         * so add +1 to each index value you are storing in returned array)
         *
         * Args: array boolean[]: boolean array thata represents the lockers, true means open locker, false means closed locker
         * Returns: int[]: array of open locker indicies as counting numbers
         */

        // Your code goes here...

        int openLockerIndex = 0;
        for (int i = 0; i < locker.length; i++) {
            for (int j = i; j < locker.length; j+= i+1) {
                locker[j] = !locker[j];
            }
        }
        for (int i = 0; i < locker.length; i++) {
            if (locker[i]) {

                openLockerIndex++;
            }
        }
        int[] openLockers = new int[openLockerIndex];
        for(int i = 0, j= 0; i < locker.length;i++){
            if(locker[i]){
                openLockers[j++] = i+1;
            }
        }
        return openLockers;
    }



















    ////////////////////// HELPER FUNCTIONS //////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%.1f\t", i);
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double random(double start, double end) {
        return start + Math.random() * (end - start);
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
