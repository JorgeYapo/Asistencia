/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Usuario;

/**
 *
 * @author David
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends SysDataAccess<Integer, Usuario> implements UsuarioDao{

    @SuppressWarnings("unchecked")
    public List<Usuario> listarEntidad() { return getListAll();}


    public Usuario buscarUsuario(int id) { return getById(id);}


    public void guardarEntidad(Usuario usuario) {savev(usuario); }


    public void eliminarEntidad(int id) { delete(id);}


    public void modificarEntidadId(Usuario usuario) { update(usuario); }


    public List<Usuario> listarPorNombre(String nombre) {
    return (List<Usuario>)sessionFactory.getCurrentSession()
            .createQuery("select a from Usuario a where a.nombres like ?")
            .setString(0, "%"+nombre+"%")
            .list();
    }

    public Usuario usuarioLogin(String login, String clave){
    return (Usuario)sessionFactory.getCurrentSession()
            .createQuery("select a from Usuario a where a.usuario=? and a.clave=? ")        
            .setString(0, login)
            .setString(1, clave)
            .uniqueResult();
    } 
    
}
