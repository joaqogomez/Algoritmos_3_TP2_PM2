package edu.fiuba.algo3.vistas.textos;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoPuntuacion extends Label {

    public TextoPuntuacion(int puntos){
        super(String.valueOf(puntos));
        super.setFont(Font.font("montserrat",25));
        super.setTextFill(Color.BLACK);
    }

}
