/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Service.Cie10;

import co.com.asistir.Service.Autenticacion.*;
import co.com.asistir.Dao.Autenticacion.AutenticacionDaoI;
import co.com.asistir.Dao.Autenticacion.AutenticacionDaoImp;
import co.com.asistir.Dao.Cie10.Cie10DaoI;
import co.com.asistir.Dao.Cie10.Cie10DaoImp;
import co.com.asistir.To.Cie10;
import co.com.asistir.To.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoridarraga
 */
public class Cie10ServiceImplement implements Cie10I{
    Cie10DaoI cie10Dao;
    List<Cie10> cie10s;
    
    public Cie10ServiceImplement(){
    cie10Dao = new Cie10DaoImp();
    cie10s = new ArrayList<Cie10>();
    }

    @Override
    public List<Cie10> listarCie10() {
       cie10s = cie10Dao.consultaCie10s();
       return cie10s;
    }
}
