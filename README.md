## Projeto Votação

Esse projeto tem como intenção de organizar usuários pautas, onde cada usuário poderá votar em uma pauta. Ele ainda não está completo, faltam algumas regras de negócios e implementações. 


## Usuário

Cadastrar - POST  `/usuarios`,

Listar - GET  `/usuarios`,

Exibir - GET  `/usuarios/{id}`,

### JSON de Retorno
````
{
  "id": 2,
  "nome": "Nome Usuário"
}
````


## Pauta

Cadastrar - POST  `/pautas`,

Listar - GET  `/pautas`,

Exibir - GET  `/pautas/{id}`,

Iniciar Votação - GET `/pautas/{id-pauta}/iniciar-votacao`,

Votar - POST `/pautas/{id-pauta}/votar`


### JSON de Para Votar
````
{
	"idPauta": 2,
	"idUsuario": 1,
	"statusVoto": 0
}
````

### JSON de Cadastro
````
{
	"nomePauta": "Divisão de Alguma Coisa",
	"tempoDeVotacao": "01:00:00",
	"usuarios": [
		{
			"id": 1,
			"nome": "Joao"
		}
	]
}

````



