import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RestletResource extends ServerResource { 

    @Get
    public String hello() {
        return "HelloWorld in Restlet, this is GET method response";
    }

    @Delete
    public void bye() {
        System.out.println("Bye Bye, DELETE method called");

    }

}
