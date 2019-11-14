package com.first_chat_SBT;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

//1. Программа работает из командной строки +
//2. Набор фраз для ответов должен храниться в отдельном файле; в том же каталоге, что и программа, и иметь название answers.txt; +
//3. каждая фраза должна находиться на отдельной строке. +
//4. После запуска программы она должна выдавать на экран приветствие, находящиеся в первой строке файла answers.txt. +
//5. Приветствие должно выдаваться только при старте программы и не использоваться в дальнейшем диалоге. +
//6. После введения любой строки, за исключением команд, перечисленных ниже – программа должна выводить на экран случайную фразу из файла answers.txt. +
//7. Смысловой анализ фраз собеседника не предусмотрен +
//8. Программа должна понимать следующие команды, вводимые в командной строке в качестве очередной фразы диалога (кавычки являются частью команды):
        //«Stop talking» - программа перестает реагировать на фразы, вводимые в дальнейшем, до тех пор, пока не будет введена команда +
        //«Start talking» - команда, вводимая для возобновления интерактивного режима работы программы после введения команды «Stop talking» +
        //«Goodbye» - должна приводить к завершению работы программы. При введении этой команды на экран должна выводиться последняя строка из файла answers.txt. +
        //«Use another file: XXXXX» - команда должна использоваться для того, чтобы изменить файл, из которого должны считываться фразы. XXXXX – путь к новому файлу (можно указать как относительный, так и абсолютный). -
        //Программа должна записывать историю общения в отдельный файл. Название файла должно состоять из даты и времени запуска программы и иметь расширение .log . -


public class Main {
    static ArrayList <String> ANSWERS = new ArrayList<String>();


        public static void main(String[] args) throws FileNotFoundException {
        readFile("answers.txt");
        System.out.println(ANSWERS.get(0));
        boolean stop = false;
        while (true) {
            String a = new Scanner(System.in).nextLine();
            if (a.equals("«Stop talking»")) {
                stop = true;
            }
            ;
            if (a.equals("«Start talking»")) {
                stop = false;
                continue;
            }
            ;
            if (stop == true) {
                continue;
            }
            if (a.equals("«Goodbye»")) {
                System.out.println(ANSWERS.get(ANSWERS.size()-1));
                break;
            } else {
                Random r = new Random();
                int Low = 1;
                int High = ANSWERS.size() - 1;
                int Result = r.nextInt(High - Low) + Low;

                System.out.println(ANSWERS.get(Result));
            }


        }
    }
    public static void readFile(String fileName) throws FileNotFoundException {
        File source = new File(fileName);
        Scanner s = new Scanner(source);
        while (s.hasNext()) {
            String nextLine = s.nextLine();
            ANSWERS.add(nextLine);
        }
        s.close();
    }

}
