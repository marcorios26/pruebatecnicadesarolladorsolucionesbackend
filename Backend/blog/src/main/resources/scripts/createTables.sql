--Create table deck--
-- Table: public.deck

-- DROP TABLE IF EXISTS public.deck;

CREATE TABLE IF NOT EXISTS public.deck
(
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    is_custom boolean NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_owner character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT deck_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.deck
    OWNER to postgres;


-- create table card --
-- Table: public.card

-- DROP TABLE IF EXISTS public.card;

CREATE TABLE IF NOT EXISTS public.card
(
    id bigint NOT NULL,
    deck_id bigint,
    value character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT card_pkey PRIMARY KEY (id),
    CONSTRAINT fk6k0or7dj9m5qhnshnk9fpg8r1 FOREIGN KEY (deck_id)
        REFERENCES public.deck (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.card
    OWNER to postgres;

-- Create table game --
-- Table: public.game

-- DROP TABLE IF EXISTS public.game;

CREATE TABLE IF NOT EXISTS public.game
(
    id bigint NOT NULL,
    facilitator character varying(255) COLLATE pg_catalog."default",
    manage_issues_players character varying(255) COLLATE pg_catalog."default" DEFAULT 'all'::character varying,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    reveal_card_owner character varying(255) COLLATE pg_catalog."default" DEFAULT 'all'::character varying,
    deck_id bigint,
    CONSTRAINT game_pkey PRIMARY KEY (id),
    CONSTRAINT fkonhoa8r0j6lio9fopynh6akcm FOREIGN KEY (deck_id)
        REFERENCES public.deck (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.game
    OWNER to postgres;

-- Create table player --
-- Table: public.player

-- DROP TABLE IF EXISTS public.player;

CREATE TABLE IF NOT EXISTS public.player
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_owner character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT player_pkey PRIMARY KEY (id),
    CONSTRAINT uk_6pj2lp1w2b2amcsy27ae5ucc8 UNIQUE (user_owner)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.player
    OWNER to postgres;

-- Create table player in game --
-- Table: public.player_in_game

-- DROP TABLE IF EXISTS public.player_in_game;

CREATE TABLE IF NOT EXISTS public.player_in_game
(
    game_id bigint NOT NULL,
    player_id bigint NOT NULL,
    is_available_to_manage_issues boolean,
    is_available_to_reveal_card boolean,
    is_observer boolean,
    CONSTRAINT player_in_game_pkey PRIMARY KEY (game_id, player_id),
    CONSTRAINT fkths7ol6u40wo1eg3bkh3doxhw FOREIGN KEY (player_id)
        REFERENCES public.player (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkto0of7fc2m2jmuqxldthjm408 FOREIGN KEY (game_id)
        REFERENCES public.game (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.player_in_game
    OWNER to postgres;