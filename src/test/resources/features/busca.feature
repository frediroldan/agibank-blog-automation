#language: pt

#Autor: Fredi Roldan
#Data: 17/05/2025

@Regressivo
Funcionalidade: Busca geral no Blog do Agi

  Cenario: Buscar com sucesso pelo termo "Crédito"
    Dado que estou na página do Blog do Agi
    Quando pesquiso por "Crédito"
    Entao devo ver artigos relacionados

  Cenario: Buscar por conteúdo inexistente
    Dado que estou na página do Blog do Agi
    Quando pesquiso por "xpto-asd-123"
    Entao devo ver uma mensagem de erro
