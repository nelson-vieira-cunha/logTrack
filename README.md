# 🚛 LogiTrack - Sistema de Gestão de Viagens e Manutenções

## 📌 Descrição do Projeto

O **LogiTrack** é uma aplicação full-stack para gestão de frotas, permitindo o controle de:

* Viagens realizadas
* Manutenções de veículos
* Indicadores operacionais (Dashboard)

O sistema foi desenvolvido com foco em **boas práticas de arquitetura**, separação de responsabilidades e **visual profissional (Angular Material)**.

---

# 🏗️ Arquitetura

## 🔹 Backend (Spring Boot)

* Arquitetura em camadas:

  * `Controller` → Entrada REST
  * `Service` → Regras de negócio
  * `Repository` → Acesso ao banco (JPA + SQL nativo)
  * `Entity` → Mapeamento das tabelas

## 🔹 Frontend (Angular Standalone)

* Componentes standalone (sem AppModule)
* Angular Material (UI profissional)
* Comunicação via REST API

## 🔹 Banco de Dados

* H2 (ambiente de desenvolvimento)
* Estrutura baseada em:

  * `veiculos`
  * `viagens`
  * `manutencoes`

---

# ⚙️ Tecnologias Utilizadas

### Backend

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database

### Frontend

* Angular (Standalone)
* Angular Material
* RxJS

---

# 📊 Funcionalidades

## 🚛 Viagens

* Cadastro de viagens
* Associação com veículo
* Controle de quilometragem

## 🔧 Manutenções

* Cadastro de manutenção
* Status (Pendente, Em andamento, Concluída)
* Controle de custos

## 📈 Dashboard (SQL obrigatório)

### Métricas:

* ✔ Total de KM percorrido
* ✔ Volume por categoria (LEVE / PESADO)
* ✔ Cronograma de manutenções (Top 5)
* ✔ Ranking de utilização (veículo mais usado)
* ✔ Projeção financeira (custos do mês)

---

# 🚀 Como rodar o projeto

## 🔹 1. Clonar repositório

```bash
git clone https://github.com/nelson-vieira-cunha/logTrack.git
```

---

## 🔹 2. Backend (Spring Boot)

### ▶️ Rodar aplicação

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### 🔧 Configuração (`application.properties`)

```properties
spring.datasource.url=jdbc:h2:mem:logitrack
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### 🌐 Acessos

* API: http://localhost:8080
* H2 Console: http://localhost:8080/h2-console

---

## 🔹 3. Frontend (Angular)

```bash
git clone https://github.com/nelson-vieira-cunha/logTrack--ui.git
npm install
ng serve
```

### 🌐 Acesso

```bash
http://localhost:4200
```

---

# 🔌 Integração Front ↔ Back

* Frontend roda em: `localhost:4200`
* Backend roda em: `localhost:8080`

⚠️ CORS configurado no backend para permitir comunicação.

---

# 📂 Estrutura do Projeto

## Backend

```
com.logTrack
├── controller
├── service
├── repository
├── entity
```

## Frontend

```
src/app
├── pages
│   ├── viagens
│   └── manutencoes
├── services
├── models
```

---

# 🧠 Decisões Técnicas

## ✔ Standalone Components (Angular)

* Elimina necessidade de módulos
* Simplifica arquitetura
* Melhor alinhamento com versões modernas

## ✔ SQL Nativo para Dashboard

* Melhor performance para agregações
* Controle total das consultas
* Aderência ao requisito do projeto

## ✔ H2 Database

* Facilidade para desenvolvimento local
* Sem necessidade de instalação externa

## ✔ Angular Material

* Interface consistente e profissional
* Componentes prontos e acessíveis

---

# ⚠️ Problemas comuns e soluções

## ❌ CORS error

➡️ Resolver com `@CrossOrigin` no backend

## ❌ HttpClient error

➡️ Adicionar `provideHttpClient()` no `main.ts`

## ❌ Banco não encontrado

➡️ Usar:

```properties
jdbc:h2:mem:logitrack
```

---

