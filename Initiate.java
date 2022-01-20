import java.util.Random;

public class Initiate {
    

    public static int cpuChoice() {

        int[] arr = {1, 2, 3};
        return getRandom(arr);
    }

    private static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static int decision(int cpu, int player) {

        int result = 0; //0 is the initiation value, 1 = win, 2 = loss, 3 = tie
        if (cpu == 1 && player == 1) {
            result = 3;
        }
        else if (cpu == 2 && player == 1) {
            result = 2;
        }
        else if (cpu == 3 && player == 1) {
            result = 1;
        }
        else if (cpu == 1 && player == 2) {
            result = 1;
        }
        else if (cpu == 2 && player == 2) {
            result = 3;
        }
        else if (cpu == 3 && player == 2) {
            result = 2;
        }
        else if (cpu == 1 && player == 3) {
            result = 2;
        }
        else if (cpu == 2 && player == 3) {
            result = 1;
        }
        else if (cpu == 3 && player == 3) {
            result = 3;
        }
        return result;
    } 
}
