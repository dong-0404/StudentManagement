/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author shin
 */
public class ValidAndNormalText {

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static boolean pressYNtoContinue(String mess) {
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static boolean pressUDtoContinue(String mess) {
        String input = getStringByRegex(mess, "U/D only!!!", "[UDud]");
        return input.equalsIgnoreCase("u");
    }

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.println(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static String getNonEmptyString(String mess) {
        String ret = "";
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            ret = removeUnnecessaryBlank(scan.nextLine());
            if (ret.equalsIgnoreCase("")) {
                System.err.println("please input Non-Empty String!!!");
                continue;
            }
            return ret;
        }
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }
}
