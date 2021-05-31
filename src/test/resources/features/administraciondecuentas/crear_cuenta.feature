Feature: administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  para validar el consumo exitoso de un servicio

  @CrearCuentaRespuestaExitosa
  Scenario Outline: Creacion exitosa de una cuenta
    Given el usuario carga la informacion de la url <url>
    When el ingresa los datos <usuario> y <contrasena>
    Then el obtiene una respuesta de creacion exitosa <respuestaEsperada>
    Examples: Datos de creacion
      | url                                | usuario        | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/User | PruebaServicio | Prueba123* | 201               |

  @CrearCuentaRespuestaFallida
  Scenario Outline: Creacion erronea de una cuenta
    Given el usuario carga la informacion de la url <url>
    When el ingresa los datos <usuario> y <contrasena> de una cuenta ya existente
    Then el obtiene una respuesta de usuario ya existente <respuestaEsperada>
    Examples: Datos de creacion
      | url                                | usuario        | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/User | PruebaServicio | Prueba123* | 406               |
