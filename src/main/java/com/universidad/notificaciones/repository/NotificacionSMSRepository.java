package com.universidad.notificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidad.notificaciones.model.NotificacionSMS;

public interface NotificacionSMSRepository extends JpaRepository<NotificacionSMS, Long> {
    Optional<NotificacionSMS> findByCodigo(String codigo);
    List<NotificacionSMS> findByDestinatario(String destinatario);
}