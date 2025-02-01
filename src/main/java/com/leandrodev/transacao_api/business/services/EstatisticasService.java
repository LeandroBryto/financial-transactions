package com.leandrodev.transacao_api.business.services;

import com.leandrodev.transacao_api.controller.dto.EstatistIcasResponseDTO;
import com.leandrodev.transacao_api.controller.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    @Autowired
    public final TransacaoService transacaoService;

    public EstatistIcasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
        log.info("Iniciada busca de estatistica de transaçãoes");

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);
        if (transacoes.isEmpty()){
            return new EstatistIcasResponseDTO(0L,0.0,0.0,0.0,0.0);
        }
        DoubleSummaryStatistics estatisticasTransacoes =  transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).
                summaryStatistics();
        log.info("Estatisticas retornada com sucesso");
        return new EstatistIcasResponseDTO(estatisticasTransacoes.getCount(),estatisticasTransacoes.getSum(),
        estatisticasTransacoes.getAverage(),estatisticasTransacoes.getMin(),estatisticasTransacoes.getMax());
    }
}
