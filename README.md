# Backend de RaícesMX

Para configurarlo en tu entorno local, sigue los siguientes pasos:

## 1. Copiar el archivo de ejemplo

Copia el archivo `application.properties.example` que se encuentra en la raíz del proyecto y renómbralo a `application.properties`. Este archivo contiene las configuraciones necesarias para que el proyecto funcione en el entorno local.

```bash
cp application.properties.example application.properties
```

## 2. Configurar tus credenciales de AWS

Abre el archivo `application.properties` y agrega tus credenciales de AWS.

```properties
# Credenciales de AWS
aws.accessKeyId=tu-access-key-id
aws.secretAccessKey=tu-secret-access-key
aws.s3.bucketName=nombre-de-tu-bucket
aws.region=us-east-1
```

## 3. Configurar las credenciales de la base de datos

En el mismo archivo `application.properties`, configura las credenciales de tu base de datos.

```properties
# Credenciales de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/raicesmx
spring.datasource.username=tu-usuario-db
spring.datasource.password=tu-contraseña-db
```
