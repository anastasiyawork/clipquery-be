create EXTENSION if not exists vector;

create table if not exists user_roles (
    code VARCHAR(100) NOT NULL PRIMARY KEY,
    description TEXT
);

create table if not exists users (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(70),
    created_at TIMESTAMP NOT NULL,
    user_role_code VARCHAR(100),
    FOREIGN KEY (user_role_code) REFERENCES user_roles ON DELETE RESTRICT
);

create table if not exists accounts (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    provider VARCHAR(50) NOT NULL,
    provider_account_id BIGINT,
    provider_email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE,
    UNIQUE(provider, provider_account_id)
);

create table if not exists statuses (
    code VARCHAR(10) NOT NULL PRIMARY KEY,
    description TEXT
);

create table if not exists clips (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    type VARCHAR(5) NOT NULL,
    size NUMERIC(12, 2) NOT NULL,
    minio_id TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    status_code VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    response TEXT,
    UNIQUE(name, user_id),
    FOREIGN KEY (status_code) REFERENCES statuses ON DELETE RESTRICT,
    FOREIGN KEY (user_id) REFERENCES users
);

create table if not exists clip_chunks (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    clip_id BIGINT NOT NULL,
    start_ms BIGINT NOT NULL,
    end_ms BIGINT NOT NULL,
    embedding VECTOR(1024) NOT NULL,
    content text NOT NULL,
    FOREIGN KEY (clip_id) REFERENCES clips ON DELETE CASCADE
);

create table if not exists chat_threads (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE
);

create table if not exists thread_clips (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    clip_id BIGINT NOT NULL,
    thread_id BIGINT NOT NULL,
    FOREIGN KEY (clip_id) REFERENCES clips ON DELETE CASCADE,
    FOREIGN KEY (thread_id) REFERENCES chat_threads ON DELETE CASCADE,
    UNIQUE (clip_id, thread_id)
);

create table if not exists outbox (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    event_type VARCHAR(30) NOT NULL,
    payload JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    sent_at TIMESTAMP
);