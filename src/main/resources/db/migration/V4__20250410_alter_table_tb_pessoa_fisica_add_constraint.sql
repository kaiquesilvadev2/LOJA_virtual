ALTER TABLE tb_pessoa_fisica ADD COLUMN empresa_id INTEGER;
ALTER TABLE tb_pessoa_fisica 
     ADD CONSTRAINT fk_empresa FOREIGN KEY(empresa_id) REFERENCES tb_pessoa_juridica(id);
