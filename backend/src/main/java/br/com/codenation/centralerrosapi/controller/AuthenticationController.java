package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.controller.exception.ErrorMessage;
import br.com.codenation.centralerrosapi.dto.LoginDTO;
import br.com.codenation.centralerrosapi.dto.UserCreateDTO;
import br.com.codenation.centralerrosapi.dto.UserDTO;
import br.com.codenation.centralerrosapi.mappers.UserMapper;
import br.com.codenation.centralerrosapi.service.AuthenticationService;
import br.com.codenation.centralerrosapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1")
public class AuthenticationController {

    private AuthenticationService authService;
    private UserService userService;
    private UserMapper userMapper;

    @ApiOperation(
            value = "Recupera token de autenticação os logs cadastrados",
            notes = "Método utilizado para recuperar um token de autenticação."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário autenticado"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ErrorMessage.class),
            @ApiResponse(code = 403, message = "Usuário ou senha inválido", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ErrorMessage.class)
    })
    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO login) throws InvalidObjectException {
        String token = authService.getTokenAuthentication(login);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().headers(headers).build();
    }

    @ApiOperation(
            value = "Cadastra um novo usuário",
            notes = "Método utilizado para cadastrar um novo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário cadastrado", response = UserDTO.class),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ErrorMessage.class)
    })
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO register(@RequestBody UserCreateDTO userCreateDTO) throws InvalidObjectException {
        return userMapper.toDto(userService.save(userCreateDTO));
    }

}