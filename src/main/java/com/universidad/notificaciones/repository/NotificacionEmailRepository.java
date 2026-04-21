package com.universidad.notificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidad.notificaciones.model.NotificacionEmail;

public interface NotificacionEmailRepository extends JpaRepository<NotificacionEmail, Long> {
    Optional<NotificacionEmail> findByCodigo(String codigo);
    List<NotificacionEmail> findByDestinatario(String destinatario);
}