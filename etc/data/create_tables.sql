-- Master table for Reports/Filings.
-- Table: public.reps
-- DROP TABLE public.reps;

CREATE TABLE public.reps
(
  repid numeric(12,0) NOT NULL,
  form character varying(4),
  comid character varying(9),
  com_name character varying(200),
  filed_date date,
  "timestamp" timestamp without time zone,
  from_date date,
  through_date date,
  md5 character varying(32),
  superceded numeric,
  previd numeric,
  rptcode character varying(4),
  ef character varying(1),
  version character varying(4),
  filed character varying(1),
  rptnum numeric,
  starting numeric,
  ending numeric,
  create_dt timestamp without time zone,
  CONSTRAINT fecefapp_repid_pk PRIMARY KEY (repid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.reps
  OWNER TO fecefapp;
GRANT ALL ON TABLE public.reps TO fecefapp;

-- Index: public.fecapp_reps_comid_idx

-- DROP INDEX public.fecapp_reps_comid_idx;

CREATE INDEX fecapp_reps_comid_idx
  ON public.reps
  USING btree
  (comid COLLATE pg_catalog."default");




-- Sched A table contains Receipts/Contribution for all Forms
-- Table: public.sched_a
-- DROP TABLE public.sched_a;
CREATE TABLE public.sched_a
(
  repid numeric(12,0) NOT NULL,
  line_num character varying(8),
  rel_lineno numeric(12,0),
  comid character varying(9),
  tran_id character varying(32) NOT NULL,
  br_tran_id character varying(20),
  br_sname character varying(8),
  entity character varying(3),
  name character varying(200),
  fname character varying(20),
  mname character varying(20),
  prefix character varying(10),
  suffix character varying(10),
  str1 character varying(34),
  str2 character varying(34),
  city character varying(30),
  state character varying(2),
  zip character varying(9),
  pgo character varying(5),
  pg_des character varying(30),
  date_con date,
  amount numeric(12,2),
  ytd numeric,
  reccode character varying(3),
  transdesc character varying(100),
  limit_ind character varying(1),
  indemp character varying(38),
  indocc character varying(38),
  other_comid character varying(9),
  donor_comname character varying(200),
  other_canid character varying(9),
  can_name character varying(38),
  can_fname character varying(20),
  can_mname character varying(20),
  can_prefix character varying(10),
  can_suffix character varying(10),
  can_off character varying(1),
  can_state character varying(2),
  can_dist character varying(2),
  other_name character varying(200),
  other_str1 character varying(34),
  other_str2 character varying(34),
  other_city character varying(30),
  other_state character varying(2),
  other_zip character varying(9),
  memo_code character varying(1),
  memo_text character varying(100),
  nc_softacct character varying(9),
  amend character varying(1),
  imageno numeric(19,0),
  used character(1),
  create_dt timestamp without time zone,
  contributor_name_text tsvector,
  contributor_employer_text tsvector,
  contributor_occupation_text tsvector,
  CONSTRAINT public_sched_a_pkey PRIMARY KEY (repid, tran_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.sched_a
  OWNER TO fecefapp;
GRANT ALL ON TABLE public.sched_a TO fecefapp;

-- Index: public.public_sched_a_repid_idx

-- DROP INDEX public.public_sched_a_repid_idx;

CREATE INDEX public_sched_a_repid_idx
  ON public.sched_a
  USING btree
  (repid);

-- Index: public.public_sched_a_tran_id_idx

-- DROP INDEX public.public_sched_a_tran_id_idx;

CREATE INDEX public_sched_a_tran_id_idx
  ON public.sched_a
  USING btree
  (tran_id COLLATE pg_catalog."default");

  
