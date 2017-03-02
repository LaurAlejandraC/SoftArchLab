package arqsoft.roles.service;

import arqsoft.roles.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by laura on 02.03.17.
 */
public class RoleService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Role> getAllRoles(int first, int maxResult){
        return entityManager.createNamedQuery(Role.FIND_ALL).setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public List<Role> getFromFirstRoles(int first) {
        return entityManager.createNamedQuery(Role.FIND_ALL).setFirstResult(first).getResultList();
    }

    public List<Role> getFromMaxRoles(int maxResult) {
        return entityManager.createNamedQuery(Role.FIND_ALL).setMaxResults(maxResult).getResultList();
    }

    public Role getRoleById(long id){
        return entityManager.find(Role.class, id);
    }

    public void createUser(Role role){
        entityManager.persist(role);
    }

    public Role updateRole(long id, Role role){
        Role roleToUpdate = entityManager.find(Role.class, id);
        roleToUpdate.setName(role.getName());
        roleToUpdate.setWritePermission(role.hasWritePermission());
        roleToUpdate.setReadPermission(role.hasReadPermission());
        roleToUpdate.setUpdatePermission(role.hasUpdatePermission());
        roleToUpdate.setDeletePermission(role.hasDeletePermission());
        return entityManager.merge(roleToUpdate);
    }

    public void deleteRole(long id){
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }
}
