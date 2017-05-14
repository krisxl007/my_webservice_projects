package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import constant.QueryValueConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ElementService;
import java.util.Optional;

@Service
@Path("element")
public class ElementResource {

    @Autowired
    private ElementService elementServiceImpl;

    @Path("/values")
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    public String push(@QueryParam("value1") final Integer value1,
                       @QueryParam("value2") final Integer value2) {
        return Optional.ofNullable(value1).isPresent() && Optional.ofNullable(value2).isPresent()
                ? elementServiceImpl.push(value1, value2)
                : QueryValueConstant.INPUT_VALUE_IS_NULL;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@QueryParam("id") final Integer id) {
        return Optional.ofNullable(id).isPresent() ? elementServiceImpl.getById(id)
                : QueryValueConstant.INPUT_VALUE_IS_NULL;
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(elementServiceImpl.list()).build();
    }

}
