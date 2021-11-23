package com.example.demo.persistence.entities;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity
@Table(name="user")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String password;

    /**
     * @param email
     * @param name
     * @param password
     */
    public Usuarios(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    /**
     *
     */
    public Usuarios(){}

    /**
     *
     * @param id
     */
    public Usuarios(Long id){
        this.id = id;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
