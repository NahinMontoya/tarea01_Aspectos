  import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

aspect Registro {
	
	File file = new File("log.txt" );
	Calendar cal = Calendar.getInstance();
	
	pointcut success(String color) : call(* cambiarColorFondo(*)) && args(color)  ;
	after(String color) : success(color) {
		String date = cal.getTime().toString();
    	try {
    		if(!file.exists()){
    			file.createNewFile();
    		}
	    	FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
	    	BufferedWriter bf = new BufferedWriter(fw);
	    	bf.write("Ha ingresado a: "+ color+ " en fecha: "+ date +"\n");
	    	bf.close();
	    	System.out.println("Log registrado.");
    	}catch(Exception e){
    		System.out.println("Error al guardar el log en:"+ e + ", en la fecha: " + date);
    	}
    }

}