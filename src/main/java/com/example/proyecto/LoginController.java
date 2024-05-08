package com.example.proyecto;

import com.example.proyecto.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.sentry.Sentry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LoginController implements ILoginApi {
    @GetMapping("/")
    public String index() {

        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        return "Greetings Login Controller";
    }
    @PostMapping( value = "/login", produces = "application/json")
    public ResponseEntity create(@RequestBody LoginDto login) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(login);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(LoginController.class.getClassLoader().getResourceAsStream("schemas/login.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            String errorsCombined = "";
            for( ValidationMessage error: errors) {
                errorsCombined += error.toString() +  "\n";
            }

            if(errors.size() > 0) {

                return ResponseEntity.badRequest().body("Please fix your JSON!,\n"+errorsCombined);
            }
            LoginResponseDto loginResponseDto = new LoginResponseDto("token","timestamp");
            return ResponseEntity.ok(loginResponseDto);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LoginResponseDto loginResponseDto = new LoginResponseDto("token","timestamp");
            return ResponseEntity.ok(loginResponseDto);
        }
    }

    @PostMapping( value = "/Credit_card", produces = "application/json")
    public ResponseEntity create(@RequestBody CreditCardDto creditCard) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(creditCard);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(LoginController.class.getClassLoader().getResourceAsStream("schemas/creditCard.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            String errorsCombined = "";
            for( ValidationMessage error: errors) {
                errorsCombined += error.toString() +  "\n";
            }

            if(errors.size() > 0) {

                return ResponseEntity.badRequest().body("Please fix your JSON!,\n"+errorsCombined);
            }
            CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto(0,"successfull");
            return ResponseEntity.ok(creditCardResponseDto);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto(0,"successfull");
            return ResponseEntity.ok(creditCardResponseDto);
        }
    }
}
