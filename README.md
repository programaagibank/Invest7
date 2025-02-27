# Simulador de Investimentos

## 📊 Sobre o Projeto

O Simulador de Investimentos é uma aplicação que permite aos usuários simular diferentes cenários de investimentos, comparar rendimentos entre diversas modalidades financeiras e tomar decisões mais informadas sobre seus investimentos.

### Principais funcionalidades:
- Simulação de investimentos em renda fixa e variável
- Comparação entre diferentes tipos de investimentos
- Histórico de simulações realizadas
- Geração de relatórios personalizados
- Cálculo de rentabilidade com base em dados históricos

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java** - Linguagem de programação principal
- **Spring Boot** - Framework para desenvolvimento do backend
- **Hibernate** - Mapeamento objeto-relacional
- **JUnit** - Testes unitários
- **Maven** - Gerenciamento de dependências

### Banco de Dados
- **MySQL** - Sistema de gerenciamento de banco de dados relacional

### Metodologia de Desenvolvimento
- **Scrum** - Metodologia ágil para gerenciamento do projeto
- **Kanban** - Visualização do fluxo de trabalho
- **Sprints** de 2 semanas
- **Daily meetings** para acompanhamento do progresso

## 🚀 Como executar o projeto

### Pré-requisitos
- JDK 17 ou superior
- Maven 3.8 ou superior
- MySQL 8.0 ou superior

### Configuração do Banco de Dados
```sql
CREATE DATABASE simulador_investimentos;
CREATE USER 'simulador_app'@'localhost' IDENTIFIED BY 'senha_secreta';
GRANT ALL PRIVILEGES ON simulador_investimentos.* TO 'simulador_app'@'localhost';
FLUSH PRIVILEGES;
```

## 🔄 Fluxo de Trabalho da Metodologia Ágil

- **Product Backlog**: Lista priorizada de todas as funcionalidades do sistema
- **Sprint Planning**: Reunião para definir o escopo de cada sprint
- **Daily Scrum**: Reunião diária para acompanhamento do progresso
- **Sprint Review**: Demonstração das funcionalidades implementadas
- **Sprint Retrospective**: Análise do processo e identificação de melhorias

## 📈 Próximos Passos

- Implementação de mais modalidades de investimentos
- Integração com APIs externas para obtenção de dados em tempo real
- Desenvolvimento de frontend em React
- Implementação de autenticação e autorização
- Adição de funcionalidades de projeção financeira a longo prazo

## 👥 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das suas mudanças (`git commit -m 'Adicionando nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
