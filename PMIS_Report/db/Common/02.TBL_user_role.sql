USE [PMISDB]
GO

/****** Object:  Table [dbo].[user_role]    Script Date: 04/18/2013 22:34:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_type] [nvarchar](50) NOT NULL,
	[role_desc] [nvarchar](50) NOT NULL
 CONSTRAINT [PK_user_role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO




