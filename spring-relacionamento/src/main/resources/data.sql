INSERT INTO professor (nome, cadastrado_em, premium) VALUES
    ('João do Node',              '2022-03-15 09:00:00', true),
    ('Fernanda Microserviços',    '2022-07-20 14:30:00', true),
    ('Carlos Do Zero ao Sênior',  '2023-01-05 08:00:00', false),
    ('Patrícia Blockchain',       '2023-04-11 11:15:00', false),
    ('Ricardo 10x Engineer',      '2023-08-22 16:45:00', true),
    ('Ana de Vasconcelos Agile',  '2024-02-01 10:00:00', false),
    ('Marcos Freela Milionário',  '2024-05-30 13:00:00', true);

INSERT INTO curso (nome, data_inicio, data_fim, nota,professor_id) VALUES
    ('Fique Milionário Aprendendo React em 2 Horas',                                '2024-01-10', '2024-01-10', 4.9,1),
    ('Docker: A Solução Para Todos os Seus Problemas (e Criador de Outros 12)',     '2024-02-01', '2024-03-15', 4.2,2),
    ('Kubernetes Para Quem Tem 3 Usuários e 1 Sonho',                               '2024-03-01', '2024-04-30', 3.8,3),
    ('Microserviços: Transforme 1 Bug em 47 Bugs Distribuídos',                     '2024-04-10', '2024-06-10', 4.5,4),
    ('Como Colocar IA em Tudo e Cobrar 10x Mais no Freela',                        '2024-05-01', '2024-05-30', 5.0,5),
    ('TypeScript: 3 Horas de Código, 5 Horas Brigando Com o Compilador',           '2024-06-01', '2024-07-01', 3.5,1),
    ('Web3, Blockchain e NFT: A Revolução Que Vai Chegar Semana Que Vem',           '2024-01-15', '2024-02-15', 1.2,2),
    ('Clean Code: Escreva Código Lindo Que Só Você Entende',                        '2024-07-01', '2024-08-01', 4.0,3),
    ('ChatGPT Vai Substituir os Devs (Curso Ministrado por Dev Desempregado)',       '2024-08-01', '2024-08-15', 2.3,4),
    ('Do Zero ao Sênior em 30 Dias: Vue, React, Angular, Node, Java, Go e Inglês', '2024-09-01', '2024-09-30', 0.5,5),
    ('Scrum: Como Fazer Reuniões Sobre as Reuniões Que Vão Planejar as Reuniões',   '2024-10-01', '2024-11-01', 3.1,1),
    ('AWS Para Iniciantes: Aprenda a Gastar R$ 3.000 Sem Querer no Primeiro Mês',  '2024-11-01', '2024-12-01', 4.7,2),
    ('Como Passar em Entrevista no Google Decorando LeetCode Por 2 Anos',           '2025-01-01', '2025-06-30', 3.9,3),
    ('Startup de Sucesso: Pivote 7 Vezes Até Virar Uma Consultoria',               '2025-02-01', '2025-03-01', 2.8,4),
    ('Linux Para Devs: Passe 4 Horas Configurando o Ambiente Antes de Codar',      '2025-03-01', '2025-04-01', 4.1,5);

