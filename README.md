# 🔐 Stark Industries Security System - Backend

Este repositorio contiene el **backend** del Sistema de Seguridad Concurrente para **Stark Industries**. Está desarrollado con **Spring Boot** y es responsable de gestionar la autenticación, el control de acceso, el procesamiento concurrente de datos de sensores, y las notificaciones en tiempo real.

## 📋 Descripción

El sistema de seguridad de Stark Industries está diseñado para manejar un gran número de datos en tiempo real provenientes de sensores distribuidos en la nueva sede en Nueva York. Los sensores incluyen detectores de movimiento, temperatura, y control de acceso. El backend procesa de manera concurrente estos datos, asegurando un tiempo de respuesta eficiente ante eventos críticos.

Además, el backend implementa **autenticación y autorización** mediante **Spring Security** y utiliza **JWT** para gestionar el acceso de los usuarios. En caso de alertas críticas, se envían **notificaciones en tiempo real** utilizando **WebSocket** y servicios de mensajería.

## 🏗️ Arquitectura General

El backend es el corazón del sistema, encargado de procesar y gestionar todos los eventos generados por los sensores. La arquitectura incluye:

- **Spring Boot**: Framework principal del backend.  
- **Spring Security con JWT**: Manejo de autenticación y autorización.  
- **@Async y ExecutorService**: Para manejar la concurrencia en el procesamiento de datos de sensores.  
- **WebSocket**: Para enviar notificaciones en tiempo real.  
- **PostgreSQL**: Base de datos para almacenar los eventos y la información de los sensores.  
- **Spring Actuator**: Para la monitorización del sistema.  

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio**:  
git clone https://github.com/stark-industries/security-system-backend.git


2. **(Opcional) Si se desea ejecutar además el frontend se debe clonar dicho repositorio al mismo nivel que el de backend**

- https://github.com/grupo-concurrente/p1-starkindustries-frontend


3. **Levantar los servicios**

   Entramos en el directorio de backend
'cd ./p1-starkindustries-backend'

- **Para levantar únicamente la BBDD y el servidor backend** ejecutar > 'docker compose up postgres_db backend'

- **Para levantar los 3 servicios (Postgres + Backend + Frontend)** ejecutar > 'docker compose up'
  

4. **(Frontend) Abrir la WebApp**:  
- Para abrir la aplicación gráfica, el fronend se expone en el puerto 5173 de localhost, por lo que se debe acceder desde un navegador a la dirección http://localhost:5173
