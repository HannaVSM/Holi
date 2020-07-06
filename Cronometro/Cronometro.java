import java.util.TimerTask;
public class Cronometro {

  Segundero segundos;
  Minutero minutos;
  Horario horas;
  
	  public Segundero getSegundos(){
	    return this.segundos; 
	  }
	  public Minutero getMinutos(){
		    return this.minutos; 
		  }
	  public Horario getHoras(){
		    return this.horas; 
		  }

  public Cronometro (){
    segundos= new Segundero();
    minutos = new Minutero();
    horas = new Horario();
  }

	 	public void Start (){
//	  		System.out.println(horas.getUnidadDeTiempo()+":	"+minutos.getUnidadDeTiempo()+":	"+segundos.getUnidadDeTiempo());	
	  		segundos.Avanzar();
	  	  		if(segundos.getUnidadDeTiempo()==0) {
	  	  			minutos.Avanzar();
	  	  			if(minutos.getUnidadDeTiempo()==0) {
	  	  				horas.Avanzar();
	  	  				}
	  	  			}
 }
// public void ActualizarLable() {
//	  String Tiempo= ((cronometro.getSegundos().getUnidadDeTiempo())<= 9 ? "0" : "")+
//		    	(cronometro.getMinutos().getUnidadDeTiempo()<= 9 ? "0" : "")+
//		    	(cronometro.getHoras().getUnidadDeTiempo()<= 9 ? "0" : "");
//	  LabelContador.setText(Tiempo);
// }
// public String ActualizarLabel() {
//	  String Tiempo= ((segundos.getUnidadDeTiempo()<= 9 ? "0" : "")+(minutos.getUnidadDeTiempo()<= 9 ? "0" : "")+(horas.getUnidadDeTiempo()<= 9 ? "0" : ""));
//	  return Tiempo;
// }

}

