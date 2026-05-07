# Analise de Log

Programa em Java para análise de arquivos de log do servidor Web Apache.

## Requisitos
- Java 8 ou superior
- Maven

## Como executar
1. Coloque o arquivo `access.log` dentro de `src/main/resources/`
2. Execute o programa pela classe `Main`
3. Escolha uma opção do menu

## Menu
- `1` - Gera `recursosGrandes.txt` com requisições bem-sucedidas e objetos maiores que 2000 bytes
- `2` - Gera `naoRespondidosNovembro.txt` com requisições com erro em novembro de 2021
- `3` - Gera `sistemasOperacionais.txt` com percentual de acessos por sistema operacional em 2021
- `4` - Exibe no terminal a média dos tamanhos das requisições POST em 2021
- `0` - Encerra o programa

## Arquivos gerados
Os arquivos são salvos automaticamente na pasta `Análise/` no diretório raiz do projeto.

## Equipe
- [Yan Neves](https://github.com/yan-dhsk)
- [Vinicius Meneses](https://github.com/viniciusmeneses-tech)
- [Arthur Machado](https://github.com/diasmarthur)