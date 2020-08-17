package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorModificador;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonMultiplicador extends Button {
    
    public BotonMultiplicador(MultiplicadorJugador multiplicador) {
        super.setText("Usar Multiplicador x"+ multiplicador.factor());
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(new ControladorModificador(this,multiplicador));
        super.setAlignment(Pos.CENTER);
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.AMARILLO), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }

}
