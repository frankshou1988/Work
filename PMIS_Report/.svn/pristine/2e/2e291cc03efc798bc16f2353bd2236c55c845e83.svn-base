USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_report_result]    Script Date: 07/17/2013 13:42:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bpu_report_result](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bpu_report_result_unique_id] [nvarchar](50) NULL,
	[bpu_machine_id] [int] NULL,
	[bpu_machine_name] [nvarchar](20) NULL,
	[bpu_machine_desc] [nvarchar](20) NULL,
	[bpu_machine_serial_number] [nvarchar](20) NULL,
	[bpu_prod_start_date_time] [datetime] NULL,
	[bpu_prod_end_date_time] [datetime] NULL,
	[bpu_prod_last_time] [nvarchar](20) NULL,
 CONSTRAINT [PK_bpu_report_result] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


