package co.com.qvision.cert.servicios.tasks;

import co.com.qvision.cert.servicios.models.Credenciales;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PrepararInfoAutorizacion implements Task {

    public String endpoint;
    public String usuario;
    public String contra;

    public PrepararInfoAutorizacion(String endpoint, String usuario, String contra) {
        this.endpoint = endpoint;
        this.usuario = usuario;
        this.contra = contra;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Credenciales datosUsuario = new Credenciales(usuario,contra);
        actor.remember("datosUsuario",datosUsuario);
        actor.remember("endpoint",endpoint);
        String muestra;
        datosUsuario=actor.recall("datosUsuario");
        muestra=actor.recall("endpoint");

        Serenity.setSessionVariable("datosUsuario").to(datosUsuario);
        Serenity.setSessionVariable("endpoint").to(endpoint);

        datosUsuario=Serenity.sessionVariableCalled("datosUsuario");
        muestra=Serenity.sessionVariableCalled("endpoint");

    }

    public static PrepararInfoAutorizacion prepararInfoAutorizacion(String usuario , String contra , String endpoint){
        return instrumented(PrepararInfoAutorizacion.class,endpoint,usuario, contra);
    }
}
