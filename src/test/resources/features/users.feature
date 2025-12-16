
Feature: Usuarios (ReqRes)
  Como tester
  Quiero consultar y crear usuarios
  Para validar endpoints simples GET y POST

  @ListarUsuarios @Api-Usuarios
  Scenario: Listar usuarios (GET) devuelve 200 y data
    When consulto la lista de usuarios de la pagina 2
    Then el codigo de estado es 200
    And la lista de usuarios no esta vacia

  @RegistrarUsuario @Api-Usuarios
  Scenario: Crear usuario (POST) devuelve 201
    When creo un usuario con Title "morpheus", Body "leader" y Id "userId"
    Then el codigo de estado es 201
    #And valido el mensaje respuesta "registro exitoso"
