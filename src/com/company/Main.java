package com.company;

import java.io.*;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/company/input.txt"));
             BufferedWriter wr = new BufferedWriter(new FileWriter("src/com/company/output.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                wr.write((isCorrectBracketSeq(line)) + "\n");
                System.out.println(isCorrectBracketSeq(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isCorrectBracketSeq(String str) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') { //проверяем открывающиеся скобки
                arrayDeque.push(str.charAt(i)); // добавляем в arrayDeque
            } else if (str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']') { // проверяем закрывающиеся скобки
                if (arrayDeque.size() == 0) return false; // если на входе только закрывающиеся скобки возвразаем false
                switch (arrayDeque.pop()) { // вынимаем из arrayDeque по элементу
                    case '[':
                        if (str.charAt(i) != ']') return false; // сравниваем скобки
                        break;
                    case '{':
                        if (str.charAt(i) != '}') return false;
                        break;
                    case '(':
                        if (str.charAt(i) != ')') return false;
                        break;
                }
            }
        }
        return arrayDeque.size() == 0; // при размере arrayDeque = 0 возвращаем true
    }
}
