<h1 align="center">
    Problema de Transporte - Método do Menor Custo
</h1>

## 💻 Grupo

- [Fábio Augusto Araújo Santos](https://github.com/fabio-aug)
- [Luana Assis Silva](https://github.com/luanaassis)

## 📰 Introdução

Desenvolvimento do método do Menor Custo para problemas transporte.

## 📂 Estrutura

O ambiente de trabalho utilizado foi o Visual Studio Code. Os arquivos foram organizados da seguinte forma:

- `/src`: pasta destinada aos códigos fontes do projeto.
- `/.vscode`: pasta destinada a configuração do projeto caso use a extensão ['Extension Pack for Java'](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).

Obs: para rodar usando a extensão é necessário algumas alterações no código.

## 🏃 Instruções para compilação e execução (Apêndice)

- Para compilar o projeto, basta inserir a seguinte linha de comando no terminal dentro da pasta `src`:

      javac src\LowerCost.java

- Para executar o projeto, é necessário inicialmente um arquivo com as informações do modelo a ser processado. Este arquivo deve ser incluído na pasta raíz.

- A estrutura do arquivo deve seguir o seguinte padrão:
    - A primeira linha é um inteiro M, representando o número de origens;
    - A segunda linha é um inteiro N, representando o número de destinos;
    - A terceira linha é um vetor de dimensão M contendo as capacidades de atendimento de cada origem;
    - A quarta linha é um um vetor de dimensão N contendo as demandas de cada destino;
    - A quinta e demais linhas é uma matriz de dimensão M x N contendo os custos de transporte entre cada origem e destino.

- Após isso, basta inserir a seguinte linha de comando no terminal para realizar a execução:

        java src\LowerCost.java <nomeArquivoEntrada>
