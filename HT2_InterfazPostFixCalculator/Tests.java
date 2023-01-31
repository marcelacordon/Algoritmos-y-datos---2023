import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class Tests {

Stack<Integer> Pila = new Stack<Integer>();
Calculator calc = new Calculator(); 

    @Test
    public void Test1(){ 
        Pila.push(1);
        Pila.push(2);
        assertEquals(false, Pila.empty());
    } 

    @Test
    public void Test2(){ 
       assertEquals(false, calc.isOperator("2"));
       assertEquals(true, calc.isOperator("+"));
    } 
}
