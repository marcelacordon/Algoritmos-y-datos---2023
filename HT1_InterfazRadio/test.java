import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class test extends TestCase{
    radio rad; 

    
    private void pruebi (){
        rad = new radio();
    }
    
    @Test
    public void TestActualAm(){
        pruebi();
        rad.Forward();
        assertEquals(540, rad.getAMActualStation());
    }

    @Test
    public void PruebaFM() throws Exception{
        pruebi();
        rad.setFrequence("FM");
        assertEquals("FM", rad.getFrequence());
    }

    @Test
    public void PruebaForwardFm() throws Exception{
        pruebi();
        rad.setFrequence("FM");
        rad.Forward();
        assertEquals(88.1, rad.getFMActualStation(), 0.1);
    }

    @Test
    public void PruebaEstacionSave(){
        pruebi();
        rad.saveAMStation(rad.getAMActualStation(), 0);
        assertTrue(rad.getAMSAVED().get(0) == 530);
    }
}
