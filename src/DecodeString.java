import java.util.Stack;

public class DecodeString {
    public DecodeString(String s) {
        this.s = s;
    }

    String s;

    public String decode() {
        Stack<String> myStack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '[') {
                i--;
                StringBuilder temp = new StringBuilder();
                for (; i >=0; i--) {
                    if (Character.isDigit(s.charAt(i))) {
                        temp.insert(0, s.charAt(i));
                    } else break;
                }
                if (temp.length() != 0) {
                    int number = Integer.parseInt(temp.toString());
                    temp = new StringBuilder();
                    while (!myStack.peek().equals("]")) {
                        temp.append(myStack.pop());
                    }
                    myStack.pop();
                    myStack.push(new String(new char[number]).replace("\0", temp.toString()));
                    i++;
                }

            } else {
                myStack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder result=new StringBuilder();
        while (!myStack.isEmpty())
            result.append(myStack.pop());
        return result.toString();
    }

}
