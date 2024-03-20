package tasks;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class TaskGenericClass {
    public class Box<T>{
        private T param;

        public void setParam(T param) {
            this.param = param;
        }

        public T getParam() {
            return param;
        }
    }

    @Test
    public void testSolution() {
        BigDecimal bigDecimalParam = BigDecimal.valueOf(10);
        Box box = new Box();
        box.setParam(bigDecimalParam);
        System.out.println(box.getParam());

        HashMap<String, Integer> hashMapParam = new HashMap<>();
        hashMapParam.put("test", 1);

        Box box1 = new Box();
        box1.setParam(hashMapParam);
        System.out.println(box1.getParam().toString());
    }
}
