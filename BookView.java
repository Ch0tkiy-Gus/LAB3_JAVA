import java.util.Scanner;

public class BookView {
    private Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBooks(Book[] books, String header) {
        System.out.println("\n--- " + header + " ---");
        boolean found = false;
        
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.toString());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Записів не знайдено.");
        }
        System.out.println("-------------------------------------------------");
    }

    public int getMenuChoice() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Знайти книги випадкового автора");
        System.out.println("2. Знайти книги випадкового видавництва");
        System.out.println("3. Знайти книги, видані пізніше випадкового року");
        System.out.println("4. Відсортувати всі книги за видавництвом");
        System.out.println("0. Вихід");
        System.out.print("Оберіть дію: ");
        
        while (!scanner.hasNextInt()) {
            System.out.print("Помилка! Введіть число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}