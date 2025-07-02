package com.apoiodigital.main.api.Dtos;

import java.util.List;

public record CompoentsAndContextDTO(String contexto, List<AndroidComponentDTO> components) {
}
