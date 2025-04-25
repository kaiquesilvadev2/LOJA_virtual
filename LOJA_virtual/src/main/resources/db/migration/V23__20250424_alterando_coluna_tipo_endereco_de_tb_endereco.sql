ALTER TABLE tb_endereco DROP CONSTRAINT tb_endereco_tipo_endereco_check;

ALTER TABLE tb_endereco
ADD CONSTRAINT tb_endereco_tipo_endereco_check
CHECK (LOWER(tipo_endereco) IN ('cobrança', 'entrega', 'particula', 'comercial'));

