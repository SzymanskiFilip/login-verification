package eu.filip.loginverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "username", length = 60)
    private String username;

    @Column(name = "password", length = 60)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "active")
    private boolean active;

}
