create table serie(
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome varchar (255),
    plataforma varchar(255),
    nota int
);