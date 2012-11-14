package com.upsam.roo.quizzusers.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Usuario {

    private Integer id;

    @NotNull
    @Size(min = 5, max = 20)
    private String usuario;

    @NotNull
    @Size(min = 5, max = 30)
    private String pwd;

    @Size(min = 5, max = 100)
    private String nombre;

    @Size(min = 5, max = 200)
    private String apellidos;

    @Size(min = 5, max = 200)
    private String email;

    private Integer admin;
}
