USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_trend_tag]    Script Date: 06/27/2013 10:11:27 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cip_trend_tag](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_trend_tag_name] [nvarchar](100) NULL,
	[cip_trend_tag_desc] [nvarchar](100) NULL,
	[cip_trend_tag_unit] [nvarchar](100) NULL,
	[cip_trend_tag_value_divided_by] [int] NULL,
	[cip_trend_tag_analog] [smallint] NULL,
	[cip_master_line] [int] NOT NULL,
 CONSTRAINT [PK_cip_trend_tag] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[cip_trend_tag]  WITH CHECK ADD  CONSTRAINT [FK_cip_trend_tag_master_line] FOREIGN KEY([cip_master_line])
REFERENCES [dbo].[cip_master_line] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[cip_trend_tag] CHECK CONSTRAINT [FK_cip_trend_tag_master_line]
GO


