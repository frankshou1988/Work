USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_phase]    Script Date: 03/22/2013 16:21:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cip_phase](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_slave_line] [int] NOT NULL,
	[cip_target] [int] NOT NULL,
	[phase_id] [int] NULL,
	[phase_name] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_cip_phase] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[cip_phase]  WITH CHECK ADD  CONSTRAINT [FK_cip_phase_cip_slave_line] FOREIGN KEY([cip_slave_line])
REFERENCES [dbo].[cip_slave_line] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[cip_phase] CHECK CONSTRAINT [FK_cip_phase_cip_slave_line]
GO

ALTER TABLE [dbo].[cip_phase]  WITH CHECK ADD  CONSTRAINT [FK_cip_phase_cip_target] FOREIGN KEY([cip_target])
REFERENCES [dbo].[cip_target] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[cip_phase] CHECK CONSTRAINT [FK_cip_phase_cip_target]
GO


