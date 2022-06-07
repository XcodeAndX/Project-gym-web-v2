package co.edu.ufps.gymproject.negocio.fachada;

import co.edu.ufps.gymproject.datos.dto.EntrenadorDTO;
import co.edu.ufps.gymproject.negocio.EntrenadorNegocio;

import java.io.Serializable;

public class EntrenadorFacade implements Serializable {

    private EntrenadorNegocio negocio;

    public EntrenadorFacade(){
        negocio = new EntrenadorNegocio();
    }

    public boolean add(EntrenadorDTO entrenador){
        return negocio.add(entrenador);
    }

    public String login(EntrenadorDTO entrenador) { return negocio.login(entrenador); }
}
