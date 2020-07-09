package com.example.demo.recursive;

public class Test1 {

    /**
     * 字符串解码
     *
     * @param args
     */
    public static void main(String[] args) {

        int n = new Test1().numDecodings("112312");

        System.out.println(n);

    }

    int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    int decode(char[] chars, int index) {
        // 处理到了第一个字符,只能有一种解码方法，返回 1
        if (index <= 0) return 1;

        int count = 0;

        char curr = chars[index];
        char prev = chars[index - 1];

        // 当前字符比 “0” 大，则直接利用它之前的字符串所求得的结果
        if (curr > '0') {
            count = decode(chars, index - 1);
        }

        // 由前一个字符和当前字符所构成的数字，值必须要在 1 到 26 之间，否则无法进行解码
        if (prev == '1' || (prev == '2' && curr <= '6')) {
            count += decode(chars, index - 2);
        }

        return count;
    }
}
