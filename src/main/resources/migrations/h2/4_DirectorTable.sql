CREATE TABLE director (
  director_id bigint NOT NULL AUTO_INCREMENT,
  identity_document VARCHAR(20) NOT NULL,
  director_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (director_id),
    UNIQUE INDEX UQ_director_identity_document(identity_document)
);

INSERT INTO director(identity_document, director_name) 
VALUES
('12345671', 'Marc Webb'),
('12345672', 'Bill Condon'),
('12345673', 'Chris Renaud'),
('12345674', 'Jon Favreau'),
('12345675', 'M. Night Shyamalan'),
('12345676', 'Alex Kurtzman');
