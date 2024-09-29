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

**Opción 1: Levantar únicamente el servidor Backend de Spring Boot**


1. **Clonar el repositorio**:  
git clone https://github.com/stark-industries/security-system-backend.git  
cd security-system-backend


2. **Levantar una instancia de la base de datos PostgreSQL a la que se conecta automáticamente el servidor (en el caso de que se use una BBDD local debe estar configurada para servir en el puerto 5432)**:
   Se puede hacer con una BBDD local o para mayor comodidad hemos hecho un docker compose que coge la imagen de docker hub y la sirve automáticamente en un contenedor en el puerto indicado, simplemente se debe tener instalada la utilidar Docker Compose y ejecutar el comando

   'docker compose up postgres_db'


  **Opción 2: Levantar la aplicación completa (Postgres + Backend + Frontend)**
  
1. **Clonar el repositorio**:  
git clone https://github.com/stark-industries/security-system-backend.git  
cd security-system-backend  

2. **Clonar el repositorio frontend al mismo nivel que el backend (para que docker compose resuelva correctamente las rutas)**:  
- https://github.com/grupo-concurrente/p1-starkindustries-frontend

3. **Ejecutar la aplicación usando el orquestdor Docker Compose**:  
- Desde la línea de comandos: docker compose up (o docker compose up --build si desea recompilar la imagen)

4. **Abrir la WebApp**:  
- Para abrir la aplicación el fronend se expone en el puerto 5173 de localhost:  http://localhost:5173
