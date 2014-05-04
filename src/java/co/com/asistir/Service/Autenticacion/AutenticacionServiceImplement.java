/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Service.Autenticacion;

import co.com.asistir.Dao.Autenticacion.AutenticacionDaoI;
import co.com.asistir.Dao.Autenticacion.AutenticacionDaoImp;
import co.com.asistir.To.Usuario;
import java.util.List;

/**
 *
 * @author hectoridarraga
 */
public class AutenticacionServiceImplement implements AutenticacionI{
    AutenticacionDaoI autenticacionDao;
    
    public AutenticacionServiceImplement(){
    autenticacionDao = new AutenticacionDaoImp();
    }

    @Override
    public Usuario esUsuarioRegistradoServiceImplement(String sUser) {
        return autenticacionDao.esUsuarioRegistrado(sUser);
    }

    @Override
    public Object GuardarUsuario(Usuario usuario) {
         return autenticacionDao.guardarUsuario(usuario);
    }
    
     @Override
    public Usuario validarExistenciaUsuario(String sUsuario, String email) {
        return autenticacionDao.validarExistenciaUsuario(sUsuario, email);
    }
}
