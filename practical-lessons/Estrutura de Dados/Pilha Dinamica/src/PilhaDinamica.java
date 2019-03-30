public class PilhaDinamica {

	NoSimples topo;
	public PilhaDinamica() {
	   topo = null;
	 }
	public boolean isEmpty () {
	   return topo==null;
	 }
	public void push (Object o){
	 NoSimples novoNo= new NoSimples();
	 novoNo.setObjeto(o);
	 novoNo.setProx(topo);
	topo =novoNo; 
	}
	public Object top() {
	if(!isEmpty ()) {
	return topo.getDado();
	}
	else
	return null;
	}
	public Object pop() {
		if (!isEmpty()) {
		Object retorno = topo.getDado();
		topo=topo.getProx();		
		return retorno;
		
		}
		else
		return null;
		}
		public void stackState () {//usar o string builder;
		if (!isEmpty()) {
		String resp=new String();
		NoSimples aux;
		aux=topo;
		while(aux!=null) {
		resp= aux.getDado().toString() + ", " + resp;
		aux = aux.getProx();
		}
		System.out.println("P:["+resp+"]");
		}else
		System.out.println("Pilha vazia");
		}
		}
