//Importacion de Librerias
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class test extends TestCase{
    radio rad; 

    
    private void pruebi (){ //Iteración de Radio de Prueba 
        rad = new radio();
    }
    
    @Test
    public void TestActualAm(){ //Prueba para confirmar que la funcion Forward funciona correctamente en caso de estar en modo AM
        pruebi();
        rad.Forward();
        assertEquals(540, rad.getAMActualStation());
    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void PruebaFM() throws Exception{ //Prueba para confirmar que la funcion setFrequence funciona correctamente 
        pruebi();
        rad.setFrequence("FM");
        assertEquals("FM", rad.getFrequence());
    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void PruebaForwardFm() throws Exception{ //Prueba para confirmar que la funcion Forward funciona correcamente en caso de estar en modo FM
        pruebi();
        rad.setFrequence("FM");
        rad.Forward();
        assertEquals(88.1, rad.getFMActualStation(), 0.1);
    }

    @Test
    public void PruebaEstacionSave(){ //Prueba para confirmar que la funcion saceAMStation funciona correctamente 
        pruebi();
        rad.saveAMStation(rad.getAMActualStation(), 0);
        assertTrue(rad.getAMSAVED().get(0) == 530);
    }
}
