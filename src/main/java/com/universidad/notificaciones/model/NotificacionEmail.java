package com.universidad.notificaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "notificaciones_email")
@DiscriminatorValue("EMAIL")
public class NotificacionEmail extends Notificacion {

    @Column(name = "asunto", length = 200)
    private String asunto;

    @Column(name = "email_remitente", length = 100)
    private String emailRemitente;

    protected NotificacionEmail() {}

    public NotificacionEmail(String codigo, String destinatario, String mensaje,
                              TipoNotificacion tipo, String asunto, String emailRemitente) {
        super(codigo, destinatario, mensaje, tipo);
        this.asunto = asunto;
        this.emailRemitente = emailRemitente;
    }
}