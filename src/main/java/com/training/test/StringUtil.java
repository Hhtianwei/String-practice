package com.training.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : tianwei
 * @date : 2024-07-17 6:56
 * @description: 使用正则表达式匹配数字部分, 完成String串的切割
 */
public class StringUtil {

    public static String spiltString(String input) {
        //设置一个截取正则
        String regex = "\\d+\\.?\\d*";
        String numberStr = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            numberStr = matcher.group();
        }
        // 提前返回
        if (numberStr.isEmpty()) {
            return numberStr;
        }
        // 提前返回
        if (!numberStr.contains(".")) {
            // 如果没有小数点，则补充 ".00"
            numberStr += ".00";
            return numberStr;
        }
        //处理复杂数据 ，有小数点，则保留两位小数
        int dotIndex = numberStr.indexOf('.');
        String integerPart = numberStr.substring(0, dotIndex);
        String decimalPart = numberStr.substring(dotIndex + 1);
        // 如果小数部分长度大于等于2，截取前两位作为小数部分
        if (decimalPart.length() >= 2) {
            decimalPart = decimalPart.substring(0, 2);
        } else {
            //补足两位
            decimalPart = String.format("%-2s", decimalPart).replace(' ', '0');
        }
        numberStr = integerPart + "." + decimalPart;
        return numberStr;
    }

    public static void main(String[] args) {
        String input1 = "abcd123.456";
        String input2 = "abcd123";
        String input3 = "abcd456.7efasdfsfasdfg";
        System.out.printf("Input: %s,->Number: %s%n", input1, spiltString(input1));
        System.out.printf("Input: %s,->Number: %s%n", input2, spiltString(input2));
        System.out.printf("Input: %s,->Number: %s%n", input3, spiltString(input3));
    }
}
