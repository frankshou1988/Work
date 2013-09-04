USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_type]    Script Date: 06/25/2013 16:43:05 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[cip_type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_type_plc_id] [int] NULL,
	[cip_type_desc] [nvarchar](100) NOT NULL,
	[plc_structure_type] [varchar](10) NULL,
 CONSTRAINT [PK_cip_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


