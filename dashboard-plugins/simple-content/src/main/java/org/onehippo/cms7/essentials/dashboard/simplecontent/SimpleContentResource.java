package org.onehippo.cms7.essentials.dashboard.simplecontent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.onehippo.cms7.essentials.dashboard.ctx.PluginContext;
import org.onehippo.cms7.essentials.dashboard.packaging.PowerpackPackage;
import org.onehippo.cms7.essentials.dashboard.rest.BaseResource;
import org.onehippo.cms7.essentials.dashboard.rest.MessageRestful;
import org.onehippo.cms7.essentials.dashboard.rest.PostPayloadRestful;


@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
@Path("/simpleContent")
public class SimpleContentResource extends BaseResource {


    /**
     * Executes powerpack
     */
    @POST
    @Path("/")
    public MessageRestful executePowerpack(final PostPayloadRestful payloadRestful, @Context ServletContext servletContext) {
        final MessageRestful message = new MessageRestful();
        final Map<String, String> values = payloadRestful.getValues();
        final PluginContext context = getContext(servletContext);
        final PowerpackPackage powerpack = new SimpleContentPowerpack();
        getInjector().autowireBean(powerpack);
        powerpack.setProperties(new HashMap<String, Object>(values));
        powerpack.execute(context);
        message.setValue("Please rebuild and restart your application");
        return message;
    }

}
