package arqsoft.authentication.model;

import arqsoft.roles.model.Role;

import javax.persistence.*;

/**
 * Created by javergarav on 15/02/2017.
 */

@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u")})
public class User {

    public static final String FIND_ALL = "User.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roles", referencedColumnName = "roleId")
    private Role role;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}