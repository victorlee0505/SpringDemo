-- Create EMPLOYEE table
CREATE TABLE EMPLOYEE (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    date_of_birth DATE,
    salary DECIMAL(10, 2),
    service_years INT,
    address VARCHAR(255),
    sin_number VARCHAR(100),
    driver_licence_number VARCHAR(100)
);

-- Insert dummy data into EMPLOYEE table
INSERT INTO EMPLOYEE (first_name, last_name, email, date_of_birth, salary, service_years, address, sin_number, driver_licence_number) VALUES
('John', 'Doe', 'john.doe@example.com', '1985-07-14', 50000.00, 5, '123 Elm St, Springfield, SP', '123 456 789', 'D1234567'),
('Jane', 'Smith', 'jane.smith@example.com', '1990-08-05', 55000.00, 3, '456 Oak St, Metropolis, MP', '234 567 890', 'D2345678'),
('Alice', 'Johnson', 'alice.johnson@example.com', '1983-11-22', 60000.00, 7, '789 Pine St, Gotham, GH', '345 678 901', 'D3456789'),
('Bob', 'Williams', 'bob.williams@example.com', '1975-04-09', 62000.00, 10, '321 Maple St, Star City, SC', '456 789 012', 'D4567890'),
('Carol', 'Brown', 'carol.brown@example.com', '1992-03-15', 45000.00, 2, '654 Spruce St, Central City, CC', '567 890 123', 'D5678901'),
('Dave', 'Jones', 'dave.jones@example.com', '1988-12-08', 47000.00, 4, '987 Cedar St, Smallville, SV', '678 901 234', 'D6789012'),
('Eve', 'Miller', 'eve.miller@example.com', '1980-01-29', 70000.00, 12, '246 Birch St, Atlantis, AT', '789 012 345', 'D7890123'),
('Frank', 'Wilson', 'frank.wilson@example.com', '1972-05-16', 73000.00, 15, '135 Willow St, Themyscira, TM', '890 123 456', 'D8901234'),
('Grace', 'Moore', 'grace.moore@example.com', '1995-07-30', 54000.00, 1, '864 Elm St, Paradise Island, PI', '901 234 567', 'D9012345'),
('Henry', 'Taylor', 'henry.taylor@example.com', '1987-09-17', 61000.00, 6, '975 Oak St, Keystone City, KC', '012 345 678', 'D0123456');
