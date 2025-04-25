ALTER TABLE tb_endereco ADD COLUMN pessoa_id INTEGER;
ALTER TABLE tb_endereco ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa(id);
