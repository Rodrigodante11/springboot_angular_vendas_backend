package com.rodrigo.clientes.rest;

import com.rodrigo.clientes.rest.exception.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.Binding;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice { // intercepitando os erros e manipulando

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationErros(MethodArgumentNotValidException ex){  //  do controller @Valid == MethodArgumentNotValidException
        BindingResult bindingResult= ex.getBindingResult();  // objeto que tem todos os resultados da validacao/erros

        List<String> messages= bindingResult.getAllErrors() // pegando o array de erros e transformando em array de mensagens
                .stream()
                .map(
                    objectError -> objectError.getDefaultMessage()
                ).collect(Collectors.toList());

        return new ApiErros(messages);
    }

    @ExceptionHandler(ResponseStatusException.class) // personalizando o not found
    public ResponseEntity handleRespomseStatusException(ResponseStatusException ex){
        String mensagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();

        ApiErros apiErros = new ApiErros(mensagemErro);

        return  new ResponseEntity(apiErros, codigoStatus);  //(mensagem , cdigo erro)
    }
}
