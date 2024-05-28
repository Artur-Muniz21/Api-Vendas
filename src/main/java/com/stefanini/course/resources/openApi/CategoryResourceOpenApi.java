package com.stefanini.course.resources.openApi;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.course.dto.GetCategory;
import com.stefanini.course.resources.exceptions.StandardError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "category")
public interface CategoryResourceOpenApi {

	List<GetCategory> findAll();
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cetegoria encontrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	GetCategory findById(@PathVariable Long id);
}
