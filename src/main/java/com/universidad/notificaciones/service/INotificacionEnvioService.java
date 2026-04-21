package com.universidad.notificaciones.service;

public interface INotificacionEnvioService<T> {
    T enviar(T notificacion);
    T consultarPorCodigo(String codigo);
    java.util.List<T> consultarPorDestinatario(String destinatario);
}