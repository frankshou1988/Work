USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_report_analyse_point]    Script Date: 06/04/2013 15:05:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cip_report_analyse_point](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_master_line] [nvarchar](100) NOT NULL,
	[cip_latest_analyse_date_time] [datetime] NOT NULL,
 CONSTRAINT [PK_cip_report_analyse_point] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


