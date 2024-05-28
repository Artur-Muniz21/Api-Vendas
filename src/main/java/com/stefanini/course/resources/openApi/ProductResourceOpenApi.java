package com.stefanini.course.resources.openApi;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.course.dto.GetProduct;
import com.stefanini.course.resources.exceptions.StandardError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "product")
public interface ProductResourceOpenApi {
	
	List<GetProduct> findAll();
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	GetProduct findById(@PathVariable Long id);

}
