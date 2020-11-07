aspect cambio{
	
	
	pointcut success(String streams) : call(* cambiarColorFondo(*)) && args(streams)  ;
    after(String plataforma) : success(plataforma) {
    	switch(plataforma) {
    	  case "Facebook Gaming":
    	    System.out.println("Se ha modificado el color del fondo a Azul");
    	    break;
    	  case "Twitch":
    		  System.out.println("Se ha modificado el color del fondo a Morado");
    	    break;
    	  case "Youtube Gaming":
    		  System.out.println("Se ha modificado el color del fondo a Rojo");
    	    break;
    	  default:
    	    System.out.println("Se ha modificado el color del fondo a Rojo Oscuro");
    	    }
    }
}
