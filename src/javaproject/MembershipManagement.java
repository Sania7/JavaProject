package javaproject;

// Класс управление членством,реализует операции добавления, удаления посетителей, так же метод для вывода
// информации о посетителе.

import java.util.InputMismatchException;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);


    private int getIntInput() {
        /**
         * Этот метод для того чтобы запросить у пользователя значение int,не получает параметров и
         * возвращает int.Если значение введенное пользователем не относится к типу int, метод продолжает
         * запрашивать у пользователя данные, пока не получит допустимое значение.
         */
        int choice = 0;

        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("ERROR: INVALID INPUT. Please try again: ");
                System.out.println("ОШИБКА: Неверный ввод. Пожалуйста, попробуйте еще раз: ");
            }
        }
        return choice;
    }


}
