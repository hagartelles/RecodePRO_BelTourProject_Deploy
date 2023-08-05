Algoritmo "Cadastro BelTour"
// Usando conceitos de programação estruturada (Vetor), criar em pseudocódigo
// um menu para simular um cadastro para uma agência de viagens
// com as seguintes funções:
// cadastro de cliente e cadastro de destino
// criar também uma consulta para cada estrutura de dados.

//Cadastro cliente:
//nome completo, endereço com cep, data de nascimento, telefone e email.
//Preferência de destinos, se irá viajar sozinho,
//quais suas preferências de passeios.

Var
   // Seção de Declarações das variáveis
   opcaoInicial, indiceD, indice, contador :inteiro
   nomeDestino, nomeCliente:vetor [1..10] de caractere
   confirmar, confirmaOpcao:caractere

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   //funcao confirmaOpcao
   indice <- 1
   indiceD <- 1




   repita
      escreval("    ===============================")
      escreval("    |                             |")
      escreval("    |     Bem vindo a BelTour     |")
      escreval("    |                             |")
      escreval("    ===============================")
      escreval("")
      escreval("    O que você deseja fazer?")
      escreval("    1 - Cadastrar cliente ")
      escreval("    2 - Cadastrar destino")
      escreval("    3 - Consultar cliente ")
      escreval("    4 - Consultar destino")
      escreval("    0 - Sair")
      leia(opcaoInicial)
      escolha opcaoInicial


         caso 1
            repita
               escreval("Informe o nome do Cliente")
               leia(nomeCliente[indice])
               indice <- indice + 1
               escreval("Deseja cadastrar um novo cliente ? (s/n)")
               leia(confirmar)
            ate (confirmar <> "s")


         caso 2
            repita
               escreval("Informe o Destino")
               leia(nomeDestino[indiceD])
               indiceD <- indiceD + 1
               escreval("Deseja cadastrar um novo Destino ? (s/n)")
               leia(confirmar)
            ate (confirmar <> "s")


         caso 3
            para contador de 1 ate indice faca
                 escreval(nomeCliente[contador])
            fimpara


         caso 4
            para contador de 1 ate indiceD faca
                 escreval(nomeDestino[contador])
            fimpara

      fimescolha
   ate opcaoInicial = 0


Fimalgoritmo