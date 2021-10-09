package javaproject;

import java.io.*;
import java.util.LinkedList;
/*
   Класс обработчик файлов, содержит три открытых метода — readFile(), appendFile() и overWriteFile().
 */


public class FileHandler {
    /**
     * Метод не принимает никаких параметров, и возвращает коллекцию LinkedList с объектами Member.
     * Метод readFile() читает данные из CSV-файла с подроб- ной информацией обо всех посетителях.
     *  Затем каждый посетитель добавляется в коллекцию LinkedList.
     * @return возвращает коллекцию LinkedList с объектами Member.
     */
     public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList<>();
        Member mem;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            String lineRead = reader.readLine();
            while (lineRead != null) {
                String[] splitLine = lineRead.split(",");
                if (splitLine[0].equals("S")) {
                    mem = new SingleClubMember('S', Integer. // char memberType, int memberId, String name, double fees, int club
                            parseInt(splitLine[1]), splitLine[2],
                            Double.parseDouble(splitLine[3]), Integer.
                            parseInt(splitLine[4]));
                } else {
                    mem = new MultiClubMember('M', Integer. // char memberType, int memberId, String name, double fees, int membershipPoints
                            parseInt(splitLine[1]), splitLine[2],
                            Double.parseDouble(splitLine[3]), Integer.
                            parseInt(splitLine[4]));
                }
                m.add(mem);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         return m;
     }
    public void appendFile(String mem) {
        /**
         * Метод присоединяет новую строку к файлу members.csv каждый раз, когда добавляется новый посетитель.
         * Он получает параметр String с именем mem и не возвращает никакого значения.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv",true))) {
             writer.write(mem + "\n");
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }

    }
    public void overWriteFile(LinkedList<Member> m) {
        /**
         * Этот метод получает параметр LinkedList<Member> с именем m и ничего не возвращает.
         * Этот метод вызывается каждый раз, когда вы хотите удалить посетителя из клуба.
         * При удалении посетителя необходимо обновить CSV-файл.
         */
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {

             for (int i = 0; i < m.size(); i++) {
                String s = m.get(i).toString();
                writer.write(s + "\n");
             }
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
         try {
             File f = new File("members.csv");
             File tf = new File("members.temp");
             f.renameTo(tf);
             tf.delete();
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }
}
