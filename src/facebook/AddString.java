package facebook;

public class AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        int left = 0;

        while (i1 >= 0 || i2 >= 0) {

            // add each digit; get each digit's value if exists, 0 otherwise
            int d1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int d2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;

            // calculate carry and current digit's left value
            left = (d1+d2+carry) % 10;
            carry = (d1+d2+carry) / 10;

            sb.append(left);    // note that each digit is appended at the end
            i1--;
            i2--;
        }
        if (carry > 0) sb.append(carry);    // append last carry if exists
        return sb.reverse().toString();     // reverse the stringbuilder and return
    }
}
