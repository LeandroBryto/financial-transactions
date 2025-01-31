package com.leandrodev.transacao_api.controller.dto;

public record EstatistIcasResponseDTO(Long cantar,
                                      Double soma,
                                      Double Avg,
                                      Double Min,
                                      Double Max) {
}
