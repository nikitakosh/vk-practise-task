CREATE TABLE IF NOT EXISTS Audit
(
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    request_time TIMESTAMP NOT NULL,
    username varchar NOT NULL
);
