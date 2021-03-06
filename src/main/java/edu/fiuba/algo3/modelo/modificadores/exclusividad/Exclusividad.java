package edu.fiuba.algo3.modelo.modificadores.exclusividad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.resultados.Resultado;

import java.util.ArrayList;

public class Exclusividad implements Modificador {

    private Jugador jugador;

    public Exclusividad(Jugador unJugador){
        jugador = unJugador;
    }

    @Override
    public void usarEnPuntaje(PuntajePenalizable puntajePenalizable, ArrayList<Modificador> modificadoresDeLaJugada) {
    }

    @Override
    public void usarEnPuntaje(PuntajeClasico puntajeClasico, ArrayList<Modificador> modificadoresDeLaJugada) {
        seUsoExclusividadEnPreguntaValida(modificadoresDeLaJugada);
    }

    @Override
    public void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada) {
        seUsoExclusividadEnPreguntaValida(modificadoresDeLaJugada);
    }

    private void seUsoExclusividadEnPreguntaValida(ArrayList<Modificador> modificadoresDeLaJugada){
        modificadoresDeLaJugada.add(this);
        jugador.pierdeExclusividad(this);
    }

    @Override
    public void aplicar(Resultado resultadoJugador1, Resultado resultadoJugador2) {
        AnalizadorExclusividad analizador = new AnalizadorExclusividad();
        resultadoJugador1.aplicaExclusividad(analizador);
        resultadoJugador2.aplicaExclusividad(analizador);
    }

}
