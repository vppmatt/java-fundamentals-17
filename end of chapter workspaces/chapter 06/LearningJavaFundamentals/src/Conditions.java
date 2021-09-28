public class Conditions {
    public static void main(String[] args) {

        int testScore = 100;

        if (testScore > 50) {
            System.out.println("well done - you passed");
        }
        else if (testScore == 50) {
            System.out.println("I'm not sure if you passed or not");
        }
        else {
            System.out.println("sorry - you failed");
        }

        switch (testScore) {
            case 0:
                System.out.println("Did you even take the test?");
                System.out.println("You scored zero");
                break;
            case 100:
                System.out.println("You got top marks!");
                break;
            default:
                System.out.println("You didn't do anything special");
                break;
        }

        testScore = 40;

        //if score > 50 and score is divisible by 10
        if (testScore > 50 && testScore % 10 == 0) {
            System.out.println("You passed with a score ending in a zero");
        }

    }
}
