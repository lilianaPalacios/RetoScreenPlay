Feature: Diligenciamiento forms

  Como un usuario
  Quiero ingresar a la pagna de formularios
  Para diligenciar la informacion
  y validar los datos ingresados
 #Background:
  # Given El usuario desea acceder al formulario

 # @regression
  Scenario: Acceso al formulario
    Given El usuario desea acceder al formulario
    When Da clic en la opcion forms
    And Llena el formulario y lo envia
    Then Valida los campos
