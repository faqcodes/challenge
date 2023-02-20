# DESAFÍO

Para el desarrollo del desafío, se utiliza los principios de [The Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) aplicado al casos de uso.

Se intenta desacoplar en capas de tal manera de "proteger" las reglas de negocio de los detalles de la infraestructura utilizando inversión de dependencias y sin anotaciones de SpringBoot para desacoplar, por ejemplo, el DI framework

Se presentan esquemas de cómo se han desarrollado los casos de uso, desde las reglas de negocio hasta la implementación de las interfaces utilizadas (ver imágenes docs/images *.png o el historial de Github)

## Principios utilizados
---
- SOLID,
- DRY (Don't Repeat Yourself)
- SAP (Stable Abstractions Principle)


# Casos de uso: Registro de un usuario

Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:

```
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "hunter2",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}
````

- Responder el código de status HTTP adecuado
- En caso de éxito, retorne el usuario y los siguientes campos:
  - id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
  - created: fecha de creación del usuario
  - modified: fecha de la última actualización de usuario
  - last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)
  - token: token de acceso de la API (puede ser UUID o JWT)
  - isactive: Indica si el usuario sigue habilitado dentro del sistema.
- Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".
- El correo debe seguir una expresión regular para validar que formato sea el correcto. (aaaaaaa@dominio.cl)
- La clave debe seguir una expresión regular para validar que formato sea el correcto. (El valor de la expresión regular debe ser configurable)
- El token deberá ser persistido junto con el usuario

# Despliegue de la solución

