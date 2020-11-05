
package Interr;

import java.util.ArrayList;

public class Rcompartido {

    private String datoCompartido;
    private ArrayList<Interrupcion> interrupciones;

    
    Rcompartido(){
        datoCompartido="";
       interrupciones = new ArrayList<Interrupcion>();
        for(int i=0;i<10;i++){
            interrupciones.add(new Interrupcion());
        }
      
    }
    
    public String getDatoCompartido() {
        boolean ban =false;
    return datoCompartido;
    }
    

 
    public void setDatoCompartido (String datoCompartido) {
       
        this.datoCompartido = datoCompartido;

    }
    
    
    public ArrayList<Interrupcion> getInterrupciones(){
        return interrupciones;
    }
    public void setInterrupciones(ArrayList<Interrupcion> interrupciones){
        this.interrupciones = interrupciones;
    }
    public void bloquea(){
        for(Interrupcion i: interrupciones){
            i.setInter(false);
        }
    }
    public void desbloquea(){
        for(Interrupcion i: interrupciones){
            i.setInter(true);
        }    
    }
    public boolean isEntra(){
        boolean ban = false;
        for(Interrupcion i: interrupciones)
            if(i.isInter()){
                ban=true;
            }else {
                return false;
            }
        return ban;
    }
}