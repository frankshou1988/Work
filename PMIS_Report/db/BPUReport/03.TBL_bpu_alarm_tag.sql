USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_alarm_tag]    Script Date: 07/17/2013 13:36:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_alarm_tag](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[alarm_tag_name] [nvarchar](50) NOT NULL,
	[alarm_insql_tag_name] [nvarchar](50) NOT NULL,
	[alarm_tag_desc] [nvarchar](50) NULL,
	[bpu_machine] [int] NOT NULL,
 CONSTRAINT [PK_bpu_alarm_tag] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[bpu_alarm_tag]  WITH CHECK ADD  CONSTRAINT [FK_bpu_alarm_tag_bpu_machine] FOREIGN KEY([bpu_machine])
REFERENCES [dbo].[bpu_machine] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[bpu_alarm_tag] CHECK CONSTRAINT [FK_bpu_alarm_tag_bpu_machine]
GO


