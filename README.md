# Blog do Agi - Testes Automatizados

Este projeto utiliza Java, Selenium WebDriver, Cucumber e JUnit para automatizar testes do blog https://blogdoagi.com.br/.

## Tecnologias
- Java 11
- Maven
- Selenium 4
- Cucumber 7
- Allure Reports

## Execução
```bash
mvn clean test verify
allure serve allure-results
```

## Jenkins
Use o Jenkinsfile incluído neste repositório para rodar em pipeline declarativa.
