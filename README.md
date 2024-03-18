A aplicação oferece as seguintes funcionalidades:<br>
(1) Cadastro de conta dos tipos poupança ou débito <br>
(2) Depósito<br>
(3) Saque<br>
(4) Alteração de limite (LIS da conta)<br>
(5) Transferência entre contas<br>
(6) Exportar histórico de transações<br>
(7) Saldo<br>
<br>
Restrições:<br>
	- Há restrição de horário para transferências entre contas: Não é possível realizar transferências entre 6PM e 6AM<br>
	- Não é possível transformar uma conta de poupança em débito e vice versa.<br>
	- O tipo de conta default é poupança<br>
	- O valor de limite da conta está relacionado ao quanto sua conta poderá ficar negativa. Lembre-se que o valor negativo é um valor que deve ser devolvido ao banco!<br>
Entradas:<br>
	- O nome de cliente deve ser uma string<br>
	- O número de agência deve ser 1 ou 2. Estamos trabalhando para expansão de agências!<br>
	- O número da conta é um número inteiro e será gerado automaticamente. Anote o número da sua conta e agência pois será necessário para realizar operações.<br>
O tipo da conta poderá ser 1 (poupança) ou 2 (débito).<br>

Diagrama de classes:<br> [![](https://mermaid.ink/img/pako:eNp9kDEOwjAMRa8SeQLRE2SFG7BmMY0LlhKnJM6Aqt6dQGGgIDxZ__0v2X-CPnkCC33AUg6M54zRiRPTZp9E0VizY1EjNVJOT2lFj5pZzkZZa8D8y-FTPQUyBYNPf3jgyEprw4PTmArrkt1sP2HBa6WfRDNKGSiT9IxPsXxZ0nL9W4cO2psR2bdOpofmQC8UyYFtq6cBa1AHTuZmxdryN-nBaq7UQR09Kr1aBDtgKDTfAZFydX4?type=png)](https://mermaid-js.github.io/mermaid-live-editor/edit#pako:eNp9kDEOwjAMRa8SeQLRE2SFG7BmMY0LlhKnJM6Aqt6dQGGgIDxZ__0v2X-CPnkCC33AUg6M54zRiRPTZp9E0VizY1EjNVJOT2lFj5pZzkZZa8D8y-FTPQUyBYNPf3jgyEprw4PTmArrkt1sP2HBa6WfRDNKGSiT9IxPsXxZ0nL9W4cO2psR2bdOpofmQC8UyYFtq6cBa1AHTuZmxdryN-nBaq7UQR09Kr1aBDtgKDTfAZFydX4)

Diagrama de sequência:<br> [![](https://mermaid.ink/img/pako:eNq1lNFKwzAUhl8l5kpx8wEiDGTDKxGh4lVvDsnZFkhzanK6oWMv5O0eoS9m0lUHKnbI7EXawPfnfE0O2UhNBqWSEZ8b9BpnFhYBqtKL9DwEypPxZHI5Jc-BnMOghMe1yHM413m82MMH4ivfUfFmcQXG9JHrXwsYrClapn2R7-snftxHlZhh3e4yLQKCs69g6GzIaGkjU7CaOqUBmwhpa45SKTL5bxrId7ayfJzKPa1IuI7PyZPbcAAf5xhSz1jojOKQ0mMfad9y5nOb4LRiBTmrLUPoYu0u5370um28Zks-KlEH63laPA22Gq29IzCpQYWOq_w6FDntbyyQC3CGjuy7RAqoA0b0fzprOZIVhgqsSXfBJqdLyUussJQqfRqcQ-O4lKXfJhQapuLFa6k4NDiSTW2AP64OqebgIm7fARQQgY0?type=png)](https://mermaid.live/edit#pako:eNq1lNFKwzAUhl8l5kpx8wEiDGTDKxGh4lVvDsnZFkhzanK6oWMv5O0eoS9m0lUHKnbI7EXawPfnfE0O2UhNBqWSEZ8b9BpnFhYBqtKL9DwEypPxZHI5Jc-BnMOghMe1yHM413m82MMH4ivfUfFmcQXG9JHrXwsYrClapn2R7-snftxHlZhh3e4yLQKCs69g6GzIaGkjU7CaOqUBmwhpa45SKTL5bxrId7ayfJzKPa1IuI7PyZPbcAAf5xhSz1jojOKQ0mMfad9y5nOb4LRiBTmrLUPoYu0u5370um28Zks-KlEH63laPA22Gq29IzCpQYWOq_w6FDntbyyQC3CGjuy7RAqoA0b0fzprOZIVhgqsSXfBJqdLyUussJQqfRqcQ-O4lKXfJhQapuLFa6k4NDiSTW2AP64OqebgIm7fARQQgY0)
