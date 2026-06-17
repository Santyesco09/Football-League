CREATE TABLE Coach (
    id_coach VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    experience_years INT
);

CREATE TABLE Stadium (
    id_stadium VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    capacity INT
);

CREATE TABLE League (
    id_league VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50),
    country VARCHAR(50),
    number_of_teams INT
);

-- 2. Tables that depend on the independent tables
CREATE TABLE Team (
    name_team VARCHAR(50) PRIMARY KEY,
    wins INT,
    matches INT,
    losses INT,
    draws INT,
    GF INT,
    GA INT,
    GD INT,
    
    -- Declared the missing columns here:
    league_id VARCHAR(50),
    coach_id VARCHAR(50),
    stadium_id VARCHAR(50),
    
    -- Now the constraints will work perfectly:
    CONSTRAINT fk_league FOREIGN KEY (league_id) REFERENCES League(id_league),
    CONSTRAINT fk_coach FOREIGN KEY (coach_id) REFERENCES Coach(id_coach),
    CONSTRAINT fk_stadium FOREIGN KEY (stadium_id) REFERENCES Stadium(id_stadium)
);

-- 3. Tables that depend on Team
CREATE TABLE Player (
    id_player VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    number INT,
    position VARCHAR(50),
    goals INT,
    assists INT,
    matches_played INT,
    yellow_cards INT,
    red_cards INT,
    injured BOOLEAN,
    able_to_play BOOLEAN,

    -- Declared the missing column here:
    team_name VARCHAR(50),
    
    CONSTRAINT fk_team FOREIGN KEY (team_name) REFERENCES Team(name_team)
);

CREATE TABLE Match (
    id_match VARCHAR(50) PRIMARY KEY,
    date DATE,
    home_team VARCHAR(50),
    away_team VARCHAR(50),
    home_score INT,
    away_score INT,

    -- Declared the missing columns here:
    stadium_id VARCHAR(50),
    league_id VARCHAR(50),
    
    CONSTRAINT fk_stadium FOREIGN KEY (stadium_id) REFERENCES Stadium(id_stadium),
    CONSTRAINT fk_league FOREIGN KEY (league_id) REFERENCES League(id_league),
    CONSTRAINT fk_home_team FOREIGN KEY (home_team) REFERENCES Team(name_team),
    CONSTRAINT fk_away_team FOREIGN KEY (away_team) REFERENCES Team(name_team)
);
