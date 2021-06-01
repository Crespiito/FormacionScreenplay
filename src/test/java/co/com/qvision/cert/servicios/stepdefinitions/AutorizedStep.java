package co.com.qvision.cert.servicios.stepdefinitions;

import co.com.qvision.cert.servicios.tasks.ConsumoServicioAutorizar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.qvision.cert.servicios.tasks.ConsumoServicioAutorizar.consumoServicioAutorizar;
import static co.com.qvision.cert.servicios.tasks.PrepararInfoAutorizacion.prepararInfoAutorizacion;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class AutorizedStep {

    @Given("el usuario carga la informacion de la url {} , {} y {}")
    public void elUsuarioCargaLaInformacionDeLaUrlHttpsDemoqaComAccountV1Authorized(String endopint,String usuario,String contra) {
        theActorInTheSpotlight().attemptsTo(prepararInfoAutorizacion(usuario,contra,endopint));
    }
    @When("el ingresa los datos {} y {}")
    public void elIngresaLosDatosPruebaServicioYPrueba123(String usuario,String contra) {
        theActorInTheSpotlight().attemptsTo(consumoServicioAutorizar());
    }
    @Then("el obtiene una respuesta exitosa {int}")
    public void elObtieneUnaRespuestaExitosa(Integer int1) {
        theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.statusCode(int1)));
    }
}
