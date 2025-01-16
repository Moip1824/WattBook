create type generos as enum('Aventura', 'Ciencia Ficcion', 'Fantasía', 'Romance', 'Misterio', 'Biográfico', 'Historia', 'Autoayuda');
create type roles as enum('ADMIN', 'USUARIO');
create type tipo_baneo as enum('TEMPORAL', 'PERMANENTE');

create table if not exists usuario(
    id serial primary key ,
    nombreusuario varchar(50) not null,
    contrasena varchar(50) not null,
    rol roles not null
);

create table if not exists perfil(
    id serial primary key,
    nombre varchar(50) not null,
    descripcion varchar(255) not null,
    email varchar(50) not null,
    imagen varchar(255) not null,
    generos generos not null,
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
    tipo_baneo tipo_baneo not null,
    motivo_baneo varchar(255) not null,
    foreign key (usuario_id) references usuario(id)
);

create table if not exists votos(
    id serial primary key,
    usuario_id int not null,
    libro_id int not null,
    tipo_voto boolean
);

create table if not exists grupos(
    id serial primary key,
    nombre varchar(50) not null,
    descripcion varchar(255) not null,
    imagen varchar(255) not null
);

create table if not exists grupos_usuarios(
    id serial primary key,
    usuario_id int not null,
    grupo_id int not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (grupo_id) references grupos(id)
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

create table if not exists chat(
    id serial primary key,
    usuario_id int not null,
    mensaje varchar(255) not null,
    fecha date not null,
    libro_id int not null,
    grupo_id int not null unique,
    foreign key (grupo_id) references grupos(id),
    foreign key (libro_id) references libros(id),
    foreign key (usuario_id) references usuario(id)
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
