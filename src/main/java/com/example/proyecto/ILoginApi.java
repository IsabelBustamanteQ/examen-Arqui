package com.example.proyecto;

import com.example.proyecto.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

public interface ILoginApi {
    @Tag(name = "Login", description = "Create a user with login and password")
    @Operation(summary = "Crear usuario", description = "Registrar un usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "Usuario añadido exitosamente",
                            content = {@Content(mediaType = "application/json",
                                    schema=@Schema(implementation = LoginResponseDto.class))}
                    ),
                    @ApiResponse(
                            responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }

                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Los datos enviados no cumplen los requerimientos mínimos",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }

                    )
            }
    )
    public ResponseEntity<LoginDto> create(LoginDto login);

    @Tag(name = "Credit Card", description = "Create una tarjeta de credito")
    @Operation(summary = "Crear tarjeta de credito", description = "Registrar una tarjeta de credito")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "Tarjeta añadida exitosamente",
                            content = {@Content(mediaType = "application/json",
                                    schema=@Schema(implementation = CreditCardResponseDto.class))}
                    ),
                    @ApiResponse(
                            responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }

                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Los datos enviados no cumplen los requerimientos mínimos",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }

                    )
            }
    )
    public ResponseEntity<CreditCardDto> create(CreditCardDto creditCard);
}
