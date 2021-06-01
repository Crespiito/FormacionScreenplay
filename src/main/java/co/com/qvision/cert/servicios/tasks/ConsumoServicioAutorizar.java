package co.com.qvision.cert.servicios.tasks;

import co.com.qvision.cert.servicios.interactions.ConsumoServicioPost;
import co.com.qvision.cert.servicios.models.Credenciales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumoServicioAutorizar implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ConsumoServicioPost.consumoServicioPost(actor.recall("datosUsuario") ,actor.recall("endpoint")));
    }

    public static ConsumoServicioAutorizar consumoServicioAutorizar(){
        return instrumented(ConsumoServicioAutorizar.class);
    }
}
