package com.universidad.notificaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "notificaciones_movil")
@DiscriminatorValue("PUSH")
public class NotificacionMovil extends Notificacion {

    @Column(name = "token_dispositivo", nullable = false)
    private String tokenDispositivo;

    @Column(name = "plataforma", length = 20)
    private String plataforma;

    protected NotificacionMovil() {}

    public NotificacionMovil(String codigo, String destinatario, String mensaje,
                              TipoNotificacion tipo, String tokenDispositivo, String plataforma) {
        super(codigo, destinatario, mensaje, tipo);
        this.tokenDispositivo = tokenDispositivo;
        this.plataforma = plataforma;
    }
}