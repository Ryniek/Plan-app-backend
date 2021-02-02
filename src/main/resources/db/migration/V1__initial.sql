CREATE TABLE IF NOT EXISTS Users(
    UserId BIGINT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(144) NOT NULL,
    Email VARCHAR(144) NOT NULL UNIQUE,
    Password VARCHAR(144) NOT NULL,
    ImageUrl VARCHAR(144),
    Provider VARCHAR(144),
    ProviderId VARCHAR(144),
    PRIMARY KEY (UserId)
);