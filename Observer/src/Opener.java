import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Opener {
	
	public static void abrirBrowser(String enlace) {
	    Desktop browser = Desktop.getDesktop();
	    try {
	        browser.browse(new URI(enlace));
	    } catch (IOException | URISyntaxException e) {
	        System.out.println("Error");
	    }
	}
}
