// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.upsam.roo.quizzusers.domain;

import com.upsam.roo.quizzusers.domain.Usuario;
import com.upsam.roo.quizzusers.domain.UsuarioDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect UsuarioDataOnDemand_Roo_DataOnDemand {
    
    declare @type: UsuarioDataOnDemand: @Component;
    
    private Random UsuarioDataOnDemand.rnd = new SecureRandom();
    
    private List<Usuario> UsuarioDataOnDemand.data;
    
    public Usuario UsuarioDataOnDemand.getNewTransientUsuario(int index) {
        Usuario obj = new Usuario();
        setAdmin(obj, index);
        setApellidos(obj, index);
        setEmail(obj, index);
        setId(obj, index);
        setNombre(obj, index);
        setPwd(obj, index);
        setUsuario(obj, index);
        return obj;
    }
    
    public void UsuarioDataOnDemand.setAdmin(Usuario obj, int index) {
        Integer admin = new Integer(index);
        obj.setAdmin(admin);
    }
    
    public void UsuarioDataOnDemand.setApellidos(Usuario obj, int index) {
        String apellidos = "apellidos_" + index;
        if (apellidos.length() > 200) {
            apellidos = apellidos.substring(0, 200);
        }
        obj.setApellidos(apellidos);
    }
    
    public void UsuarioDataOnDemand.setEmail(Usuario obj, int index) {
        String email = "foo" + index + "@bar.com";
        if (email.length() > 200) {
            email = email.substring(0, 200);
        }
        obj.setEmail(email);
    }
    
    public void UsuarioDataOnDemand.setId(Usuario obj, int index) {
        Integer id = new Integer(index);
        obj.setId(id);
    }
    
    public void UsuarioDataOnDemand.setNombre(Usuario obj, int index) {
        String nombre = "nombre_" + index;
        if (nombre.length() > 100) {
            nombre = nombre.substring(0, 100);
        }
        obj.setNombre(nombre);
    }
    
    public void UsuarioDataOnDemand.setPwd(Usuario obj, int index) {
        String pwd = "pwd_" + index;
        if (pwd.length() > 30) {
            pwd = pwd.substring(0, 30);
        }
        obj.setPwd(pwd);
    }
    
    public void UsuarioDataOnDemand.setUsuario(Usuario obj, int index) {
        String usuario = "usuario_" + index;
        if (usuario.length() > 20) {
            usuario = usuario.substring(0, 20);
        }
        obj.setUsuario(usuario);
    }
    
    public Usuario UsuarioDataOnDemand.getSpecificUsuario(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Usuario obj = data.get(index);
        Long id = obj.getId_();
        return Usuario.findUsuario(id);
    }
    
    public Usuario UsuarioDataOnDemand.getRandomUsuario() {
        init();
        Usuario obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId_();
        return Usuario.findUsuario(id);
    }
    
    public boolean UsuarioDataOnDemand.modifyUsuario(Usuario obj) {
        return false;
    }
    
    public void UsuarioDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Usuario.findUsuarioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Usuario' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Usuario>();
        for (int i = 0; i < 10; i++) {
            Usuario obj = getNewTransientUsuario(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
