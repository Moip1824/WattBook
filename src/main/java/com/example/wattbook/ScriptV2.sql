create type generos as enum('AVENTURA', 'CIENCIA FICCION', 'FANTASÍA', 'ROMANCE', 'MISTERIO', 'BIOGRÁFICO', 'HISTORIA', 'AUTOAYUDA');
create type roles as enum('ADMIN', 'USUARIO');

create table if not exists usuario(
    id serial primary key ,
    nombreusuario varchar(50) not null,
    contrasena varchar(50) not null,
    rol roles not null
);

create table if not exists perfil(
    id serial primary key,
    nombre varchar(50) not null,
    apellidos varchar(50) not null,
    descripcion varchar(255),
    email varchar(50) not null,
    imagen varchar(255),
    generos generos, -- Generos de libros
    usuario_id int not null,
    foreign key (usuario_id) references usuario(id)
);

create table if not exists libros(
    id serial primary key,
    nombre varchar(50) not null,
    descripcion varchar(255) not null,
    generos generos not null,
    fecha_publicacion date not null,
    imagen varchar(255) not null,
    autor_id int not null,
    foreign key (autor_id) references usuario(id)
);

create table if not exists seguidores(
    id serial primary key,
    usuario_id int not null,
    seguidor_id int not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (seguidor_id) references usuario(id)
);

create table if not exists usuarios_baneados(
    id serial primary key,
    usuario_id int not null,
    fecha_baneo date not null,
    motivo_baneo varchar(255) not null,
    foreign key (usuario_id) references usuario(id)
);

create table if not exists votos(
    id serial primary key,
    usuario_id int not null,
    libro_id int not null,
    tipo_voto boolean
);

create table if not exists chat(
    id serial primary key,
    libro_id int not null,
    nombre varchar(50) not null,
    descripcion varchar(255) not null,
    imagen varchar(255) not null,
    foreign key (libro_id) references libros(id)

);

create table if not exists chat_usuarios(
    id serial primary key,
    usuario_id int not null,
    chat_id int not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (chat_id) references chat(id)
);
create table if not exists chat_mesnsajes(
    id serial primary key,
    usuario_id int not null,
    chat_id int not null,
    fecha timestamp default now() not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (chat_id) references chat(id)
);


create table if not exists libros_favoritos(
    id serial primary key,
    usuario_id int not null,
    libro_id int not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (libro_id) references libros(id)
);

create table autores_favoritos(
    id serial primary key,
    usuario_id int not null,
    autor_id int not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (autor_id) references usuario(id)
);


create table if not exists comentarios(
    id serial primary key,
    usuario_id int not null,
    libro_id int not null,
    comentario varchar(255) not null,
    fecha date not null,
    foreign key (libro_id) references libros(id),
    foreign key (usuario_id) references usuario(id)
);
