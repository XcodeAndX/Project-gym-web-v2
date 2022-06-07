package co.edu.ufps.gymproject.negocio;

import co.edu.ufps.gymproject.datos.dao.EntrenadorDAO;
import co.edu.ufps.gymproject.datos.dto.EntrenadorDTO;

import java.util.List;
import java.util.ArrayList;

public class EntrenadorNegocio {

    private EntrenadorDAO entrenadorDao;

    public EntrenadorNegocio(){
        entrenadorDao = new EntrenadorDAO();
    }

    public boolean add(EntrenadorDTO entrenador){
        boolean add = false;
        try {
            EntrenadorDTO entrenadorBd = entrenadorDao.getByCedula(entrenador.getCedula());
            if(entrenadorBd == null){
                add = entrenadorDao.add(entrenador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return add;
        }
    }

    public EntrenadorDTO findById(EntrenadorDTO entrenador){
        EntrenadorDTO entrenadorBd = null;
        try{
            entrenadorBd = entrenadorDao.getById(entrenador.getId());
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            return entrenadorBd;
        }
    }

    public EntrenadorDTO findByCedula(EntrenadorDTO entrenador){
        EntrenadorDTO entrenadorBd = null;
        try{
            entrenadorBd = entrenadorDao.getById(entrenador.getCedula());
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            return entrenadorBd;
        }
    }

    public boolean update(EntrenadorDTO entrenador){
        boolean update = false;
        try {
            EntrenadorDTO entrenadorBd = entrenadorDao.getByCedula(entrenador.getCedula());
            if(entrenadorBd != null){
                update = entrenadorDao.update(entrenador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return update;
        }
    }

    public List<EntrenadorDTO> get(){
        List<EntrenadorDTO> entrenadores = new ArrayList<>();
        try {
            entrenadores = entrenadorDao.get();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return entrenadores;
        }
    }

    public boolean delete(EntrenadorDTO entrenador){
        boolean delete = false;
        try {
            delete = entrenadorDao.delete(entrenador.getId());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return delete;
        }
    }

    public String login(EntrenadorDTO entrenador){
        String message = "Ocurrio un error";
        try {
            EntrenadorDTO entrenadorBd = entrenadorDao.getByEmail(entrenador.getEmail());
            if(entrenadorBd != null){
                if(entrenador.getPassword().equals(entrenadorBd.getPassword())){
                    message = "Inicio de sesion";
                }else{
                    message = "Password Incorrecto";
                }

            }else{
                message = "Email incorrecto";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return message;
        }
    }
}
