package co.com.qvision.cert.servicios.interactions;

import co.com.qvision.cert.servicios.models.Credenciales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ConsumoServicioPost implements Interaction {

    public Credenciales datosUsuario;
    public String endpoint;

    public ConsumoServicioPost(Credenciales datosUsuario,String endpoint) {
        this.datosUsuario = datosUsuario;
        this.endpoint =endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(Post.to(endpoint).with(request -> request
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"userName\": "+ datosUsuario.getUserName()+",\n" +
                        "  \"password\": "+ datosUsuario.getPassword()+"\n" +
                        "}")
                .relaxedHTTPSValidation()));
    }

    public static ConsumoServicioPost consumoServicioPost(Credenciales datosUsuario,String endpoint){
        return instrumented(ConsumoServicioPost.class,datosUsuario,endpoint);
    }
}
