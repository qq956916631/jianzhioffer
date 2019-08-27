package charater4;

import java.util.*;


public class 面试题38_2字符串组合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder res = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        combine(str, 0, res, arrayList);
        for (String ans : arrayList) {
            System.out.println(ans + " ");
        }
    }

    private static void combine(String str, int point, StringBuilder res, ArrayList<String> arrayList) {
        if (point == str.length()) {
            arrayList.add(res.toString());
            return;
        }
        res.append(str.charAt(point));
        combine(str, point + 1, res, arrayList);
        res.deleteCharAt(res.length() - 1);
        combine(str, point + 1, res, arrayList);
    }
}

/*
题目：
    输入一个字符串，输出该字符串中相邻字符的所有组合。
    举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重
    输入 bac
    输出 a b c ac ba bac
*/
class 相似例题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder res = new StringBuilder();
        ArrayList<MyString> arrayList = new ArrayList<>();
        combine(str, 0, res, arrayList);
        Collections.sort(arrayList);
        for (int i = 1; i < arrayList.size(); i++)
                System.out.print(arrayList.get(i) + " ");
    }

    private static void combine(String str, int point, StringBuilder res, ArrayList<MyString> arrayList) {
        if (point == str.length()) {
            MyString string = new MyString(res.toString());
            if (!arrayList.contains(string))
                arrayList.add(string);
            return;
        }
        if (res.length() == 0 || (res.charAt(res.length() - 1) == str.charAt(point - 1))) {
            res.append(str.charAt(point));
            combine(str, point + 1, res, arrayList);
            res.deleteCharAt(res.length() - 1);
        }
        combine(str, point + 1, res, arrayList);
    }

    private static class MyString implements Comparable {
        String str;

        public MyString(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(Object o) {
            MyString other = (MyString) o;
            if (str.length() == other.str.length())
                return str.compareTo(other.str);
            return str.length() - other.str.length();
        }

        @Override
        public String toString() {
            return str;
        }

        @Override
        public boolean equals(Object obj) {
            return str.equals(((MyString) obj).str);
        }
    }
}