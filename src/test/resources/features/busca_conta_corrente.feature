#language: pt

#Autor: Fredi Roldan
#Data: 17/05/2025

@Regressivo
Funcionalidade: Busca por artigos relacionados à Conta Corrente

  Cenario: Buscar por termo válido "Conta Corrente"
    Dado que estou na homepage do Blog Agi
    Quando pesquiso pelo termo "Conta Corrente"
    Entao deve retornar artigos sobre Conta Corrente

  Cenario: Buscar por espaços em branco
    Dado que estou na homepage do Blog Agi
    Quando pesquiso pelo termo "   "
    Entao deve aparecer aviso de pesquisa inválida
