#language: pt

#Autor: Fredi Roldan
#Data: 17/05/2025

@Regressivo
Funcionalidade: Busca por artigos sobre Cartões

  Cenario: Buscar por Cartões com resultados
    Dado que estou na página do Blog do Agi
    Quando pesquiso por "Cartões" no menu de cartões
    Entao devo ver artigos relacionados

  Cenario: Buscar por termo inválido
    Dado que estou na página do Blog do Agi
    Quando pesquiso por "cartoesinvalido"
    Entao devo ver uma mensagem de erro
