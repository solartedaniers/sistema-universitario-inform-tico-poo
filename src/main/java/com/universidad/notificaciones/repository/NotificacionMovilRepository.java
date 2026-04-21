package com.universidad.notificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidad.notificaciones.model.NotificacionMovil;

public interface NotificacionMovilRepository extends JpaRepository<NotificacionMovil, Long> {
    Optional<NotificacionMovil> findByCodigo(String codigo);
    List<NotificacionMovil> findByDestinatario(String destinatario);
}