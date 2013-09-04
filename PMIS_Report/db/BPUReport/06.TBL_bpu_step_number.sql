USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_step_number]    Script Date: 07/17/2013 13:40:01 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[bpu_step_number](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bpu_step_n] [int] NOT NULL,
	[bpu_step_n_desc] [nvarchar](50) NOT NULL,
	[machine_type] [varchar](20) NOT NULL,
 CONSTRAINT [PK_bpu_step_number] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


