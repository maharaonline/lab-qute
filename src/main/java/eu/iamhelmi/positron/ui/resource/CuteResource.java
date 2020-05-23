package eu.iamhelmi.positron.ui.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.iamhelmi.positron.dto.Cute;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("/cute")
public class CuteResource {
    @Inject
    Template cute; 
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance geta() {
        Cute c = new Cute();
        c.setWho("helmi");
        c.setYesNo(Boolean.TRUE);
        c.setNote("kind");
        
        Cute c2 = new Cute();
        c2.setWho("monkey");
        c2.setYesNo(Boolean.TRUE);
        c2.setNote("jump");
        
        Cute c3 = new Cute();
        c3.setWho("chicken");
        c3.setYesNo(Boolean.TRUE);
        c3.setNote("humble");
        
        List<Cute> cutes = new ArrayList<>();
        cutes.add(c);
        cutes.add(c2);
        cutes.add(c3);
        
        return cute.data("cutes",cutes);
    }
}
