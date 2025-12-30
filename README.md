# 🔗 Encurtador de URLs

Projeto backend desenvolvido em **Java com Spring Boot**, que permite encurtar URLs longas, armazená-las com prazo de validade e realizar redirecionamento automático para a URL original.

Este projeto foi criado como **desafio técnico** e também faz parte do meu **portfólio**, com foco em boas práticas, arquitetura limpa e deploy em cloud.

---

## 🚀 Funcionalidades

* Encurtar URLs longas em códigos alfanuméricos (5 a 8 caracteres)
* Redirecionamento automático usando HTTP **302 (FOUND)**
* Validação de dados com **Bean Validation**
* URLs com **data de expiração**
* Tratamento global de exceções
* Persistência em banco de dados **PostgreSQL**
* Deploy em cloud com **Docker** e **Railway**
* CI/CD automático a cada commit no GitHub

---

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

* **Controller** → Camada REST (endpoints HTTP)
* **Service** → Regras de negócio
* **Repository** → Acesso a dados com Spring Data JPA
* **Model** → Entidades e DTOs
* **Exception** → Tratamento centralizado de erros

---

## 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Bean Validation
* PostgreSQL
* Docker
* Railway (Cloud Deploy)
* Maven

---

## 📌 Endpoints

### 🔹 Encurtar URL

**POST** `/url/encurtar`

```json
{
  "url": "https://backendbrasil.com.br"
}
```

**Response:**

```json
{
  "urlEncurtada": "DXB6V"
}
```

---

### 🔹 Redirecionar para URL original

**GET** `/{codigo}`

Exemplo:

```
GET /DXB6V
```

➡️ Redireciona automaticamente para a URL original.

* Retorna **302 FOUND** se existir e estiver válida
* Retorna **404 NOT FOUND** se não existir ou estiver expirada

---

## ⏳ Expiração de URLs

Cada URL encurtada possui uma data de expiração definida no momento da criação.

A validação é feita diretamente na consulta ao banco de dados utilizando **JPQL**, garantindo que apenas URLs válidas sejam retornadas.

---

## 🐳 Docker & Deploy

O projeto é totalmente containerizado com Docker.

Para produção, utiliza:

* Banco PostgreSQL gerenciado
* Variáveis de ambiente
* Deploy automático via integração com GitHub

Cada commit na branch principal dispara automaticamente o build e deploy da aplicação.

---

## 🌍 Acesso em Produção

A aplicação está disponível publicamente via Railway:

```
encurtadorurl-production.up.railway.app
```

---

## 🧪 Como executar localmente

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo
docker compose up
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

## 📈 Próximas Evoluções

* Contador de acessos por URL
* Rate limit
* Limpeza automática de URLs expiradas
* Domínio customizado
* Observabilidade e métricas

---

## 👤 Autor

**Felipe Santana**
Desenvolvedor Backend Java

🔗 LinkedIn: https://www.linkedin.com/in/felipe-santanadev/
---

⭐ Se você gostou do projeto, deixe uma estrela no repositório!
