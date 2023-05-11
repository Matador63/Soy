
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Calculator {
    static String[] roman = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
            "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
            "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
            "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод данных");
        String expression = scanner.nextLine();
         System.out.print(job(expression));
    }
 public static String job(String expression) throws Exception{
        int num1;
        int num2;
        String oper;
        String result;
        boolean isGood;
        String[] operands = expression.split("[+*\\-/]");
        if (operands.length != 2) throw new Exception("1");
        oper = detectOperation(expression);
        String[]decim={"1","2","3","4","5","6","7","8","9","10"};
     List<String>uno= Arrays.asList(decim);
     List<String>dos=Arrays.asList(roman);

            if (dos.contains(operands[0]) && dos.contains(operands[1])) {
                num1=convertToArab(operands[0]);
                num2 = convertToArab(operands[1]);
                isGood=true;
            }
            else if (uno.contains(operands[0]) && uno.contains(operands[1])) {
                num1 = Integer.parseInt(operands[0]);
                num2 = Integer.parseInt(operands[1]);
                isGood=false;
            } else {
                throw new Exception("2");
            }

        if (num1 > 10 || num2 > 10) {
            throw new Exception("3");
        }
        int arabian = calc(num1, num2, oper);
            if (isGood) {
                if (arabian < 1) {
                    throw new Exception("4");
                }
                result = roman[arabian];
            } else  {
                result = String.valueOf(arabian);
            }
            return result;
    }
    public static int convertToArab(String val){
        for(int i=0;i<roman.length;i++){
            if(val.equals(roman[i])){
                return i;}}return-1;
    }
    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else  return "/";
    }

    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;}
    }






