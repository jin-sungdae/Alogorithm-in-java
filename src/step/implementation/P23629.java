package step.implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P23629 {

    public static String test(String s){
        LinkedList<Long> numList = new LinkedList<>();
        LinkedList<Character> opList = new LinkedList<Character>();
        String num = "";
        boolean check = true;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '+' || ch =='-' || ch == '*' || ch == '/') {
                if (num == "")
                    check = false;
                else if (num != "")
                    numList.add(Long.parseLong(num));
                opList.add(ch);
                num = "";
                continue;
            }
            num += ch;
        }
        numList.add(Long.parseLong(num));
        while(!opList.isEmpty() && check == true) {
            Long prevNum = numList.poll();
            Long nextNum = numList.poll();
            char op = opList.poll();

            if(op == '+') {
                numList.addFirst(prevNum + nextNum);
            } else if(op == '-') {
                numList.addFirst(prevNum - nextNum);
            } else if(op == '*') {
                numList.addFirst(prevNum * nextNum);
            } else if(op == '/') {
                Long resultNum = (Long)Math.round((double) prevNum / (double) nextNum);
                numList.addFirst(resultNum);
            }
        }
        String result = "";
        if (check == true)
            result = numList.poll().toString();
        else if (check == false){
            result = "Madness!";
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.replaceAll("ONE" , "1").replaceAll("TWO", "2")
                .replaceAll("THREE", "3").replaceAll("FOUR", "4")
                .replaceAll("FIVE", "5").replaceAll("SIX", "6")
                .replaceAll("SEVEN", "7").replaceAll("EIGHT", "8")
                .replaceAll("NINE", "9").replaceAll("ZERO", "0");

        System.out.println(str);
        str = str.replace("=" ,"").replaceAll("x", "*");

        String result = test(str);
        result = result.replaceAll("1" , "ONE").replaceAll("2", "TWO")
                .replaceAll("3", "THREE").replaceAll("4", "FOUR")
                .replaceAll("5", "FIVE").replaceAll("6", "SIX")
                .replaceAll("7", "SEVEN").replaceAll("8", "EIGHT")
                .replaceAll("9", "NINE").replaceAll("0", "ZERO");
        System.out.println(result);

    }
}
