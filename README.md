# Validação de CEP em Java

Este projeto em Java realiza requisições que retornam dados de um **CEP** (Código de Endereçamento Postal) e valida a resposta para garantir que o CEP é válido. Caso o CEP seja inválido, o projeto lida com a resposta e exibe uma mensagem de erro.

## Funcionalidades

- **Validação de CEP**: Verifica se o CEP retornado é válido.
- **Tratamento de Erros**: Quando o CEP é inválido, a resposta retorna um JSON contendo uma chave `"error": true` em vez dos dados completos. O programa captura esse cenário e exibe uma mensagem de erro ao usuário.
- **Exibição de Dados**: Se o CEP é válido, o programa exibe as informações completas do CEP, como cidade e estado.

## Tecnologias Utilizadas

Este projeto utiliza as seguintes tecnologias e bibliotecas:

- **Java**: Linguagem principal do projeto.
- **Gson**: Biblioteca usada para manipulação e parsing de JSON de forma simples. Neste projeto, Gson é usado para converter a resposta JSON de uma requisição em um objeto Java (`JsonObject`) e para verificar a presença da chave `error`.
