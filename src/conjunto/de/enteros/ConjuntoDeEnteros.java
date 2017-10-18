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
            conjunto = new int[auxArrIndice];
            System.arraycopy(auxArr, 0, conjunto, 0, auxArrIndice);
        }
        
    }
    
    //Método auxiliar que comprueba si un elemento se haya repetido en un vector
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
        return conjunto.length == 0;

    }
    
    public boolean añade(int newValue){
        
        if(!(conjunto.length == 10) || validoAux(conjunto, newValue)){
            int[] aux = new int[conjunto.length+1];
            System.arraycopy(conjunto, 0, aux, 0, conjunto.length);
            aux[conjunto.length+1] = newValue;
            conjunto = aux;
        }
        return false;
    }
    
    public boolean pertenece(int value){
        for(int i =0; i<conjunto.length; i++){        
            if(conjunto[i]==value)return false;
        }
        return true;
    }
    
    
    public ConjuntoDeEnteros union(ConjuntoDeEnteros compared){
        if(contenido(compared))return this;
        if(compared.contenido(this))return compared;
        
        int[] aux = new int[conjunto.length + compared.conjunto.length];
        System.arraycopy(conjunto, 0, aux, 0, conjunto.length);
        System.arraycopy(compared.conjunto, 0, aux, conjunto.length-1, compared.conjunto.length);
        return new ConjuntoDeEnteros(aux);
    }
    
    public ConjuntoDeEnteros interseccion(ConjuntoDeEnteros compared){
        int[] aux = new int[10];
        int auxIndice = 0;
        if(compared.cardinal() <= conjunto.length){
            if(contenido(compared))return compared;
            for (int i = 0; i < compared.cardinal(); i++) {
                if(pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                    auxIndice++;
                }
            }
        }else{
            if(compared.contenido(this))return this;
            for (int i = 0; i < cardinal(); i++) {
                if(pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                    auxIndice++;
                }
            }   
        }
        return new ConjuntoDeEnteros(aux);
    }
    
    public ConjuntoDeEnteros diferencia(ConjuntoDeEnteros compared){
        int[] aux = new int[10];
        int auxIndice = 0;
        if(compared.cardinal() <= conjunto.length){
             for (int i = 0; i < compared.cardinal(); i++) {
                if(!pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                    auxIndice++;
                }
            }
            if(auxIndice < cardinal()){
                System.arraycopy(elementos(), auxIndice, aux, auxIndice, cardinal()-auxIndice);
            }
        }else{
            for (int i = 0; i < cardinal(); i++) {
                if(!pertenece(compared.conjunto[i])){
                    aux[auxIndice] = compared.conjunto[i];
                    auxIndice++;
                }
            }
            if(auxIndice < cardinal()){
                System.arraycopy(elementos(), auxIndice, aux, auxIndice, cardinal()-auxIndice);
            }
        }
        return new ConjuntoDeEnteros(aux);
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
