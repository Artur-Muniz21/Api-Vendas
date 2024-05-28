package com.stefanini.course.resources.openApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.stefanini.course.entities.LoginUser;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "login-user")
public interface LoginUserResourceOpenApi {

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Login válido"),
			@ApiResponse(responseCode = "401", description = "Login inválido")
	})
	ResponseEntity<String> login(@RequestBody LoginUser loginUser);
}
