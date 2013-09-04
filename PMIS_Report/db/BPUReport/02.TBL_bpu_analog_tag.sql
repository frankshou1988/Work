USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_analog_tag]    Script Date: 07/17/2013 13:34:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_analog_tag](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[analog_tag_name] [nvarchar](50) NOT NULL,
	[analog_insql_tag_name] [nvarchar](50) NOT NULL,
	[analog_tag_desc] [nvarchar](50) NULL,
	[analog_tag_unit] [nvarchar](50) NULL,
	[analog_tag_value_divided_by] [float] NOT NULL,
	[analog_tag_value_type] [nvarchar](10) NOT NULL,
	[analog_standard_max_value] [nvarchar](10) NULL,
	[analog_standard_min_value] [nvarchar](10) NULL,
	[bpu_machine] [int] NOT NULL,
 CONSTRAINT [PK_bpu_machine_analog_tag] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[bpu_analog_tag]  WITH CHECK ADD  CONSTRAINT [FK_bpu_machine_analog_tag_bpu_machine] FOREIGN KEY([bpu_machine])
REFERENCES [dbo].[bpu_machine] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[bpu_analog_tag] CHECK CONSTRAINT [FK_bpu_machine_analog_tag_bpu_machine]
GO


