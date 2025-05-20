#language: pt

#Autor: Fredi Roldan
#Data: 17/05/2025

@Regressivo
Funcionalidade: Busca por artigos relacionados ao INSS

  Cenario: Buscar por termo válido "INSS"
    Dado que estou na página do Blog do Agi
    Quando pesquiso por "INSS" no campo de busca do INSS"
    Entao devo ver artigos relacionados

  Cenario: Buscar com campo vazio
    Dado que estou na página do Blog do Agi
    Quando pesquiso por ""
    Entao devo ver uma mensagem de erro
