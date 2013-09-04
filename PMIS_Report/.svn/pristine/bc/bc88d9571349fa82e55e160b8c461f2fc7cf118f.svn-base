USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_target]    Script Date: 03/22/2013 16:19:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cip_target](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_target_name] [nvarchar](100) NOT NULL,
	[cip_target_desc] [nvarchar](100) NULL,
	[cip_target_group] [int] NOT NULL,
 CONSTRAINT [PK_cip_target] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[cip_target]  WITH CHECK ADD  CONSTRAINT [FK_cip_target_cip_target_group] FOREIGN KEY([cip_target_group])
REFERENCES [dbo].[cip_target_group] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[cip_target] CHECK CONSTRAINT [FK_cip_target_cip_target_group]
GO


