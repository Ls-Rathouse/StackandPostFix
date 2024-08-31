public class MyStack
{
  private String[] stackList;
  private int bottom;
  private int top;
  private int length;
  
  public MyStack(int size)
  {
    stackList = new String[size];
    bottom = 0;
    top = 0;
    length = 0;
  }

  public void push(String str)
  {
    stackList[top % stackList.length] = str;
    if(length < stackList.length)
    {
      length++;
    }
    top++;
    if(top - stackList.length == bottom + 1)
    {
      bottom++;
    }
  }

  public String pop()
  {
    top--;
    length--;
    if(top < 0)
    {
      top = stackList.length - 1;
    }
    return stackList[(top % stackList.length)];
  }

  public String peak()
  {
    return stackList[((top - 1) % stackList.length)];
  }

  public boolean empty()
  {
    return top - bottom == 0;
  }

  public void display()
  {
    System.out.print("[");
    for(int i = 0; i < length; i++)
    {
      System.out.print(stackList[(bottom + i) % stackList.length] + " ");
    }
    System.out.println("]");
  }
}