USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_alarm_report_analyse_point]    Script Date: 07/17/2013 13:41:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_alarm_report_analyse_point](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bpu_alarm_latest_analyse_date_time] [nvarchar](50) NOT NULL,
	[bpu_alarm_tag] [int] NOT NULL,
 CONSTRAINT [PK_bpu_alarm_report_analyse_point] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[bpu_alarm_report_analyse_point]  WITH CHECK ADD  CONSTRAINT [FK_bpu_alarm_report_analyse_point_bpu_alarm_tag] FOREIGN KEY([bpu_alarm_tag])
REFERENCES [dbo].[bpu_alarm_tag] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[bpu_alarm_report_analyse_point] CHECK CONSTRAINT [FK_bpu_alarm_report_analyse_point_bpu_alarm_tag]
GO


