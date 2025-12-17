Feature: Usuarios (ReqRes)
  Como tester
  Quiero consultar y crear usuarios
  Para validar endpoints simples GET y POST

  @ListarUsuarios @Api-Usuariosx
  Scenario: Listar usuarios (GET) devuelve 200 y data
    When consulto la lista de usuarios
    Then el codigo de estado es 200
    And la lista de usuarios no esta vacia

  @RegistrarUsuario @Api-Usuarios
  Scenario Outline: Crear usuario (POST) devuelve 201
    When creo un usuario con Nombre "<nombre>", Usuario "<usuario>" y Email "<email>"
    Then el codigo de estado es 201
    #And valido el mensaje respuesta "registro exitoso"
    Examples:
      | nombre | usuario | email            |
      | Joel   | Joequi  | joelq@inetum.com |
      | Diego  | Diecio  | diego@test.com   |

  @BuscarUsuarioPorUsername @Api-Usuarios
  Scenario: Buscar usuario por username (GET) devuelve 200
    When busco el usuario por username "Bret"
    Then el codigo de estado es 200
    And la respuesta contiene al menos un usuario
    And el primer usuario tiene username "Bret"

  @BuscarUsuarioPorId @Api-Usuarios
  Scenario: Buscar usuario por id (GET) devuelve 200 y valida campos básicos
    When busco el usuario por id 1
    Then el codigo de estado es 200
    And la respuesta del usuario incluye los parametros name, username y email

