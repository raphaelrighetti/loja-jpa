# JPA -Loja

## Persistência com JPA: Hibernate

Neste curso irei aprender a utilizar a JPA com a implementação do Hibernate com o intuito de aprofundar mais os meus conhecimentos na JPA.

### Aula 1

#### Entendendo motivação da JPA

Nesta aula entendi a motivação da criação do Hibernate e da JPA, o que eles facilitam em comparação com o JDBC e o EJB2 e a diferença o Hibernate (implementação) e a JPA (especificação).

Além disso, iniciei um projeto com as dependências necessárias para o início dos estudos.

### Aula 2

#### Configurando e persistindo

Nesta aula aprendi a configurar a JPA com o arquivo "persistence.xml", criando a minha "persistence-unit" com várias propriedades, tanto de conexão quanto outras específicas do Hibernate.

Também vi que as annotations que usamos no JPA são as mesmas que já estou acostumado a utilizar no Spring Data JPA, coisa que eu já imaginava, mas não tinha certeza.

Além disso, aprendi a usar o EntityManager para persistir os dados no banco de dados, assim como controlar as transações manualmente, tendo em vista que não estou utilizando o "transaction-type" RESOURCE_LOCAL.

Tive que mudar a minha dependência do Hibernate para conseguir acompanhar o curso fielmente utilizando o "javax" em vez do "jakarta" e também tive que fazer algumas modificações para conseguir usar o postgre como banco, mas no fim deu tudo certo.

### Aula 3

#### Aplicando relacionamento

Nesta aula vi que também é comum utilizar DAOs quando estamos trabalhando com a JPA, assim como no JDBC, além de ter visto que realmente é comum não deixar lógicas de transação e abertura de EntityManager, ou algo parecido, dentro do código dos nossos DAOs.

Além disso, vi como aplicar um relacionamento entre duas entidades JPA, que não é diferente da forma que fazemos no Spring Data JPA.

### Aula 4

#### Entendendo ciclo de vida

Nesta aula aprendi sobre o ciclo de vida das entidades e os possíveis estados delas nas ações possíveis.

É muito bom entender esse ciclo de vida, pois agora entendo o porquê de as mudanças que fazemos em entidades pêgas do banco de dados no Spring Data JPA são realmente persistidas no banco de dados sem termos que explicitamente chamar um método de atualizar ou algo do tipo.

### Aula 5

#### Listando e detalhando

Nesta aula aprendi a utilizar os métodos "find()" e "createQuery()", juntamente com a JPQL, para executar SELECTs no banco e conseguir fazer buscas por produtos no sistema.

Vi que não tem diferença entre a JPQL no Spring Data JPA e a JPQL no JPA puro com o Hibernate, apenas muda o jeito de executar as queries feitas com a JPQL.

### Conclusão

Neste curso pude aprender o básico de como utilizar a JPA com o Hibernate em um projeto Java sem o uso do Spring Data JPA e o Spring Boot, que facilitam muito na parte de configuração e mudam um pouco o jeito de executar as queries no banco, fazendo o uso dos Repositories no lugar dos DAOs.

Além disso, aprendi sobre o ciclo de vida das entidades JPA, coisa que eu não fazia ideia e clareou muito algumas coisas na minha cabeça. Agora sei como funcionam as atualizações no banco de dados das entidades já registradas, o que eu sempre fiquei em dúvida de como funcionava por baixo dos panos.

Foi um curso muito bom no geral e sinto que entendo mais de JPA agora do que quando estava trabalhando somente com o Spring Data JPA.
