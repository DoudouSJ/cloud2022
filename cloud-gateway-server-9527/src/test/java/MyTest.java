import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @author Doudou
 * @date 2022/3/24 - 10:09
 */
public class MyTest {
    @Test
    public void test01(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
