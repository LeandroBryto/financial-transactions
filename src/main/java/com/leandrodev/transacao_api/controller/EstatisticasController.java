package com.leandrodev.transacao_api.controller;

import com.leandrodev.transacao_api.business.services.EstatisticasService;
import com.leandrodev.transacao_api.controller.dto.EstatistIcasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    EstatisticasService estatisticasService;
    @GetMapping
    @Operation(description = "Endpoint responsável por buscar estatísticas de transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca de estatísticas de transações"),
            @ApiResponse(responseCode = "500", description = "Erro de interno do servidor")
    })
    public ResponseEntity<EstatistIcasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervalorBusca",required = false, defaultValue = "60") Integer intervaloBusca){
        return ResponseEntity.ok(
                estatisticasService.calcularEstatisticasTransacoes(intervaloBusca)
        );
    }
}
