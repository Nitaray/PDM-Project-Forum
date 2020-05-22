USE [ForumMidterm]
GO

INSERT INTO [dbo].[Role]
           ([RoleName])
     VALUES
           ('User')
GO

INSERT INTO [dbo].[Role]
           ([RoleName])
     VALUES
           ('Moderator')
GO

INSERT INTO [dbo].[Role]
           ([RoleName])
     VALUES
           ('Admin')
GO

INSERT INTO [dbo].[User]
           ([Username]
           ,[Email]
           ,[FirstName]
           ,[LastName]
           ,[Gender]
           ,[Country]
           ,[Password]
           ,[About]
           ,[RoleID])
     VALUES
           ('NLNGUYEN'
           ,'ititiu18094@student.hcmiu.edu.vn'
           ,'Le Nguyen'
           ,'Nguyen'
           ,'Male'
           ,'Vietnam'
           ,'123456'
           ,'A student'
           ,3)
GO

INSERT INTO [dbo].[User]
           ([Username]
           ,[Email]
           ,[FirstName]
           ,[LastName]
           ,[Gender]
           ,[Country]
           ,[Password]
           ,[About]
           ,[RoleID])
     VALUES
           ('NTCUONG'
           ,'ititiu18172@student.hcmiu.edu.vn'
           ,'Tien Cuong'
           ,'Nguyen'
           ,'Male'
           ,'Vietnam'
           ,'654321'
           ,'Another student'
           ,2)
GO

INSERT INTO [dbo].[User]
           ([Username]
           ,[Email]
           ,[FirstName]
           ,[LastName]
           ,[Gender]
           ,[Country]
           ,[Password]
           ,[About]
           ,[RoleID])
     VALUES
           ('NVTRI'
           ,'ititun18051@student.hcmiu.edu.vn'
           ,'Van Tri'
           ,'Nguyen'
           ,'Male'
           ,'Vietnam'
           ,'142536'
           ,'Yet another student'
           ,1)
GO

INSERT INTO [dbo].[Thread]
           ([UserID]
		   ,[ThreadTitle]
           ,[Content])
     VALUES
           (1
		   ,'Welcome Message'
           ,'Welcome to the Forum!')
GO

INSERT INTO [dbo].[Thread]
           ([UserID]
		   ,[ThreadTitle]
           ,[Content])
     VALUES
           (2
		   ,'New Mod Announcement!'
           ,'Hello I am your moderator!')
GO

INSERT INTO [dbo].[Thread]
           ([UserID]
		   ,[ThreadTitle]
           ,[Content])
     VALUES
           (3
		   ,'New User here!'
           ,'Hello I am new!')
GO

INSERT INTO [dbo].[Comment]
           ([CreatorID]
           ,[ThreadID]
           ,[Content])
     VALUES
           (2
           ,1
           ,'Hello, please treat me well!')
GO

INSERT INTO [dbo].[Comment]
           ([CreatorID]
           ,[ThreadID]
           ,[Content])
     VALUES
           (2
           ,3
           ,'Welcome welcome')
GO

INSERT INTO [dbo].[Comment]
           ([CreatorID]
           ,[ThreadID]
           ,[Content])
     VALUES
           (1
           ,2
           ,'Please do your job well!')
GO


INSERT INTO [dbo].[Follows]
           ([UserID]
           ,[ThreadID])
     VALUES
           (1
           ,1)
GO

INSERT INTO [dbo].[Follows]
           ([UserID]
           ,[ThreadID])
     VALUES
           (2
           ,1)
GO

INSERT INTO [dbo].[Follows]
           ([UserID]
           ,[ThreadID])
     VALUES
           (3
           ,1)
GO

INSERT INTO [dbo].[Notification]
           ([Content])
     VALUES
           ('Welcome to the Forum')
GO

INSERT INTO [dbo].[Notification]
           ([Content])
     VALUES
           ('Welcome new User')
GO

INSERT INTO [dbo].[Receives]
           ([UserID]
           ,[NotificationID])
     VALUES
           (2
           ,1)
GO

INSERT INTO [dbo].[Receives]
           ([UserID]
           ,[NotificationID])
     VALUES
           (3
           ,1)
GO

INSERT INTO [dbo].[Receives]
           ([UserID]
           ,[NotificationID])
     VALUES
           (2
           ,2)
GO

INSERT INTO [dbo].[Receives]
           ([UserID]
           ,[NotificationID])
     VALUES
           (3
           ,2)
GO
