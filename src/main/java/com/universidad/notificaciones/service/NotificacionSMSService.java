package com.universidad.notificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universidad.notificaciones.model.EstadoNotificacion;
import com.universidad.notificaciones.model.NotificacionSMS;
import com.universidad.notificaciones.repository.NotificacionSMSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionSMSService implements INotificacionEnvioService<NotificacionSMS> {

    private final NotificacionSMSRepository smsRepository;

    @Override
    @SuppressWarnings("null")
    public NotificacionSMS enviar(NotificacionSMS notificacion) {
        var guardada = smsRepository.save(notificacion);
        simulacionEnvioSMS(guardada);
        guardada.actualizarEstado(EstadoNotificacion.ENVIADO);
        var actualizada = smsRepository.save(guardada);
        return actualizada;
    }

    @Override
    public NotificacionSMS consultarPorCodigo(String codigo) {
        return smsRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException(
                        "Notificacion SMS no encontrada con codigo: " + codigo));
    }

    @Override
    public List<NotificacionSMS> consultarPorDestinatario(String destinatario) {
        return smsRepository.findByDestinatario(destinatario);
    }

    private void simulacionEnvioSMS(NotificacionSMS n) {
        System.out.printf("[SMS] Para: %s | Numero: %s | Operadora: %s%n",
                n.getDestinatario(), n.getNumeroTelefono(), n.getOperadora());
    }
}
