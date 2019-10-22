package com.company.bai2;

import java.io.IOException;
import java.util.*;

public class StringEx {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s;
        char c;
        System.out.println("nhập chuỗi :");
        s = scanner.nextLine();
        count(s);
        combinations(s);
        System.out.println("Nối chuỗi :");
        List<String> strings = new ArrayList<>();
        strings.add("inoha");
        strings.add("kuriboh");
        System.out.println(stringToList(String.valueOf(strings)));
        System.out.println("nhập ký tự c:");
        c=(char)System.in.read();
        System.out.println("Nhập lần thứ n xuất hiện :");
        int n = scanner.nextInt();
        count2(c,s,n);
        System.out.println(replace("I am fresher","fresher","junior"));
        String list ="inoha,kuriboh,kairuka";
        List<String> strings1=stringToList(list);
        for(String str : strings1){
            System.out.println(str);
        }
    }

    static List<String> stringToList(String s) {
        List<String> strings = new ArrayList<>();
        String[] output = s.split(",");
        for (int i = 0; i < output.length; i++) {
            strings.add(output[i]);
        }
        return strings;
    }

    static void count(String str) {
        String[] count = str.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String s : count) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
    static String listToString(List<String> strings){
        return String.join(",",strings);
    }
    static void combinations(String string){
        System.out.println("chuỗi phụ của \"" + string + "\" là :-");
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j <= string.length() - i; j++) {
                String sub = string.substring(i, j + i);
                hs.add(sub);
            }
        }
        for (String s: hs){
            System.out.println(s);
        }
    }
    static void count2(char x, String s, int n){
        int count = 0;

        for (int i= 0; i< s.length(); i++){
            if (x == s.charAt(i)){
                count ++;
            }
        }
        System.out.println("số lần xuất hiện : "+count);
        System.out.println("Phần từ xuất hiện vị chí đầu tiên là: "+s.indexOf(x));
        System.out.println("Phần từ xuất hiện ở vị trí cuối cùng là: "+s.lastIndexOf(x));
        int dem = 0;
        for (int i= 0; i< s.length(); i++){
            if (x == s.charAt(i)){
                dem ++;
            }
            if (dem == n){
                System.out.println("Xuất hiện lần thứ "+n+" ở vị trí: "+i);
                break;
            }
        }
    }
    static void wordCount(String s){
        char[] arrayC = new char[100];
        int[] arrayI = new int[100];
        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i= 0; i< s.length(); i++){
            for (int j= i + 1; j< s.length(); j++){
                if (s.charAt(j) == s.charAt(i)){
                    arrayC[i] = s.charAt(i);
                    arrayI[i] ++;
                }
            }
        }
    }

    static String replace(String raw, String from, String to){
        String replaceString = null;
        if (raw.contains(from)){
            replaceString = raw.replace(from, to);
        }else{
            System.out.println("Khong tim duoc chuoi can thay the");
        }
        return replaceString;
    }}
