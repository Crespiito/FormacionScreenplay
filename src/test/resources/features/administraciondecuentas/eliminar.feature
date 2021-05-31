Feature: administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  para validar el consumo exitoso de un servicio

  @EliminarCuentaExistenteDeFormaExitosa
  Scenario Outline: Eliminar cuenta existente de forma exitosa
    Given el usuario carga la informacion de la url <url>
    When el ingresa el tipo de autenticacion <tipoAutenticacion> y el token <token> de la cuenta
    Then el obtiene una respuesta exitosa <respuestaEsperada>
    Examples: Datos de eliminacion
      | url                                                                     | tipoAutenticacion | token                                                                                                                                                                           | respuestaEsperada |
      | https://demoqa.com/Account/v1/User/2d535036-8e53-44aa-b9f9-39b56c733b0d | Bearer Token      | eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBydWViYVNlcnZpY2lvIiwicGFzc3dvcmQiOiJQcnVlYmExMjMqIiwiaWF0IjoxNjIxOTAxNjgxfQ.7UqGVFTQAL53Kun5LMjS-V33istsaWEOZM95gbizjug | 204               |

  @EliminarCuentaExistenteConTokenInvalido
  Scenario Outline: Eliminar cuenta existente con token invalido
    Given el usuario carga la informacion de la url <url>
    When el ingresa el tipo de autenticacion <tipoAutenticacion> y el token <token> de la cuenta
    Then el obtiene una fallida <respuestaEsperada>
    Examples: Datos de eliminacion
      | url                                                                     | tipoAutenticacion | token                                                                                                                                                                           | respuestaEsperada |
      | https://demoqa.com/Account/v1/User/2d535036-8e53-44aa-b9f9-39b56c733b0d | Bearer Token      | eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBydWViYVNlcnZpY2lvIiwicGFzc3dvcmQiOiJQcnVlYmExMjMqIiwiaWF0IjoxNjIxOTAxNjgxfQ.7UqGVFTQAL53Kun5LMjS-V33istsaWEOZM95gbizjug |                   |
