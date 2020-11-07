import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ventana {
	private BorderPane bPane;
	private Background Bg;
	private Button btnfbG;
	private Button btnytb;
	private Button btntwwt;
	private Button btnNt;

	private ImageView imgfbG;
	private ImageView imgtwwt;
	private ImageView imgytb;
	private ImageView imgnt;
	private Label titulo;
	
	
	
	 public Ventana(Stage pstage){
		 	bPane = new BorderPane();
		 	Bg = new Background(new BackgroundFill(Color.BLACK,null,null));
	        titulo = new Label("STREAMS");
	        btnfbG = new Button("Facebook Gaming");
	        btnfbG.setTextFill(Color.web("#0077ff"));
	        btntwwt = new Button("Twitch");
	        btntwwt.setTextFill(Color.web("#ee00ff"));
	        btnytb = new Button("Youtube Gaming");
	        btnytb.setTextFill(Color.web("#ff0036"));
	        btnNt = new Button("Netflix");
	        btnNt.setTextFill(Color.web("#cd0724"));
	        bPane.setBackground(Bg);
	        imgfbG = new ImageView(new Image("/recursos/facebook_gaming.png"));
	        imgtwwt = new ImageView(new Image("/recursos/Twitch.png"));
	        imgytb = new ImageView(new Image("/recursos/youtube1.png"));
	        imgnt = new ImageView(new Image("/recursos/Netflix.png"));
	        setActions();
	        ordenarBotones();
	        
	    }


	public void setActions() {
		btnfbG.setOnAction(e-> {
			cambiarColorFondo(btnfbG.getText());
		    Opener.abrirBrowser("www.fb.gg");
		
		});
		btnytb.setOnAction(e->{ 
			cambiarColorFondo(btnytb.getText());
			Opener.abrirBrowser("www.youtube.com/gaming");
			});
		btntwwt.setOnAction(e-> { 
			cambiarColorFondo(btntwwt.getText());
			Opener.abrirBrowser("www.twitch.tv");
			});
		btnNt.setOnAction(e->{ 
			cambiarColorFondo(btnNt.getText());
			Opener.abrirBrowser("www.Netflix.com");
			});
		
		
	}
	
	private void organizarTitulo() {
		
		titulo.setStyle(" -fx-font: 80px Arial;" +"-fx-font-weight: bold;"+
                "    -fx-text-fill: white;" +
                "    -fx-stroke-width: 1;");
        bPane.setTop(titulo);
        bPane.setAlignment(titulo, Pos.TOP_CENTER);
	}
	
	public void ordenarBotones() {
		organizarTitulo();
		VBox fb = new VBox(); 
		VBox yt = new VBox(); 
		VBox tw = new VBox(); 
		VBox nt = new VBox(); 
		fb.getChildren().addAll(imgfbG, btnfbG);
		yt.getChildren().addAll(imgytb, btnytb);
		tw.getChildren().addAll(imgtwwt, btntwwt);
		nt.getChildren().addAll(imgnt, btnNt);
		
		fb.setAlignment(Pos.CENTER);
		tw.setAlignment(Pos.CENTER);
		yt.setAlignment(Pos.CENTER);
		nt.setAlignment(Pos.CENTER);
		
		
		bPane.setCenter(fb);
		fb.setAlignment(Pos.CENTER);
		//Insets(arriba,derecha,abajo,izquierda)
		bPane.setLeft(tw);
		tw.setAlignment(Pos.CENTER);
		bPane.setMargin(tw, new Insets(0,0,0,50));
		bPane.setRight(yt);
		bPane.setMargin(yt, new Insets(0,50,0,0));
		bPane.setBottom(nt);
		bPane.setAlignment(nt, Pos.CENTER);
		bPane.setMargin(nt, new Insets(0,25,50,00));
		
		
				
		TamañoBoton(imgfbG);
		TamañoBoton(imgtwwt);
		TamañoBoton(imgnt);
		TamañoBoton(imgytb);
	}
	
	public void TamañoBoton(ImageView img) {
		img.setFitHeight(80);
		img.setFitWidth(80);
	}
	
	public void cambiarColorFondo( String streams) {
		if (streams.equals("Facebook Gaming")) 
			bPane.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
		else if (streams.equals("Twitch"))
			bPane.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
		else if (streams.equals("Youtube Gaming"))
			bPane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		else if (streams.equals("Netflix"))
			bPane.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
		
	}
	
	public Scene getSceneInicio(){
	        Scene escenaInicio=new Scene(getBPane(),800, 500);
	        return escenaInicio;
	}
	    
	
	public BorderPane getBPane() {
		return bPane;
	}





}
