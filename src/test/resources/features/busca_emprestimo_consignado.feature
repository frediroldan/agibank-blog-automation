#language: pt

#Autor: Fredi Roldan
#Data: 17/05/2025

@Regressivo
Funcionalidade: Busca por "Empréstimo Consignado" no Blog do Agi

  Cenario: Buscar por "Empréstimo Consignado" com resultados
    Dado que estou na página inicial do Blog do Agi
    Quando clico na lupa e digito "Empréstimo Consignado"
    E pressiono Enter
    Entao devo ver uma lista de artigos relacionados ao termo buscado

  Cenario: Buscar por termo inexistente
    Dado que estou na página inicial do Blog do Agi
    Quando clico na lupa e digito "xyz123"
    E pressiono Enter
    Entao devo ver uma mensagem indicando que nenhum resultado foi encontrado
