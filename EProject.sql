USE [HorseRacingDB]
GO

/****** Object:  Table [dbo].[Bets]    Script Date: 27.02.2021 12:35:21 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

DROP TABLE IF EXISTS Bets;
DROP TABLE IF EXISTS Races;
DROP TABLE IF EXISTS Clients;

CREATE TABLE Races (
	[RaceID] [int] NOT NULL PRIMARY KEY,
	[RaceResult] [int] NULL,
	CHECK ([RaceResult] > 0 AND [RaceResult] < 8)
)

CREATE TABLE Clients (
	[ClientID] [int] NOT NULL PRIMARY KEY,
	[ClientName] [varchar](10) NOT NULL
)

CREATE TABLE Bets (
	[Amount] [int] NOT NULL,
	[Horse] [int] NOT NULL,
	CHECK ([Horse] > 0 AND [Horse] < 8),
	[ClientID] [int] NOT NULL REFERENCES [Clients] ([ClientID]) ON DELETE CASCADE ON UPDATE CASCADE,
	[RaceID] [int] NOT NULL REFERENCES [Races] ([RaceID]) ON DELETE CASCADE ON UPDATE CASCADE
)

INSERT INTO Clients ([ClientID], [ClientName]) VALUES
('1', 'Roman'),
('2', 'Albert'),
('3', 'Zina'),
('4', 'Marina'),
('5', 'Misha')

INSERT INTO Races ([RaceID], [RaceResult]) VALUES
('1', '7'),
('2', '2'),
('3', '5'),
('4', NULL),
('5', '1')

INSERT INTO Bets ([Amount], [Horse], [ClientID], [RaceID]) VALUES
('1000', '2', '1', '5'),
('5000', '1', '2', '3'),
('1500', '5', '3', '1'),
('2000', '7', '4', '5'),
('7000', '3', '5', '2')
