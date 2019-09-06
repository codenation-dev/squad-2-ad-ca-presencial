package br.com.codenation.centralerrosapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {

    @ApiModelProperty(value = "Usuário", example = "codenation", required = true)
    private String username;

    @ApiModelProperty(value = "Senha do usuário", example = "T3st3@999", required = true)
    private String password;

}
