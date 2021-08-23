JDBC Assignment 

user table creation

-- Table: public.user

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    firstname character varying(20) COLLATE pg_catalog."default",
    lastname character varying(20) COLLATE pg_catalog."default",
    email character varying(50) COLLATE pg_catalog."default",
    userid integer NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (userid)
)

TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;
	
	------------------------------
	----------Insert -------------
	------------------------------
	
	INSERT INTO public.\"user\"(\r\n"
			+ "	firstname, lastname, email, userid)\r\n"
			+ "	VALUES (?, ?, ?, (select max( userid ) from \"user\") +1)
			
	Ex: 
	
INSERT INTO public."user"(
	firstname, lastname, email, userid)
	VALUES ('Tusar', 'Mallick', 't@gmail.com', (select max( userid ) from "user") +1);
	
	
	
	--------------------------------------------------
	 Display User operation
	---------------------------------------------
	
	SELECT firstname, lastname, email, userid
	FROM "user";
	
	-----------------
	delete query 
	---------------
	
DELETE FROM "user"
	WHERE "user".userid = 105;
	
	
	
	
	------------------------
	update
	------------------------
	
	UPDATE public."user"
	SET firstname=?, lastname=?, email=?, userid=?
	WHERE "user".userid=104;
	
	
	
	
	