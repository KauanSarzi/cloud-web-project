**Deploy de Aplicação Web com Docker em Serviços de Nuvem**

**1. Introdução**

Este projeto teve como objetivo desenvolver e realizar o deploy de uma
aplicação web em ambiente de nuvem utilizando Docker e instâncias EC2 da
AWS. Durante o desenvolvimento, foram aplicados conceitos fundamentais
de computação em nuvem, como virtualização, redes privadas (VPC),
controle de acesso por meio de Security Groups e comunicação entre
serviços.

**2. Descrição da aplicação**

A aplicação desenvolvida é composta por duas partes:

-   Frontend: uma interface web simples construída com HTML, CSS e
    JavaScript, contendo um botão que realiza uma requisição ao backend.

-   Backend: uma aplicação desenvolvida em Java utilizando Spring Boot,
    contendo uma rota /mensagem que retorna uma resposta em formato
    JSON.

A comunicação entre frontend e backend ocorre via requisição HTTP,
utilizando JavaScript (fetch).

<img width="1568" height="728" alt="image" src="https://github.com/user-attachments/assets/4b7bdde3-6e7f-4971-9711-c00de1bb9049" />

**3. Tecnologias utilizadas**

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto:

-   Java (Spring Boot)

-   HTML, CSS e JavaScript

-   Docker

-   Nginx

-   AWS EC2

-   VPC (Virtual Private Cloud)

-   Security Groups

**4. Containerização com Docker**

**4.1 Backend**

O backend foi containerizado utilizando Docker, permitindo que a
aplicação Java fosse executada de forma independente do ambiente. O
Dockerfile do backend foi estruturado da seguinte forma:

-   Utilização de uma imagem base com Java

-   Cópia do arquivo .jar gerado

-   Exposição da porta 25000

-   Execução da aplicação

**4.2 Frontend**

O frontend foi containerizado utilizando Nginx, que atua como servidor
web responsável por servir os arquivos estáticos da aplicação. O
Dockerfile do frontend:

-   Utiliza a imagem do Nginx

-   Copia os arquivos HTML para o diretório padrão do servidor

-   Expõe a porta 80 (mapeada para 8080 externamente)

**5. Infraestrutura na AWS**

Para o deploy da aplicação, foram utilizadas duas instâncias EC2:

<img width="1568" height="217" alt="image" src="https://github.com/user-attachments/assets/775aa712-bdb3-4e5b-97fd-b11b34bdce71" />


**5.1 EC2 Web**

-   Responsável pelo frontend

-   Acesso público habilitado

-   Porta 8080 aberta para acesso externo

**5.2 EC2 Backend**

-   Responsável pelo backend

-   Comunicação restrita

-   Não exposta diretamente à internet

**6. Configuração de rede e segurança**

A aplicação foi configurada utilizando a VPC padrão da AWS, permitindo
comunicação interna entre as instâncias. Foram configurados Security
Groups com as seguintes regras:

**EC2 Web -- Security Group**

-   Porta 8080 liberada para acesso público

-   Porta 22 (SSH) para acesso administrativo

<img width="980" height="145" alt="image" src="https://github.com/user-attachments/assets/af19c16b-233c-4297-a089-7a10d009ab61" />

**EC2 Backend -- Security Group**

-   Porta 25000 liberada apenas para a EC2 web

-   Porta 22 (SSH) para acesso administrativo

<img width="980" height="286" alt="image" src="https://github.com/user-attachments/assets/4c6f961a-54b0-43ed-91c0-1750d200905c" />

**7. Deploy da aplicação**

O processo de deploy foi realizado em ambas as instâncias EC2 utilizando
Docker.

Backend: Build da aplicação Java, criação da imagem Docker e execução do
container na porta 25000.

Frontend: Criação da imagem com Nginx e execução do container na porta
8080.

<img width="980" height="234" alt="image" src="https://github.com/user-attachments/assets/34bbd0a9-0dbf-4d21-b912-a59396cae695" />

*Figura 7 -- Container frontend em execução (docker ps na EC2 Web)*

<img width="980" height="134" alt="image" src="https://github.com/user-attachments/assets/a28f7be3-da07-4bcc-9bb9-56b0488bbe0d" />

*Figura 8 -- Container backend em execução (docker ps na EC2 Backend)*

**8. Testes realizados**

**Teste da aplicação web**

A aplicação foi acessada via navegador utilizando o IP público da EC2
web, exibindo a mensagem de resposta do backend Java.

<img width="1918" height="727" alt="image" src="https://github.com/user-attachments/assets/53ed58f1-77d1-46b2-b054-cf9d0c107ead" />

**Teste de segurança**

Foi realizada tentativa de acesso direto ao backend via navegador pelo
IP público da instância EC2 Backend, que foi bloqueada conforme esperado
pelos Security Groups configurados.

<img width="980" height="386" alt="image" src="https://github.com/user-attachments/assets/5d9bbb6b-8b10-4855-acd9-6c6399a293d7" />

**9. Desafios encontrados**

Durante o desenvolvimento, alguns desafios foram enfrentados:

-   Configuração de CORS no backend

-   Diferença entre localhost e acesso via IP

-   Problemas na comunicação entre containers

-   Configuração correta dos Security Groups

-   Atualização de containers após alterações

**10. Conclusão**

O projeto permitiu compreender na prática o processo de deploy de
aplicações web em ambiente de nuvem, utilizando Docker e AWS. Também foi
possível entender a importância da separação entre frontend e backend,
além da configuração de segurança para proteção dos serviços.

A utilização de duas instâncias EC2 e o isolamento do backend demonstram
uma arquitetura mais segura e próxima de ambientes reais de produção.


