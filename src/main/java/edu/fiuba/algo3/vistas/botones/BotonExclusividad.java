package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.controladores.ControladorModificador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class BotonExclusividad extends Button {

    public BotonExclusividad(ArrayList<Exclusividad> exclusividades) {
        super.setText("Usar Exclusividad");
        super.setFont(Font.font(EstilosApp.FUENTE, 15));
        super.setPadding(new Insets(5));
        super.setTextFill(Color.BLACK);
        Exclusividad exclusividad = exclusividades.get(0);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.AMARILLO, EstilosApp.ALPHA_BOTON_INACTIVO), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);

        super.setOnAction(new ControladorModificador(this,exclusividad));
        super.setOnMouseEntered(new ControladorActivarBoton(this, EstilosApp.AMARILLO));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, EstilosApp.AMARILLO));
    }
}
