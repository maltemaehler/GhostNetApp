// Simple Controller class for the Spring Boot application. Handels HTTP requests and responses.

// Let's the program know where this class is located
package malte.dev.app.GhostNet;

// Imports annotations and classes. Dependency "spring-boot-starter-web" must be set in pom.xml.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Handels HTTP requests and responses.
@RestController
public class SimpleOutputController {
    // Sets service and variable for the instance of the class
    private final SimpleOutputService simpleOutputService;

    // Constructor that initializes the service variable
    public SimpleOutputController(SimpleOutputService simpleOutputService) {
        this.simpleOutputService = simpleOutputService;
    }

    // Maps the HTTP GET request to the "/hello" endpoint and returns a greeting message
    @GetMapping("/hello")
    public String sayHello() {
        return simpleOutputService.getGreeting();
    }
}
