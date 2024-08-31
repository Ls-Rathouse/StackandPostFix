import java.util.Scanner;

class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    Integer num = 0;
    System.out.println("What is the size of the stack?");
    int length = scan.nextInt();
    MyStack stack = new MyStack(length);
    int option = 0;
    while(option != 4)
    {
      System.out.println("\n===================\nChoose from the menu:\n1. Push.\n2. Pop.\n3. Peak.\n4. Exit.");
      option = scan.nextInt();
      while(option < 1 || 4 < option)
      {
        System.out.println("That is not an available option, please select one.");
        option = scan.nextInt();
      }
      if(option == 1)
      {
        System.out.println("Enter an integer to push into the stack:");
        num = scan.nextInt();
        stack.push(num.toString());
      }
      if(option == 2)
      {
        if(stack.empty())
        {
          System.out.println("The stack is empty, there is nothing to pop.");
        }
        else
        {
          System.out.println(stack.pop() + " is removed from the stack.");
        }
      }
      if(option == 3)
      {
        if(stack.empty())
        {
          System.out.println("The stack is empty, there is nothing to peak.");
        }
        else
        {
          System.out.println("The top of the stack is " + stack.peak());
        }
      }
      System.out.println("Elements in the stack:");
      stack.display();
    }
    //Separation between Stack & Postfix
    boolean again = true;
    while(again)
    {
      System.out.println("\nEnter an infix expression:");
      InfixToPostfix equation = new InfixToPostfix(scan.next());
      System.out.println("The postfix form of the expression is:");
      System.out.println(equation.getPostFix());
      PostfixEvaluator eval = new PostfixEvaluator();
      String result = eval.evaluatePostFix(equation.getPostFixArray());
      System.out.println("Result = " + result);
      System.out.println("Do you want to continue?");
      if(scan.next().equals("no"))
      {
        again = false;
      }
    }
  }
}