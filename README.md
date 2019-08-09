# Carrinho de compras

##Para executar o projeto:

1- Clone o arquivo para sua pasta de preferencia.

2- Com sua IDE de prefencia importar o pom.xml como um projeto.

Eclipse : File > Open project from File System...> No campo ‘Root Directory’, selecione o diretório que está o source do projeto (pom.xml) > Selecione o pom.xml > Finish.

Intellij : File > Open > Navegue até o diretorio em que está o souce do projeto e o selecione > Open as project.

3- Instalar o banco de dados mysql

4- Criar uma nova database chamada "carrinho_de_compra"

5- No projeto abrir o arquivo "application.properties" 

5.1 Atribuir ao campo "spring.datasource.username" o username do seu usuario do mysql
5.2 No campo "spring.datasource.password" atribuir a senha do usuario.

6- Execute a classe "CarrinhoDeCompraApplication" e seja feliz !!

###Observações 

Os endpoints estão protegidos com basic auth, o ususario e senha padrão é: devninjas, 1234




