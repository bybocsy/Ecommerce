CREATE TABLE companies (
    company_id UUID PRIMARY KEY UNIQUE NOT NULL,
    nameCompany TEXT NOT NULL,
    description TEXT
    CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);
