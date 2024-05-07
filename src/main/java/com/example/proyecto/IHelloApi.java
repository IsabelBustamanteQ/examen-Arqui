package com.example.proyecto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.ErrorResponse;

public interface IHelloApi {
    @Tag(name = "Products", description = "Obtain the list of products")
    @Operation(summary = "Lista de productos", description = "Loren ipsum")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "loren ipson landa bla"
                    ),
                    @ApiResponse(
                            responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }

                    )
            }
    )
    public String index();
}
