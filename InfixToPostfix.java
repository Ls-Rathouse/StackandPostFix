import java.util.ArrayList;

public class InfixToPostfix
{
  private String postFix;
  private ArrayList<String> postFixArray;
  static int opOrder(String str)
    {
        char ch = str.charAt(0);
        switch (ch)
        {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }
    
  public InfixToPostfix(String inFix)
  {
    postFix = "";
    MyStack stack = new MyStack(inFix.length());
    int i = 0;
    ArrayList<String> outputArray = new ArrayList<String>();
    Boolean foundOperator = false;
    char prevChar = ' ';
    while(i < inFix.length())
    {
      char ch = inFix.charAt(i);
      String str = inFix.substring(i, i+1);
      if(ch == '(')
      {
        stack.push(str);
      }
      else if (ch == ')')
      {
        while(!stack.empty() && !stack.peak().equals("("))
        {
          outputArray.add(stack.pop());
        }
        stack.pop();
      }
      else if (Character.isLetterOrDigit(ch))
      {
        if(Character.isLetterOrDigit(prevChar))
        {
          String prevStr = outputArray.get(outputArray.size() - 1);
          String newStr = prevStr += str;
          outputArray.set(outputArray.size() - 1, newStr);
        }
        else 
        {
          outputArray.add(str);
        }
      }
      else 
      {
        if(!stack.empty())
        {
          while(!stack.empty() && opOrder(str) <= opOrder(stack.peak()))
          {
            outputArray.add(stack.pop());
          }
        }
      stack.push(str);
      }
      i++;
      prevChar = ch;
    }
    while (!stack.empty()) {
      outputArray.add(stack.pop());
    }
    for(int j = 0; j < outputArray.size(); j++)
    {
      postFix += outputArray.get(j) + " ";
    }
    postFixArray = outputArray;
  }

  public String getPostFix()
  {
    return postFix;
  }
  
  public ArrayList<String> getPostFixArray()
  {
    return postFixArray;
  }
}