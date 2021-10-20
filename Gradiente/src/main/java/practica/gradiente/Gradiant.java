package practica.gradiente;

public class Gradiant {
    
    HelperArithmetic aux = new HelperArithmetic();
    
    private double beta0, beta1, a;
    
    //Constructor
    public Gradiant(){
        this.beta0 = 0;
        this.beta1 = 0;
        this.a = 0.003;
    }
    
    //Setters y Getters
    public void setBeta0(double aux){   this.beta0 = aux;   }
    public double getBeta0(){   return this.beta0;  }
    
    public void setBeta1(double aux){   this.beta1 = aux;   }
    public double getBeta1(){   return this.beta1;  }
    
    public void setA(double aux){   this.a = aux;   }
    public double getA(){   return this.a;  }
    
    //Aplicacion del metodo Gradiente descendiente
    public void Metod(){
        
        double e = aux.Error(getBeta0(), getBeta1());
        
        System.out.println("Error inicial = " + e);
        
         while(e > 0){
            double alfa = getA();
            
            double auxBeta0 = alfa * aux.derB0(getBeta0(),getBeta1());
            double auxBeta1 = alfa * aux.derB1(getBeta0(),getBeta1());
             
            setBeta0(getBeta0() - auxBeta0);
            setBeta1(getBeta1() - auxBeta1);
            
            e = aux.Error(getBeta0(), getBeta1());
            
            System.out.println("Error en el ciclo = " + e);
         }
        System.out.println("Beta0 = " + getBeta0());
        System.out.println("Beta1 = " + getBeta1());
    }
}
