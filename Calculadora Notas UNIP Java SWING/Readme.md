# Calculadora de Notas Universidade Paulista Java SWING

Este é um projeto feito em java com a API SWING para desenvolve-lo sendo que o SWING foi utilizado para criar a interface gráfica do programa.

## Estrutura de pastas

O espaço de trabalho contém duas pastas por padrão, onde:

- `src`: a pasta para manter as fontes
- `lib`: a pasta para manter as dependências

Enquanto isso, os arquivos de saída compilados serão gerados na pasta `bin` por padrão.

> Se você deseja personalizar a estrutura de pastas, abra `.vscode/settings.json` e atualize as configurações relacionadas lá.

## Gerenciamento de Dependências

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## A Interface de Usuário do Projeto

Para rodar o app basta abrir a pasta Notas-UNIP dentro dela na pasta src abra o arquivo CalculadoraNotas.java no vs code e apertar as teclas Ctrl + Alt + N que ele irá rodar.

A seguir uma imagem do programa assim que ele inicia:

![Captura de tela 2024-12-10 150206.png](Captura%20de%20tela%202024-12-10%20150206.png)

O cálculo da nota de um aluno na Universidade Paulista (UNIP) é feito de acordo com a média final, que é calculada da seguinte forma:

Se a Média Disciplinar (MD) for igual ou superior a 7,0, o aluno está aprovado na disciplina.

Se a MD for inferior a 7,0, o aluno deve fazer o Exame da disciplina. A Média Final (MF) é calculada pela média aritmética entre a MD e a nota do Exame (EX), ou seja, MF = (MD + EX)/2.

Abaixo, segui um exemplo de nota com a média semestral e uma mensagem se será necessário fazer a prova do exame.

![Captura de tela 2024-12-10 150229.png](Captura%20de%20tela%202024-12-10%20150229.png)

E a seguir aparece uma imagem com uma nota da mídia semestral + a nota no exame resultando na média final e a situação do aluno na disciplina com uma mensagem se está aprovado ou reprovado.

![Captura de tela 2024-12-10 150251.png](Captura%20de%20tela%202024-12-10%20150251.png)

Foi feito um vídeo do programa funcionando veja ele logo abaixo

![Gravação-de-Tela-2024-12-10-150335.gif](Grava%C3%A7%C3%A3o-de-Tela-2024-12-10-150335.gif)

Caso não queira saber como o progrma funciona e somente deseja calcular a sua nota click 2 vezes no arquivo Calculadora Notas UNIP Java.jar.