USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_slave_line]    Script Date: 03/22/2013 16:07:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cip_slave_line](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_slave_line_name] [nvarchar](100) NOT NULL,
	[cip_slave_line_desc] [nvarchar](100) NULL,
	[cip_master_line] [int] NOT NULL,
 CONSTRAINT [PK_cip_slave_line] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[cip_slave_line]  WITH CHECK ADD  CONSTRAINT [FK_cip_slave_line_master_line] FOREIGN KEY([cip_master_line])
REFERENCES [dbo].[cip_master_line] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[cip_slave_line] CHECK CONSTRAINT [FK_cip_slave_line_master_line]
GO


