package com.universidad.notificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universidad.notificaciones.model.EstadoNotificacion;
import com.universidad.notificaciones.model.NotificacionEmail;
import com.universidad.notificaciones.repository.NotificacionEmailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionEmailService implements INotificacionEnvioService<NotificacionEmail> {

    private final NotificacionEmailRepository emailRepository;

    @Override
    @SuppressWarnings("null")
    public NotificacionEmail enviar(NotificacionEmail notificacion) {
        var guardada = emailRepository.save(notificacion);
        simulacionEnvioEmail(guardada);
        guardada.actualizarEstado(EstadoNotificacion.ENVIADO);
        var actualizada = emailRepository.save(guardada);
        return actualizada;
    }

    @Override
    public NotificacionEmail consultarPorCodigo(String codigo) {
        return emailRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException(
                        "Notificacion email no encontrada con codigo: " + codigo));
    }

    @Override
    public List<NotificacionEmail> consultarPorDestinatario(String destinatario) {
        return emailRepository.findByDestinatario(destinatario);
    }

    private void simulacionEnvioEmail(NotificacionEmail n) {
        System.out.printf("[EMAIL] Para: %s | Asunto: %s | Remitente: %s%n",
                n.getDestinatario(), n.getAsunto(), n.getEmailRemitente());
    }
}
