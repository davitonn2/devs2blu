# 🕵️‍♂️ Portal de Denúncias Anônimas

## 📄 Descrição do Projeto
O Portal de Denúncias Anônimas é um sistema web voltado para que qualquer cidadão possa relatar situações como corrupção, assédio, crimes ou irregularidades sem precisar se identificar. O sistema garante o anonimato do denunciante, permitindo também o acompanhamento do status da denúncia por meio de um código de rastreio.

---

## 👨‍💼 Integrantes da Equipe
- Davi Augusto
- Kaio Levi

---

## 🛠️ Tecnologias Utilizadas
- **Front-end:** HTML, CSS, JavaScript, React
- **Back-end:** Java + Spring Boot
- **Banco de Dados:** PostgreSQL
- **Outros:** JWT (autenticação), Swagger (documentação), AWS (deploy)

---

## ✅ Quantidade Total de Sprints
**25 sprints**

---

## 🔄 Resumo sobre a Metodologia Ágil
A metodologia Ágil facilitou a divisão de tarefas e a entrega de funcionalidades de forma incremental. A principal vantagem foi a clareza nos papéis e prazos definidos. A maior dificuldade foi organizar as tarefas entre os membros nas primeiras sprints, o que foi resolvido com comunicação constante e revisões periódicas.

---

## 🏛️ Sprints Desenvolvidas

### Sprint 1: Cadastro de Denúncia Anônima
- *O que foi feito:* Formulário com campos de categoria, descrição, local e data. Backend para salvar os dados.
- *Desenvolvedores:* Davi e Kaio
- *O que cada um fez:*
  - Davi: Backend com endpoint para criar a denúncia.
  - Kaio: Front-end com React e validação.
- *Período de desenvolvimento:* 3 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 01/08/2025 - 07/08/2025

### Sprint 2: Geração de Código de Rastreamento
- *O que foi feito:* Código único gerado e associado à denúncia.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Backend para geração do código e exibição no front-end.
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 02/08/2025 - 07/08/2025

### Sprint 3: Consulta de Status da Denúncia
- *O que foi feito:* Página para inserir o código e visualizar o status da denúncia.
- *Desenvolvedores:* Davi
- *O que foi feito:* Endpoint de consulta e tela com feedback.
- *Período de desenvolvimento:* 3 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 03/08/2025 - 07/08/2025

### Sprint 4: Upload de Anexos (Imagens/PDFs)
- *O que foi feito:* Página para upload de arquivos de imagens e PDFs das denúncias.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Formulário com input de arquivo.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 04/08/2025 - 07/08/2025

### Sprint 5: Sistema de CAPTCHA contra Spam
- *O que foi feito:* Botão para verificar o CAPTCHA ao final do formulário.
- *Desenvolvedores:* Davi
- *O que foi feito:* Adicionada a API reCAPTCHA ao final do formulário.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 04/08/2025 - 07/08/2025

### Sprint 6: Tela de Agradecimento com Código de Rastreio
- *O que foi feito:* Página que exibe um texto de agradecimento com um código de rastreio.
- *Desenvolvedores:* Davi
- *O que foi feito:* Criada uma nova página com um h2 contendo um texto de agradecimento e um h4 com um código de rastreio/ID gerado automaticamente pelo banco.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 04/08/2025 - 08/08/2025

### Sprint 7: Painel de Login do Administrador
- *O que foi feito:* Página de login para o ator administrador.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Criada uma página com input de e-mail, input de senha, botão "Esqueci a senha" e botão para realizar o login.
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 2 dias
- *Deploy:* 2 dias
- *Data:* 11/08/2025 - 15/08/2025

### Sprint 8: Listagem de Denúncias no Painel Admin
- *O que foi feito:* Página com uma lista das denúncias feitas pelos atores públicos.
- *Desenvolvedores:* Davi
- *O que foi feito:* Criada uma página com uma lista ul contendo as denúncias feitas por meio do formulário.
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 11/08/2025 - 18/08/2025

### Sprint 9: Filtro por Categoria/Status/Data
- *O que foi feito:* Adicionados filtros para a lista de denúncias na página do administrador.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Criados botões que filtram a lista por categoria, status e data com JavaScript.
- *Período de desenvolvimento:* 3 dias
- *Testes:* 1 dia
- *Revisão:* 4 dias
- *Deploy:* 3 dias
- *Data:* 11/08/2025 - 19/08/2025

### Sprint 10: Mudança de Status: "Em Análise", "Respondida", "Arquivada"
- *O que foi feito:* Mudança de status das denúncias diretamente na lista.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Adicionado um select com as opções "Em Análise", "Respondida" e "Arquivada".
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 11/08/2025 - 20/08/2025

### Sprint 11: Envio de Resposta ao Denunciante via Tela de Consulta
- *O que foi feito:* Tela com envio de resposta por e-mail para o denunciante a respeito da denúncia.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Criada uma tela para envio de respostas por e-mail.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 11/08/2025 - 20/08/2025

### Sprint 12: Auditoria/Logs Internos
- *O que foi feito:* Registros gerados automaticamente pelo sistema que detalham qualquer interação feita por qualquer usuário.
- *Desenvolvedores:* Kaio
- *O que foi feito:* Arquivo JSON que registra os logs de qualquer alteração ou interação feita por qualquer tipo de usuário.
- *Período de desenvolvimento:* 5 dias
- *Testes:* 1 dia
- *Revisão:* 2 dias
- *Deploy:* 4 dias
- *Data:* 18/08/2025 - 26/08/2025

### Sprint 13: Paginação e Ordenação
- *O que foi feito:* Paginação e ordenação dos dados das denúncias.
- *Desenvolvedores:* Davi
- *O que foi feito:* Botões "Anterior" e "Próximo" para navegar entre as páginas e selects que ordenam a lista por data da ocorrência.
- *Período de desenvolvimento:* 3 dias
- *Testes:* 2 dias
- *Revisão:* 4 dias
- *Deploy:* 3 dias
- *Data:* 18/08/2025 - 28/08/2025

### Sprint 14: Layout Responsivo
- *O que foi feito:* Telas com design responsivo.
- *Desenvolvedores:* Kaio e Davi
- *O que foi feito:* Funções @media no CSS de todas as páginas para telas de 720px, 1080px e 2120px.
- *Período de desenvolvimento:* 5 dias
- *Testes:* 3 dias
- *Revisão:* 2 dias
- *Deploy:* 5 dias
- *Data:* 25/08/2025 - 29/08/2025

### Sprint 15: Estatísticas e gráficos de categorias
- *O que foi feito:* Feito os gráficos e estatísticas de cada categoria
- *Desenvolvedores:* Davi
- *O que foi feito:* Utilizado ferramentas para a geração dos gráficos e estatísticas.
- *Período de desenvolvimento:* 4 dias
- *Testes:* 2 dias
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 03/08/2025 - 06/08/2025


### Sprint 16: Cadastro de administradores
- *O que foi feito:* Implementação da funcionalidade de usarios administradores no sistema.
- *Desenvolvedores:* Davi
- *O que foi feito:* Código gerado a partir da especificação recomendada
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 02/08/2025 - 03/08/2025


### Sprint 17: Sistema de permissões
- *O que foi feito:* Implementação da funcionalidade de permições do sistema com base nos diferentes níveis de usuários
- *Desenvolvedores:* Davi
- *O que foi feito:* Análise e código feito a partir das definições definidas previamente
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 01/08/2025 - 02/08/2025


### Sprint 18: Documentação da API (Swagger)
- *O que foi feito:* Documentado nossa API para caso necessite de alterações futuras
- *Desenvolvedores:* Kaio
- *O que foi feito:* Utilizado o Swagger para documentar de forma rápida nossa API.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 15/08/2025

### Sprint 19: Testes unitários (JUnit)
- *O que foi feito:* Criação e implementação de teste unitários com o JUnit
- *Desenvolvedores:* Davi e Kaio
- *O que foi feito:* Código feito com base nas classes e métodos ja implementados no sistema, visando as boas práticas de teste
- *Período de desenvolvimento:** 4 dias
- *Testes:* 2 dias
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 10/08/2025 - 13/08/2025


### Sprint 20: Integração com notificadores (e-mail para admins)
- *O que foi feito:* Criação e implementação de envio de e-mails para os administradores do sistema usando SMTP
- *Desenvolvedores:* Davi e Kaio
- *O que foi feito:* Integração com a ferramenta paga Mailgun para otimizar o envio e melhorar a comunicação com os usuários
- *Período de desenvolvimento:* 3 dias
- *Testes:* 1 dia
- *Revisão:* 2 dias
- *Deploy:* 1 dia
- *Data:* 10/08/2025 - 12/08/2025

### Sprint 21: Política de privacidade e LGPD
- *O que foi feito:* Criado as políticas de privicidade e LGPD para o sistema
- *Desenvolvedores:* Kaio
- *O que foi feito:* Ferramenta Open Source utilizada para geração dos documentos, com posterior adaptação ao contexto do sistema.
- *Período de desenvolvimento:* 2 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 2 dias
- *Data:* 09/08/2025 - 10/08/2025


### Sprint 22: Página institucional
- *O que foi feito:* Pagina "About Us" criada e implementada no sistema
- *Desenvolvedores:* Kaio
- *O que foi feito:* Página desenvolvida para apresentar informações sobre a empresa, seus objetivos e os criadores do sistema
- *Período de desenvolvimento:* 2,5 dias
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 17/08/2025 - 19/08/2025


### Sprint 23: Tema escuro/claro
- *O que foi feito:* Criado o suporte do sistema para temas claro/escuro.
- *Desenvolvedores:* Davi
- *O que foi feito:* Implementado suporte a tema claro e escuro no sistema, com alternância manual e persistência da escolha do usuário.
- *Período de desenvolvimento:* 1 dia
- *Testes:* 1 dia
- *Revisão:* 1 dia
- *Deploy:* 1 dia
- *Data:* 20/08/2025

### Sprint 24: Implementação da Rotina de Backup Automático do Banco de Dados
- *O que foi feito:*  Implementada e configurada a rotina automática de backup do banco de dados, garantindo a segurança e integridade das informações armazenadas no sistema.
- *Desenvolvedores:* Davi
- *O que foi feito:* Desenvolvidos scripts/configurações para execução periódica, verificação de integridade e tratamento de falhas
- *Período de desenvolvimento:* 2 dia
- *Testes:* 1 dias
- *Revisão:* 0,5 dia
- *Deploy:* 0,5 dia
- *Data:* 21/08/2025 - 22/08/2025

  ### Sprint 25: Deploy Final da Aplicação com Banco de Dados na AWS e Backup Automático Integrado
- *O que foi feito:* Realizado o deploy final da aplicação em ambiente de produção na AWS
- *Desenvolvedores:* Kaio
- *O que foi feito:* A aplicação utilizou banco de dados gerenciado que já conta com rotina de backup automático previamente configurada, além de alta disponibilidade e segurança.
- *Período de desenvolvimento:* 5 dia
- *Testes:* 1 dias
- *Revisão:* 2 dia
- *Deploy:* 2 dia
- *Data:* 27/08/2025 - 31/08/2025
