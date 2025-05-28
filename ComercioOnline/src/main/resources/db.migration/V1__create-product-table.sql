CREATE TABLE product (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price INTEGER NOT NULL,
    description TEXT,
    category VARCHAR(100) NOT NULL,
    stock BIGINT,
    productImage VARCHAR(400) NOT NULL,
    company_id UUID,
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES companies(company_id)
);
