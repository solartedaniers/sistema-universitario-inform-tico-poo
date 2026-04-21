package com.universidad.notificaciones.controller.dto;

import com.universidad.notificaciones.model.TipoNotificacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionSMSRequest {

    @NotBlank private String codigo;
    @NotBlank private String destinatario;
    @NotBlank private String mensaje;
    @NotNull  private TipoNotificacion tipoNotificacion;
    @NotBlank private String numeroTelefono;
    private String operadora;
}