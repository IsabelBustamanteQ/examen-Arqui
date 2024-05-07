package com.example.proyecto;

import com.example.proyecto.dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class HelloController implements IHelloApi{
    @GetMapping("/")
    public String index() {

        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
//            Sentry.captureException(e);
        }
        return "Greetings from Spring boot";
    }
    @GetMapping( value = "/products/{id}", produces = "application/json")
    public ResponseEntity<ProductDto> obtain(@PathVariable String id) {

        var product = new ProductDto(1,"a", 2);
        return ResponseEntity.ok(product);
    }

    @PostMapping( value = "/products", produces = "application/json")
    public ResponseEntity create(@RequestBody ProductDto product) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(product);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(HelloController.class.getClassLoader().getResourceAsStream("schemas/product.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            String errorsCombined = "";
            for( ValidationMessage error: errors) {
                errorsCombined += error.toString() +  "\n";
            }

            if(errors.size() > 0) {
                return ResponseEntity.badRequest().body("Please fix your JSON!,\n"+errorsCombined);
            }
            return ResponseEntity.ok(product);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.ok(product);
        }
    }

}
