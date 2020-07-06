public class Tiempo{
  private int unidadDeTiempo;
  private int limite;

  public Tiempo (){
    this.unidadDeTiempo=unidadDeTiempo;
    this.limite=limite;
  } 
  
  public void setUnidadDeTiempo(int unidadDeTiempo){
    this.unidadDeTiempo=unidadDeTiempo;  
  }
  public int getUnidadDeTiempo(){
    return this.unidadDeTiempo; 
  }
  
  public void setLimite(int limite){
    this.limite=limite;  
  }
  public int getLimite(){
    return this.limite; 
  }
  
  public void Avanzar () {
	 unidadDeTiempo++;
	 if(unidadDeTiempo==limite) {
		 unidadDeTiempo=0;
	  	     }
  }
}
