public class NameManager {

    private String myName = "Matt Greencroft";

    public String getFirstName() {
        String[] values = myName.split(" ");
        return values[0];
    }

    public String getSurname() {
        String[] values = myName.split(" ");
        doSomething();
        return values[values.length - 1];
    }

    public static void doSomething() {
        System.out.println("I'm doing something");
    }
}
