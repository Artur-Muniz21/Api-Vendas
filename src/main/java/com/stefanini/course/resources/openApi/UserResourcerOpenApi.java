package com.stefanini.course.resources.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stefanini.course.dto.GetUser;
import com.stefanini.course.dto.PostUser;
import com.stefanini.course.dto.PutUser;
import com.stefanini.course.dto.response.UserResponse;
import com.stefanini.course.resources.exceptions.StandardError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "user")
public interface UserResourcerOpenApi {

	List<GetUser> findAll();
	
	@Operation(summary = "Busque um usuário pelo id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	GetUser findById(@PathVariable Long id);
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204"),
			@ApiResponse(responseCode = "400", description = "Usuário com pendencias", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	ResponseEntity<Void> delete(@Parameter(description = "digite o id do usuário") @PathVariable Long id);
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "400", description = "Erro de validação", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	ResponseEntity<UserResponse> insert(@Valid @RequestBody PostUser obj);
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "400", description = "Erro de validação", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody PutUser  obj);
}
