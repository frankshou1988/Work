USE [PMISDB]
GO

/****** Object:  Table [dbo].[bpu_machine]    Script Date: 07/17/2013 13:33:04 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[bpu_machine](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[machine_name] [nvarchar](50) NOT NULL,
	[machine_desc] [nvarchar](50) NULL,
	[machine_serial_number] [nvarchar](50) NULL,
	[machine_type] [varchar](20) NOT NULL,
	[step_number_insql_tag] [nvarchar](50) NULL,
	[phase_status_insql_tag] [nvarchar](50) NULL,
 CONSTRAINT [PK_bpu_machine] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


