import static org.junit.Assert.*;
import org.junit.Test;

public class InfixCalculatorTest {

    
@Test
    public void testOperate_withVectorStack() {
        Stack<Double> stack = StackFactory.createStack("2", null);
        double result = Calculator.getInstance().operate("5 3 -", stack);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testOperate_withSinglyListStack() {
        Stack<Double> stack = StackFactory.createStack("3", "1");
        double result = Calculator.getInstance().operate("4 2 *", stack);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testOperate_withDoublyListStack() {
        Stack<Double> stack = StackFactory.createStack("3", "2");
        double result = Calculator.getInstance().operate("9 3 /", stack);
        assertEquals(3.0, result, 0.001);
    }

    //operacion en cada tipo de stack
}