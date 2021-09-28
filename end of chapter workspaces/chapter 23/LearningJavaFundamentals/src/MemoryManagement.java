public class MemoryManagement {

    public static void main(String[] args) {

        String allNumbers = "";

        for (int i = 1; i < 10; i++) {
            allNumbers += " " + i;
        }

        System.out.println(allNumbers);


        StringBuilder allNumbersSB = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            allNumbersSB.append(" ");
            allNumbersSB.append(i);
        }
        System.out.println(allNumbersSB.toString());

    }
}
