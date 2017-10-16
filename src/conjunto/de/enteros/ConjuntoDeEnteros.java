package conjunto.de.enteros;

public class ConjuntoDeEnteros {
    
    private int[] conjunto;
    
    public ConjuntoDeEnteros(){
        conjunto = new int[0];
    }
    
    public ConjuntoDeEnteros(int[] arr){
        if(arr.length == 0){
            conjunto = new int[0];
        }else{
            int[] auxArr = new int[10];
            int auxArrIndice = 0;
            for (int i = 0; i < arr.length; i++) {
                if(validoAux(auxArr, arr[i]) && auxArrIndice <=9){
                    auxArr[auxArrIndice] = arr[i];
                    auxArrIndice++;
                }
            }
            /*******************************
             *      INSERT
             *            ARRAYCOPY
             *                      HERE
             ********************************/
        }
        
    }
    
    private boolean validoAux(int[] arr, int value){
        for(int i =0; i<arr.length; i++){        
            if(arr[i]==value)return false;
        }
        return true;
    }
    
    public int cardinal(){
        return conjunto.length;
    }
    
    public boolean estáVacío(){
        return conjunto.length == 0 /*&& Comprobar tambien que no contenga "nulls"*/;
    }
    
    public boolean añade(int newValue){
        /*************************
         *  IMPLEMENTATION
         *      WITH
         *    ARRAYCOPY
         *************************/ 

        return !(conjunto.length == 10 || !validoAux(conjunto, newValue));
    }
    
    public boolean pertenece(int value){
        for(int i =0; i<conjunto.length; i++){        
            if(conjunto[i]==value)return false;
        }
        return true;
    }
    
    
    public ConjuntoDeEnteros union(ConjuntoDeEnteros compared){
        int[] aux = new int[10];
        int auxIndice = 0;
        if(compared.cardinal() <= conjunto.length){
            if(contenido(compared))return compared;
            for (int i = 0; i < compared.cardinal(); i++) {
                if(pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                }
            }
        }else{
            if(compared.contenido(this))return this;
            for (int i = 0; i < cardinal(); i++) {
                if(pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                }
            }   
        }
        int[] resultArr = new int[]{1};
        /****************************
         *      AJUSTAR CON
         *       ARRAYCOPY
         ****************************/
        return new ConjuntoDeEnteros(resultArr);
    }
    
    public ConjuntoDeEnteros interseccion(ConjuntoDeEnteros compared){
        return null;
    }
    
    public ConjuntoDeEnteros diferencia(ConjuntoDeEnteros compared){
        return null;
    }
    
    public boolean equals(ConjuntoDeEnteros compared){
        if(compared.cardinal() == cardinal()){
            for (int i = 0; i < conjunto.length; i++) {
                if(!pertenece(compared.conjunto[i]))return false;
            }
            return true;
        }
        return false;
    }
    
    public boolean contenido(ConjuntoDeEnteros compared){
        if(compared.cardinal() <= conjunto.length){
            for (int i = 0; i < compared.cardinal(); i++) {
                if(!pertenece(compared.conjunto[i])){
                    return false;
                }
            }
            return true;
        }else{
            for (int i = 0; i < cardinal(); i++) {
                if(!pertenece(compared.conjunto[i])){
                    return false;
                }
            }
            return true;
            
        }
    }
    
    public int[] elementos(){
        return conjunto;
    }
}
