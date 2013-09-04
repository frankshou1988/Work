USE [PMISDB]
GO

/****** Object:  Table [dbo].[cip_master_line]    Script Date: 06/25/2013 14:07:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[cip_master_line](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cip_master_line_name] [nvarchar](100) NOT NULL,
	[cip_master_line_desc] [nvarchar](100) NULL,
	[cip_master_line_oper_tag] [nvarchar](100) NULL,
	[cip_master_line_route_phase_id_tag] [nvarchar](100) NULL,
	[cip_master_line_cip_program_id_tag] [nvarchar](100) NULL,
	[cip_master_line_operated_by_id_tag] [nvarchar](100) NULL,
	[cip_master_line_cip_result_id_tag] [nvarchar](100) NULL,
	[cip_master_line_steps_tag] [nvarchar](100) NULL,
	[cip_master_line_step_timer_tag] [nvarchar](100) NULL,
	[cip_master_line_flow_out_tag] [nvarchar](100) NULL,
	[cip_master_line_temperature_out_tag] [nvarchar](100) NULL,
	[cip_master_line_conductivity_back_tag] [nvarchar](100) NULL,
	[cip_master_line_temperature_back_tag] [nvarchar](100) NULL,
	[phase_activity_id_tag] [nvarchar](100) NULL,
	[pre_rinse_step_n_tag] [nvarchar](100) NULL,
	[pre_rinse_step_timer_hold_tag] [nvarchar](100) NULL,
	[int_rinse_step_n_tag] [nvarchar](100) NULL,
	[int_rinse_step_timer_hold_tag] [nvarchar](100) NULL,
	[lye_step_n_tag] [nvarchar](100) NULL,
	[lye_step_timer_hold_tag] [nvarchar](100) NULL,
	[acid_step_n_tag] [nvarchar](100) NULL,
	[acid_step_timer_hold_tag] [nvarchar](100) NULL,
	[hot_wat_step_n_tag] [nvarchar](100) NULL,
	[hot_wat_step_timer_hold_tag] [nvarchar](100) NULL,
	[chem_dis_step_n_tag] [nvarchar](100) NULL,
	[chem_dis_step_timer_hold_tag] [nvarchar](100) NULL,
	[final_rinse_step_n_tag] [nvarchar](100) NULL,
	[final_rinse_step_timer_hold_tag] [nvarchar](100) NULL,
	[plc_structure_type] [varchar](10) NULL,
	[workshop_type] [varchar](10) NULL,
 CONSTRAINT [PK_cip_master_line] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


