import static org.junit.Assert.*;

import org.junit.Test;

public class unitTest {
    @Test
    public void testSteve(){
        int i = 0;
        int j = 0;
        while(i<500 && j < 500){
            boolean result  = Flik.isSameNumber(i,j); //要记得说明是Filk class里面的方法
            if(!result){
                System.out.printf("i is %d, j is %d",i,j);
            }
            assertEquals(true,result);
            i++;
            j++;
        }
    }
}
