import java.util.ArrayList;
import java.util.Scanner;

class BookLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("Hello there! Enter your choice:");
            System.out.println("1. Fiction");
            System.out.println("2. NonFiction");
            System.out.println("3. List Books");
            System.out.println("4. Exit");
            String userInput = scan.nextLine();

            if ("Exit".toLowerCase().equals(userInput) || "4".equals(userInput)) break;
            else if ("fiction".equals(userInput.toLowerCase()) || "1".equals(userInput)) {
                System.out.println("Enter title:");
                String title = scan.nextLine();
                System.out.println("Enter author:");
                String author = scan.nextLine();
                System.out.println("Enter year:");
                int year = scan.nextInt();
                scan.nextLine();
                
                try {
                    Fiction fictionBook = new Fiction(title, author, year);
                    Library.addBook(fictionBook);
                } catch (IncompleteBookException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Would you like to do more operations? y/n");
                String choice = scan.nextLine();
                System.out.println();
                if ("y".toLowerCase().equals(choice) || "yes".toLowerCase().equals(choice)) continue;
                else if ("n".toLowerCase().equals(choice) || "no".toLowerCase().equals(choice)) break;
            }
            else if ("nonfiction".equals(userInput.toLowerCase()) || "2".equals(userInput)) {
                System.out.println("Enter title:");
                String title = scan.nextLine();
                System.out.println("Enter author:");
                String author = scan.nextLine();
                System.out.println("Enter year:");
                int year = scan.nextInt();
                scan.nextLine();
                
                try {
                    NonFiction nonFictionBook = new NonFiction(title, author, year);
                    Library.addBook(nonFictionBook);
                } catch (IncompleteBookException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Would you like to do more operations? y/n");
                String choice = scan.nextLine();
                System.out.println();
                if ("y".toLowerCase().equals(choice) || "yes".toLowerCase().equals(choice)) continue;
                else if ("n".toLowerCase().equals(choice) || "no".toLowerCase().equals(choice)) break;
            }
            else if ("list books".equals(userInput.toLowerCase()) || "3".equals(userInput)) {
                try {
                    Library.displayBooks();
                } catch (LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Would you like to do more operations? y/n");
                String choice = scan.nextLine();
                System.out.println();
                if ("y".toLowerCase().equals(choice) || "yes".toLowerCase().equals(choice)) continue;
                else if ("n".toLowerCase().equals(choice) || "no".toLowerCase().equals(choice)) break;
            }
            else {
                System.out.println("Please enter the correct choice. Would you like to try again? y/n");
                String choice = scan.nextLine();
                System.out.println();
                if ("y".toLowerCase().equals(choice) || "yes".toLowerCase().equals(choice)) continue;
                else if ("n".toLowerCase().equals(choice) || "no".toLowerCase().equals(choice)) break;
            }
        }
    }
}

abstract class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) throws IncompleteBookException {
        if (title == null || title.isEmpty() || author == null || author.isEmpty() || year <= 0) {
            throw new IncompleteBookException("Incomplete book information provided.");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public abstract void getDetails();
}

class Fiction extends Book {
    public Fiction(String title, String author, int year) throws IncompleteBookException {
        super(title, author, year);
    }

    @Override
    public void getDetails() {
        StringBuilder out = new StringBuilder("Fiction Book Title: ");
        out.append(getTitle());
        out.append(", Author: ");
        out.append(getAuthor());
        out.append(", Year: ");
        out.append(getYear());

        System.out.println(out);
    }
}

class NonFiction extends Book {
    public NonFiction(String title, String author, int year) throws IncompleteBookException {
        super(title, author, year);
    }

    @Override
    public void getDetails() {
        StringBuilder out = new StringBuilder("NonFiction Book Title: ");
        out.append(getTitle());
        out.append(", Author: ");
        out.append(getAuthor());
        out.append(", Year: ");
        out.append(getYear());

        System.out.println(out);
    }
}

class Library {
    static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            throw new LibraryEmptyException("The library is empty. No books to display.");
        }
        for (Book book : books) {
            book.getDetails();
        }
    }
}
