//package com.example.proyecto;
//
//import com.example.proyecto.dto.ProductDto;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
//
//public interface IHelloApi {
//    @Tag(name = "Products", description = "Obtain the list of products")
//    @Operation(summary = "Lista de productos", description = "Obtener la lista de todos los productos registrados")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(
//                            responseCode = "200", description = "Los productos fueron obtenidos exitosamente",
//                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))}
//                    ),
//                    @ApiResponse(
//                            responseCode = "500", description = "${api.responseCodes.internalServer.description}",
//                            content = {
//                                    @Content(mediaType = "application/json",
//                                            schema = @Schema(implementation = ErrorResponse.class))
//                            }
//
//                    )
//            }
//    )
//    public String index();
//
//    @Tag(name = "Products", description = "Obtain one product by id")
//    public ResponseEntity<ProductDto> obtain(String id);
//
//
//    @Tag(name = "Products", description = "Create product")
//    @Operation(summary = "Crear un producto", description = "Registrar un producto")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(
//                            responseCode = "200", description = "El producto fue añadido exitosamente",
//                            content = {@Content(mediaType = "application/json",
//                                    schema=@Schema(implementation = ProductDto.class))}
//                    ),
//                    @ApiResponse(
//                            responseCode = "500", description = "${api.responseCodes.internalServer.description}",
//                            content = {
//                                    @Content(mediaType = "application/json",
//                                            schema = @Schema(implementation = ErrorResponse.class))
//                            }
//
//                    )
//            }
//    )
//    public ResponseEntity<ProductDto> create(ProductDto product);
//
//}
