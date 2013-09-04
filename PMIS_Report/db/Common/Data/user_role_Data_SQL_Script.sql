SET IDENTITY_INSERT [user_role] ON;
INSERT INTO [user_role] ([id],[role_type],[role_desc]) VALUES (1,'R_ADMIN','管理员');
INSERT INTO [user_role] ([id],[role_type],[role_desc]) VALUES (2,'R_OPER','操作工');
INSERT INTO [user_role] ([id],[role_type],[role_desc]) VALUES (3,'R_ROOT','系统');
SET IDENTITY_INSERT [user_role] OFF;
