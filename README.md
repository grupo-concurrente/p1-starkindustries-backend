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
cd security-system-backend  

2. **Configurar la base de datos**:  
- Configura una instancia de PostgreSQL y añade los detalles en `src/main/resources/application.properties`:  
spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>  
spring.datasource.username=<usuario>  
spring.datasource.password=<contraseña>  

3. **Ejecutar la aplicación**:  
- Desde la línea de comandos:  
./mvnw spring-boot:run  

4. **Docker**:  
- Para ejecutar el backend en un contenedor Docker:  
docker build -t security-system-backend .  
docker run -p 8080:8080 security-system-backend  

## 🔑 Autenticación y Seguridad

- **Spring Security**: Se utiliza para gestionar la autenticación y autorización de usuarios.  
- **JWT (JSON Web Token)**: Autenticación basada en tokens. Los usuarios deben autenticarse y obtener un JWT para acceder a los servicios del backend.

## 🛠️ Tecnologías Utilizadas

- **Spring Boot**  
- **Spring Security**  
- **JWT**  
- **PostgreSQL**  
- **WebSocket**  
- **Docker**  

## 📊 Monitorización

Se ha configurado **Spring Actuator** para monitorizar el estado del sistema en tiempo real. Podrás acceder a la información de salud del sistema en `/actuator/health`.

---

## 📧 Contacto

Si tienes alguna duda o sugerencia sobre el proyecto, no dudes en contactarnos en soporte@starkindustries.com.

---

¡Gracias por contribuir a la seguridad de Stark Industries!
