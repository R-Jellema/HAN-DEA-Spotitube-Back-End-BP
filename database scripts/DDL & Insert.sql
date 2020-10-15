CREATE DATABASE spotitube
GO
USE [spotitube]
GO
/****** Object:  User [Rick]    Script Date: 10/15/2020 4:30:56 PM ******/
CREATE USER [Rick] FOR LOGIN [Rick] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [Rick]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [Rick]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [Rick]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [Rick]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [Rick]
GO
ALTER ROLE [db_datareader] ADD MEMBER [Rick]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [Rick]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [Rick]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [Rick]
GO
/****** Object:  Table [dbo].[playlists]    Script Date: 10/15/2020 4:30:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[playlists](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[owner] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tracks]    Script Date: 10/15/2020 4:30:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tracks](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NULL,
	[performer] [varchar](50) NULL,
	[duration] [int] NULL,
	[album] [varchar](50) NULL,
	[playcount] [int] NULL,
	[publicationDate] [date] NULL,
	[description] [varchar](150) NULL,
	[offlineAvailable] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tracks_of_playlist]    Script Date: 10/15/2020 4:30:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tracks_of_playlist](
	[playlistID] [int] NOT NULL,
	[trackID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[playlistID] ASC,
	[trackID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 10/15/2020 4:30:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[playlists]  WITH CHECK ADD FOREIGN KEY([owner])
REFERENCES [dbo].[users] ([username])
GO
ALTER TABLE [dbo].[playlists]  WITH CHECK ADD FOREIGN KEY([owner])
REFERENCES [dbo].[users] ([username])
GO
ALTER TABLE [dbo].[tracks_of_playlist]  WITH CHECK ADD FOREIGN KEY([playlistID])
REFERENCES [dbo].[playlists] ([id])
GO
ALTER TABLE [dbo].[tracks_of_playlist]  WITH CHECK ADD FOREIGN KEY([trackID])
REFERENCES [dbo].[tracks] ([id])
GO

INSERT INTO users VALUES 
('Rick', '12345'),   
('Kees', '12345'), 
('Herman', '12345'),
('Bart', '12345'),
('Rody', '12345')
GO

INSERT INTO playlists VALUES 
('Afspeellijst van Bart', 'Bart'),
('Afspeellijst van Rody', 'Rody'),
('Afspeellijst van Rick', 'Rick'),
('Afspeellijst van Kees', 'Kees'),
('Afspeellijst van Herman', 'Herman'),
('Afspeellijst van Bart', 'Bart'),
('Afspeellijst van Bart 2', 'Bart'),
('Afspeellijst van Rody 2', 'Rody'),
('Afspeellijst van Rick 2', 'Rick'),
('Afspeellijst van Kees 2', 'Kees'),
('Afspeellijst van Herman 2', 'Herman'),
('Afspeellijst van Bart 2', 'Bart')
GO

INSERT INTO tracks VALUES 
('REISE REISE', 'Rammstein', 500, 'Reise Reise', 500, GETDATE(), 'By Rammstein', 0),		-- 1
('MEIN TEIL', 'Rammstein', 600, 'Reise Reise', 600, GETDATE(), 'By Rammstein', 0),			-- 2
('STEIN UM STEIN', 'Rammstein', 700, 'Reise Reise', 550, GETDATE(), 'By Rammstein', 0),		-- 3
('OHNE DICH', 'Rammstein', 800, 'Reise Reise', 506, GETDATE(), 'By Rammstein', 0),			-- 4
('MOSKAU', 'Rammstein', 900, 'Reise Reise', 503, GETDATE(), 'By Rammstein', 0),				-- 5
('AMERIKA', 'Rammstein', 1000, 'Reise Reise', 5032, GETDATE(), 'By Rammstein', 0),			-- 6
('MORGENSTERN', 'Rammstein', 100, 'Reise Reise', 5033, GETDATE(), 'By Rammstein', 0),		-- 7
('AMOUR', 'Rammstein', 200, 'Reise Reise', 520, GETDATE(), 'By Rammstein', 0),				-- 8
('LOS', 'Rammstein', 300, 'Reise Reise', 530, GETDATE(), 'By Rammstein', 0),				-- 9
('DU HAST', 'Rammstein', 400, 'Reise Reise', 350, GETDATE(), 'By Rammstein', 0),			-- 10
('KEINE LUST', 'Rammstein', 60, 'Reise Reise', 350, GETDATE(), 'By Rammstein', 0),			-- 11
('Making of - AMOUR', 'Rammstein', 200, null, 520, GETDATE(), 'By Rammstein Crew', 0),		-- 12
('Making of - LOS', 'Rammstein', 300, null, 530, GETDATE(), 'By Rammstein Crew', 0),		-- 13
('Making of - AMERIKA', 'Rammstein', 400, null, 350, GETDATE(), 'By Rammstein Crew', 0),	-- 14
('Making of - KEINE LUST', 'Rammstein', 60, null, 350, GETDATE(), 'By Rammstein Crew', 0)	-- 15
GO

INSERT INTO tracks_of_playlist VALUES 
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10),
(1,11),
(1,15),
(1,14),
(1,13),
(1,12),

(2,6),
(2,7),
(2,8),
(2,9),
(2,10),
(2,11),
(2,12),
(2,13),

(3,1),
(3,2),
(3,3),
(3,4),
(3,5),
(3,14),
(3,15),

(4,2),
(4,3),
(4,4),
(4,5),
(4,7),
(4,10),
(4,15),
(4,14),
(4,13)
GO