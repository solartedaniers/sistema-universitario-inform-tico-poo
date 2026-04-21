package com.universidad.notificaciones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.notificaciones.controller.dto.NotificacionEmailRequest;
import com.universidad.notificaciones.model.NotificacionEmail;
import com.universidad.notificaciones.service.NotificacionEmailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones/email")
@RequiredArgsConstructor
public class NotificacionEmailController {

    private final NotificacionEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<NotificacionEmail> enviar(
            @Valid @RequestBody NotificacionEmailRequest req) {
        NotificacionEmail notificacion = new NotificacionEmail(
                req.getCodigo(), req.getDestinatario(), req.getMensaje(),
                req.getTipoNotificacion(), req.getAsunto(), req.getEmailRemitente()
        );
        return ResponseEntity.ok(emailService.enviar(notificacion));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<NotificacionEmail> consultarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(emailService.consultarPorCodigo(codigo));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<NotificacionEmail>> consultarPorDestinatario(
            @PathVariable String destinatario) {
        return ResponseEntity.ok(emailService.consultarPorDestinatario(destinatario));
    }
}