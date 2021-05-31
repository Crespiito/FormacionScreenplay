Feature: administrar en el proceso la autorizacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar en el proceso la autorizacion de cuentas
  para validar el consumo exitoso del servicio

  @AutorizedExitosa
  Scenario Outline: Autorizacion exitosa de una cuenta
    Given el usuario carga la informacion de la url <url>
    When el ingresa los datos <usuario> y <contrasena>
    Then el obtiene una respuesta exitosa <respuestaEsperada>
    Examples: Datos de autenticacion
      | url                                      | usuario        | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/Authorized | PruebaServicio | Prueba123* | 200               |

  @AutorizedUsuarioNoEncontradoAutorized
  Scenario Outline: Autorizacion de usuario no encontrado
    Given el usuario carga la informacion de la url <url>
    When el ingresa los datos <usuario> y <contrasena> de una cuenta no creada
    Then el obtiene una respuesta de usuario no encontrado <respuestaEsperada>
    Examples: Datos de autenticacion
      | url                                      | usuario        | contrasena | respuestaEsperada |
      | https://demoqa.com/Account/v1/Authorized | PruebaServicio | Prueba123* | 404               |
