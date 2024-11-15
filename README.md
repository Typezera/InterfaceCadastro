##Tecnologias utilizada:
Java 21
JavaFx
Google Gson

##Como funciona:
A interface faz o consumo apenas do métodos POST, na interface existe 4 inputs de entrada, para informar nome,email,senha e cpf,
No momento que é passado essas informações, só clicar no botão enviar, onde é chamado o metodo static da classe ClienteAPI que recebe,
todos os campos como parametros, dentro deste metodo é necessário informar o link da API no caso é http://localhost:8080/usuario/cadastro, abrir a conexão,
informar qual é o metodo que no caso vai ser POST e pronto.
