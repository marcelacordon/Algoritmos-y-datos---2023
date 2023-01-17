//Importacion de Librerias
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class radio implements IRadio{
    private boolean onoff = true; // para ver si está apagado o encendido
    private String frequencetype = "AM"; //para ver si está en AM, FM o guardadas
    private int AMstation = 530; // para ver la estación en la que se encuentra al estar en AM
    private double FMstation = 87.9 ; // para ver la estación en la que se encuentra al estar en FM
    private ArrayList<Integer> AMSAVED = new ArrayList<Integer> (); //para guardar en los 12 slots emisoras de AM
    private ArrayList<Double> FMSAVED = new ArrayList<Double> (); //para guardar en los 12 slots emisoras de AM
    DecimalFormat df = new DecimalFormat("#.#"); //Para lograr que los decimales de las emisoras tipo FM se guarden solo con un numero decimal

    radio(){ 
        AMSAVED.add(530);
        AMSAVED.add(540);
        AMSAVED.add(550);
        AMSAVED.add(560);
        AMSAVED.add(570);
        AMSAVED.add(580);
        AMSAVED.add(590);
        AMSAVED.add(600);
        AMSAVED.add(610);
        AMSAVED.add(620);
        AMSAVED.add(630);
        AMSAVED.add(640);
        FMSAVED.add(87.9);
        FMSAVED.add(88.1);
        FMSAVED.add(88.3);
        FMSAVED.add(88.5);
        FMSAVED.add(88.9);
        FMSAVED.add(89.1);
        FMSAVED.add(89.3);
        FMSAVED.add(89.5);
        FMSAVED.add(89.9);
        FMSAVED.add(90.1);
        FMSAVED.add(90.3);
        FMSAVED.add(90.5);

    }

    // utilizado para prender la radio 
    @Override
    public void on() {
        // TODO Auto-generated method stub
        onoff = true;
        
    }
    // utilizado para apagar la radio 
    @Override
    public void off() {
        // TODO Auto-generated method stub
        onoff = false;
        
    }

    // indica si la radio esta prendida o apagadan
    /** 
     * @return boolean
     */
    @Override
    public boolean isOn() {
        // TODO Auto-generated method stub
        return onoff;
    }

    //es para cambiar de FM a AM, o los guardados 
    /** 
     * @param freq
     * @throws Exception
     */
    @Override
    public void setFrequence(String freq) throws Exception {
        // TODO Auto-generated method stub
        frequencetype = freq;
        
    }

    //se utiliza para obtener si es AM o FM 
    /** 
     * @return String
     */
    @Override
    public String getFrequence() {
        // TODO Auto-generated method stub
        return frequencetype;
    }

    // metodo utilizado para adelantar las estaciones de radio, para FM sube 0.2 cada vez y en AM sube de 10 en 10 
    @Override
    public void Forward() {
        // TODO Auto-generated method stub
        if (frequencetype == "AM"){
            if (AMstation < 1610){
                AMstation = AMstation + 10;
            }
            else if ( AMstation >= 1610){
                AMstation = 530;
            }
        }
        else if (frequencetype == "FM"){
            if (FMstation < 107.9){
                FMstation = FMstation + 0.2;
                df.setRoundingMode(RoundingMode.HALF_UP);
                FMstation = Double.parseDouble(df.format(FMstation));
            }
            else if (FMstation >= 107.9){
                FMstation = 87.9;
            }
        }
    }

    // metodo utilizado para atrasar las estaciones de radio, para FM baja de 0.2 en 0.2 cada vez y en AM baja de 10 en 10
    @Override
    public void Backward() {
        // TODO Auto-generated method stub
        if (frequencetype == "AM"){
            if (AMstation > 530){
                AMstation = AMstation - 10;
            }
            else if ( AMstation == 530){
                AMstation = 1610;
            }
        }
        else if (frequencetype == "FM"){
            if (FMstation > 87.9){
                FMstation = FMstation - 0.2;
                df.setRoundingMode(RoundingMode.HALF_UP);
                FMstation = Double.parseDouble(df.format(FMstation));
            }
            else if (FMstation == 87.9){
                FMstation = 107.9;
            }
        } 
    }


    // obtener en que estacion se encuentra el usuario, cuando esta en la frequencia FM
    /** 
     * @return double
     */
    @Override
    public double getFMActualStation() {
        // TODO Auto-generated method stub
        return FMstation;
    }

    // obtener en que estacion se encuentra el usuario, cuando esta en la frequencia AM
    /** 
     * @return int
     */
    @Override
    public int getAMActualStation() {
        // TODO Auto-generated method stub
        return AMstation;
    }

    //utilizado para colocar en que estacion se encuentra el usuario en la frequencia FM 
    /** 
     * @param actualStation
     */
    @Override
    public void setFMActualStation(double actualStation) {
        // TODO Auto-generated method stub
        FMstation = actualStation;
        
    }

    //utilizado para colocar en que estacion se encuentra el usuario en la frequencia AM 
    /** 
     * @param actualStation
     */
    @Override
    public void setAMActualStation(int actualStation) {
        // TODO Auto-generated method stub
        AMstation = actualStation;
    }

    //utilizado para guardar la estaciones en uno de los 12 slots en FM 
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveFMStation(double actualStation, int slot) {
        // TODO Auto-generated method stub
        FMSAVED.set(slot,actualStation);
        
    }

    //utilizado para guardar la estaciones en uno de los 12 slots en AM 
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveAMStation(int actualStation, int slot) {
        // TODO Auto-generated method stub
        AMSAVED.set(slot, actualStation);
    }

    //utilizado para obtener en que slot esta guardada la estacion en FM 
    /** 
     * @param slot
     * @return double
     */
    @Override
    public double getFMSlot(int slot) {
        // TODO Auto-generated method stub
        return FMSAVED.get(slot);
    }

    //utilizado para obtener en que slot esta guardada la estacion en AM 
    /** 
     * @param slot
     * @return int
     */
    @Override
    public int getAMSlot(int slot) {
        // TODO Auto-generated method stub
        return AMSAVED.get(slot);
    }




    
    /** 
     * @return boolean
     */
    // indica si esta prendido o apagado, prendido(true) y apagado (false)
    public boolean isOnoff() {
        return onoff;
    }
    
    /** 
     * @param onoff
     */
    // para actualizar el estado de la radio, si esta on u off
    public void setOnoff(boolean onoff) {
        this.onoff = onoff;
    }

    
    /** 
     * @return String
     */
    //para obtener en que tipo de frequencia se encuentra el usuario 
    public String getFrequencetype() {
        return frequencetype;
    }

    
    /** 
     * @param frequencetype
     */
    //utilizado para actualizar el 
    public void setFrequencetype(String frequencetype) {
        this.frequencetype = frequencetype;
    }

    
    /** 
     * @return int
     */
    //obtener en que estacion se encuentra en el AM 
    public int getAMstation() {
        return AMstation;
    }

    
    /** 
     * @param aMstation
     */
    //actualizar en que estacion se encuentra en el AM 
    public void setAMstation(int aMstation) {
        AMstation = aMstation;
    }

    
    /** 
     * @return double
     */
    //obtener en que estacion se encuentra en el FM 
    public double getFMstation() {
        return FMstation;
    }

    
    /** 
     * @param fMstation
     */
    //actualizar en que estacion se encuentra en el AM 
    public void setFMstation(double fMstation) {
        FMstation = fMstation;
    }

    
    /** 
     * @return ArrayList<Integer>
     */
    //para obtener la lista de las estaciones en AM 
    public ArrayList<Integer> getAMSAVED() {
        return AMSAVED;
    }

    
    /** 
     * @param aMSAVED
     */
    //para actualizar la lista de las estaciones en AM 
    public void setAMSAVED(ArrayList<Integer> aMSAVED) {
        AMSAVED = aMSAVED;
    }

    
    /** 
     * @return ArrayList<Double>
     */
    //para obtener la lista de las estaciones en FM 
    public ArrayList<Double> getFMSAVED() {
        return FMSAVED;
    }

    
    /** 
     * @param fMSAVED
     */
    //para actualiz la lista de las estaciones en FM 
    public void setFMSAVED(ArrayList<Double> fMSAVED) {
        FMSAVED = fMSAVED;
    }
    
    
    
}
