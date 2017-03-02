package arqsoft.roles.model;

import arqsoft.authentication.model.User;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by laura on 02.03.17.
 */

@Entity
@Table(name = "roles")

public class Role {

    public static final String FIND_ALL = "Role.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    private String name;
    private boolean writePermission;
    private boolean readPermission;
    private boolean updatePermission;
    private boolean deletePermission;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<User> usersCollection;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasWritePermission() {
        return writePermission;
    }

    public void setWritePermission(boolean writePermission) {
        this.writePermission = writePermission;
    }

    public boolean hasReadPermission() {
        return readPermission;
    }

    public void setReadPermission(boolean readPermission) {
        this.readPermission = readPermission;
    }

    public boolean hasUpdatePermission() {
        return updatePermission;
    }

    public void setUpdatePermission(boolean updatePermission) {
        this.updatePermission = updatePermission;
    }

    public boolean hasDeletePermission() {
        return deletePermission;
    }

    public void setDeletePermission(boolean deletePermission) {
        this.deletePermission = deletePermission;
    }
}
