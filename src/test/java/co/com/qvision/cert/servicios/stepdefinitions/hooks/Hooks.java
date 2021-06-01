package co.com.qvision.cert.servicios.stepdefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.qvision.cert.servicios.utils.Constantes.NOMBRE_USUARIO;
import static co.com.qvision.cert.servicios.utils.Constantes.URL_BASE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {

    @Before()
    public void configuracionInicialDeEscenarios(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(NOMBRE_USUARIO);
        theActorInTheSpotlight().whoCan(CallAnApi.at(URL_BASE));
    }
}
