//Importacion de Librerias
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class radio implements IRadio{
    boolean encendida = false;
    String Frecuencia = "FM";
    double FM = 92;
    int AM = 600;
    int[] ListaAM = new int[13];
    double[] ListaFM = new double[13];
    


    @Override
    public void on() {
        encendida = true;
    }

    @Override
    public void off() {
        encendida = false;
    }

    @Override
    public boolean isOn() {
        return encendida;
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        Frecuencia = freq;
    }

    @Override
    public String getFrequence() {
        return Frecuencia;
    }

    @Override
    public void Forward() {
        if(Frecuencia.equals("FM")){
            FM = FM + 0.2;
            if(FM>107.9){
                FM = 87.9;
            }
        }
        if(Frecuencia.equals("AM")){
            AM = AM +10;
            if(AM >1610){
                AM = 530;
            }
        }
        
    }

    @Override
    public void Backward() {

        if(Frecuencia.equals("FM")){
            FM = FM - 0.5;
            if(FM<87.9){
                FM = 107.9;
            }
        }
        if(Frecuencia.equals("AM")){
            AM = AM -10;
            if(AM<530){
                AM = 1610;
            }
        }
        
    }

    @Override
    public double getFMActualStation() {
        return FM;
    }

    @Override
    public int getAMActualStation() {
        return AM;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        FM = actualStation;
        
    }

    @Override
    public void setAMActualStation(int actualStation) {
        AM = actualStation;
    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        ListaFM[slot] = actualStation;
    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        ListaAM[slot] = actualStation;

    }

    @Override
    public double getFMSlot(int slot) {
        return ListaFM[slot];
    }

    @Override
    public int getAMSlot(int slot) {
        return ListaAM[slot];
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    public String getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        Frecuencia = frecuencia;
    }

    public double getFM() {
        return FM;
    }

    public void setFM(double fM) {
        FM = fM;
    }

    public int getAM() {
        return AM;
    }

    public void setAM(int aM) {
        AM = aM;
    }

    public int[] getListaAM() {
        return ListaAM;
    }

    public void setListaAM(int[] listaAM) {
        ListaAM = listaAM;
    }

    public double[] getListaFM() {
        return ListaFM;
    }

    public void setListaFM(double[] listaFM) {
        ListaFM = listaFM;
    }
    



    
}
