package com.universidad.notificaciones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.notificaciones.controller.dto.NotificacionMovilRequest;
import com.universidad.notificaciones.model.NotificacionMovil;
import com.universidad.notificaciones.service.NotificacionMovilService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones/movil")
@RequiredArgsConstructor
public class NotificacionMovilController {

    private final NotificacionMovilService movilService;

    @PostMapping("/enviar")
    public ResponseEntity<NotificacionMovil> enviar(
            @Valid @RequestBody NotificacionMovilRequest req) {
        NotificacionMovil notificacion = new NotificacionMovil(
                req.getCodigo(), req.getDestinatario(), req.getMensaje(),
                req.getTipoNotificacion(), req.getTokenDispositivo(), req.getPlataforma()
        );
        return ResponseEntity.ok(movilService.enviar(notificacion));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<NotificacionMovil> consultarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(movilService.consultarPorCodigo(codigo));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<NotificacionMovil>> consultarPorDestinatario(
            @PathVariable String destinatario) {
        return ResponseEntity.ok(movilService.consultarPorDestinatario(destinatario));
    }
}