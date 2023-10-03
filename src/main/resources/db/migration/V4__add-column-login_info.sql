
ALTER TABLE client ADD COLUMN login_info_id bigint REFERENCES login_info(id);

