
package Interr;

import javax.swing.JTextArea;

public class Hilo extends Thread{
    private JTextArea area;
    private Rcompartido rc;
    public boolean entrada=true;
    public boolean cerradura=true;
    private final static int ini=195;
    private final static int fin=200;

    private boolean dead = false;
    
    Hilo(JTextArea area,Rcompartido rc){
        this.area=area;
        this.rc=rc;
       
    }
    
    public void run(){
         while(true){
                    try{
                        if(rc.isEntra()){
                            rc.bloquea();
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido() + "\n");
                            if(isDead()){
                                stop();
                            }
                            rc.desbloquea();
                        }else{
                            area.append("Esperando...\n");
                        }
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
    }
    
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    public void Stop(){
        entrada = false;
    }
    
}
