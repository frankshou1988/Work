USE [PMISDB]
GO

/****** Object:  Table [dbo].[user_account]    Script Date: 04/17/2013 10:10:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [nvarchar](50) NOT NULL,
	[user_pass] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_user_account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


