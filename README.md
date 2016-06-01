# Trabalho de programação II

##Descrição do trabalho:

###O trabalho da disciplina consiste em desenvolver um sistema Java com as seguintes características:
1. Deve ter pelo menos 3 entidades (por exemplo: Cliente, Venda, Locação, Produto,Categoria, etc.). Pelo menos uma dessas entidades deve representação umatransação, ou seja, o propósito principal do sistema (por exemplo, se for um sistemade uma locadora, a transação é a locação, se for uma loja, a transação é Venda);

2. O sistema deve ter interface gráfica com o usuário, contendo uma janela principal euma janela ou painel para cada entidade.

3. O painel/janela de cada entidade deve possuir campos para o usuário informar osatributos das entidades e uma tabela que permite visualizar todos os dadosexistentes da entidade. Uma dica: para criar uma tabela gráfica, use as classesJTable e DefaultTableModel;

4. Para preencher a tabela gráfica, carregue os objetos do arquivo e armazene-os emuma estrutura de dados da API JCF adequada. Também deve ser possível ordenaros dados dessa tabela/estrutura com base em mais de um atributo da entidadecorrespondente. Opcionalmente, pode-se usar reflexão com a classeDefaultTableModel para ter um código único que é capaz de criar e preencher umatabela gráfica para qualquer entidade;

5. Deve ser possível inserir, alterar e excluir dados das entidades;

6. Os dados do sistema devem ser gravados em um arquivo, sendo um arquivo paracada entidade. Desse modo, deve ser possível recuperar 
os dados gravados mesmose o sistema for fechado e executado novamente;

7. O padrão MVC deve ser aplicado para separar o sistema em três camadas: modelo,controle e visão. Os alunos devem pesquisar e aprender sobre esse padrão paradesenvolver o trabalho. O professor pode tirar dúvidas;

8. O padrão Abstract Factory deve ser aplicado para criar as classes da camada demodelo e da camada de visão (interface gráfica) para cada entidade do sistema;

9. O padrão Singleton deve ser aplicado para a classe responsável por gravar os dadosnos arquivos. Essa classe deve ter um método que recebe um objeto e o caminho(Path) do arquivo e realiza a gravação do objeto passado nesse arquivo;

10. Opcionalmente, outros padrões podem ser aplicados;

11. Deve ser criado o modelo de classes do sistema completo;

12. Também deve ser criado um modelo de sequência correspondente à operação deinclusão da transação do sistema (por exemplo, gravar uma venda);

13. O trabalho pode ser realizado em dupla ou trio, mas as notas são individuais.Portanto, alunos do mesmo grupo podem receber notas diferentes;

14. Os alunos deverão apresentar o trabalho para o professor no laboratório na aulaseguinte à da terceira prova. O professor avaliará o sistema e poderá fazer perguntasindividuais aos membros da equipe. Os alunos devem postar no AVA os arquivos.java e as imagens dos modelos na forma de um arquivo compactado, cujo nome éformado pelos membros da equipe.
