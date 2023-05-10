package org.example.Util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean ValidName(String name) {
        // Expresión regular para validar un nombre: solo letras y espacios, con una longitud mínima de 2 caracteres
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,}$";
        return name.matches(regex);
    }

    public static boolean validLast_name(String Last_name ) {
        return Last_name.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚüÜ]+(\\s[A-Za-zñÑáéíóúÁÉÍÓÚüÜ]+)?\\s[A-Za-zñÑáéíóúÁÉÍÓÚüÜ]+$");
    }
    public static boolean validAge(int age) {
        boolean isValid = false;
        if (age>=1 && age<=100){
            isValid=true;
        }else {
            isValid=false;
        }
            return isValid;
    }
    public static String stringInput() {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void showMessage(String msg) {
        System.out.println(msg);
    }
    public static int IntInput() {

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }





}
