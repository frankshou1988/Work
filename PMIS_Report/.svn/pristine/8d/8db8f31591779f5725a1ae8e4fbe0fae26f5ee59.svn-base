USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_alarm_report_result]    Script Date: 07/17/2013 13:41:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_alarm_report_result](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bpu_machine_id] [int] NULL,
	[bpu_machine_name] [nvarchar](50) NULL,
	[bpu_machine_desc] [nvarchar](50) NULL,
	[bpu_machine_serial_number] [nvarchar](50) NULL,
	[alarm_tag_id] [int] NULL,
	[alarm_bit] [smallint] NULL,
	[alarm_msg] [nvarchar](50) NULL,
	[alarm_start_date_time] [datetime] NULL,
	[alarm_end_date_time] [datetime] NULL,
	[alarm_last_time] [nvarchar](50) NULL,
 CONSTRAINT [PK_bpu_alarm_result] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


