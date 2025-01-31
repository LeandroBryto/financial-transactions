package com.leandrodev.transacao_api.business.services;

import com.leandrodev.transacao_api.controller.dto.EstatistIcasResponseDTO;
import com.leandrodev.transacao_api.controller.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {

    @Autowired
    public final TransacaoService transacaoService;

    public EstatistIcasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes =  transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).
                summaryStatistics();
        return new EstatistIcasResponseDTO(estatisticasTransacoes.getCount(),estatisticasTransacoes.getSum(),
        estatisticasTransacoes.getAverage(),estatisticasTransacoes.getMin(),estatisticasTransacoes.getMax());
    }
}
