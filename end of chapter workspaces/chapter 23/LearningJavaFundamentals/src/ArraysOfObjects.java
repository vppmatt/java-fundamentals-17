public class ArraysOfObjects {

    public static void main(String[] args) {

        int[] numbers = {1,2,3};

        Book[] books = new Book[10];

        books[4] = new Book("A good read", "Matt Greencroft", 17.99);

        Book myBook;
        myBook = new Book("A good read part 2", "Matt Greencroft", 37.99);
        //myBook = null;

        if (myBook != null) {
            System.out.println(myBook.getTitle());
        }

        books[5] = myBook;

        books[8] = new Book("Of mice and men", "John Steinbeck", 16.50);
        books[7] = new Book("Pride and prejudice", "Jane Austen", 19.99);

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null)
                System.out.println(books[i].getTitle());
        }

        for (Book book : books) {
            if (book != null)
                System.out.println(book.getTitle());
        }

    }
}
