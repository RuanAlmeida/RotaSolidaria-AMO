# 🚗 Rota Solidária — Sistema de Gestão e Controle de Refugiados

Análise, desenvolvimento e implementação de um sistema desktop robusto voltado para organizações e empresas humanitárias responsáveis pelo gerenciamento, acolhimento e controle de fluxo de pessoas refugiadas.

O projeto foi concebido como a entrega principal do encerramento de semestre do curso de Ciência da Computação, unindo o rigor técnico da engenharia de software ao impacto social.

---

## 📝 Sobre o Projeto

O **Rota Solidária** é uma aplicação desktop desenvolvida para solucionar gargalos logísticos e operacionais enfrentados por instituições de apoio humanitário. O sistema centraliza dados críticos e automatiza processos que envolvem desde o acolhimento inicial até o acompanhamento contínuo da permanência e saída dessas populações, garantindo integridade, segurança da informação e relatórios consistentes para tomadas de decisão rápidas.

### 🚀 Principais Funcionalidades
- **Gestão de Acessos:** Módulo de autenticação seguro para administradores e usuários responsáveis pela operação do sistema.
- **Controle de Entrada e Saída:** Registro cronológico e detalhado do fluxo migratório e de acolhimento de refugiados.
- **Cadastro Centralizado de Pessoas:** Ficha cadastral completa contendo dados pessoais, documentação de identificação, histórico de triagem e status atual.
- **Persistência de Dados Confiável:** Armazenamento estruturado e consultas otimizadas utilizando banco de dados relacional.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

O projeto foi construído utilizando tecnologias consolidadas no ecossistema corporativo, garantindo escalabilidade e facilidade de manutenção:

- **Linguagem Principal:** [Java](https://www.oracle.com/java/)
- **Gerenciador de Dependências e Build:** [Apache Maven](https://maven.apache.org/) (Configurado via `pom.xml`)
- **Ambiente de Desenvolvimento (IDE):** [NetBeans](https://netbeans.apache.org/) (Interface desenvolvida de forma visual com arquivos `.form`)
- **Banco de Dados:** SQL (Persistência estruturada com scripts relacionais)

---

## 📐 Arquitetura do Sistema

Para garantir uma separação clara de responsabilidades, alta coesão e baixo acoplamento, o código-fonte foi estruturado seguindo uma variação do padrão **MVC (Model-View-Controller)** com foco no padrão arquitetural **DAO (Data Access Object)** para isolamento da camada de dados:

```text
rota-solidaria/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── main.java              # Classe principal que inicializa o sistema
│   │   │   │
│   │   │   ├── model/                 # Camada de Entidades do Negócio
│   │   │   │   └── Pessoa.java        # Estrutura de dados representativa do refugiado/usuário
│   │   │   │
│   │   │   ├── dao/                   # Camada de Persistência (Data Access Object)
│   │   │   │   ├── PessoaDao.java     # Métodos CRUD e consultas SQL para Pessoas
│   │   │   │   └── usuarioDAO.java    # Métodos de autenticação e controle de usuários
│   │   │   │
│   │   │   ├── util/                  # Classes Utilitárias e Ferramentas Auxiliares
│   │   │   │   └── Conexao.java       # Gerenciamento do ciclo de vida da conexão SQL
│   │   │   │
│   │   │   └── views / forms          # Telas e Interfaces Gráficas do Usuário (GUI)
│   │   │       ├── main.form / .java  # Dashboard e menu principal do sistema
│   │   │       ├── adm.form / .java   # Painel administrativo e controle de acessos
│   │   │       └── cadastro.form / .java # Tela de cadastro de refugiados e triagem
│   │   │
│   │   └── resources/                 # Arquivos de propriedades e configurações
│   └── test/                          # Classes de testes automatizados
│
└── pom.xml                            # Arquivo de configuração de dependências do Maven
