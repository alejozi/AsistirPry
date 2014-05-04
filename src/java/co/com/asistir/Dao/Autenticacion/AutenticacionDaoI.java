/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Dao.Autenticacion;

import co.com.asistir.To.Usuario;

/**
 *
 * @author hectoridarraga
 */
public interface AutenticacionDaoI {
    public Usuario esUsuarioRegistrado(String sUsuario);
    public Object guardarUsuario(Usuario usuario);
    public Usuario validarExistenciaUsuario(String sUsuario, String email);
}
