package com.universidad.notificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.universidad.notificaciones.model.EstadoNotificacion;
import com.universidad.notificaciones.model.NotificacionMovil;
import com.universidad.notificaciones.repository.NotificacionMovilRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionMovilService implements INotificacionEnvioService<NotificacionMovil> {

    private final NotificacionMovilRepository movilRepository;

    @Override
    @SuppressWarnings("null")
    public NotificacionMovil enviar(NotificacionMovil notificacion) {
        var guardada = movilRepository.save(notificacion);
        simulacionEnvioPush(guardada);
        guardada.actualizarEstado(EstadoNotificacion.ENVIADO);
        var actualizada = movilRepository.save(guardada);
        return actualizada;
    }

    @Override
    public NotificacionMovil consultarPorCodigo(String codigo) {
        return movilRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException(
                        "Notificacion movil no encontrada con codigo: " + codigo));
    }

    @Override
    public List<NotificacionMovil> consultarPorDestinatario(String destinatario) {
        return movilRepository.findByDestinatario(destinatario);
    }

    private void simulacionEnvioPush(NotificacionMovil n) {
        System.out.printf("[PUSH] Para: %s | Token: %s | Plataforma: %s%n",
                n.getDestinatario(), n.getTokenDispositivo(), n.getPlataforma());
    }
}
