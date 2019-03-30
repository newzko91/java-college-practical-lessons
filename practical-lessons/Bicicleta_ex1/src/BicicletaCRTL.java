
public class BicicletaCRTL {

	public static void main(String[] args) {
		
		
		Caloi bicicleta_caloi = new Caloi();
		Bicicleta bicicleta_monarque = new Monarque();
		
		bicicleta_caloi.setVelocidade(50);
		bicicleta_caloi.setEnferruja(false);
		
		bicicleta_monarque.setVelocidade(30);
		bicicleta_monarque.setCor("amarela");
		
		
		System.out.println("A cor da Caloi é: " +bicicleta_caloi.getCor());
		System.out.println("A cor da Monarque é: " +bicicleta_monarque.getCor());
		
		System.out.println("A Caloi enferruja? " +bicicleta_caloi.isEnferruja());
		System.out.println("A Monarque enferruja? " +bicicleta_monarque.isEnferruja());
		
		System.out.println("A velocidade máxima da Caloi é: " +bicicleta_caloi.getVelocidade() +"km/h");
		System.out.println("A velocidade máxima da Monarque é: " +bicicleta_monarque.getVelocidade() +"km/h");
		
		System.out.println("O tamanho da roda da Caloi: " +bicicleta_caloi.getAro());
		System.out.println("O tamanho da roda da Monarque: " +bicicleta_monarque.getAro());
	
		
		
	}

}
