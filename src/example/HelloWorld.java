package example;/**
 * Created by Administrator on 2018/3/22/022.
 */
public class HelloWorld {

  public String sayTitle(String from) {
    String result = "title is " + from;
    System.out.println(result);
    return result;
  }

  public String sayBody(String other) {
    String result = "----------body is--------" + other;
    System.out.println(result);
    return result;
  }

  public String sayAll(String title,String body) {
    String result = "-----titlt: " + title + "------/r/nbody:" + body + "--------";
    System.out.println(result);
    return result;
  }
}
