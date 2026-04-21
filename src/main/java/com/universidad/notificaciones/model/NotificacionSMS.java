package com.universidad.notificaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "notificaciones_sms")
@DiscriminatorValue("SMS")
public class NotificacionSMS extends Notificacion {

    @Column(name = "numero_telefono", length = 20)
    private String numeroTelefono;

    @Column(name = "operadora", length = 50)
    private String operadora;

    protected NotificacionSMS() {}

    public NotificacionSMS(String codigo, String destinatario, String mensaje,
                            TipoNotificacion tipo, String numeroTelefono, String operadora) {
        super(codigo, destinatario, mensaje, tipo);
        this.numeroTelefono = numeroTelefono;
        this.operadora = operadora;
    }
}