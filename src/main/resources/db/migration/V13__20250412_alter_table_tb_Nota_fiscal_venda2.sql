ALTER TABLE tb_Nota_fiscal_venda
ADD COLUMN venda_compra_virtual_id INTEGER UNIQUE;

ALTER TABLE tb_Nota_fiscal_venda
ADD CONSTRAINT fk_venda_compra_virtual FOREIGN KEY (venda_compra_virtual_id)
REFERENCES tb_venda_compra_virtual(id);
