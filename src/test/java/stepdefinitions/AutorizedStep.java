package stepdefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class AutorizedStep {
    @Given("el usuario carga la informacion de la url {}")
    public void elUsuarioCargaLaInformacionDeLaUrlHttpsDemoqaComAccountV1Authorized(String url) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Maleja").whoCan(CallAnApi.at(url));
    }
    @When("el ingresa los datos {} y {}")
    public void elIngresaLosDatosPruebaServicioYPrueba123(String usuario,String contra) {

        theActorInTheSpotlight().attemptsTo(Post.to("").with(request -> request
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"userName\": "+usuario+",\n" +
                        "  \"password\": "+contra+"\n" +
                        "}")
                .relaxedHTTPSValidation()));

    }
    @Then("el obtiene una respuesta exitosa {int}")
    public void elObtieneUnaRespuestaExitosa(Integer int1) {
        theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.statusCode(int1)));
    }
}
