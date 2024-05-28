package com.stefanini.course.resources.openApi;

import java.util.List;

import com.stefanini.course.entities.OrderItem;
import com.stefanini.course.resources.exceptions.StandardError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "order-item")
public interface OrderItemResourceOpenApi {

	List<OrderItem> findAll();
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "400", description = "Erro de estrutura", content = @Content(schema = @Schema(implementation = StandardError.class)))
	})
	OrderItem insert(OrderItem obj);
}
