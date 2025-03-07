package com.psksoft;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressRegxValidation {
    public static void main(String[] args) {

        String regex  = "^[\\w\\s\\W&&[^@]]+@[\\w\\s\\W&&[^@]]+\\.[a-zA-Z]{2,}";
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter email address for validation");
        System.out.println(">");
        String email = scanner.nextLine();

        Pattern compile = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(email);

        if(matcher.find()){
            System.out.println(String.format("email %s is Valid", email));
        }else {
            System.out.println(String.format("email %s is NOT Valid", email));
        }

    }

}
