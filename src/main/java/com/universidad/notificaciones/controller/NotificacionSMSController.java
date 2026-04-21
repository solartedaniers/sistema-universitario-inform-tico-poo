package com.universidad.notificaciones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.notificaciones.controller.dto.NotificacionSMSRequest;
import com.universidad.notificaciones.model.NotificacionSMS;
import com.universidad.notificaciones.service.NotificacionSMSService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones/sms")
@RequiredArgsConstructor
public class NotificacionSMSController {

    private final NotificacionSMSService smsService;

    @PostMapping("/enviar")
    public ResponseEntity<NotificacionSMS> enviar(
            @Valid @RequestBody NotificacionSMSRequest req) {
        NotificacionSMS notificacion = new NotificacionSMS(
                req.getCodigo(), req.getDestinatario(), req.getMensaje(),
                req.getTipoNotificacion(), req.getNumeroTelefono(), req.getOperadora()
        );
        return ResponseEntity.ok(smsService.enviar(notificacion));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<NotificacionSMS> consultarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(smsService.consultarPorCodigo(codigo));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<NotificacionSMS>> consultarPorDestinatario(
            @PathVariable String destinatario) {
        return ResponseEntity.ok(smsService.consultarPorDestinatario(destinatario));
    }
}