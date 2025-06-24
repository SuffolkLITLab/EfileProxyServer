--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: at_rest_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.at_rest_keys (
    server_id uuid NOT NULL,
    server_name text,
    api_key text NOT NULL,
    tyler_enabled boolean,
    jeffnet_enabled boolean,
    created timestamp without time zone
);

--- NOTE(brycew): these ALTER OWNER to postgres statements were in the dump, 
--- but they seem to cause issues with the testcontainers library
--- ALTER TABLE public.at_rest_keys OWNER TO postgres;

--
-- Name: message_settings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message_settings (
    server_id uuid NOT NULL,
    from_email text,
    subject_line text,
    email_template text,
    email_confirmation text
);


--- ALTER TABLE public.message_settings OWNER TO postgres;

--
-- Name: submitted_filings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.submitted_filings (
    user_id uuid,
    name text,
    phone_number text,
    email text,
    transaction_id uuid NOT NULL,
    server_id uuid,
    api_key_used text,
    court_id text,
    casetype text,
    submitted date
);


---ALTER TABLE public.submitted_filings OWNER TO postgres;

--
-- Data for Name: at_rest_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.at_rest_keys (server_id, server_name, api_key, tyler_enabled, jeffnet_enabled, created) FROM stdin;
e5272977-2ceb-4d6b-a054-91e87bb6cb9f	servername	gSLloW8rxeaxmcPicUacY	t	f	2021-10-13 13:02:22.776
91bb1e8b-b4cc-4a3f-a3a5-a8736631f450	apps-dev-server	BnyE2hAKwbAwz4px7foWX	t	f	2021-10-13 13:03:09.215
331e6344-cef4-4d58-b8fa-3a50b20d423c	apps-test-server	12gzGj8JqiVCFDgGmUZ9D	t	f	2021-10-13 13:04:12.114
1a93e989-17e0-4dae-9c54-4498a1bb018b	local-brycew	J8CDj9vjj4gBjauf4PDpC	t	f	2021-11-05 13:34:49.007
c44cc53f-786a-4693-8456-25df9d2f1546	servername	RWip5QStnQD06PxxwNfIy	t	f	2022-02-25 10:58:47.768
\.


--
-- Data for Name: message_settings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message_settings (server_id, from_email, subject_line, email_template, email_confirmation) FROM stdin;
\.


--
-- Data for Name: submitted_filings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.submitted_filings (user_id, name, phone_number, email, transaction_id, server_id, api_key_used, court_id, casetype, submitted) FROM stdin;
0fae5af5-3054-429e-b67e-894e6ba8081b	Bryce McUserFace	123-456-7890	bryce.steven.willey@gmail.com	b5952dc2-2a52-4422-9644-ebfb934e8976	331e6344-cef4-4d58-b8fa-3a50b20d423c	QGNL4E89XQRBSBXY3WPFFR64XR9FNQV91QULXYGEN8RQX5	Jefferson	103 Petition for Divorce - No Children	2021-10-13
a9b48be2-5a5e-4e1f-bffd-cc4fcdd72a83	Bryce McUserFace	123456780	bryce.steven.willey@gmail.com	ad2b1dd0-baea-45f4-a356-437338b85a2c	331e6344-cef4-4d58-b8fa-3a50b20d423c	QGNL4E89XQRBSBXY3WPFFR64XR9FNQV91QULXYGEN8RQX5	Jefferson	Louisiana Adult Name Change Form	2021-10-13
0ff0ea57-da9b-46a7-8e8d-85fde130fee2	John Brown	\N	bwilley@suffolk.edu	38ff4c9e-4095-4ddc-83d2-dd693f21715b	331e6344-cef4-4d58-b8fa-3a50b20d423c	bwilley@suffolk.edu:09edb3ac-4327-4039-8a20-9de5b351adf3	adams	122667	2021-11-05
6594474c-c713-4868-85e9-615995cc142e	Dave Buster	\N	bwilley@suffolk.edu	1ce610dd-0bc1-44f9-9d63-bea5c9bd0802	331e6344-cef4-4d58-b8fa-3a50b20d423c	bwilley@suffolk.edu:480518dc-143a-4a86-8651-e4eb870ce15a	adams	25361	2022-01-04
\.


--
-- Name: at_rest_keys at_rest_keys_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.at_rest_keys
    ADD CONSTRAINT at_rest_keys_pkey PRIMARY KEY (server_id);


--
-- Name: message_settings message_settings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message_settings
    ADD CONSTRAINT message_settings_pkey PRIMARY KEY (server_id);


--
-- Name: submitted_filings submitted_filings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submitted_filings
    ADD CONSTRAINT submitted_filings_pkey PRIMARY KEY (transaction_id);


--
-- PostgreSQL database dump complete
--

