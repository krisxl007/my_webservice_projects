package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ElementService;

@Service
@Path("element")
public class ElementResource {

    private static final Logger LOGGER = Logger.getLogger(ElementResource.class);

    @Autowired
    private ElementService elementServiceImpl;

    @Path("/values")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public String push(@QueryParam("value1") final int value1,
                       @QueryParam("value2") final int value2) {
        String status = elementServiceImpl.push(value1, value2);
        LOGGER.info("Values added");
        return status;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        LOGGER.info("Got it!");
        return "Got it!";
    }

}
