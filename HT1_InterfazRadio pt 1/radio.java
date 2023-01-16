import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class radio implements IRadio{
    private ArrayList<Integer> AM = new ArrayList<Integer>();//lista de todas las emisoras posibles
    private ArrayList<Double> FM = new ArrayList<Double>(); // lista de todas las emisoras posibles
    private ArrayList<Integer> AMSAVED = new ArrayList<Integer>();//donde va a poder guardar las favoritas
    private ArrayList<Double> FMSAVED = new ArrayList<Double>();//donde va a poder guardar las favoritas
    private boolean prendidopapito; // indica si esta prendido (true) o apagado (false)
    private String amorfm; // Frecuencia de la radio
    private int actualam; // indica indice en que estacion se quedo en AM (Array List AM)
    private int actualfm; // indica indice en que estacion se quedo en FM (Array List FM)
    private int actualslotam;// indica indice en cual de los 12 slot esta guardado en AM (Array List AMSAVED)
    private int actualslotfm; // indica indice en cual de los 12 slot esta guardado en FM (Array List FAMSAVED)
    private int ambaby; //es el numero de am que esta
    private double fmpapi; // numero de fm que esta
    private int savedambaby;//guardado am number
    private double savedfmpapi; //guardado fm number

    radio() throws FileNotFoundException{
        AM = radioamArrayList("AM.txt", AM);
        FM = radiofmArrayList( "FM.txt", FM);
        prendidopapito = true;
        amorfm = "AM";
        actualam = 0;
        actualfm = 0;
        actualslotam = 0;
        actualslotam =0;
        ambaby = AM.get(actualam);
        fmpapi = FM.get(actualfm);
        actualslotam =0;
        actualfm =0;
    }

    public ArrayList<Integer> radioamArrayList(String filenam, ArrayList<Integer> am) throws FileNotFoundException{
        File filename = new File(filenam);
        //crea las canciones que tengo en mi archivo de playlists
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            int u = Integer.parseInt(data[0]) ;
            am.add(u);
        } 
        sc.close();
        return am;
    }
    public ArrayList<Double> radiofmArrayList(String filenam, ArrayList<Double> fm) throws FileNotFoundException{
        File filename = new File(filenam);
        //crea las canciones que tengo en mi archivo de playlists
        String[] data;
        Scanner sc = new Scanner(filename);
        while (sc.hasNextLine()) {
            data =sc.nextLine().split(";");
            Double u = Double.parseDouble(data[0])  ;
            fm.add(u);
        } 
        sc.close();
        return fm;
    }



    @Override
    public void on() {
        //encender radio
        prendidopapito = true;
        
    }

    @Override
    public void off() {
        // apagar radio
        prendidopapito = false;
    }

    
    /** para ver si esta apagado o encendido el radio
     * @return boolean
     */
    @Override
    public boolean isOn() {
        boolean on = prendidopapito;
        if (prendidopapito == true){
            on = true;
        }
        else if (prendidopapito == false){
            on = false;
        }
        return on;
    }

    
    /** para cambiar de frecuencia
     * @param freq
     * @throws Exception
     */ // 
    @Override
    public void setFrequence(String freq) throws Exception {
        amorfm = freq;
    }

    
    /** 
     * @return String
     */ // permite obetener en que frecuencia se encuentra  
    @Override
    public String getFrequence() {
        return amorfm;
    }

    @Override
    // ir cambiando de estacion en estacion para adelante 
    public void Forward() {
        
        if (amorfm == "AM"){
            if (actualam < AM.size()){
                actualam = actualam + 1;
                ambaby = AM.get(actualam);

            }
            else if (actualam > AM.size()){
                ambaby = AM.get(0);
                actualam = 0;
            }
        }
        else if (amorfm == "FM"){
            if (actualfm < FM.size()){
                actualfm = actualfm + 1;
                fmpapi = FM.get(actualfm);
            }
            else if (actualam > AM.size()){
                fmpapi = FM.get(0);
                actualam = 0;
            }
        }
        else if (amorfm == "Saved AM"){
            if (actualslotam < AMSAVED.size()){
                actualslotam = actualslotam + 1;
                savedambaby = AMSAVED.get(actualslotam);
            }
            else if (actualslotam > AMSAVED.size()){
                savedambaby = AMSAVED.get(0);
                actualslotam = 0;
            }
        }
        else if (amorfm == "Saved FM"){
            if (actualslotfm < FMSAVED.size()){
                actualslotfm = actualslotfm + 1;
                savedfmpapi = FMSAVED.get(actualslotfm);
            }
            else if (actualslotfm > FMSAVED.size()){
                savedfmpapi = FMSAVED.get(0);
                actualslotfm = 0;
            }
        }
    }

    @Override
    public void Backward() {
        //pasar a la siguiente estación
        if (amorfm == "AM"){
            if (actualam > 0){
                actualam = actualam - 1;
                ambaby = AM.get(actualam);

            }
            else if (actualam == 0){
                ambaby = AM.get(AM.size());
                actualam = AM.size();
            }
        }
        else if (amorfm == "FM"){
            if (actualfm > 0){
                actualfm = actualfm - 1;
                fmpapi = FM.get(actualfm);
            }
            else if (actualam == 0){
                fmpapi = FM.get(FM.size());
                actualam = FM.size();
            }
        }
        else if (amorfm == "Saved AM"){
            if (actualslotam > AMSAVED.size()){
                actualslotam = actualslotam - 1;
                savedambaby = AMSAVED.get(actualslotam);
            }
            else if (actualslotam > AMSAVED.size()){
                savedambaby = AMSAVED.get(0);
                actualslotam = 0;
            }
        }
        else if (amorfm == "Saved FM"){
            if (actualslotfm > FMSAVED.size()){
                actualslotfm = actualslotfm - 1;
                savedfmpapi = FMSAVED.get(actualslotfm);
            }
            else if (actualslotfm > FMSAVED.size()){
                savedfmpapi = FMSAVED.get(0);
                actualslotfm = 0;
            }
        }
    }

    
    /** 
     * @return double
     */
    @Override
    public double getFMActualStation() {
        // TODO Auto-generated method stub
        return fmpapi;
    }

    
    /** 
     * @return int
     */
    @Override
    public int getAMActualStation() {
        // TODO Auto-generated method stub
        return ambaby;
    }

    
    /** 
     * @param actualStation
     */
    @Override
    public void setFMActualStation(double actualStation) {
        // TODO Auto-generated method stub
        fmpapi = actualStation;
    }

    
    /** 
     * @param actualStation
     */
    @Override
    public void setAMActualStation(int actualStation) {
        // TODO Auto-generated method stub
        ambaby = actualStation;
        
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveFMStation(double actualStation, int slot) {
        // TODO Auto-generated method stub
        FMSAVED.add(slot, actualStation);
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    @Override
    public void saveAMStation(int actualStation, int slot) {
        // TODO Auto-generated method stub
        AMSAVED.add(slot, actualStation);
    }

    
    /** 
     * @param slot
     * @return double
     */
    @Override
    public double getFMSlot(int slot) {
        // TODO Auto-generated method stub

        return actualslotfm;
    }

    
    /** 
     * @param slot
     * @return int
     */
    @Override
    public int getAMSlot(int slot) {
        // TODO Auto-generated method stub
        return actualam;
    }





    //estos ya solo son gets y sets

    /** 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getAM() {
        return AM;
    }

    
    /** 
     * @param aM
     */
    public void setAM(ArrayList<Integer> aM) {
        AM = aM;
    }

    
    /** 
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getFM() {
        return FM;
    }

    
    /** 
     * @param fM
     */
    public void setFM(ArrayList<Double> fM) {
        FM = fM;
    }

    
    /** 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getAMSAVED() {
        return AMSAVED;
    }

    
    /** 
     * @param aMSAVED
     */
    public void setAMSAVED(ArrayList<Integer> aMSAVED) {
        AMSAVED = aMSAVED;
    }

    
    /** 
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getFMSAVED() {
        return FMSAVED;
    }

    
    /** 
     * @param fMSAVED
     */
    public void setFMSAVED(ArrayList<Double> fMSAVED) {
        FMSAVED = fMSAVED;
    }

    
    /** 
     * @return boolean
     */
    public boolean isPrendidopapito() {
        return prendidopapito;
    }

    
    /** 
     * @param prendidopapito
     */
    public void setPrendidopapito(boolean prendidopapito) {
        this.prendidopapito = prendidopapito;
    }

    
    /** 
     * @return String
     */
    public String getAmorfm() {
        return amorfm;
    }

    
    /** 
     * @param amorfm
     */
    public void setAmorfm(String amorfm) {
        this.amorfm = amorfm;
    }

    public int getActualam() {
        return actualam;
    }

    public void setActualam(int actualam) {
        this.actualam = actualam;
    }

    public int getActualfm() {
        return actualfm;
    }

    public void setActualfm(int actualfm) {
        this.actualfm = actualfm;
    }

    public int getActualslotam() {
        return actualslotam;
    }

    public void setActualslotam(int actualslotam) {
        this.actualslotam = actualslotam;
    }

    public int getActualslotfm() {
        return actualslotfm;
    }

    public void setActualslotfm(int actualslotfm) {
        this.actualslotfm = actualslotfm;
    }

    public int getAmbaby() {
        return ambaby;
    }

    public void setAmbaby(int ambaby) {
        this.ambaby = ambaby;
    }

    public double getFmpapi() {
        return fmpapi;
    }

    public void setFmpapi(double fmpapi) {
        this.fmpapi = fmpapi;
    }

    public int getSavedambaby() {
        return savedambaby;
    }

    public void setSavedambaby(int savedambaby) {
        this.savedambaby = savedambaby;
    }

    public double getSavedfmpapi() {
        return savedfmpapi;
    }

    public void setSavedfmpapi(double savedfmpapi) {
        this.savedfmpapi = savedfmpapi;
    }
    
    
}
