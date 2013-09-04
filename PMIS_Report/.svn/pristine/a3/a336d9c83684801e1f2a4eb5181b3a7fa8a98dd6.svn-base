USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_report_result]    Script Date: 07/04/2013 13:47:41 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[cip_report_result](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_master_line_id] [int] NULL,
	[cip_master_line_name] [nvarchar](100) NULL,
	[cip_slave_line_id] [int] NULL,
	[cip_slave_line_name] [nvarchar](100) NULL,
	[cip_target_name] [nvarchar](100) NULL,
	[cip_target_desc] [nvarchar](100) NULL,
	[cip_start_date_time] [datetime] NULL,
	[cip_end_date_time] [datetime] NULL,
	[cip_last_time] [nvarchar](100) NULL,
	[cip_type] [nvarchar](100) NULL,
	[cip_type_plc_id] [int] NULL,
	[cip_result_plc_id] [int] NULL,
	[cip_result] [nvarchar](100) NULL,
	[cip_pre_rinse_start_date_time] [datetime] NULL,
	[cip_pre_rinse_end_date_time] [datetime] NULL,
	[cip_pre_rinse_last_time] [nvarchar](100) NULL,
	[cip_pre_rinse_temperature_out] [nvarchar](100) NULL,
	[cip_pre_rinse_flow_out] [nvarchar](100) NULL,
	[cip_pre_rinse_temperature_back] [nvarchar](100) NULL,
	[cip_lye_cycle_start_date_time] [datetime] NULL,
	[cip_lye_cycle_end_date_time] [datetime] NULL,
	[cip_lye_cycle_last_time] [nvarchar](100) NULL,
	[cip_lye_cycle_temperature_out] [nvarchar](100) NULL,
	[cip_lye_cycle_flow_out] [nvarchar](100) NULL,
	[cip_lye_cycle_conductivity_back] [nvarchar](100) NULL,
	[cip_lye_cycle_temperature_back] [nvarchar](100) NULL,
	[cip_inter_rinse_start_date_time] [datetime] NULL,
	[cip_inter_rinse_end_date_time] [datetime] NULL,
	[cip_inter_rinse_last_time] [nvarchar](100) NULL,
	[cip_inter_rinse_temperature_out] [nvarchar](100) NULL,
	[cip_inter_rinse_flow_out] [nvarchar](100) NULL,
	[cip_inter_rinse_temperature_back] [nvarchar](100) NULL,
	[cip_acid_cycle_start_date_time] [datetime] NULL,
	[cip_acid_cycle_end_date_time] [datetime] NULL,
	[cip_acid_cycle_last_time] [nvarchar](100) NULL,
	[cip_acid_cycle_temperature_out] [nvarchar](100) NULL,
	[cip_acid_cycle_flow_out] [nvarchar](100) NULL,
	[cip_acid_cycle_conductivity_back] [nvarchar](100) NULL,
	[cip_acid_cycle_temperature_back] [nvarchar](100) NULL,
	[cip_final_rinse_start_date_time] [datetime] NULL,
	[cip_final_rinse_end_date_time] [datetime] NULL,
	[cip_final_rinse_last_time] [nvarchar](100) NULL,
	[cip_final_rinse_temperature_out] [nvarchar](100) NULL,
	[cip_final_rinse_flow_out] [nvarchar](100) NULL,
	[cip_final_rinse_temperature_back] [nvarchar](100) NULL,
	[cip_ster_start_date_time] [datetime] NULL,
	[cip_ster_end_date_time] [datetime] NULL,
	[cip_ster_last_time] [nvarchar](100) NULL,
	[cip_ster_temperature_out] [nvarchar](100) NULL,
	[cip_ster_flow_out] [nvarchar](100) NULL,
	[cip_ster_temperature_back] [nvarchar](100) NULL,
	[cip_operated_by_id] [int] NULL,
	[cip_operated_by_name] [nvarchar](100) NULL,
	[plc_structure_type] [varchar](10) NULL,
	[workshop_type] [varchar](10) NULL,
	[time_since_last_operation] [nvarchar](100) NULL,
 CONSTRAINT [PK_cip_report_result] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO
