package co.com.qvision.cert.servicios.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/administraciondecuentas/autorized.feature",
        glue = "co.com.qvision.cert.servicios.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
class AutorizedRunner {
}
