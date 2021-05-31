Feature: administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  para validar el consumo exitoso de un servicio

  @ObtenerTokenDeFormaExitosa
  Scenario Outline: Obtener token de forma exitosa
    Given el usuario carga la informacion de la url <url>
    When el ingresa los datos <usuario> y <contrasena> de una cuenta ya existente
    Then el obtiene una respuesta de generacion de token exitosa <respuestaEsperada>
    Examples: Datos de obtencion de token
      | url                                         | usuario        | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/GenerateToken | PruebaServicio | Prueba123* | 200               |

  @ObtenerTokenDeFormaFallida
  Scenario Outline: Obtener Token De Forma Fallida
    Given el usuario carga la informacion de la url <url>
    When el no envia los datos <usuario> y <contrasena>
    Then el obtiene una respuesta de campos requeridos <respuestaEsperada>
    Examples: Datos de obtencion de token
      | url                                         | usuario | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/GenerateToken |         |            | 400               |