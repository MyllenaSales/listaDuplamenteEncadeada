package listaDuplamenteEncadeada;

public class Lista {
	
	private Celula cabeca;
	private Celula cauda;
	private int totalDeElementos=0;
	
	public void adicionarNoInicio(Object object) {
		if(totalDeElementos==0) {
			Celula c = new Celula(object);
			this.cabeca = c;
			this.cauda = c;
		}else {
			
			Celula c = new Celula( this.cabeca, null,object);
			this.cabeca.setAnterior(c);
			this.cabeca = c;
		}
		this.totalDeElementos ++;
	}
	
	public void adicionarNoFim (Object elemento) {
		if(totalDeElementos==0) {
			adicionarNoInicio(elemento);
		}else {
			
			Celula c = new Celula (null, this.cauda, elemento);
			this.cauda.setProxima(c);
			this.cauda = c;
			
		}
		this.totalDeElementos ++;
	}
	
	public void listarElementos() {
		
		Celula aux = this.cabeca;
		
		for(int i =0; i<totalDeElementos; i++) {
			System.out.println(aux.getElemento());
			aux = aux.getProxima();
		}
	}
	
	public void adicionarPorPosicao (int posicao, Object elemento) {
		
		if(posicao<0 || posicao >totalDeElementos) {
			System.out.println("Posição inválida!");
		}
		if(posicao ==0) {
			adicionarNoInicio(elemento);
		}
		if(posicao==totalDeElementos) {
			adicionarNoFim(elemento);
		}
		if(posicao<totalDeElementos && posicao>0) {
			Celula aux = this.cabeca;
			
			for(int i=0; i<posicao-1;i++) {
				aux = aux.getProxima();
			}
			Celula nova = new Celula(aux, aux.getProxima(),elemento);
	
			nova.setProxima(aux.getProxima());
			aux.setProxima(nova);;
			
			totalDeElementos ++;
		}
	}
	
	public void removerPorPosicao(int posicao) {
		if(posicao>=0 && posicao<=totalDeElementos) {
			
			Celula aux = this.cabeca;
			for(int i =0; i<posicao-1;i++) {
				aux = aux.getProxima();
				
			}
			Celula nova = aux.getProxima();
			aux.setProxima(nova.getProxima());
			nova.getProxima().setAnterior(aux);
			
		
			
		}else {
			System.out.println("Essa posição nem existe");
		}
		totalDeElementos--;
	}
	
	public void removerDoInicio() {
		this.cabeca = this.cabeca.getProxima();
		this.cabeca.setAnterior(null);
		
		totalDeElementos --;
	}
	
	public void removerDoFinal() {
		this.cauda = this.cauda.getAnterior();
		this.cauda.setProxima(null);
		
		totalDeElementos --;
	}

}
