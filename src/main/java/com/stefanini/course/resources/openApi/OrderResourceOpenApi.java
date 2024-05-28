package com.stefanini.course.resources.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stefanini.course.dto.GetOrder;
import com.stefanini.course.dto.PostOrder;
import com.stefanini.course.dto.response.OrderResponse;
import com.stefanini.course.resources.exceptions.StandardError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "order")
public interface OrderResourceOpenApi {

	List<GetOrder> findAll();
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pedido encontrado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	GetOrder findById(@PathVariable Long id);
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "400", description = "Erro de estrutura", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	ResponseEntity<OrderResponse> insert(@RequestBody PostOrder post);
}
