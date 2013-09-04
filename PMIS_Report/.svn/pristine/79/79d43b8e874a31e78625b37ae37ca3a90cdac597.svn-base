USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_report_analyse_point]    Script Date: 07/17/2013 13:42:22 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_report_analyse_point](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bpu_report_latest_analyse_date_time] [nvarchar](50) NOT NULL,
	[bpu_machine] [int] NOT NULL,
 CONSTRAINT [PK_bpu_report_analyse_point] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[bpu_report_analyse_point]  WITH CHECK ADD  CONSTRAINT [FK_bpu_report_analyse_point_bpu_machine] FOREIGN KEY([bpu_machine])
REFERENCES [dbo].[bpu_machine] ([id])
GO

ALTER TABLE [dbo].[bpu_report_analyse_point] CHECK CONSTRAINT [FK_bpu_report_analyse_point_bpu_machine]
GO


