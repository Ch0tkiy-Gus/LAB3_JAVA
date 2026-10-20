import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BookController {
    private Book[] books;
    private BookView view;
    private Random random = new Random();

    public BookController(BookView view) {
        this.view = view;
        initData();
    }

    private void initData() {
        books = new Book[10];
        books[0] = new Book("Кобзар", "Шевченко Т.Г.", "А-БА-БА-ГА-ЛА-МА-ГА", 2020, 320, 250.0);
        books[1] = new Book("Захар Беркут", "Франко І.Я.", "Фоліо", 2018, 250, 150.0);
        books[2] = new Book("Тіні забутих предків", "Коцюбинський М.М.", "Ранок", 2015, 180, 120.0);
        books[3] = new Book("Лісова пісня", "Українка Л.", "Основа", 2019, 150, 130.0);
        books[4] = new Book("Тигролови", "Багряний І.", "А-БА-БА-ГА-ЛА-МА-ГА", 2021, 280, 200.0);
        books[5] = new Book("Інтернат", "Жадан С.", "Meridian Czernowitz", 2017, 336, 300.0);
        books[6] = new Book("Ворошиловград", "Жадан С.", "Фоліо", 2010, 320, 280.0);
        books[7] = new Book("Місто", "Підмогильний В.", "Ранок", 2022, 290, 210.0);
        books[8] = new Book("Маруся Чурай", "Костенко Л.", "А-БА-БА-ГА-ЛА-МА-ГА", 2018, 220, 240.0);
        books[9] = new Book("Кайдашева сім'я", "Нечуй-Левицький І.", "Основа", 2016, 210, 140.0);
    }

    public void start() {
        view.printBooks(books, "ПОЧАТКОВИЙ МАСИВ КНИГ");

        int choice;
        do {
            choice = view.getMenuChoice();
            processMenu(choice);
        } while (choice != 0);
    }

    private void processMenu(int choice) {
        switch (choice) {
            case 1:
                searchByRandomAuthor();
                break;
            case 2:
                searchByRandomPublisher();
                break;
            case 3:
                searchByRandomYear();
                break;
            case 4:
                sortByPublisher();
                break;
            case 0:
                view.printMessage("Роботу завершено.");
                break;
            default:
                view.printMessage("Невірний вибір. Спробуйте ще раз.");
        }
    }

    private void searchByRandomAuthor() {
        String[] authors = {"Жадан С.", "Шевченко Т.Г.", "Костенко Л.", "Стівен Кінг"};
        String targetAuthor = authors[random.nextInt(authors.length)];
        
        Book[] result = new Book[books.length];
        int count = 0;
        for (Book b : books) {
            if (b.getAuthor().equals(targetAuthor)) {
                result[count++] = b;
            }
        }
        view.printBooks(Arrays.copyOf(result, count), "Книги автора: " + targetAuthor);
    }

    private void searchByRandomPublisher() {
        String[] publishers = {"А-БА-БА-ГА-ЛА-МА-ГА", "Фоліо", "КСД"};
        String targetPublisher = publishers[random.nextInt(publishers.length)];
        
        Book[] result = new Book[books.length];
        int count = 0;
        for (Book b : books) {
            if (b.getPublisher().equals(targetPublisher)) {
                result[count++] = b;
            }
        }
        view.printBooks(Arrays.copyOf(result, count), "Книги видавництва: " + targetPublisher);
    }

    private void searchByRandomYear() {
        int[] years = {2015, 2018, 2021};
        int targetYear = years[random.nextInt(years.length)];
        
        Book[] result = new Book[books.length];
        int count = 0;
        for (Book b : books) {
            if (b.getYear() > targetYear) {
                result[count++] = b;
            }
        }
        view.printBooks(Arrays.copyOf(result, count), "Книги, видані після " + targetYear + " року");
    }

    private void sortByPublisher() {
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        
        Arrays.sort(sortedBooks, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPublisher().compareTo(b2.getPublisher());
            }
        });
        
        view.printBooks(sortedBooks, "КНИГИ ВІДСОРТОВАНІ ЗА ВИДАВНИЦТВОМ");
    }
}