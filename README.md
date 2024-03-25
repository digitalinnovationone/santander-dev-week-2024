# Santander Dev Week 2024

RESTful API da Santander Dev Week 2024 construída em Java 21 com Spring Boot 3. Uma iniciativa fruto da parceria entre DIO e Santander para a divulgação dos Bootcamps Santander 2024.

Ainda não se inscreveu!? Então corre que ainda da tempo, as inscrições vão até 08/04/2024: [Landing Page do Santander](https://l.dio.me/devweeksantander).

## Diagrama Arquitetural Simplificado

```mermaid
graph LR;
  subgraph layer-infra[Infraestrutura];
    UI("Frontend (UI)") --> Controller
    subgraph layer-adpaters[Adaptadores];
      Controller("Controllers") <--> UC
      subgraph layer-app[Aplicação];
        UC(Casos de Uso) <--> Model
        subgraph layer-entities[Domínio];
          Model("Modelos")
          IPort("Interfaces das Portas (Gateways)")
        end
     end
     Repo("Repositórios") -..-> |implementam| IPort
     HTTP("Clientes HTTP") -..-> |implementam| IPort
    end
    BD("Bancos de Dados SQL") <--> Repo
    EXT("APIs REST de IA") <--> HTTP
  end

classDef infra fill:#a3c9ff,stroke:#00315c,color:#00315c;
classDef adapters fill:#67dbb1,stroke:#003828,color:#003828;
classDef ucs fill:#ffb1c1,stroke:#5f112b,color:#5f112b;
classDef entities fill:#e2c54b,stroke:#3a3000,color:#3a3000;

class BD,EXT,UI infra;
class Controller,Repo,HTTP adapters;
class UC ucs;
class Model,IPort entities;
```

## Estrutura de Diretórios

Sendo assim, a aplicação está organizada seguindo os princípios da [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), com o objetivo de separar as responsabilidades de maneira clara e promover a independência das camadas. Abaixo está a estrutura de diretórios adotada:

- `adapters/` - Contém os adaptadores que interagem com mecanismos externos ou recebem requisições do usuário.
  - `in/` - Adaptadores de entrada, como controladores REST, responsáveis por receber as requisições dos usuários.
  - `out/` - Adaptadores de saída, para interação com bancos de dados e APIs externas.
- `application/` - Define os casos de uso da aplicação, encapsulando a lógica de negócios.
- `domain/` - O núcleo da aplicação, incluindo entidades, exceções e interfaces (portas) que definem as regras de negócio.
  - `exception/` - Exceções personalizadas do domínio.
  - `model/` - Modelos de entidades do domínio.
  - `ports/` - Interfaces que definem os contratos para os adaptadores e serviços externos.
- `Application.java` - Classe principal que inicia a aplicação.

Esta estrutura promove a divisão das responsabilidades, facilitando a manutenção, testabilidade e a escalabilidade do sistema.
