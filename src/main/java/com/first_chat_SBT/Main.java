package com.first_chat_SBT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
        //«Goodbye» - должна приводить к завершению работы программы.
        // При введении этой команды на экран должна выводиться последняя строка из файла answers.txt. +
        //«Use another file: XXXXX» - команда должна использоваться для того, чтобы изменить файл, из которого должны считываться фразы. +
        //XXXX – путь к новому файлу (можно указать как относительный, так и абсолютный). +
        //Программа должна записывать историю общения в отдельный файл. Название файла должно состоять из даты и времени запуска программы и иметь расширение .log . -


public class Main {


        public static void main(String[] args) throws IOException {
            LogManager.getLogManager().reset();
            Logger log = Logger.getLogger(Main.class.getName());

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String timeStamp = dateFormat.format(new Date());
            FileHandler fh = new FileHandler(timeStamp + ".log", 30000, 4, true);
            fh.setFormatter(new MyFormatter());
            log.addHandler(fh);


        Readfile.readFile("answers.txt");
        System.out.println(Readfile.ANSWERS.get(0));
        log.info(Readfile.ANSWERS.get(0));

        boolean stop = false;
        while (true) {
            String a = new Scanner(System.in).nextLine();
            log.info(a);
            if (a.equals("«Stop talking»"))
            {
                stop = true;
            }
            if (a.equals("«Start talking»"))
                {
                stop = false;
                continue;
            }
            ;
            if (stop == true) {
                continue;
            }
            if (a.equals("«Goodbye»")) {
                System.out.println(Readfile.ANSWERS.get(Readfile.ANSWERS.size() - 1));
                log.info(Readfile.ANSWERS.get(Readfile.ANSWERS.size() - 1));
                break;
            }
            ;
            if (a.equals("«Use another file: answers2»")) {
                Readfile.ANSWERS.clear();
                Readfile.readFile("answers2.txt");
                System.out.println("чтение из файла «answers2.txt»");
                log.info("чтение из файла «answers2.txt»");
                stop = true;
                stop = false;
                continue;
            }
            if (a.equals("«Use another file: answers»")) {
                Readfile.ANSWERS.clear();
                Readfile.readFile("answers.txt");
                System.out.println("чтение из файла «answers.txt»");
                log.info("чтение из файла «answers.txt»");
                stop = true;
                stop = false;
                continue;
            }

            else {Random r = new Random();
                int Low = 1;
                int High = Readfile.ANSWERS.size() - 1;
                int Result;

                {
                    switch (Result = r.nextInt(High - Low) + Low) {
                    }
                }

                System.out.println(Readfile.ANSWERS.get(Result));
                log.info(Readfile.ANSWERS.get(Result));

                }

        }

        }


}
