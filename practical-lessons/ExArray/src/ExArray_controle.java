public class ExArray_controle {
		
	public static void main(String[] args) {
		ExArray[] objArray = new ExArray[2];
		
		//Para tipos complexos é necessário chamar o construtor
		for(int i=0; i<=objArray.length-1;i++) {
			objArray[i] = new ExArray();
		}
		
		objArray[0].nome = "Teste1";
		objArray[1].nome = "Teste2";
		
		for(int i=0; i<=objArray.length-1;i++) {
			System.out.println(objArray[i].nome);
		}
		
	/*	System.out.println(objArray[0].nome);
		System.out.println(objArray[1].nome);
		System.out.println(objArray.length);
	*/
		
	}	
}		