import java.util.*;

public class ManipulatingCollections {

    public static void main(String[] args) {
        List<String> firstList = new ArrayList<>();
        firstList.add("one");
        firstList.add("two");
        firstList.add("three");
        firstList.add("four");
        firstList.add("five");

        for (String s: firstList) {
            System.out.println(s);
        }

        Collections.sort(firstList);

        for (String s: firstList) {
            System.out.println(s);
        }

        List<Book> books = new ArrayList<>();
        books.add(new Book("First Book", "Matt Greencroft", 15.99));
        books.add(new Book("A Good Read", "Sally Mauve", 29.99));
        books.add(new Book("Something Quick to Read", "Dave Green", 29.99));

        Collections.sort(books);
        for (Book b : books) {
            System.out.println(b);
        }


        Map<Integer, Book> bookMap = new HashMap<>();
        bookMap.put(17,new Book("First Book", "Matt Greencroft", 15.99) );
        bookMap.put(3,new Book("A Good Read", "Sally Mauve", 29.99) );
        bookMap.put(21,new Book("Something Quick to Read", "Dave Green", 29.99) );
        bookMap.put(3,new Book("More reading", "Michael Black", 29.99) );

        System.out.println(bookMap.size());
        Book foundBook = bookMap.get(3);
        System.out.println(foundBook);

        Set<Integer> keys = bookMap.keySet();
        for (Integer k: keys) {
            System.out.println(bookMap.get(k));
        }

        var values = bookMap.values();
        for(Book b : values) {
            System.out.println(b);
        }

        List<Book> bookList= new ArrayList<>(bookMap.values());
        Collections.sort(bookList);

        bookMap.remove(3);

        Map<Integer, String> myMap = Map.of(1, "one", 2, "two");


    }
}
