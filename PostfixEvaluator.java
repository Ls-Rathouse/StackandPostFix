import java.util.ArrayList;

public class PostfixEvaluator
{
  public PostfixEvaluator()
  {
    
  }
  
  public String evaluatePostFix(ArrayList<String> arrayList) {
    MyStack stack = new MyStack(arrayList.size());
    for(int i = 0; i < arrayList.size(); i++)
    {
      String str = arrayList.get(i);
      Boolean isNum = false;
      try 
      { 
        Integer.parseInt(str);
        isNum = true;
      } catch(NumberFormatException e) 
        {
          isNum = false;
        }
      if(isNum)
      {
        stack.push(str);
      } else
      {
        int val1 = Integer.parseInt(stack.pop());
        int val2 = Integer.parseInt(stack.pop());
        Integer newVal = 0;
        char ch = str.charAt(0);
        switch (ch)
        {
        case '+':
          newVal = val2 + val1;
          stack.push(newVal.toString());
          break;
        case '-':
          newVal = val2 - val1;
          stack.push(newVal.toString());
          break;
        case '/':
          newVal = val2 / val1;
          stack.push(newVal.toString());
          break;
        case '*':
          newVal = val2 * val1;
          stack.push(newVal.toString());
          break;
        }
      }   
    }
    return stack.pop();   
  }
}