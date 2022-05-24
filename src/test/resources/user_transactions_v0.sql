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
e5272977-2ceb-4d6b-a054-91e87bb6cb9f	servername	gSLloW8rxeaxmcPicUacY	t	t	2021-10-13 13:02:22.776
91bb1e8b-b4cc-4a3f-a3a5-a8736631f450	apps-dev-server	BnyE2hAKwbAwz4px7foWX	t	t	2021-10-13 13:03:09.215
331e6344-cef4-4d58-b8fa-3a50b20d423c	apps-test-server	12gzGj8JqiVCFDgGmUZ9D	t	t	2021-10-13 13:04:12.114
1a93e989-17e0-4dae-9c54-4498a1bb018b	local-brycew	J8CDj9vjj4gBjauf4PDpC	t	t	2021-11-05 13:34:49.007
c44cc53f-786a-4693-8456-25df9d2f1546	servername	RWip5QStnQD06PxxwNfIy	t	t	2022-02-25 10:58:47.768
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
25b40491-ed3e-4783-af0d-4e1127269f99	Amanda Brown	6014930484	amanda@lagniappelawlab.org	06873611-419c-4e80-8ee2-c605e02a1c42	331e6344-cef4-4d58-b8fa-3a50b20d423c	QGNL4E89XQRBSBXY3WPFFR64XR9FNQV91QULXYGEN8RQX5	Jefferson	Louisiana Adult Name Change Form	2022-01-12
8b230ec3-00a5-48d4-afab-2a428161785e	Chris Burns	\N	chris.burns@tylertech.com242	ae832168-7d9b-420e-8faf-71762f000237	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com242:f8596d36-0d6d-4549-9f92-ef3e6180fbbe	peoria	5892	2022-01-13
1e1b0e57-d226-44d0-8efe-dab50f070da9	Chris Burns	\N	chris.burns@tylertech.com242	4453f7b8-9776-482d-af45-478251e3d954	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com242:f8596d36-0d6d-4549-9f92-ef3e6180fbbe	peoria	5892	2022-01-20
50cd0a97-6033-45cf-87ac-ed3a1def766e	Chris Burns	\N	chris.burns@tylertech.com242	9b44c6e8-57c1-4968-b1af-b88c55642d04	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com242:f8596d36-0d6d-4549-9f92-ef3e6180fbbe	peoria	5892	2022-01-21
08a855c4-6da5-4171-a3d5-0ffc383e0fea	Chris Burns	\N	chris.burns@tylertech.com242	0261a4b2-623b-4374-96b5-cfe75ac38890	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com242:f8596d36-0d6d-4549-9f92-ef3e6180fbbe	peoria	5892	2022-01-21
0065d5f3-d19b-4742-84c7-5803bfe1bc42	Chris Burns	\N	bryce.beltran@tylertech.com	1ed25a73-01c8-4523-8474-cfd88b3c81b1	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	5892	2022-01-25
0065d5f3-d19b-4742-84c7-5803bfe1bc42	Chris Burns	\N	bryce.beltran@tylertech.com	56206ee5-b8e9-4eaf-b10b-f09e27f85e9b	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	5892	2022-01-25
61226253-4746-4049-ad2d-19a4485e2039	Riley J Burns	\N	bryce.beltran@tylertech.com	53bca673-4e84-4e0b-96b5-79214677d927	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	5892	2022-01-25
695d768b-603a-4e75-8618-bb17b6353378	Chris Burns	\N	bryce.beltran@tylertech.com	7564cf88-63ef-4d6a-a0e5-9331743a4225	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	5892	2022-01-25
9f57ba14-af9d-47bb-a6eb-ae37d29cf3a8	Riley J Burns	\N	bryce.beltran@tylertech.com	be97bae8-7fea-4754-8871-9bd6276efdfa	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	\N	2022-01-28
d8615f11-5cff-47af-91cd-20ab8e88c73e	Chris Burns	\N	chris.burns@tylertech.com	5067ae37-e699-41b0-8044-77a7a0c484f8	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com:84c39115-f8cc-4cb5-975a-963dce391303	peoria	\N	2022-02-02
08af26ed-4121-42f8-9200-10dc8e8d3983	Chris Burns	\N	chris.burns222@tylertech.com	c2806ca5-6883-4cf4-bde3-ba8d276006de	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns222@tylertech.com:4ce28b65-a4f1-4b92-a8b1-ce2bdad1f767	peoria	\N	2022-02-02
ee3af763-6dd1-4497-a482-20a4f6b561dd	Chris Burns	\N	chris.burns@tylertech.com	2cf35d85-45ac-4209-a380-ae5ef7ea2fa9	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	coles	\N	2022-02-08
5deb967c-01c7-43a1-9cb8-9e85b08cff32	Chris Burns	\N	chris.burns@tylertech.com	de98c9dd-7f6d-4fdc-9d37-51a05d8483f9	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	\N	2022-02-08
ac233e67-3020-42be-b830-40a04f89d3e3	Bryce Pro Se Willey	\N	bryce.steven.willey+faketylerprose@gmail.com	e692c366-50f1-43d6-9a24-6d0748c41a99	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.steven.willey+faketylerprose@gmail.com:777c4027-3b56-43f4-9812-14f850c15368	coles	\N	2022-02-11
dee7ceff-cd81-46f5-9035-93c13134546c	Chris Burns	\N	chris.burns@tylertech.com	e7ad0ff3-51ab-4d02-ada3-a601fc32147b	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.beltran@tylertech.com:82509f7a-f7ef-419d-af37-74aa3ebc0dd1	peoria	\N	2022-02-22
ada19713-b35d-4fe5-8d71-966444ada27e	Chris Burns	\N	chris.burns@tylertech.com242	dcf47b05-1c82-4213-b196-74834a183a1f	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com242:f8596d36-0d6d-4549-9f92-ef3e6180fbbe	peoria	\N	2022-02-22
7e009f67-db37-47cc-8ed7-2a3ab8815fdb	Chris Burns	\N	chris.burns@tylertech.com	ae9def70-1d16-414b-b3f3-2ad0357dc5c7	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com:84c39115-f8cc-4cb5-975a-963dce391303	peoria	\N	2022-02-22
a229a29b-9942-4725-bf6c-95f5abfc46bb	Chris Burns	\N	chris.burns@tylertech.com	8377850b-6526-4b4d-b2b9-6c9515b0491c	331e6344-cef4-4d58-b8fa-3a50b20d423c	chris.burns@tylertech.com:84c39115-f8cc-4cb5-975a-963dce391303	peoria	\N	2022-02-22
2c85beaa-6372-46b4-91cc-72c5443af8a7	Bryce Willey	\N	bwilley@suffolk.edu	f8f38ac3-b41d-4c6e-9a04-acc8b4cab2a9	331e6344-cef4-4d58-b8fa-3a50b20d423c	bwilley@suffolk.edu:480518dc-143a-4a86-8651-e4eb870ce15a	peoria	\N	2022-03-25
e74a4a33-d0de-4820-9c5e-08dd2fc37588	Bob Ma	\N	example@example.com	d4fb9d18-ed42-4e2e-9c75-ccad85c509ec	331e6344-cef4-4d58-b8fa-3a50b20d423c	bryce.steven.willey+faketylerprose@gmail.com:777c4027-3b56-43f4-9812-14f850c15368	peoria	\N	2022-03-30
8c10b895-7adf-4256-9ed5-bbffce03f069	Bob Ma	\N	example@example.com	4f8fbf00-9e05-4551-99ff-66193e0f4f1f	331e6344-cef4-4d58-b8fa-3a50b20d423c	bwilley@suffolk.edu:480518dc-143a-4a86-8651-e4eb870ce15a	peoria	\N	2022-03-30
c047e2cc-edcf-46ac-8741-643b1666cc94	Bob Ma	\N	example@example.com	8dff5c3a-f48b-4e15-b329-3875db6ef9c7	331e6344-cef4-4d58-b8fa-3a50b20d423c	bwilley@suffolk.edu:480518dc-143a-4a86-8651-e4eb870ce15a	peoria	\N	2022-03-31
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

