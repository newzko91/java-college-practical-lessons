public class Main {

    public static void main(String[] args) {
	    MontaFrase objFrase = new MontaFrase();
	    String frase1 = null;
	    String frase2 = null;
	    
	    try {
	        frase2 = objFrase.AumentaFrase(frase1);
	        System.out.println("A frase é: "+frase2);
	    } catch (Exception objexc){
	        System.out.println("Não há frase para redimensionar!");
	        //System.out.println(frase2);
	    }
    }
}
