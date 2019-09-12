public class DemoBooksLibrary {

    public static void main(String[] args) {

        //создаем переменные для заполнения объекта класса "Book"
        String name = "Think Java: How to Think Like a Computer Scientist";
        String[] autors = {"Allen B. Downey", "Chris Mayfield"};
        String publisher = "O'Reilly Media";
        int year = 2016;
        int pages = 252;
        int price = 200;
        String binding = "soft";

        //вызываем конструктор класса для создания объекта
        Book book = new Book(name, autors, publisher, year, pages, price, binding);

        //создаем новый объект класса "BookLibrary", агрегирующего массив типа "Book"
        BooksLibrary thisLibrary = new BooksLibrary();

        //последовательно наполняем "библиотеку книгами"
        thisLibrary.addBook(book);

        name = "Think Java: How to Think Like a Computer Scientist";
        autors = new String[2];
        autors[0] = "Allen B. Downey";
        autors[1] = "Chris Mayfield";
        publisher = "O'Reilly Media";
        year = 2020;
        pages = 280;
        price = 250;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);
        thisLibrary.addBook(book);

        name = "Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists";
        autors = new String[1];
        autors[0] = "Mike Meyers";
        publisher = "McGraw-Hill Education";
        year = 2019;
        pages = 352;
        price = 200;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);
        thisLibrary.addBook(book);

        name = "CompTIA A+ Certification All-in-One Exam Guide, Tenth Edition (Exams 220-1001 & 220-1002)";
        autors = new String[1];
        autors[0] = "Frank Abagnale";
        publisher = "Portfolio";
        year = 2019;
        pages = 1568;
        price = 500;
        binding = "hardcover";
        book = new Book(name, autors, publisher, year, pages, price, binding);
        thisLibrary.addBook(book);

        name = "Adobe Photoshop CC Classroom in a Book (2019 Release) ";
        autors = new String[2];
        autors[0] = "Andrew Faulkner";
        autors[1] = "Conrad Chavez";
        publisher = "Adobe Press";
        year = 2018;
        pages = 416;
        price = 180;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);
        thisLibrary.addBook(book);

        name = "Gone with the Wind";
        autors = new String[2];
        autors[0] = "Margaret Mitchell";
        autors[1] = "Pat Conroy";
        publisher = "Scribner";
        year = 2011;
        pages = 960;
        price = 100;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);
        thisLibrary.addBook(book);

        //выводим на печать все книги (Book) библиотеки (BookLibrary)
        System.out.println("All the books in the library:\n");
        System.out.println(thisLibrary.toString());

        //выводим на печать все книги заданного автора
        thisLibrary.printBookWhereAuthorIs("Chris Mayfield");

        //выводим на печать все книги заданного издательства
        thisLibrary.printBooksWherePublisherIs("O'Reilly Media");

        //выводим на печать все книги изданные после заданного года
        thisLibrary.printBooksPublishedAfter(2018);
    }
}
