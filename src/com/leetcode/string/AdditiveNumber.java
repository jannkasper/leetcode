package com.leetcode.string;

// https://leetcode.com/problems/additive-number/
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;

        for (int len = 2; len < num.length(); len++) {
            for (int mid = 1; mid < len; mid++) {
                if (check(num.substring(len), num.substring(0, mid), num.substring(mid, len))) return true;
            }
        }

        return false;
    }

    private boolean check(String s, String s1, String s2) {
        if (s.length() == 0) return true;
        if (s1.length() > 1 && s1.startsWith("0")) return false;
        if (s2.length() > 1 && s2.startsWith("0")) return false;

        String start = add(s1, s2);

        if (s.startsWith(start)) {
            return check(s.substring(start.length()), s2, start);
        }
        return false;
    }

    private String add(String addend1, String addend2) {
        StringBuilder buf = new StringBuilder();
        for ( int i1 = addend1.length() - 1, i2 = addend2.length() - 1, carry = 0;
              i1 >= 0 || i2 >= 0 || carry != 0;
              i1--, i2-- ) {
            int digit1 = i1 < 0 ? 0 : Integer.parseInt(Character.toString(addend1.charAt(i1)));
            int digit2 = i2 < 0 ? 0 : Integer.parseInt(Character.toString(addend2.charAt(i2)));

            int digit = digit1 + digit2 + carry;
            if (digit > 9) {
                carry = 1;
                digit -= 10;
            } else {
                carry = 0;
            }

            buf.append(digit);
        }
        return buf.reverse().toString();
    }
}
