package MyHooks;

import framework.DriverHelper;
import framework.Props;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;


public class Myhooks

{
    @Before
    public static void setup()
    {
        System.out.println("before");
     DriverHelper.callDriver();

    }
    @After
    public static void afterEveryScenario()
    {
        System.out.println("after");
        //DriverHelper.close();
       DriverHelper.Quit();
    }
//    @AfterAll
//    public static void afterAll()
//    {
//        System.out.println("afterall");
//       DriverHelper.Quit();
//    }


}
