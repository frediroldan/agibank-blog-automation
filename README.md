# 🧪 Blog do Agi – Projeto de Testes Automatizados (PageFactory + Cucumber)

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.5-green)
![Selenium](https://img.shields.io/badge/Selenium-4.21.0-brightgreen)
![Cucumber](https://img.shields.io/badge/Cucumber-7.14.0-yellow)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-red)
![Allure](https://img.shields.io/badge/Allure-2.24.0-purple)

## 📌 Descrição do Projeto

Este projeto automatiza testes de regressão da funcionalidade de **busca de artigos** do [Blog do Agi](https://blogdoagi.com.br/), utilizando:

- **Java 11+**
- **Selenium WebDriver**
- **Cucumber com BDD (Gherkin)**
- **Padrão Page Object + PageFactory**
- **Relatórios Cucumber HTML e Allure**
- **Pipeline Jenkins para CI/CD**

## 📂 Estrutura do Projeto

```
blogdoagi-tests/
├── src/
│   ├── main/java/pages/           → Page Object com PageFactory
│   └── test/java/stepDefinitions/ → Steps por contexto + steps reutilizáveis
│   └── test/java/runners/         → Runner de testes
│   └── test/resources/features/   → Cenários Gherkin
├── pom.xml                        → Gerenciador de dependências
├── Jenkinsfile                    → Pipeline CI/CD
```

## ⚙️ Tecnologias e Versões

| Ferramenta         | Versão     | Descrição                                   |
|--------------------|------------|---------------------------------------------|
| Java               | 11+        | Linguagem base                              |
| Maven              | 3.9.5      | Build automation tool                        |
| Selenium WebDriver | 4.21.0     | Automação de browser                        |
| Cucumber           | 7.14.0     | BDD com Gherkin                             |
| Allure             | 2.24.0     | Relatórios de execução                      |
| WebDriverManager   | 5.8.0      | Gerenciador automático do driver            |

## 🚀 Execução Local

### 1. Clonar o projeto

```bash
git clone https://github.com/seuusuario/blogdoagi-tests.git
cd blogdoagi-tests
```

### 2. Rodar os testes

```bash
mvn clean test verify
```

### 3. Gerar Relatório HTML (Cucumber)

```bash
# Após rodar:
abrir o arquivo:
target/cucumber-html-reports/overview-features.html
```

### 4. Gerar Allure Report

```bash
allure serve allure-results
```

> Certifique-se de ter o [Allure CLI](https://docs.qameta.io/allure/#_installing_a_commandline) instalado.

## ✅ Tags disponíveis para execução

| Tag         | Descrição                              |
|-------------|----------------------------------------|
| `@conta`    | Busca por Conta Corrente               |
| `@cartoes`  | Busca por Cartões                      |
| `@inss`     | Busca por temas do INSS                |
| `@busca`    | Busca genérica por artigos             |
| `@Regressivo` | Executa todos os cenários principais  |

```bash
mvn clean test -Dcucumber.filter.tags="@cartoes"
```

## 🧱 Page Object com PageFactory

```java
@FindBy(css = "input.search-field")
private WebElement campoBusca;

public void buscarPor(String termo) {
    campoBusca.sendKeys(termo);
    campoBusca.submit();
}
```

> A separação das responsabilidades entre Page e StepDefinition melhora a manutenção e reuso dos testes.

## 🔁 Reutilização com Steps Compartilhados

```java
@Entao("devo ver artigos relacionados")
public void verificarArtigosRelacionados() {
    Assert.assertTrue(homePage.encontrouResultados());
}
```

Classe: `ValidacoesComunsSteps.java`

## 🛠️ Integração CI/CD com Jenkins

### Jenkinsfile

```groovy
pipeline {
    agent any
    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.5'
    }
    environment {
        IS_WINDOWS = "${isUnix() ? 'false' : 'true'}"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/seurepositorio/blogdoagi-tests.git'
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    def comando = "mvn clean test verify"
                    if (env.IS_WINDOWS == 'true') {
                        bat comando
                    } else {
                        sh comando
                    }
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, results: [[path: 'allure-results']]
            }
        }
        stage('Archive HTML Reports') {
            steps {
                archiveArtifacts artifacts: 'target/cucumber-html-reports/**/*.*', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo '✅ Pipeline finalizada com sucesso!'
        }
        failure {
            echo '❌ Falha na execução da pipeline.'
        }
    }
}
```

## 📈 Relatórios de Execução

| Relatório        | Caminho/Execução                          |
|------------------|-------------------------------------------|
| HTML (Cucumber)  | `target/cucumber-html-reports/index.html` |
| Allure CLI       | `allure serve allure-results`             |
| Jenkins Allure   | Usar plugin "Allure Jenkins Plugin"       |

## 🔒 Boas práticas aplicadas

- ✅ Separação de responsabilidades (Pages, Steps, Features)
- ✅ Sem repetição de código (`DRY`)
- ✅ Pipelines multiplataforma (Linux/Windows)
- ✅ Execução por tags
- ✅ PageFactory para robustez

## ❓ FAQ

**Q: Por que usar PageFactory e não apenas Page Object?**  
A PageFactory facilita a manutenção com `@FindBy`, melhora legibilidade e desacopla o código.

**Q: O que fazer se o ChromeDriver não abrir?**  
Atualize sua versão local de driver ou use o WebDriverManager como no projeto.

---
