public class Strings {

    public static void main(String[] args) {
        String myName = "Matt";
        int length = myName.length();
        System.out.println("My name is " + myName);
        System.out.println("This has " + length + " characters");
        String myNameUpper = myName.toUpperCase();
        System.out.println("My name is " + myNameUpper);

        String phrase = "Many hands make light work.";
        System.out.println(phrase.startsWith("Many"));
        System.out.println(phrase.startsWith("many"));
        System.out.println(phrase.indexOf("light"));
        System.out.println(phrase.indexOf("Light"));
        System.out.println(phrase.indexOf("hello"));
        System.out.println(phrase.substring(16));
        System.out.println(phrase.substring(16, 21));
        System.out.println(phrase.replace("light", "heavy"));

        myName = "Dale McGovern";
        String yourName = "Dale Smethurst";

        String myFirstName = myName.substring(0,4);
        String yourFirstName = yourName.substring(0,4);

        System.out.println(myFirstName);
        System.out.println(yourFirstName);

        //boolean weHaveTheSameFirstName = myFirstName == yourFirstName;
        boolean weHaveTheSameFirstName = myFirstName.equals(yourFirstName);

        System.out.println(weHaveTheSameFirstName);

        String firstDay = "Sunday";

        String lastDay;

        if (firstDay.equals("Sunday")) {
            lastDay = "Saturday";
        }
        else {
            lastDay = "Sunday";
        }

        String nextDay = firstDay.equals("Sunday") ? "Monday" : "Tuesday";

        String person = "Sandra Burnsides";
        int spacePosition = person.indexOf(" ");
        String surname = person.substring(spacePosition + 1, person.length());
        //boolean evenLength = surname.length() % 2 == 0 ? true : false;
        boolean evenLength = surname.length() % 2 == 0;
        System.out.println(surname);
        System.out.println(evenLength);

        System.out.println(myName + " " + surname + " " + evenLength + " " + spacePosition);

        //String greeting = "Good morning <<surname>>, today is <<nextDay>>";

        String greeting = "Good morning " + surname + ", today is " + nextDay;
        String greeting2 = String.format("Good morning %s, today is %s", surname, nextDay);
        System.out.println(greeting);
        System.out.println(greeting2);

        String colors = "blue, red, green, orange, purple";
        String[] colorsArray = colors.split(", ");

        for (String color : colorsArray) {
            System.out.println(color);
        }

    }
}
