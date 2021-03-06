PGDMP         5                z         
   DB_pruebas    14.2    14.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16448 
   DB_pruebas    DATABASE     k   CREATE DATABASE "DB_pruebas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE "DB_pruebas";
                postgres    false                        2615    16449    pruebas    SCHEMA        CREATE SCHEMA pruebas;
    DROP SCHEMA pruebas;
                postgres    false            ?            1259    16565    Register    TABLE     ?   CREATE TABLE pruebas."Register" (
    "idRegister" integer NOT NULL,
    name character varying NOT NULL,
    "idUser" integer NOT NULL,
    date date NOT NULL,
    "productName" character varying NOT NULL,
    quantity integer DEFAULT 2 NOT NULL
);
    DROP TABLE pruebas."Register";
       pruebas         heap    postgres    false    5            ?            1259    16564    Register_idRegister_seq    SEQUENCE     ?   CREATE SEQUENCE pruebas."Register_idRegister_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE pruebas."Register_idRegister_seq";
       pruebas          postgres    false    5    212            ?           0    0    Register_idRegister_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE pruebas."Register_idRegister_seq" OWNED BY pruebas."Register"."idRegister";
          pruebas          postgres    false    211            ?            1259    16547    Users    TABLE     ?   CREATE TABLE pruebas."Users" (
    "idUser" integer NOT NULL,
    username character varying NOT NULL,
    charge character varying NOT NULL,
    age integer NOT NULL,
    "admissionDate" date NOT NULL
);
    DROP TABLE pruebas."Users";
       pruebas         heap    postgres    false    5            ?            1259    16546    Users_idUser_seq    SEQUENCE     ?   CREATE SEQUENCE pruebas."Users_idUser_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE pruebas."Users_idUser_seq";
       pruebas          postgres    false    210    5            ?           0    0    Users_idUser_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE pruebas."Users_idUser_seq" OWNED BY pruebas."Users"."idUser";
          pruebas          postgres    false    209            b           2604    16568    Register idRegister    DEFAULT     ?   ALTER TABLE ONLY pruebas."Register" ALTER COLUMN "idRegister" SET DEFAULT nextval('pruebas."Register_idRegister_seq"'::regclass);
 G   ALTER TABLE pruebas."Register" ALTER COLUMN "idRegister" DROP DEFAULT;
       pruebas          postgres    false    211    212    212            a           2604    16550    Users idUser    DEFAULT     t   ALTER TABLE ONLY pruebas."Users" ALTER COLUMN "idUser" SET DEFAULT nextval('pruebas."Users_idUser_seq"'::regclass);
 @   ALTER TABLE pruebas."Users" ALTER COLUMN "idUser" DROP DEFAULT;
       pruebas          postgres    false    209    210    210            ?          0    16565    Register 
   TABLE DATA           b   COPY pruebas."Register" ("idRegister", name, "idUser", date, "productName", quantity) FROM stdin;
    pruebas          postgres    false    212   ?       ?          0    16547    Users 
   TABLE DATA           T   COPY pruebas."Users" ("idUser", username, charge, age, "admissionDate") FROM stdin;
    pruebas          postgres    false    210   +                   0    0    Register_idRegister_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('pruebas."Register_idRegister_seq"', 5, true);
          pruebas          postgres    false    211                       0    0    Users_idUser_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('pruebas."Users_idUser_seq"', 2, true);
          pruebas          postgres    false    209            e           2606    16554    Users PKiduser 
   CONSTRAINT     W   ALTER TABLE ONLY pruebas."Users"
    ADD CONSTRAINT "PKiduser" PRIMARY KEY ("idUser");
 =   ALTER TABLE ONLY pruebas."Users" DROP CONSTRAINT "PKiduser";
       pruebas            postgres    false    210            g           2606    16572    Register idRegister_PK 
   CONSTRAINT     c   ALTER TABLE ONLY pruebas."Register"
    ADD CONSTRAINT "idRegister_PK" PRIMARY KEY ("idRegister");
 E   ALTER TABLE ONLY pruebas."Register" DROP CONSTRAINT "idRegister_PK";
       pruebas            postgres    false    212            h           2606    16578    Register idUser_FK    FK CONSTRAINT     ?   ALTER TABLE ONLY pruebas."Register"
    ADD CONSTRAINT "idUser_FK" FOREIGN KEY ("idUser") REFERENCES pruebas."Users"("idUser");
 A   ALTER TABLE ONLY pruebas."Register" DROP CONSTRAINT "idUser_FK";
       pruebas          postgres    false    3173    210    212            ?   e   x?E?=?0??N?j K?a?LD??????{???890QL?fs??GH?v?????D??y;i???uQo?)H????6?leu?$??x??$!      ?   F   x?3?,N?-M͉??L,N-?/2-8?-tLt?̸?8?Ks8?R?J?9MM?r?? d????? ?m     