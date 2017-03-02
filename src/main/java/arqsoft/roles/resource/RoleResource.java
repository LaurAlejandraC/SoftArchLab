package arqsoft.roles.resource;

import arqsoft.roles.model.Role;
import arqsoft.roles.service.RoleService;

import javax.ejb.EJB;
import javax.persistence.GeneratedValue;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by laura on 02.03.17.
 */

@Path("/roles")
public class RoleResource {

    @Context
    UriInfo uriInfo;

    @EJB
    RoleService roleService;

    @GET
    public List<Role> getAllRoles(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult){
        return roleService.getAllRoles(first, maxResult);
    }

    @GET
    public List<Role> getFromFirstRoles(@QueryParam("first") int first){
        return roleService.getFromFirstRoles(first);
    }

    @GET
    public List<Role> getFromMaxRoles(@QueryParam("maxResult") int maxResult){
        return roleService.getFromMaxRoles(maxResult);
    }

    @GET
    @Path("{id}")
    public Role getRoleById(@PathParam("id") long id){
        return roleService.getRoleById(id);
    }

    @POST
    public Response createRole(Role role) {
        roleService.createUser(role);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateRole(@PathParam("id") long id, Role role){
        roleService.updateRole(id, role);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") long id) {
        roleService.deleteRole(id);
        return Response.status(Response.Status.OK).build();
    }
}
