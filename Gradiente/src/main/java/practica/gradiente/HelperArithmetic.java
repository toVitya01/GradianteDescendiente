package practica.gradiente;
//Importa bigdecimal

public class HelperArithmetic {
    
    DataSet aux = new DataSet();
    
    //Constructor
    public HelperArithmetic(){};
    
    //Calcula el error respecto a los valores actuales de beta0 y beta 1
    public double Error(double beta0, double beta1){
        double resultado = 0;
        double[] auxX = aux.getX();
        double[] auxY = aux.getY();
        int n = aux.getN();
        
        for(int i = 0; i < aux.getN(); i++){
            resultado = Math.sqrt(auxY[i] - beta0 - (beta1 * auxX[i]));
        }
        resultado = resultado / n; 
        return resultado;
    } 
    
    //Sustituye los valores de beta0 y beta1 en la derivada parcial respecto a beta0
    public double derB0(double beta0, double beta1){//Mejor que retorne BigDecimal
        double resultado = 0;
        double[] auxX = aux.getX();
        double[] auxY = aux.getY();
        int n = aux.getN();
        
        for(int i = 0; i < aux.getN(); i++){
            resultado = auxY[i] - beta0 - (beta1 * auxX[i]);
        }
        resultado = -2 * resultado;
        resultado = resultado / n;
        return resultado;
    } 
    
    //Sustituye los valores de beta0 y beta1 en la derivada parcial respecto a beta1
    public double derB1(double beta0, double beta1){
        double resultado = 0;
        double[] auxX = aux.getX();
        double[] auxY = aux.getY();
        int n = aux.getN();
        
        for(int i = 0; i < aux.getN(); i++){
            resultado = auxX[i] * (auxY[i] - beta0 - (beta1 * auxX[i]));
        }
        resultado = -2 * resultado;
        resultado = resultado / n;
        return resultado;
    } 
}
