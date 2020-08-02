package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.RespuestaGrupo;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


public class PreguntaGrupoTest {

    @Test
    public void test01SeRespondeCorrectamenteUnaPreguntaGroupChoiceYDevuelve1Punto() {

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(respuesta1Grupo1);
        respuestaGrupo1Jugador.add(respuesta2Grupo1);
        respuestaGrupo1Jugador.add(respuesta3Grupo1);
        respuestaGrupo2Jugador.add(respuesta1Grupo2);
        respuestaGrupo2Jugador.add(respuesta2Grupo2);
        respuestaGrupo2Jugador.add(respuesta3Grupo2);


        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(1, resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test02SeRespondeIncorrectamenteUnaPreguntaGroupChoiceYDevuelve0Puntos() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Gatito");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("Conejo");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("Lagarto");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Iguana");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);

        Grupo grupo1 = new Grupo("Mamiferos",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Reptiles",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(respuesta1Grupo1);
        respuestaGrupo1Jugador.add(respuesta2Grupo2);
        respuestaGrupo2Jugador.add(respuesta1Grupo2);
        respuestaGrupo2Jugador.add(respuesta1Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test03SeRespondeIncorrectamenteUnaPreguntaGroupChoiceAgregandoMasRespuestasAUnGrupoYDevuelve0Puntos() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Gatito");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("Conejo");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("Lagarto");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Iguana");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);

        Grupo grupo1 = new Grupo("Mamiferos",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Reptiles",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(respuesta1Grupo1);
        respuestaGrupo1Jugador.add(respuesta2Grupo2);
        respuestaGrupo2Jugador.add(respuesta1Grupo2);
        respuestaGrupo2Jugador.add(respuesta1Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test04SeRespondeIncorrectamenteUnaPreguntaGroupChoiceMetiendoTodoAUnGrupoYDevuelveCeroPuntos() {

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(respuesta1Grupo1);
        respuestaGrupo1Jugador.add(respuesta2Grupo1);
        respuestaGrupo1Jugador.add(respuesta3Grupo1);
        respuestaGrupo1Jugador.add(respuesta1Grupo2);
        respuestaGrupo1Jugador.add(respuesta2Grupo2);
        respuestaGrupo1Jugador.add(respuesta3Grupo2);


        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
    }

}